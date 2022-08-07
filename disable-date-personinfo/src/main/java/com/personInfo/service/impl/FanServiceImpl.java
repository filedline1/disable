package com.personInfo.service.impl;



import com.personInfo.bean.Fan;
import com.personInfo.bean.Follow;
import com.personInfo.common.ServiceResultEnum;
import com.personInfo.mapper.FanMapper;
import com.personInfo.mapper.FollowMapper;
import com.personInfo.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

import static com.personInfo.constants.FanStatus.ATTENTION;
import static com.personInfo.constants.FanStatus.UNFOLLOW;

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
    @Transactional(rollbackFor = Exception.class)
    public String addAttention(Fan fan){
        Follow follow = new Follow();
        follow.setUserId(fan.getFollower());
        follow.setFollowedUserId(fan.getUserId());
        //若存在记录那么将关注状态改为关注
        if (fanMapper.selectAttentionStatus(fan.getUserId(),fan.getFollower()) > 0){
            //开启事务
            try {
                fanMapper.addAttention(fan);
                followMapper.addAttention(follow);
                //结束事务
                return ServiceResultEnum.SUCCESS.getResult();
            } catch (Exception e){
                System.out.println("方法出现异常：" + e);
                //手动实现回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        } else {
            //若不存在记录，那么插入关注记录
            follow.setStatus(ATTENTION);
            fan.setStatus(ATTENTION);
            //开启事务
            try {
                int i = fanMapper.insertAttentionRecord(fan);
                int j = followMapper.insertAttentionRecord(follow);
                //结束事务
                if (i > 0 && j > 0){
                    return ServiceResultEnum.SUCCESS.getResult();
                }
            } catch (Exception e){
                System.out.println("方法出现异常：" + e);
                //手动实现回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    /**
     * 取消关注
     * @param fan
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String cancelAttention(Fan fan){
        Follow follow = new Follow();
        follow.setUserId(fan.getFollower());
        follow.setFollowedUserId(fan.getUserId());
        //若存在记录那么将关注状态改为不关注
        if (fanMapper.selectAttentionStatus(fan.getUserId(),fan.getFollower()) > 0){
            //开启事务
            try {
                fanMapper.cancelAttention(fan);
                followMapper.cancelAttention(follow);
                //结束事务
                return ServiceResultEnum.SUCCESS.getResult();
            } catch (Exception e) {
                System.out.println("方法出现异常：" + e);
                //手动实现回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        } else {
            //若不存在记录，那么插入关注记录
            follow.setStatus(UNFOLLOW);
            fan.setStatus(UNFOLLOW);
            //开启事务
            try {
                int i = fanMapper.insertAttentionRecord(fan);
                int j = followMapper.insertAttentionRecord(follow);
                //结束事务
                if (i > 0 && j > 0){
                    return ServiceResultEnum.SUCCESS.getResult();
                }
            } catch (Exception e) {
                System.out.println("方法出现异常：" + e);
                //手动实现回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }


    /**
     * 删除改用户的所有关注信息（注销账号时使用）
     * @param userId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteRecord(Integer userId){
        Integer follower = userId;
        //开启事务
        try {
            final int i = fanMapper.deleteRecord(userId,follower);
            final int j = followMapper.deleteRecord(userId, follower);
            //结束事务
            if (i > 0 && j > 0){
                return ServiceResultEnum.SUCCESS.getResult();
            }
        } catch (Exception e){
            System.out.println("方法出现异常：" + e);
            //手动实现回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

}
