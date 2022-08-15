package com.personInfo.service;

import com.personInfo.bean.Videos;

import java.util.List;

public interface VideosService {

    int deleteByPrimaryKey(String id);

    List<Videos> selectByUserId(Integer userId);

    int insert(Videos record);

    int insertSelective(Videos record);

    Videos selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Videos record);

    int updateByPrimaryKey(Videos record);

}
