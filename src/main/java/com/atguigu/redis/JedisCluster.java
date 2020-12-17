package com.atguigu.redis;

import redis.clients.jedis.*;

import java.util.HashSet;

public class JedisCluster {

    private static redis.clients.jedis.JedisCluster jedisCluster =null;

    public static redis.clients.jedis.JedisCluster getJedisFromPool(){
        if(jedisCluster ==null){
            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(5); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong

            HashSet<HostAndPort> hostAndPorts = new HashSet<>();

            hostAndPorts.add(new HostAndPort("192.168.202.102",6379));
            hostAndPorts.add(new HostAndPort("192.168.202.103",6380));
            hostAndPorts.add(new HostAndPort("192.168.202.104",6381));
            jedisCluster=new redis.clients.jedis.JedisCluster(hostAndPorts,jedisPoolConfig);


            return jedisCluster;
        }else{
            return jedisCluster;
        }
    }




}
