package com.jn.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;

/**
 * redis配置文件
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@Configuration
public class RedisConfig {



    @Bean
    public RedisTemplate<String, Object> redisTemplateHandle(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }

    @Bean
    @ConditionalOnMissingBean(Jedis.class)
   public Jedis jedis (RedisConnectionFactory redisConnectionFactory){
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory)redisConnectionFactory;
        Jedis jedis = jedisConnectionFactory.getShardInfo().createResource();
        return jedis;
    }
}
