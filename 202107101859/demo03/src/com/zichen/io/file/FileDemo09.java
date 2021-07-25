package com.zichen.io.file;

import java.io.*;

/**
 * 使用 DataOutputStream 存储和读取基本数据类型和字符串
 * @author zc
 * @date 2021-07-25 16:39
 */
public class FileDemo09 {

    public static void main(String[] args) {
        write();
        read();
    }

    /**
     * 存储数据
     */
    private static void write() {
        // 创建一个输出流
        try (FileOutputStream fileOutputStream = new FileOutputStream("f:/test2.txt");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)) {
            // 使用输出流写基本数据类型和字符串
            dataOutputStream.writeInt(12);
            dataOutputStream.writeDouble(3.14);
            dataOutputStream.writeChar('a');
            dataOutputStream.writeUTF("测试");
            dataOutputStream.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取数据
     */
    private static void read() {
        // 创建一个输入流
        try (FileInputStream fileInputStream = new FileInputStream("f:/test2.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {
            // 使用输入流读基本数据类型和字符串
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
