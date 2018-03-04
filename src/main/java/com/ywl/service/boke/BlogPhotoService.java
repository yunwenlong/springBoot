package com.ywl.service.boke;

import com.ywl.entity.BlogPhoto;

public interface BlogPhotoService {
    int deleteByPrimaryKey(String id);

    int insertSelective(BlogPhoto record);

    BlogPhoto selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogPhoto record);

}