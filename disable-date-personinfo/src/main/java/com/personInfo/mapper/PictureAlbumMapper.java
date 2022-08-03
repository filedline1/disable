package com.personInfo.mapper;

import com.personInfo.bean.PictureAlbum;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureAlbumMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PictureAlbum record);

    int insertSelective(PictureAlbum record);

    PictureAlbum selectByPrimaryKey(Long id);

    List<PictureAlbum> selectPictureByUserId(Long userId);

    int selectPictureCountByUserId(Long userId);

    int updateByPrimaryKeySelective(PictureAlbum record);

    int updateByPrimaryKey(PictureAlbum record);

}