package com.ywl.service.boke;

import com.ywl.entity.BlogUser;

public interface BlogUserService {
    int deleteByPrimaryKey(String id);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogUser record);

}