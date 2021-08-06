package com.zichen.javase.javareflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取类的属性信息 Field
 * @author zc
 * @date 2021-08-06 22:04
 */
public class ReflectDemo08 {

    public static void main(String[] args) {
        try {
            // 获取整个类
            Class<?> studentClass = Class.forName("com.zichen.javase.javareflect.entity.Student");
            // 获取类的完整类名
            System.out.println(studentClass.getName());
            // 获取类的简类名
            System.out.println(studentClass.getSimpleName());
            // 获取类中所有 public 修饰的 Fields
            Field[] fields = studentClass.getFields();
            System.out.println(fields.length);
            // 获取类中所有的 Fields
            Field[] declaredFields = studentClass.getDeclaredFields();
            System.out.println(declaredFields.length);
            for (Field declaredField : declaredFields) {
                // 获取 Field 的修饰符数组 修饰符代号 int 转为 String
                int modifiers = declaredField.getModifiers();
                // 修饰符代号转为字符串
                String s = Modifier.toString(modifiers);
                System.out.print(s);
                if (modifiers != 0) {
                    System.out.print(" ");
                }
                // 获取 Field 的类型的类
                Class<?> type = declaredField.getType();
                // 获取类的全名字 java.lang.String
                String name = type.getName();
                // 简类名 String
                String simpleName = type.getSimpleName();
                System.out.print(name + " " + simpleName + " ");
                // 获取 Field 的名字
                System.out.println(declaredField.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
