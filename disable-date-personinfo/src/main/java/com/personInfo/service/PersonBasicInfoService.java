package com.personInfo.service;


import com.personInfo.bean.PersonBasicInfo;
import com.personInfo.bean.PersonDetailInfo;
import com.personInfo.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonBasicInfoService {

    /**
     * 获取记录的分页列表
     *
     * @param pageUtil
     * @return
     */
    List<PersonBasicInfo> findRecordList(PageQueryUtil pageUtil);

    /**+
     * 选择性更新记录
     * @param personBasicInfo
     * @return
     */
    int updateByPrimaryKeySelective(PersonBasicInfo personBasicInfo);


    /**
     * 插入记录
     * @param personBasicInfo
     * @return
     */
    int insert(PersonBasicInfo personBasicInfo);

    /**
     * 根据record对象更新数据
     * @param personBasicInfo
     * @return
     */
    int update(PersonBasicInfo personBasicInfo);


    int insertBatch(@Param("recordItems") List<PersonBasicInfo> recordItems);


    /**
     * 选择性插入记录
     * @param personBasicInfo 记录对象
     * @return
     */
    int insertSelective(PersonBasicInfo personBasicInfo);

    /**
     * 根据id查找PersonBasicInfo对象
     * @param personId
     * @return
     */
    PersonBasicInfo selectByPrimaryKey(Integer personId);

    /**
     * 批量删除信息
     * @param id 用户id
     * @return
     */
    int delete(Integer id);


}
