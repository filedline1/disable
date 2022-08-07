package com.personInfo.service;

import com.personInfo.bean.PictureAlbum;
import com.personInfo.bean.VipPermission;
import com.personInfo.util.PageQueryUtil;

import java.util.List;

public interface PictureAlbumService {

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
