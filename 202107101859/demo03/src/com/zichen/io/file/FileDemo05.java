package com.zichen.io.file;

import java.io.*;

/**
 * jdk7 新的资源释放方式
 * 把要释放的资源写在 try 后面括号中
 * @author zc
 * @date 2021-07-24 12:11
 */
public class FileDemo05 {

    public static void main(String[] args) {
        // 1.创建输入流和输出流
        try (InputStream fileInputStream = new FileInputStream("f:/test.mp4");
             OutputStream fileOutputStream = new FileOutputStream("f:/test1.mp4")) {
            // 2.使用输入流和输出流完成文件的复制
            // 定义一个中转站，就是一个字节数组
            byte[] buf = new byte[1024];
            // 先读内容到一个字节数组 读文件的内容放入到字节数组中，返回读取的字节数
            int len;
            // len == -1 读到了文件的末尾
            while ((len = fileInputStream.read(buf)) != -1) {
                // 将字节数组的内容写入文件 读了多少字节数写多少字节数
                fileOutputStream.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
