package com.ywl.mapper.boke;

import com.ywl.entity.BlogDictionary;

public interface BlogDictionaryMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogDictionary record);

    int insertSelective(BlogDictionary record);

    BlogDictionary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogDictionary record);

    int updateByPrimaryKey(BlogDictionary record);
}