package com.ywl.mapper.boke;

import com.ywl.entity.BlogCity;

public interface BlogCityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogCity record);

    int insertSelective(BlogCity record);

    BlogCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogCity record);

    int updateByPrimaryKey(BlogCity record);
}