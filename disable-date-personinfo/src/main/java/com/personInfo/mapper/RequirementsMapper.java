package com.personInfo.mapper;


import com.personInfo.bean.Requirement;
import com.personInfo.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Mapper
public interface RequirementsMapper {

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
     * 根据recordId查找Requirement对象
     * @param personId
     * @return
     */
    Requirement selectByPrimaryKey(Integer personId);


    /**
     * 删除择偶要求，账号注销时使用
     * @param id
     * @return
     */
    int delete(Integer id);

}
