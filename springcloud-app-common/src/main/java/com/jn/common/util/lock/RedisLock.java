package com.jn.common.util.lock;

import com.jn.common.util.lock.service.Lock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * redis锁的实现
 *
 * @author： fengxh
 * @date： Created on 2018/12/10 16:40
 * @version： v1.0
 * @modified By:
 */
@Component("redisLock")
public class RedisLock implements Lock {

    @Autowired
    private Jedis jedis;
    /**
     * jedis成功标识
     */
    private static final String LOCK_SUCCESS = "OK";
    /**
     * 设置不存在，才添加
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * 设置需要超时时间
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 运行标识符
     */
    private static final Long RELEASE_SUCCESS = 1L;


    @Override
    public Boolean getLock(String account, String lockKey, Integer expireTime) {
        String result = jedis.set(lockKey, account, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime*1000);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean releaseLock(String account, String lockKey) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(account));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
