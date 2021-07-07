package com.zichen.jdbc;

import com.zichen.entity.Student;
import com.zichen.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 将Student表封装为对象，装载集合，返回查询结果
 * @author zc
 */
public class JdbcDemo03 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 获取数据库连接对象 使用自定义的 jdbc 工具类
            conn = JdbcUtils.getConnection();
            String sql = "select * from student";
            // 预编译sql语句 防止sql注入
            pstmt = conn.prepareStatement(sql);
            // 执行查询 不需要传sql
            rs = pstmt.executeQuery();
            List<Student> arrayList = new ArrayList<>();
            // 减少每次循环都要创建一个 student
            Student student;
            while (rs.next()) {
                // 把查询的每行记录封装为 student 对象
                student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                // 添加进数组
                arrayList.add(student);
            }
            // 输出结果
            arrayList.forEach((item)->System.out.println(item.toString()));
            /*
              Student{id=1, name='zhangsan', age=20}
              Student{id=2, name='lisi', age=21}
             */
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.close(conn, pstmt, rs);
        }
    }

}
