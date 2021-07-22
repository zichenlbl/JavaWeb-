package com.zichen.web.jedis;

import com.zichen.web.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

/**
 * 使用 JedisPool 工具类
 * @author zc
 * @date 2021-07-22 23:40
 */
public class JedisDemo03 {

    public static void main(String[] args) {
        // 通过连接池工具类获取连接
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("username", "zhangsan");
        String test = jedis.get("username");
        System.out.println(test);
        jedis.close();
    }

}
