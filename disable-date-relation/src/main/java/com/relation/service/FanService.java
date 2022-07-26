package com.relation.service;


import com.relation.bean.Fan;

import java.util.List;

public interface FanService {

    /**
     * 分页查询粉丝对象
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    public List<Fan> selectFollowerByUserId(Integer userId,Integer start,Integer limit);

    /**
     * 查找该用户的粉丝数
     * @param userId
     * @return
     */
    public int selectFollowerCountByUserId(Integer userId);

    /**
     * 查询两个人之间的关注情况
     * @param firstUserId
     * @param secondUserId
     * @return
     */
    public List<Fan> selectStatusBetweenTwoUser(Integer firstUserId, Integer secondUserId);

    /**
     * 增加关注
     * @param fan
     * @return
     */
    public String addAttention(Fan fan);

    /**
     * 取消关注
     * @param fan
     * @return
     */
    public String cancelAttention(Fan fan);

    /**
     * 删除改用户的所有关注信息（注销账号时使用）
     * @param userId
     * @return
     */
    public String deleteRecord(Integer userId);


}
