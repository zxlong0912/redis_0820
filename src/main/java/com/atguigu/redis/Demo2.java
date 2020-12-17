package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {

        Jedis jedis = sentinelUtil.getJedisFromPool();
        String pong = jedis.ping();
        jedis.set("k1", "v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
        Set<String> keys = jedis.keys("*");
        for(String key:keys){
            System.out.println(key);
        }
        String keys1 = jedis.type("keys");
        System.out.println(keys1);

        System.out.println(jedis.exists("keys"));

        jedis.close();
    }
}
