package com.personInfo.service.impl;

import com.personInfo.bean.PictureAlbum;
import com.personInfo.bean.VipPermission;
import com.personInfo.mapper.PictureAlbumMapper;
import com.personInfo.service.PictureAlbumService;
import com.personInfo.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class PictureAlbumServiceImpl implements PictureAlbumService {

    @Autowired
    private PictureAlbumMapper pictureAlbumMapper;

    @Override
    public List<VipPermission> findRecordList(PageQueryUtil pageUtil) {
        final List<VipPermission> recordList = pictureAlbumMapper.findRecordList(pageUtil);
        return recordList;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pictureAlbumMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PictureAlbum record) {
        return pictureAlbumMapper.insert(record);
    }

    @Override
    public int insertSelective(PictureAlbum record) {
        record.setCreateTime(new Date());
        return pictureAlbumMapper.insertSelective(record);
    }

    @Override
    public PictureAlbum selectByPrimaryKey(Long id) {
        return pictureAlbumMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PictureAlbum> selectPictureByUserId(Long userId) {
        return pictureAlbumMapper.selectPictureByUserId(userId);
    }

    @Override
    public int selectPictureCountByUserId(Long userId) {
        return pictureAlbumMapper.selectPictureCountByUserId(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(PictureAlbum record) {
        return pictureAlbumMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PictureAlbum record) {
        return pictureAlbumMapper.updateByPrimaryKey(record);
    }
}
