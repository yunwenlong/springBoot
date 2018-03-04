package com.ywl.service.impl.boke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywl.entity.BlogCity;
import com.ywl.mapper.boke.BlogCityMapper;
import com.ywl.service.boke.BlogCityService;

@Service
public class BlogCityServiceImpl implements BlogCityService {

	@Autowired
	private BlogCityMapper blogCityMapper;

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return blogCityMapper.deleteByPrimaryKey(id);
	}

	public int insertSelective(BlogCity record) {
		// TODO Auto-generated method stub
		return blogCityMapper.insertSelective(record);
	}

	public BlogCity selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return blogCityMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(BlogCity record) {
		// TODO Auto-generated method stub
		return blogCityMapper.updateByPrimaryKeySelective(record);
	}
	
}
