package com.ywl.service.impl.boke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywl.entity.BlogUser;
import com.ywl.mapper.boke.BlogUserMapper;
import com.ywl.service.boke.BlogUserService;


@Service
public class BlogUserServiceImpl implements BlogUserService {
	
	@Autowired
	private BlogUserMapper blogUserMapper;

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogUserMapper.deleteByPrimaryKey(id);
	}

	public int insertSelective(BlogUser record) {
		// TODO Auto-generated method stub
		return blogUserMapper.insertSelective(record);
	}

	public BlogUser selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogUserMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(BlogUser record) {
		// TODO Auto-generated method stub
		return blogUserMapper.updateByPrimaryKeySelective(record);
	}

	

}
