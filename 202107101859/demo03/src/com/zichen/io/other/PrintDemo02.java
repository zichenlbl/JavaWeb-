package com.zichen.io.other;

import java.io.*;

/**
 * PrintWriter 字符输出流 输出一行并换行
 * @author zc
 * @date 2021-07-25 21:47
 */
public class PrintDemo02 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("f:/test.txt"));
             PrintWriter printWriter = new PrintWriter("f:/test1.txt")) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                // 写入一行并换行
                printWriter.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
