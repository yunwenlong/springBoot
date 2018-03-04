package com.ywl.mapper.boke;

import com.ywl.entity.BlogSpeak;

public interface BlogSpeakMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogSpeak record);

    int insertSelective(BlogSpeak record);

    BlogSpeak selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogSpeak record);

    int updateByPrimaryKeyWithBLOBs(BlogSpeak record);

    int updateByPrimaryKey(BlogSpeak record);
}