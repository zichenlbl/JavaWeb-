package com.zichen.io.entity;

import java.io.Serializable;

/**
 * 学生实体类
 * @author zc
 * @date 2021-07-25 18:15
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 3107157470734594792L;
    private String name;
    /**
     * transient 临时的 不参与序列化到硬盘 persistence 持久的
      */
    private transient Integer age;
    private Classroom classroom;

    public Student() {
    }

    public Student(String name, Integer age, Classroom classroom) {
        this.name = name;
        this.age = age;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classroom=" + classroom +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
