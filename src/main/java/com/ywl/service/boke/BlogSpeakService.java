package com.ywl.service.boke;

import com.ywl.entity.BlogSpeak;

public interface BlogSpeakService {
    int deleteByPrimaryKey(String id);

    int insertSelective(BlogSpeak record);

    BlogSpeak selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogSpeak record);

}