package com.zichen.javase.javareflect.entity;

/**
 * 用户实体类
 * @author zc
 * @date 2021-08-04 22:59
 */
public class User {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 年龄
     */
    private int age;

    public User() {
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
