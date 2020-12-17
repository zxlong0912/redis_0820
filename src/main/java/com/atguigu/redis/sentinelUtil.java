package com.atguigu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import javax.print.attribute.HashAttributeSet;
import java.util.HashSet;

public class sentinelUtil {

    private static JedisSentinelPool jedisSentinelPool=null;
    public static Jedis getJedisFromPool(){
        if(jedisSentinelPool==null){
            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(5); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong

            HashSet hashSet = new HashSet<String>();
//写的是 sentinel里边的节点以及端口
            hashSet.add("hadoop102:26379");
           jedisSentinelPool = new JedisSentinelPool("mymaster",hashSet,jedisPoolConfig);
            return jedisSentinelPool.getResource();
        }else{
            return jedisSentinelPool.getResource();
        }
    }




}
