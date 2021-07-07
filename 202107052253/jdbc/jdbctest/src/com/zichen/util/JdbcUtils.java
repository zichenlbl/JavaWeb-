package com.zichen.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * Jdbc 自定义工具类
 * @author zc
 * @date 2021-07-07 12:27
 */
public class JdbcUtils {
    // 静态变量被静态代码块读取
    /**
     * 数据库 url
     */
    private static final String URL;
    /**
     * 数据库 用户名
     */
    private static final String USER;
    /**
     * 数据库 密码
     */
    private static final String PASSWORD;
    /**
     * 数据库 驱动名
     */
    private static final String DRIVER;

    // 读取 jdbc.properties 配置文件,只需读取一次即可获取配置的值 只执行一次
    static {
        // 读取资源文件，获得配置的值
        // 1.创建 Properties 集合类
        Properties pro = new Properties();
        // 获取src路径下的文件的方式-->Class Loader 类加载器 可以 加载字节码文件进内存;可以 获取src路径下文件的URL
        ClassLoader classLoader = JdbcUtils.class.getClassLoader();
        // 以src为相对的根路径
        // URL:统一资源定位器 绝对路径
        URL url = classLoader.getResource("jdbc.properties");
        String path = "";
        if (url != null) {
            // 获取次URL的路径部分
            path = url.getPath();
        }
        // 2.加载文件
        try {
            pro.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3.获取数据，赋值
        URL = pro.getProperty("url");
        USER = pro.getProperty("user");
        PASSWORD = pro.getProperty("password");
        DRIVER = pro.getProperty("driver");
        // 4.注册驱动
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * 数据库名从配置文件  中获得
     * @return 数据库连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 关闭 jdbc 连接资源
     * @param conn 数据库连接对象
     * @param stmt 执行sql的对象
     * @param rs   结果集对象
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭 jdbc 连接资源
     * @param conn 数据库连接对象
     * @param stmt 执行sql的对象
     */
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }

}
