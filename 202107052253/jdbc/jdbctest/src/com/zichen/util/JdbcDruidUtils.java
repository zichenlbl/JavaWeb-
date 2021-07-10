package com.zichen.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid 数据库连接池的工具类
 * @author zc
 * @date 2021-07-10 13:35
 */
public class JdbcDruidUtils {
    /**
     * 数据库连接池对象 数据源
     */
    private static final DataSource DATA_SOURCE;

    static {
        // 1.加载配置文件
        Properties pro = new Properties();
        InputStream io = JdbcDruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.获取 DataSource 数据源
        DataSource ds = null;
        try {
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DATA_SOURCE = ds;
    }

    /**
     * 获取连接
     * @return 数据库连接对象
     * @throws  SQLException 数据库异常
     */
    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }

    /**
     * 释放资源 查询
     * @param conn 数据库连接对象
     * @param stmt 执行sql的对象
     * @param rs 结果集对象
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        JdbcUtils.close(conn, stmt, rs);
    }

    /**
     * 释放资源 增删改
     * @param conn 数据库连接对象
     * @param stmt 执行sql的对象
     */
    public static void close(Connection conn, Statement stmt) {
        JdbcUtils.close(conn, stmt);
    }

    /**
     * 获取连接池方法
     * @return 数据库连接池对象
     */
    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }

}
