package com.zichen.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0的演示
 * @author zc
 * @date 2021-7-9 19:53
 */
public class JdbcDemo05 {

    public static void main(String[] args) {
        // 1.创建数据库连接池对象 不传参数 使用默认的配置 传参数 使用指定名称的配置
        DataSource ds = new ComboPooledDataSource();
        // 2.获取连接对象
        try {
            Connection conn = ds.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
