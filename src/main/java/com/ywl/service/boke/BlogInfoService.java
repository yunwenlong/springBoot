package com.ywl.service.boke;

import com.ywl.entity.BlogInfo;


public interface BlogInfoService {
	
    int deleteByPrimaryKey(String id);

    int insertSelective(BlogInfo record);

    BlogInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogInfo record);

}