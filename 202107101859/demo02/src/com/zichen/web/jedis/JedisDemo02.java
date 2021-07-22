package com.zichen.web.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis 连接池
 * @author zc
 * @date 2021-07-22 23:01
 */
public class JedisDemo02 {

    public static void main(String[] args) {
        // 0.9.创建一个配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大允许连接数
        jedisPoolConfig.setMaxTotal(50);
        // 最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        // 1.创建 Jedis 连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
        // 2.获取连接
        Jedis jedis = jedisPool.getResource();
        // 3.使用
        jedis.set("age", "21");
        // 输出
        String age = jedis.get("age");
        System.out.println(age);
        // 4.关闭 归还到连接池
        jedis.close();
    }

}
