package com.zichen.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * druid的演示
 * @author zc
 * @date 2021-07-10 00:51
 */
public class JdbcDemo06 {

    public static void main(String[] args) {
        // 1.导入jar包
        // 2.定义配置文件 druid.properties
        // 3.加载配置文件
        Properties pro = new Properties();
        InputStream io = JdbcDemo06.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4.获取数据库连接池对象
        try {
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            // 5.获取连接
            Connection conn = ds.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
