package com.zichen.javase.javareflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取类路径下配置文件 以流的方式返回
 * @author zc
 * @date 2021-08-05 22:26
 */
public class ReflectDemo06 {

    public static void main(String[] args) {
        // 直接以流的方式返回
        InputStream resourceAsStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("test.properties");
        try {
            // 读取配置文件
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            resourceAsStream.close();
            String className = properties.getProperty("className");
            System.out.println(className);
            // 调用反射实例化对象的方法
            ReflectDemo05.instantiateObject(className);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
