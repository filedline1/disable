package com.personInfo.controller;

import com.personInfo.bean.PictureAlbum;
import com.personInfo.bean.Videos;
import com.personInfo.bean.VipPermission;
import com.personInfo.service.VideosService;
import com.personInfo.util.PageQueryUtil;
import com.personInfo.util.Result;
import com.personInfo.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Controller
public class VideosController {

    @Autowired
    VideosService videosService;

    /**
     * 根据用户id查找该用户的所有照片
     * @param userId
     * @return
     */
    @RequestMapping(value = "/videos/userId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByUserId(@RequestParam("userId") Integer userId) {
        final List<Videos> pictureAlbums = videosService.selectByUserId(userId);
        if (pictureAlbums == null){
            return ResultGenerator.genFailResult("该用户不存在");
        }
        return ResultGenerator.genSuccessResult(pictureAlbums);
    }

    /**
     * 根据相册id删除MV路径
     * @param id
     * @return
     */
    @RequestMapping(value = "/videos/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteByPrimaryKey(String id) {
        int delete = videosService.deleteByPrimaryKey(id);
        if (delete > 0){
            return ResultGenerator.genSuccessResult("删除成功");
        }
        return ResultGenerator.genSuccessResult("删除失败");
    }

    /**
     * 新增照片
     * @param record
     * @return
     */
    @RequestMapping(value = "/videos/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSelective(Videos record) {
        int insert = videosService.insertSelective(record);
        if (insert > 0){
            return ResultGenerator.genSuccessResult("新增MV成功");
        }
        return ResultGenerator.genFailResult("服务器错误，请及时联系管理员");
    }

    /**
     * 根据照片id查找MV
     * @param id
     * @return
     */
    @RequestMapping(value = "/videos/id", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByPrimaryKey(@RequestParam("id") String id) {
        final Videos pictureAlbum = videosService.selectByPrimaryKey(id);
        if (pictureAlbum == null){
            return ResultGenerator.genFailResult("该MV不存在");
        }
        return ResultGenerator.genSuccessResult(pictureAlbum);
    }

    /**
     * 更新MV信息
     * @param record
     * @return
     */
    @RequestMapping(value = "/videos/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateByPrimaryKeySelective(Videos record) {
        int update = videosService.updateByPrimaryKeySelective(record);
        if (update > 0){
            return ResultGenerator.genSuccessResult("更新成功");
        }
        return ResultGenerator.genFailResult("更新失败");
    }

}
