package com.personInfo.mapper;

import com.personInfo.bean.Videos;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VideosMapper {

    int deleteByPrimaryKey(String id);

    List<Videos> selectByUserId(Integer userId);

    int insert(Videos record);

    int insertSelective(Videos record);

    Videos selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Videos record);

    int updateByPrimaryKey(Videos record);
}