package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class list {
    public static void main(String[] args) {
        Jedis jedis = jedisUtil.getJedisFromPool();

        Long a = jedis.lpush("a", "1", "2", "3", "4");
        List<String> a1 = jedis.lrange("a", 0, -1);
        for (String str:a1) {
            System.out.println(str);
        }
        jedis.close();
    }
}
