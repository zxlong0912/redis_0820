package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hash {
    public static void main(String[] args) {
        Jedis jesis = jedisUtil.getJedisFromPool();
//        jesis.hset("user","email","@163");
//        String hget = jesis.hget("user", "email");
//        System.out.println(hget);
//        jesis.hset("c","name","zhangsan");
//        jesis.hset("c","age","18");
//        jesis.hset("c","id","1");
//        Map<String, String> c = jesis.hgetAll("c");
        HashMap<String, String> map = new HashMap<>();

        map.put("name","zhangsan");
        map.put("age","18");
        map.put("id","1");

        jesis.hmset("e",map);
        List<String> result = jesis.hmget("e", "name", "age");
        for(String str:result){
            System.out.println(str);
        }


        jesis.close();
    }
}
