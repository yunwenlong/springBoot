package com.ywl.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywl.entity.BlogSpeak;
import com.ywl.entity.BlogUser;
import com.ywl.entity.ResponseBean;
import com.ywl.service.boke.BlogSpeakService;
import com.ywl.service.test.BlogUserTestService;
import com.ywl.utils.DateUtil;
import com.ywl.utils.StringUtil;
import com.ywl.utils.UUIDGenerator;


@Controller
public class BlogSpeakController {

	@Autowired
	private BlogSpeakService blogSpeakService;
	
	@Autowired
	private BlogUserTestService blogUserTestService;

	@RequestMapping("insertSelective")
	@ResponseBody
	public ResponseBean insertSelective(HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean(false);
		String blog_id = (String) request.getParameter("author");
		String email = (String) request.getParameter("email");
		String phone = (String) request.getParameter("phone");
		String text = (String) request.getParameter("text");
		if (!StringUtil.isNullOrSpace(blog_id) && StringUtil.isMobile(phone)
				&& StringUtil.isEmail(email)
				&& !StringUtil.isNullOrSpace(text)) {
			String id = new UUIDGenerator().generate().toString();
			String addtime = DateUtil.getTimeNormalString(new Date());
			BlogSpeak blogSpeak = new BlogSpeak(id,blog_id,phone,email,addtime,text);
			blogSpeakService.insertSelective(blogSpeak);
			responseBean.setFlag(true);
			responseBean.setMsg("留言成功！");
		}
		return responseBean;
	}
	
	@RequestMapping("getUser")
	@ResponseBody
	public ResponseBean getUser(HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean(false);
		String id = request.getParameter("id");
		BlogUser user = blogUserTestService.selectByPrimaryKey(id);
		responseBean.setObject(user);
		responseBean.setMsg("获取数据正常");
		responseBean.setFlag(true);
		return responseBean;
	}
	

}
