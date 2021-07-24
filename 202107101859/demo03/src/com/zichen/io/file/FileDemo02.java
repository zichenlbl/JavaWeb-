package com.zichen.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 实现对文件、文件夹的创建和删除
 * 如果文件存在，就删除，如果不存在，就创建
 * @author zc
 * @date 2021-07-24 11:13
 */
public class FileDemo02 {

    public static void main(String[] args) {
        // 创建一个 File 对象指向一个文件
        // File file = new File("f:/test.txt");
        File file = new File("f:/abc/def/test.txt");
        // 如果文件存在，就删除，如果不存在，就创建
        if (file.exists()) {
            file.delete();
        } else {
            // 如果上级文件夹不存在，就创建
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                // parentFile.mkdir(); // make directory 新建一级文件夹
                parentFile.mkdirs(); // 新建多级文件夹
            }
            try {
                // 创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
