package com.personInfo.service.impl;

import com.personInfo.bean.Follow;
import com.personInfo.mapper.FollowMapper;
import com.personInfo.service.FollowService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class FollowServiceImpl implements FollowService {


    @Autowired
    private FollowMapper followMapper;

    /**
     * 查询该用户关注列表
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    @Override
    public List<Follow> selectAttentionByUserId(@Param("userId") Integer userId, @Param("start")Integer start, @Param("limit")Integer limit){
        List<Follow> follows = followMapper.selectAttentionByUserId(userId, start, limit);
        return follows;
    }


    public Follow selectFollowById(Integer id){
        Follow follow = followMapper.selectFollowById(id);
        return follow;
    }

    /**
     * 查询该用户关注数量
     * @param userId
     * @return
     */
    @Override
    public int selectAttentionCountByUserId(Integer userId){
        final int count = followMapper.selectAttentionCountByUserId(userId);
        return count;
    }


}
