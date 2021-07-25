package com.zichen.io.file;

import java.io.*;

/**
 * 缓冲字符流 BufferedReader 读取一行
 * 1.提高速度 2.简化操作
 * @author zc
 * @date 2021-07-25 16:01
 */
public class FileDemo08 {

    public static void main(String[] args) {
        // 创建输入流和输出流
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("f:/test.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("f:/test1.txt"))) {
            String str;
            // 读取一行
            while ((str = bufferedReader.readLine()) != null) {
                // 写一行
                bufferedWriter.write(str);
                // 换行 不同操作系统的换行符是不同的
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
