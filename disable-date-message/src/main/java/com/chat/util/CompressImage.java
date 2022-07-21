package com.chat.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class CompressImage {

    public static void compressImage(File compressFile) {
        try {
            Thumbnails.of(compressFile)
                    .size(1200, 800)
                    .keepAspectRatio(false)
                    .allowOverwrite(true)
                    .toFile(compressFile);
        } catch (IOException e) {
            System.out.println("压缩文件错误!");
            e.printStackTrace();
        }

    }

}
