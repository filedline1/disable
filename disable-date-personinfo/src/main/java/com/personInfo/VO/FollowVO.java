package com.personInfo.VO;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class FollowVO {

    private Integer userId;

    private String nickName;

    private Integer status;

    private String personSign;

    private String headPicPath;

    public FollowVO() {
    }

    public FollowVO(Integer userId, String nickName, Integer status, String personSign, String headPicPath) {
        this.userId = userId;
        this.nickName = nickName;
        this.status = status;
        this.personSign = personSign;
        this.headPicPath = headPicPath;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPersonSign() {
        return personSign;
    }

    public void setPersonSign(String personSign) {
        this.personSign = personSign;
    }

    public String getHeadPicPath() {
        return headPicPath;
    }

    public void setHeadPicPath(String headPicPath) {
        this.headPicPath = headPicPath;
    }

    @Override
    public String toString() {
        return "FanVO{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", status=" + status +
                ", personSign='" + personSign + '\'' +
                ", headPicPath='" + headPicPath + '\'' +
                '}';
    }
}
