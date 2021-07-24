package com.zichen.io.file;

import java.io.*;

/**
 * 复制文件
 * @author zc
 * @date 2021-07-24 12:00
 */
public class FileDemo03 {

    public static void main(String[] args) throws IOException {
        // 1.创建输入流和输出流
        File file = new File("f:/test.txt");
        File file1 = new File("f:/test1.txt");
        InputStream fileInputStream = new FileInputStream(file);
        OutputStream fileOutputStream = new FileOutputStream(file1);
        // 2.使用输入流和输出流完成文件的复制
        // 定义一个中转站，就是一个字节
        int n;
        // 先读一个字节
        n = fileInputStream.read();
        // n == -1 读到了文件的末尾
        while (n != -1) {
            // 写一个字符
            fileOutputStream.write(n);
            // 再读一个字节
            n = fileInputStream.read();
        }
        // 3.关闭资源
        fileInputStream.close();
        fileOutputStream.close();
    }

}
