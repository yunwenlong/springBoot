package com.ywl.service.impl.boke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywl.entity.BlogDictionary;
import com.ywl.mapper.boke.BlogDictionaryMapper;
import com.ywl.service.boke.BlogDictionaryService;


@Service
public class BlogDictionaryServiceImpl implements BlogDictionaryService {
	
	@Autowired
	private BlogDictionaryMapper blogDictionaryMapper;

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogDictionaryMapper.deleteByPrimaryKey(id);
	}

	public int insertSelective(BlogDictionary record) {
		// TODO Auto-generated method stub
		return blogDictionaryMapper.insertSelective(record);
	}

	public BlogDictionary selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return blogDictionaryMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(BlogDictionary record) {
		// TODO Auto-generated method stub
		return blogDictionaryMapper.updateByPrimaryKeySelective(record);
	}

	

}
