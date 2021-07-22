package com.zichen.web.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool 工具类
 * 加载配置文件，配置连接池的参数
 * 提供获取连接的方法
 * @author zc
 * @date 2021-07-22 23:16
 */
public class JedisPoolUtils {

    /**
     * 连接池对象
     */
    private static final JedisPool jedisPool;

    static {
        // 1.读取配置文件
        InputStream inputStream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        // 2.创建 Properties 对象
        Properties properties = new Properties();
        try {
            // 3.关联文件
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4.获取数据,设置到 JedisPoolConfig 中
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        // 5.初始化 JedisPool
        jedisPool = new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }

    /**
     * 获取连接
     * @return 连接对象
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}
