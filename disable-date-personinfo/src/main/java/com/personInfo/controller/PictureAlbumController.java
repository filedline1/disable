package com.personInfo.controller;

import com.personInfo.bean.PictureAlbum;
import com.personInfo.bean.VipPermission;
import com.personInfo.service.PictureAlbumService;
import com.personInfo.service.VipPermissionService;
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
public class PictureAlbumController {

    @Autowired
    private PictureAlbumService pictureAlbumService;

    @Autowired
    private VipPermissionService vipPermissionService;

    /**
     * 获取记录的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/pictureAlbum/list", method = RequestMethod.GET)
    @ResponseBody
    public Result findRecordList(@Param("start")int start, @Param("limit")int limit){
        PageQueryUtil params = new PageQueryUtil(start,limit);
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        final List<VipPermission> recordList = pictureAlbumService.findRecordList(params);
        return ResultGenerator.genSuccessResult(recordList);
    }

    /**
     * 根据相册id删除照片路径
     * @param id
     * @return
     */
    @RequestMapping(value = "/pictureAlbum/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteByPrimaryKey(Long id) {
        int delete = pictureAlbumService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/pictureAlbum/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSelective(PictureAlbum record) {
        VipPermission vipPermission = vipPermissionService.selectByUserId(record.getUserId());
        int number = pictureAlbumService.selectPictureCountByUserId(record.getUserId());
        int limit = vipPermission.getAlbumCount();
        if (vipPermission == null){
            limit = 0;
        }
        if (number >= limit){
            return ResultGenerator.genFailResult("上传的照片数超过上限!");
        }
        System.out.println(record);
        int insert = pictureAlbumService.insertSelective(record);
        if (insert > 0){
            return ResultGenerator.genSuccessResult("新增图片成功");
        }
        return ResultGenerator.genFailResult("服务器错误，请及时联系管理员");
    }

    /**
     * 根据照片id查找图片
     * @param id
     * @return
     */
    @RequestMapping(value = "/pictureAlbum/id", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByPrimaryKey(@RequestParam("id") Long id) {
        final PictureAlbum pictureAlbum = pictureAlbumService.selectByPrimaryKey(id);
        if (pictureAlbum == null){
            return ResultGenerator.genFailResult("该图片不存在");
        }
        return ResultGenerator.genSuccessResult(pictureAlbum);
    }

    /**
     * 根据用户id查找该用户的所有照片
     * @param userId
     * @return
     */
    @RequestMapping(value = "/pictureAlbum/userId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByUserId(@RequestParam("userId") Long userId) {
        final List<PictureAlbum> pictureAlbums = pictureAlbumService.selectPictureByUserId(userId);
        if (pictureAlbums == null){
            return ResultGenerator.genFailResult("该用户不存在");
        }
        return ResultGenerator.genSuccessResult(pictureAlbums);
    }

    /**
     * 更新照片信息
     * @param record
     * @return
     */
    @RequestMapping(value = "/pictureAlbum/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateByPrimaryKeySelective(PictureAlbum record) {
        int update = pictureAlbumService.updateByPrimaryKeySelective(record);
        if (update > 0){
            return ResultGenerator.genSuccessResult("更新成功");
        }
        return ResultGenerator.genFailResult("更新失败");
    }

}
