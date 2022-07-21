package com.chat.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class imageTest {

    public static void main(String[] args) throws Exception {
        //需要压缩的图片地址     aaa.jpg为需要压缩的图片
        File customaryFile = new File("C:\\Users\\Administrator\\Pictures\\uToolsWallpapers\\wallhaven-1k3ezw.jpg");
        //压缩过后输出的路径地址    eee.jpg 可进行设置为任意名称
        File compressAfter = new File("C:\\Users\\Administrator\\Pictures\\uToolsWallpapers\\wallhaven-1k3ezwTest.jpg");
        Thumbnails.of(customaryFile)
                .size(3840, 2160)
                .keepAspectRatio(false)
                .allowOverwrite(true)
                .toFile(compressAfter);
    }

}
