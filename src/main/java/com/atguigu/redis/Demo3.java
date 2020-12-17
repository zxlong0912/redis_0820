package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Demo3 {
    public static void main(String[] args) {

        redis.clients.jedis.JedisCluster jedis = JedisCluster.getJedisFromPool();
        jedis.set("k1", "v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");

        System.out.println(jedis.get("k1"));

        System.out.println(jedis.get("k2"));
        String keys1 = jedis.type("keys");
        System.out.println(keys1);

        System.out.println(jedis.exists("keys"));


    }
}
