package com.relation.service;


import com.relation.bean.Fan;
import com.relation.bean.Follow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowService {

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


    /**
     * 删除该用户的所有关注信息（注销账号时使用）
     * @param userId
     * @return
     */
    public String deleteRecord(Integer userId);


}
