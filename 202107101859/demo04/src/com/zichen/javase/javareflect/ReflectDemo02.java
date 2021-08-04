package com.zichen.javase.javareflect;

import com.zichen.javase.javareflect.entity.User;

/**
 * 反射实例化对象
 * @author zc
 * @date 2021-08-04 22:57
 */
public class ReflectDemo02 {

    public static void main(String[] args) {
        // 普通方法实例化对象
        User user = new User();
        System.out.println(user);
        try {
            // 通过反射机制获取 Class，通过 Class 来实例化对象
            Class<?> user1 = Class.forName("com.zichen.javase.javareflect.entity.User");
            // newInstance() 方法会调用 User 类的无参构造方法(必须要有无参构造方法)，完成对象的创建
            Object o = user1.newInstance();
            System.out.println(o);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
