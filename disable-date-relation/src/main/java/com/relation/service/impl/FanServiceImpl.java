package com.relation.service.impl;


import com.relation.bean.Fan;
import com.relation.bean.Follow;
import com.relation.common.ServiceResultEnum;
import com.relation.mapper.FanMapper;
import com.relation.mapper.FollowMapper;
import com.relation.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class FanServiceImpl implements FanService {

    @Autowired
    private FanMapper fanMapper;

    @Autowired
    private FollowMapper followMapper;

    /**
     * 分页查询粉丝对象
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    @Override
    public List<Fan> selectFollowerByUserId(Integer userId, Integer start, Integer limit){
        List<Fan> fans = fanMapper.selectFollowerByUserId(userId, start, limit);
        return fans;
    }

    /**
     * 查找该用户的粉丝数
     * @param userId
     * @return
     */
    @Override
    public int selectFollowerCountByUserId(Integer userId){
        int count = fanMapper.selectFollowerCountByUserId(userId);
        return count;
    }

    /**
     * 查询两个人之间的关注情况
     * @param firstUserId
     * @param secondUserId
     * @return
     */
    @Override
    public List<Fan> selectStatusBetweenTwoUser(Integer firstUserId, Integer secondUserId){
        List<Fan> fans = fanMapper.selectStatusBetweenTwoUser(firstUserId, secondUserId);
        return fans;
    }

    /**
     * 增加关注记录
     * @param fan
     * @return
     */
    @Override
    public String addAttention(Fan fan){
        Follow follow = new Follow();
        follow.setUserId(fan.getFollower());
        follow.setFollowedUserId(fan.getUserId());
        //若存在记录那么将关注状态改为关注
        if (fanMapper.selectAttentionStatus(fan.getUserId(),fan.getFollower()) > 0){
            fanMapper.addAttention(fan);
            followMapper.addAttention(follow);
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            //若不存在记录，那么插入关注记录
            follow.setStatus(2);
            fan.setStatus(2);
            int i = fanMapper.insertAttentionRecord(fan);
            int j = followMapper.insertAttentionRecord(follow);
            if (i > 0 && j > 0){
                return ServiceResultEnum.SUCCESS.getResult();
            }
            return ServiceResultEnum.DB_ERROR.getResult();
        }
    }

    /**
     * 取消关注
     * @param fan
     * @return
     */
    @Override
    public String cancelAttention(Fan fan){
        Follow follow = new Follow();
        follow.setUserId(fan.getFollower());
        follow.setFollowedUserId(fan.getUserId());
        //若存在记录那么将关注状态改为不关注
        if (fanMapper.selectAttentionStatus(fan.getUserId(),fan.getFollower()) > 0){
            fanMapper.cancelAttention(fan);
            followMapper.cancelAttention(follow);
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            //若不存在记录，那么插入关注记录
            follow.setStatus(2);
            fan.setStatus(1);
            int i = fanMapper.insertAttentionRecord(fan);
            int j = followMapper.insertAttentionRecord(follow);
            if (i > 0 && j > 0){
                return ServiceResultEnum.SUCCESS.getResult();
            }
            return ServiceResultEnum.DB_ERROR.getResult();
        }
    }


    /**
     * 删除改用户的所有关注信息（注销账号时使用）
     * @param userId
     * @return
     */
    @Override
    public String deleteRecord(Integer userId){
        Integer follower = userId;
        final int i = fanMapper.deleteRecord(userId,follower);
        final int j = followMapper.deleteRecord(userId, follower);
        if (i > 0 && j > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

}
