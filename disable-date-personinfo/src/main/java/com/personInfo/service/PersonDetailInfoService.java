package com.personInfo.service;


import com.personInfo.bean.PersonDetailInfo;
import com.personInfo.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonDetailInfoService {

    /**
     * 获取记录的分页列表
     *
     * @param pageUtil
     * @return
     */
    List<PersonDetailInfo> findRecordList(PageQueryUtil pageUtil);

    /**+
     * 选择性更新记录
     * @param personDetailInfo
     * @return
     */
    int updateByPrimaryKeySelective(PersonDetailInfo personDetailInfo);


    /**
     * 插入记录
     * @param personDetailInfo
     * @return
     */
    int insert(PersonDetailInfo personDetailInfo);

    /**
     * 根据record对象更新数据
     * @param personDetailInfo
     * @return
     */
    int update(PersonDetailInfo personDetailInfo);


    int insertBatch(@Param("recordItems") List<PersonDetailInfo> recordItems);


    /**
     * 选择性插入记录
     * @param personDetailInfo 记录对象
     * @return
     */
    int insertSelective(PersonDetailInfo personDetailInfo);

    /**
     * 根据id查找PersonBasicInfo对象
     * @param personId
     * @return
     */
    PersonDetailInfo selectByPrimaryKey(Integer personId);

    /**
     * 批量删除信息
     * @param id 用户id
     * @return
     */
    int delete(Integer id);


}
