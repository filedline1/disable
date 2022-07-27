package com.relation.mapper;

import com.relation.bean.Follow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface FollowMapper {

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
     * 查询二者关注关系
     * @param userId
     * @param followedUserId
     * @return
     */
    public int selectAttentionStatus(Integer userId,Integer followedUserId);

    /**
     * 增加关注记录
     * @param follow
     * @return
     */
    public int insertAttentionRecord(Follow follow);

    /**
     * 添加关注
     * @param follow
     * @return
     */
    public int addAttention(Follow follow);

    /**
     * 取消关注
     * @param follow
     * @return
     */
    public int cancelAttention(Follow follow);

    /**
     * 删除该用户的所有关注信息（注销账号时使用）
     * @param userId
     * @param followedUserId
     * @return
     */
    public int deleteRecord(Integer userId,Integer followedUserId);

}
