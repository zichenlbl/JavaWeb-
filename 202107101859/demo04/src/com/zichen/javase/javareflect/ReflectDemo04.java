package com.zichen.javase.javareflect;

/**
 * 反射实例化对象 只让对象的静态代码块执行
 * @author zc
 * @date 2021-08-05 21:44
 */
public class ReflectDemo04 {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.zichen.javase.javareflect.TestClass01");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class TestClass01 {
    /**
     * id
     */
    private Integer id;
    // 静态代码块在类加载的时候只执行一次
    static {
        System.out.println("静态代码块执行...");
    }

}
