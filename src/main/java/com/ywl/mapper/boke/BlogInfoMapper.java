package com.ywl.mapper.boke;

import com.ywl.entity.BlogInfo;

public interface BlogInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogInfo record);

    int insertSelective(BlogInfo record);

    BlogInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogInfo record);

    int updateByPrimaryKeyWithBLOBs(BlogInfo record);

    int updateByPrimaryKey(BlogInfo record);
}