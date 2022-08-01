package com.personInfo.mapper;

import com.personInfo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {

    public User selectUserByLoginName(String loginName);

    public User selectUserByNickName(String nickName);

    public int insertUser(User user);

    public int updatePassword(@Param("loginName") String loginName,@Param("newPassword") String newPassword);

    public int signIn(@Param("reward") Integer reward,@Param("loginName")String loginName);

    public int openVip(@Param("loginName") String loginName,@Param("month")Integer month);

    public int renewalVip(@Param("loginName") String loginName,@Param("month")Integer month);

    public int updateNickName(@Param("loginName") String loginName,@Param("nickName") String nickName);

    public int delete(Integer userId);

}
