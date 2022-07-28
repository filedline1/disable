package com.personInfo.service;


import com.personInfo.bean.Requirement;
import com.personInfo.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RequirementService {

    /**
     * 获取记录的分页列表
     *
     * @param pageUtil
     * @return
     */
    List<Requirement> findRecordList(PageQueryUtil pageUtil);

    /**+
     * 选择性更新记录
     * @param requirement
     * @return
     */
    int updateByPrimaryKeySelective(Requirement requirement);


    /**
     * 插入记录
     * @param requirement
     * @return
     */
    int insert(Requirement requirement);

    /**
     * 根据record对象更新数据
     * @param requirement
     * @return
     */
    int update(Requirement requirement);


    int insertBatch(@Param("recordItems") List<Requirement> recordItems);


    /**
     * 选择性插入记录
     * @param requirement 记录对象
     * @return
     */
    int insertSelective(Requirement requirement);

    /**
     * 根据id查找Requirement对象
     * @param personId
     * @return
     */
    Requirement selectByPrimaryKey(Integer personId);

    /**
     * 删除信息
     * @param id 用户id
     * @return
     */
    int delete(Integer id);


}
