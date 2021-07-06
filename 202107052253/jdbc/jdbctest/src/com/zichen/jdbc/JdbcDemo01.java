package com.zichen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc快速入门
 * @author zc
 */
public class JdbcDemo01 {

    public static void main(String[] args) {
        // 1.导入驱动jar包 mysql jar包右键->Add As Library
        // 2.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 3.获取数据库连接对象
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/zichen",
                    "root",
                    "root");
            // 4.定义sql语句
            String sql = "update student set age = 20 where id = 01";
            // 5.获取执行sql的对象
            Statement stmt = conn.createStatement();
            // 6.执行sql
            int count = stmt.executeUpdate(sql);
            // 7.处理结果
            System.out.println(count);
            // 8.释放资源
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
