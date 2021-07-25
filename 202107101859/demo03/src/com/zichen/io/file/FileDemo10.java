package com.zichen.io.file;

import com.zichen.io.entity.Classroom;
import com.zichen.io.entity.Student;

import java.io.*;
import java.util.Date;

/**
 * 使用 ObjectOutputStream 存储和读取各种数据类型
 * @author zc
 * @date 2021-07-25 18:16s
 */
public class FileDemo10 {

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
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream)) {
            // 使用输出流写基本数据类型和字符串
            objectOutputStream.writeInt(12);
            objectOutputStream.writeDouble(3.14);
            objectOutputStream.writeChar('a');
            objectOutputStream.writeUTF("测试");
            objectOutputStream.writeBoolean(true);
            // 写对象类型
            objectOutputStream.writeObject(new Date());
            // 序列化
            // age 是 transient 临时的 变量，年龄为 null
            objectOutputStream.writeObject(new Student("zhangsan", 21, new Classroom(1, "计算机1班")));
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
             ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream)) {
            // 使用输入流读基本数据类型和字符串
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readDouble());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readUTF());
            System.out.println(objectInputStream.readBoolean());
            // 读对象类型
            System.out.println(objectInputStream.readObject());
            // 反序列化
            System.out.println(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
