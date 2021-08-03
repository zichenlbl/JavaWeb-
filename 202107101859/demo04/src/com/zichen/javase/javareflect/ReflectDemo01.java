package com.zichen.javase.javareflect;

/** 获取一个类的字节码的三种方式
 * 反射机制可以操作类的字节码文件
 * @author zc
 * @date 2021-08-03 22:42
 */
public class ReflectDemo01 {

    public static void main(String[] args) {
        // 第一种方式 Class.forName() 静态方法 参数是全类名
        Class<?> aClass = null;
        try {
            aClass = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 第二种方式 java 中任何对象都有 getClass() 方法
        String s = "";
        Class<? extends String> aClass1 = s.getClass();
        // 第三种方式 java 中任何类型都有 .class 属性
        Class<String> aClass2 = String.class;
        // true
        System.out.println(aClass == aClass1);
        // true
        System.out.println(aClass == aClass2);
        // true
        System.out.println(aClass1 == aClass2);
    }

}
