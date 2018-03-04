package com.ywl.service.test;

import com.ywl.entity.BlogUser;

public interface BlogUserTestService {
    int deleteByPrimaryKey(String id);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogUser record);

}