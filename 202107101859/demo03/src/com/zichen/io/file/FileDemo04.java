package com.zichen.io.file;

import java.io.*;

/**
 * InputStream 和 OutputStream 复制文件
 * @author zc
 * @date 2021-07-24 12:11
 */
public class FileDemo04 {

    public static void main(String[] args) {
        // 1.创建输入流和输出流
        /*File file = new File("f:/test.mp4");
        File file1 = new File("f:/test1.mp4");
        InputStream fileInputStream = new FileInputStream(file);
        OutputStream fileOutputStream = new FileOutputStream(file1);*/
        /*InputStream fileInputStream = new FileInputStream(new File("f:/test.mp4"));
        OutputStream fileOutputStream = new FileOutputStream(new File("f:/test1.mp4"));*/
        // append 追加
        // OutputStream fileOutputStream = new FileOutputStream(file1, true);
        InputStream fileInputStream = null;
        OutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("f:/test.mp4");
            fileOutputStream = new FileOutputStream("f:/test1.mp4");
            // 2.使用输入流和输出流完成文件的复制
            // 定义一个中转站，就是一个字节数组
            byte[] buf = new byte[1024];
            // 先读内容到一个字节数组 读文件的内容放入到字节数组中，返回读取的字节数
            int len = fileInputStream.read(buf);
            // len == -1 读到了文件的末尾
            while (len != -1) {
                // 将字节数组的内容写入文件 读了多少字节数写多少字节数
                fileOutputStream.write(buf, 0, len);
                // 再读内容到一个字节数组
                len = fileInputStream.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.关闭资源
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
