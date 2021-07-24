package com.zichen.io.file;

import java.io.*;

/**
 * 字符流复制文本文件
 * 字符流处理非英文字符方便，字符流的底层是字节流
 * FileReader FileWriter FileInputStream FileOutputStream 都是节点流：直接和数据源相邻
 * @author zc
 * @date 2021-07-24 16:21
 */
public class FileDemo06 {

    public static void main(String[] args) {
        // 1.创建输入流和输出流
        try (Reader fileReader = new FileReader("f:/test2.txt");
             Writer fileWriter = new FileWriter("f:/test3.txt")) {
        // 2.使用输入流和输出流复制文件
            // 2.1定义一个中转站，一个字符
            char[] cbuf = new char[1024];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                // 2.2写一个字符数组的内容到文件
                fileWriter.write(cbuf, 0, len);
                // 测试 输出到控制台
                System.out.println(new String(cbuf,0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
