package com.zichen.web.jedis;

import redis.clients.jedis.Jedis;

/**
 * Jedis 连接 Redis
 * @author zc
 * @date 2021-07-22 21:58
 */
public class JedisDemo01 {

    public static void main(String[] args) {
        // 1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2.操作
        jedis.set("username", "lisi");
        // 获取
        String username = jedis.get("username");
        System.out.println(username);
        // 3.关闭连接
        jedis.close();
    }

}
