package com.personInfo.mapper;

import com.personInfo.bean.Fan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface FanMapper {


    public List<Fan> selectFollowerByUserId(@Param("follower") Integer follower, @Param("start")Integer start, @Param("limit")Integer limit);

    public int selectFollowerCountByUserId(Integer userId);

    public List<Fan> selectStatusBetweenTwoUser(@Param("firstUserId") Integer firstUserId,@Param("secondUserId") Integer secondUserId);

    public int selectAttentionStatus(@Param("userId") Integer userId,@Param("follower") Integer follower);

    public int insertAttentionRecord(Fan fan);

    public int addAttention(Fan fan);

    public int cancelAttention(Fan fan);

    public int deleteRecord(Integer userId,Integer follower);

}
