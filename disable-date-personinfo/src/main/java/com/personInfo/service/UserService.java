package com.personInfo.service;

import com.personInfo.bean.User;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface UserService {

    /**
     * 批量查询
     * @param recordItems
     * @return
     */
    public List<User> selectBatch(List<Integer> recordItems);

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     * @throws ParseException
     */
    public User login(String loginName, String password) throws ParseException;

    /**
     * 注册
     * @param user
     * @return
     * @throws ParseException
     */
    public String register(User user) throws ParseException;

    /**
     * 修改账号密码
     * @param loginName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public int updatePassword(String loginName,String oldPassword,String newPassword);

    /**
     * 修改用户昵称
     * @param oldName
     * @param newName
     * @return
     */
    public String updateNickName(String oldName,String newName);

    /**
     * 注销账号
     * @param userId
     * @return
     */
    public String delete(Integer userId);

    /**
     * 签到
     * @param reward
     * @param loginName
     * @return
     */
    public String signIn(Integer reward,String loginName);

    /**
     * 开通会员
     * @param loginName
     * @param month
     * @return 到期时间
     */
    public Date openVip(String loginName, Integer month);

    /**
     * 续费会员
     * @param loginName
     * @param month
     * @return
     */
    public Date renewalVip(@Param("loginName") String loginName,@Param("month")Integer month);

    /**
     * 根据用户手机号查询用户信息
     * @param loginName
     * @return
     */
    public User selectUserByLoginName(String loginName);

    /**
     *
     * @param userId
     * @return
     */
    public User selectByPrimaryKey(Integer userId);


    /**
     * 点赞
     * @param userId
     * @return
     */
    public int addLikesCount(@Param("userId") Integer userId);

    /**
     * 更新用户的头像路径
     * @param loginName
     * @param headPicPath
     * @return
     */
    public int updateHeadPicPath(@Param("loginName") String loginName,@Param("headPicPath") String headPicPath);

    /**
     * 喜欢
     * @param userId
     * @return
     */
    public int addLoveCount(@Param("userId") Integer userId);

}
