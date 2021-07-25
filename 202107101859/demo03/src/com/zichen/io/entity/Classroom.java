package com.zichen.io.entity;

import java.io.Serializable;

/**
 * 教室实体类
 * @author zc
 * @date 2021-07-25 19:19
 */
public class Classroom implements Serializable {
    private Integer id;
    private String name;

    public Classroom() {
    }

    public Classroom(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
