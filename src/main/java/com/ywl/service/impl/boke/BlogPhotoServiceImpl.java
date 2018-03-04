package com.ywl.service.impl.boke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywl.entity.BlogPhoto;
import com.ywl.mapper.boke.BlogPhotoMapper;
import com.ywl.service.boke.BlogPhotoService;


@Service
public class BlogPhotoServiceImpl implements BlogPhotoService {

	@Autowired
	private BlogPhotoMapper blogPhotoMapper;
	
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogPhotoMapper.deleteByPrimaryKey(id);
	}

	public int insertSelective(BlogPhoto record) {
		// TODO Auto-generated method stub
		return blogPhotoMapper.insertSelective(record);
	}

	public BlogPhoto selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogPhotoMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(BlogPhoto record) {
		// TODO Auto-generated method stub
		return blogPhotoMapper.updateByPrimaryKeySelective(record);
	}



}
