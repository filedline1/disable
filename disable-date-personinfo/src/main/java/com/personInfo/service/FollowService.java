package com.personInfo.service;


import com.personInfo.bean.Follow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowService {

    public Follow selectFollowById(Integer id);

    /**
     * 查询用户关注列表
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    public List<Follow> selectAttentionByUserId(@Param("userId") Integer userId, @Param("start")Integer start, @Param("limit")Integer limit);

    /**
     * 查询用户关注数量
     * @param userId
     * @return
     */
    public int selectAttentionCountByUserId(Integer userId);




}
