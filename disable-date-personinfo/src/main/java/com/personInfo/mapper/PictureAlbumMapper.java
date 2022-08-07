package com.personInfo.mapper;

import com.personInfo.bean.PictureAlbum;
import java.util.List;

import com.personInfo.bean.VipPermission;
import com.personInfo.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PictureAlbumMapper {

    /**
     * 获取记录的分页列表
     *
     * @param pageUtil
     * @return
     */
    List<VipPermission> findRecordList(PageQueryUtil pageUtil);

    int deleteByPrimaryKey(Long id);

    int insert(PictureAlbum record);

    int insertSelective(PictureAlbum record);

    PictureAlbum selectByPrimaryKey(Long id);

    List<PictureAlbum> selectPictureByUserId(Long userId);

    int selectPictureCountByUserId(Long userId);

    int updateByPrimaryKeySelective(PictureAlbum record);

    int updateByPrimaryKey(PictureAlbum record);

}