package com.relation.mapper;

import com.relation.bean.Fan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface FanMapper {

    public Fan selectFanById(Integer id);

    public List<Fan> selectFollowerByUserId(@Param("userId") Integer userId,@Param("start")Integer start,@Param("limit")Integer limit);

    public int selectFollowerCountByUserId(Integer userId);

    public List<Fan> selectStatusBetweenTwoUser(Integer firstUserId, Integer secondUserId);

    public int selectAttentionStatus(Integer userId,Integer follower);

    public int insertAttentionRecord(Fan fan);

    public int addAttention(Fan fan);

    public int cancelAttention(Fan fan);

    public int deleteRecord(Integer userId,Integer follower);

}
