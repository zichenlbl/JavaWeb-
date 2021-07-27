package com.zichen.io.file;

import java.io.*;

/**
 * 复制文件夹内容
 * @author zc
 * @date 2021-07-27 19:42
 */
public class FileDemo11 {

    public static void main(String[] args) {
        String sourceFilePath = "F:\\test";
        String destinationFilePath = "F:\\test1";
        copyDirectory(sourceFilePath, destinationFilePath);
    }

    /**
     * 复制一个文件
     * @param sourceFilePath 源文件路径
     * @param destinationFilePath 目标文件路径
     */
    private static void copyFile(String sourceFilePath, String destinationFilePath) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFilePath))) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buf)) != -1) {
                bufferedOutputStream.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文件夹下的所有文件，不包括文件夹
     * @param sourceDirectory  源文件夹路径
     * @param destinationDirectory 目标文件夹路径
     */
    private static void copyDirectory(String sourceDirectory, String destinationDirectory) {
        // 如果源文件夹不存在，给出提示，结束程序
        File file = new File(sourceDirectory);
        // 不存在
        if (!file.exists()) {
            System.err.println("原文件夹不存在");
            return;
        }
        // 如果目标文件夹不存在，就创建目标文件夹
        File file1 = new File(destinationDirectory);
        if (!file1.exists()) {
            // 创建多级文件夹
            file1.mkdirs();
        }
        // 获取源文件夹下的所有文件(和文件夹)，并复制(文件)到目标文件夹路径下
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            // 如果是文件,就复制文件
            if (f.isFile()) {
                copyFile(sourceDirectory + "/" + f.getName(), destinationDirectory + "/" + f.getName());
            } else {
                // 如果是文件夹，就复制文件夹下的所有文件，不包括文件夹
                copyDirectory(sourceDirectory + "/" + f.getName(), destinationDirectory + "/" + f.getName());
            }
        }
    }

}
