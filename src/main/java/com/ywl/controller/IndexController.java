package com.ywl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	/**
	 * 
	 * TODO	进入主页
	 * 2017年6月30日下午10:47:47
	 * @author 云文龙
	 * @return String
	 * @return
	 */
	@RequestMapping("login")
	public String toLogin(){
		return "pages/before/index";
	}
	
	/**
	 * 
	 * TODO  进入about页面
	 * 2017年6月30日下午10:48:26
	 * @author 云文龙
	 * @return String
	 * @return
	 */
	@RequestMapping("about")
	public String toAbout(){
		return "pages/before/about";
	}
	
	/**
	 * 
	 * TODO  进入blog页面
	 * 2017年6月30日下午10:48:46
	 * @author 云文龙
	 * @return String
	 * @return
	 */
	@RequestMapping("blog")
	public String toBlog(){
		return "pages/before/blog";
	}
	
	/**
	 * 
	 * TODO  进入contact页面
	 * 2017年6月30日下午10:48:55
	 * @author 云文龙
	 * @return String
	 * @return
	 */
	@RequestMapping("contact")
	public String toContact(){
		return "pages/before/contact";
	}
	
	/**
	 * 
	 * TODO  进入gallery页面
	 * 2017年6月30日下午10:49:12
	 * @author 云文龙
	 * @return String
	 * @return
	 */
	@RequestMapping("gallery")
	public String toGallery(){
		return "pages/before/gallery";
	}
	
}
