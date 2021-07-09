package com.zichen.jdbc;

import com.zichen.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc管理事务
 * @author zc
 * @date 2021-07-09 11:00
 */
public class JdbcDemo04 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            String sql = "update student set age = ? where name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 20);
            pstmt.setString(2, "zhangsan");
            Integer count = pstmt.executeUpdate();
            System.out.println(count);
            // 出现错误 java.lang.ArithmeticException: / by zero 自动回滚事务
            int a = 1/0;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 25);
            pstmt.setString(2, "lisi");
            count = pstmt.executeUpdate();
            System.out.println(count);
            // 提交事务
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    // 事务回滚
                    conn.rollback();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, pstmt);
        }
    }

}
