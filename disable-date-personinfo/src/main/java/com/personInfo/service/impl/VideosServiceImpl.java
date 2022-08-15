package com.personInfo.service.impl;

import com.personInfo.bean.Videos;
import com.personInfo.mapper.VideosMapper;
import com.personInfo.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class VideosServiceImpl implements VideosService {

    @Autowired
    VideosMapper videosMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public List<Videos> selectByUserId(Integer userId) {
        return videosMapper.selectByUserId(userId);
    }

    @Override
    public int insert(Videos record) {
        return 0;
    }

    @Override
    public int insertSelective(Videos record) {
        return 0;
    }

    @Override
    public Videos selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Videos record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Videos record) {
        return 0;
    }
}
