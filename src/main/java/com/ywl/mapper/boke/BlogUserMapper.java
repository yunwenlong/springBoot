package com.ywl.mapper.boke;

import com.ywl.entity.BlogUser;

public interface BlogUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKeyWithBLOBs(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}