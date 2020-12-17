package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class set {
    public static void main(String[] args) {
        Jedis jedis = jedisUtil.getJedisFromPool();

        jedis.sadd("b","1");
        jedis.sadd("b","2");



        Set<String> list = jedis.smembers("b");

        for(String str:list){
            System.out.println(str);
        }

        jedis.close();
    }

}
