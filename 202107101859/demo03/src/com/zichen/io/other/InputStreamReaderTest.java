package com.zichen.io.other;

import java.io.*;

/**
 * InputStreamReader 将字节输入流转为字符流
 * @author zc
 * @date 2021-07-25 22:03
 */
public class InputStreamReaderTest {

    public static void main(String[] args) {
        // 控制台输入流
        InputStream inputStream = System.in;
        // 将字节输入流转换为字符流 方便操作
        Reader reader = new InputStreamReader(inputStream);
        // 缓冲字符输入流
        BufferedReader bufferedReader = new BufferedReader(reader);
        // 字符打印输出流
        try (PrintWriter printWriter = new PrintWriter("f:/test3.txt")) {
            String str;
            // 控制台输入 "-1" 结束输入
            String flag = "-1";
            while (!flag.equals(str = bufferedReader.readLine())) {
                printWriter.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭资源
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
