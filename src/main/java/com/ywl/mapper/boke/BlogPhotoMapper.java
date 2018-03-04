package com.ywl.mapper.boke;

import com.ywl.entity.BlogPhoto;


public interface BlogPhotoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogPhoto record);

    int insertSelective(BlogPhoto record);

    BlogPhoto selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogPhoto record);

    int updateByPrimaryKeyWithBLOBs(BlogPhoto record);

    int updateByPrimaryKey(BlogPhoto record);
}