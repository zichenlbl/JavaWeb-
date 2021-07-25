package com.zichen.io.other;

import java.io.*;
import java.util.Scanner;

/**
 * PrintStream 打印输出流 处理流
 * @author zc
 * @date 2021-07-25 20:54
 */
public class PrintDemo01 {

    public static void main(String[] args) {
        // 字符流 输出流 输出字符到浏览器
        PrintWriter printWriter;
        // 字节流 输出流
        PrintStream printStream = System.out;
        // 打印在控制台
        printStream.println("Hello World!");
        try {
            // 打印在文件中
            printStream = new PrintStream("f:/test.txt");
            printStream.println("Hello World!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStream inputStream;
        Scanner sc;
        // 从控制台读取
        inputStream = System.in;
        sc = new Scanner(inputStream);
        System.out.println(sc.next());
        try {
            // 从文件中读取
            inputStream = new FileInputStream("f:/test.txt");
            sc = new Scanner(inputStream);
            System.out.println(sc.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 打印错误的流 红色字体错误提示 PrintStream err = null;
        System.err.println("test");
    }

}
