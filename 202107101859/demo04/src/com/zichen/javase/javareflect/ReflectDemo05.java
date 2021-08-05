package com.zichen.javase.javareflect;

import java.io.*;
import java.util.Properties;

/**
 * 获取类路径下文件的绝对路径
 * 文件需要在类路径下
 * @author zc
 * @date 2021-08-05 21:55
 */
public class ReflectDemo05 {

    public static void main(String[] args) {
        // 当前线程对象 获取当前线程的类加载器对象 获取资源 当前线程的类加载器默认从类的根路径下加载资源
        String path = Thread.currentThread()
                .getContextClassLoader()
                .getResource("test.properties")
                .getPath();
        System.out.println(path);
        try {
            // 通过 IO 流读取 test.properties 配置文件
            FileReader fileReader = new FileReader(path);
            // 创建属性类对象 Map
            Properties properties = new Properties();
            // 加载
            properties.load(fileReader);
            // 关闭流
            fileReader.close();
            // 通过 key 获取 value
            String className = properties.getProperty("className");
            System.out.println(className);
            instantiateObject(className);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实例化对象
     * @param className 对象全类名
     */
    protected static void instantiateObject(String className) {

        try {
            // 通过反射机制实例化对象
            Class<?> aClass = Class.forName(className);
            Object o = aClass.newInstance();
            System.out.println(o);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
