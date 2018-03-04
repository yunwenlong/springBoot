package com.ywl.service.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywl.entity.BlogUser;
import com.ywl.mapper.test.BlogUserTestMapper;
import com.ywl.service.test.BlogUserTestService;


@Service
public class BlogUserTestServiceImpl implements BlogUserTestService {
	
	@Autowired
	private BlogUserTestMapper blogUserMapper;

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
