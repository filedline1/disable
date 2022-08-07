package com.personInfo.mapper;


import com.personInfo.bean.PersonBasicInfo;
import com.personInfo.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Mapper
public interface PersonBasicInfoMapper {


    /**
     * 批量查询personBasicInfo
     * @param recordItems
     * @return
     */
    List<PersonBasicInfo> selectBatch(@Param("recordItems") List<Integer> recordItems);

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
     * 根据recordId查找PersonBasicInfo对象
     * @param personId
     * @return
     */
    PersonBasicInfo selectByPrimaryKey(Integer personId);

    /**
     * 根据手机号查找PersonBasicInfo对象
     * @param phone
     * @return
     */
    PersonBasicInfo selectByPhone(String phone);

    /**
     * 删除择偶要求，账号注销时使用
     * @param id
     * @return
     */
    int delete(Integer id);

}
