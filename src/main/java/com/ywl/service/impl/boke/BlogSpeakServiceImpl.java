package com.ywl.service.impl.boke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywl.entity.BlogSpeak;
import com.ywl.mapper.boke.BlogSpeakMapper;
import com.ywl.service.boke.BlogSpeakService;


@Service
public class BlogSpeakServiceImpl implements BlogSpeakService {
	
	@Autowired
	private BlogSpeakMapper blogSpeakMapper;

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogSpeakMapper.deleteByPrimaryKey(id);
	}

	public int insertSelective(BlogSpeak record) {
		// TODO Auto-generated method stub
		return blogSpeakMapper.insertSelective(record);
	}

	public BlogSpeak selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogSpeakMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(BlogSpeak record) {
		// TODO Auto-generated method stub
		return blogSpeakMapper.updateByPrimaryKeySelective(record);
	}

	

}
