package com.zichen.jdbc;

import com.zichen.util.JdbcUtils;

import java.sql.*;

/**
 * ResultSet 使用
 * @author zc
 */
public class JdbcDemo02 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from student";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getInt(1) + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.print(rs.getInt(3) + " ");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.close(conn, stmt, rs);
        }

    }

}
