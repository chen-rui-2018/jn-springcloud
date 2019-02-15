package com.jn.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * 获取jedis
 *
 * @author： fengxh
 * @date： Created on 2018/12/11 17:47
 * @version： v1.0
 * @modified By:
 */
@Component
public class JedisFactory {


    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    /**
     * 获取jedis
     */
    private Jedis jedis;

    /**
     * 获取jedis
     * @return
     */
    public synchronized Jedis getJedis(){
        if(jedis == null){
            JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory)redisConnectionFactory;
            jedis = jedisConnectionFactory.getShardInfo().createResource();
        }else {
            Boolean var = true;
            try{
                jedis.ping();
            }catch (Exception e){
                var = false;
            }
            if(!var) {
                jedis = null;
                getJedis();
            }
        }
        return jedis;
    }
}
