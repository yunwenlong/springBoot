package com.ywl.service.boke;

import com.ywl.entity.BlogCity;


public interface BlogCityService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(BlogCity record);

    BlogCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogCity record);

}