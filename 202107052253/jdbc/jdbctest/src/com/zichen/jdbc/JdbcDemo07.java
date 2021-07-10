package com.zichen.jdbc;

import com.zichen.entity.Student;
import com.zichen.util.JdbcDruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * JdbcTemplate 入门
 * @author zc
 * @date 2021-07-10 13:27
 */
public class JdbcDemo07 {

    private static JdbcTemplate template;
    /**
     * sql语句
     */
    private static String sql;

    public static void main(String[] args) {
        // 测试各个sql方法
        boolean flag = false;
        // 开启测试
        flag = true;
        // 1.导入jar包
        // 2.创建 JdbcTemplate 对象
        template = new JdbcTemplate(JdbcDruidUtils.getDataSource());
        if (flag) {
            test01("lisi");
            test02();
            test03();
            test04();
            return;
        }
        // 3.调用方法
        sql = "update student set age = ? where name = ?";
        int count = template.update(sql, 19, "lisi");
        System.out.println(count);
    }

    /**
     * 查询某个学生的信息 queryForMap Map 一条记录
     */
    private static void test01(String name) {
        Map<String, Object> map = template.queryForMap(
                "select * from student where name = ?",
                name);
        // {id=1, name=zhangsan, age=18}
        System.out.println(map);
        System.out.println("---------------------------");
    }

    /**
     * 查询所有学生信息 queryForList List 多个 Map 记录
     */
    private static void test02() {
        sql = "select * from student";
        for (Map<String, Object> map : template.queryForList(sql)) {
            System.out.println(map);
        }
        System.out.println("---------------------------");
    }

    /**
     * 查询所有学生信息 封装为 Student 对象的 List 集合
     */
    private static void test03() {
        sql = "select * from student";
        // 使用 package org.springframework.jdbc.core; 提供的实现类
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        for (Student stu:list
             ) {
            System.out.println(stu);
        }
        System.out.println("---------------------------");
        // 自己写一个匿名对象重写 mapRow 方法
        for (Student student : template.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
            }
        })) {
            System.out.println(student);
        }
        /*
            Student{id=1, name='zhangsan', age=18}
            Student{id=2, name='lisi', age=55}
         */
        System.out.println("---------------------------");
    }

    /**
     * 查询学生的数量 queryForObject 聚合函数的查询
     */
    private static void test04() {
        Long count = template.queryForObject("select count(id) from student", Long.class);
        System.out.println(count);
        // 2
        System.out.println("---------------------------");
    }

}
