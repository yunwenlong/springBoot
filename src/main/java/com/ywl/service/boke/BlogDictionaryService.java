package com.ywl.service.boke;

import com.ywl.entity.BlogDictionary;


public interface BlogDictionaryService {
	
    int deleteByPrimaryKey(String id);

    int insertSelective(BlogDictionary record);

    BlogDictionary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogDictionary record);

}