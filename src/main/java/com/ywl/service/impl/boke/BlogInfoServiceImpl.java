package com.ywl.service.impl.boke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywl.entity.BlogInfo;
import com.ywl.mapper.boke.BlogInfoMapper;
import com.ywl.service.boke.BlogInfoService;


@Service
public class BlogInfoServiceImpl implements BlogInfoService{
	
	@Autowired
	private BlogInfoMapper blogInfoMapper;

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogInfoMapper.deleteByPrimaryKey(id);
	}

	public int insertSelective(BlogInfo record) {
		// TODO Auto-generated method stub
		return blogInfoMapper.insertSelective(record);
	}

	public BlogInfo selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogInfoMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(BlogInfo record) {
		// TODO Auto-generated method stub
		return blogInfoMapper.updateByPrimaryKeySelective(record);
	}


}
