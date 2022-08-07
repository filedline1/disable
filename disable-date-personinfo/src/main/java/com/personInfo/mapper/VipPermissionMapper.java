package com.personInfo.mapper;

import com.personInfo.bean.VipPermission;
import java.util.List;

import com.personInfo.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VipPermissionMapper {

    /**
     * 获取记录的分页列表
     *
     * @param pageUtil
     * @return
     */
    List<VipPermission> findRecordList(PageQueryUtil pageUtil);

    /**
     * 根据configId删除VipPermission
     * @param configId
     * @return
     */
    int deleteByPrimaryKey(Long configId);

    /**
     * 插入VipPermission对象
     * @param record
     * @return
     */
    int insert(VipPermission record);

    /**
     * 选择性插入VipPermission对象
     * @param record
     * @return
     */
    int insertSelective(VipPermission record);


    /**
     * 根据configId查询VipPermission
     * @param configId
     * @return
     */
    VipPermission selectByPrimaryKey(Long configId);

    /**
     * 根据userId查询VipPermission
     * @param userId
     * @return
     */
    VipPermission selectByUserId(Long userId);

    int updateByPrimaryKeySelective(VipPermission record);

    int updateByPrimaryKey(VipPermission record);
}