package com.relation.service.impl;


import com.relation.bean.Fan;
import com.relation.bean.Follow;
import com.relation.bean.Follow;
import com.relation.common.ServiceResultEnum;
import com.relation.mapper.FanMapper;
import com.relation.mapper.FollowMapper;
import com.relation.mapper.FollowMapper;
import com.relation.service.FollowService;
import com.relation.service.FollowService;
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

    /**
     * 删除改用户的所有关注信息（注销账号时使用）
     * @param userId
     * @return
     */
    @Override
    public String deleteRecord(Integer userId){
        Integer follower = userId;
        final int i = followMapper.deleteRecord(userId,follower);
        if (i > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

}
