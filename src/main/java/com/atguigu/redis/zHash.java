package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class zHash {
    public static void main(String[] args) {

        Jedis jedis = jedisUtil.getJedisFromPool();

        jedis.zadd("g",10d,"v2");
        jedis.zadd("g",4d,"v2");
        jedis.zadd("g",18d,"v2");
        jedis.zadd("g",22d,"v2");

        Long value = jedis.zcard("g");
        System.out.println(value);
        System.out.println("******************************");
        Set<String> list1 = jedis.zrange("g", 0, -1);
        for(String list:list1){
            System.out.println(list);
        }

        System.out.println("******************");
        Set<String> list2 = jedis.zrevrangeByScore("g", 100d, 20d);
        for(String list:list2){
            System.out.println(list);
        }
        System.out.println("**************");
        List<String> list3 = jedis.mget("g");
        for(String list :list3){
            System.out.println(list);
        }


        jedis.close();

    }
}
