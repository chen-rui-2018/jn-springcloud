package com.jn.redis.mq;

import com.alibaba.fastjson.JSON;
import com.jn.send.model.Delay;
import com.jn.server.DelaySendMessageClientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 基于redis的消息队列
 *
 * @author： fengxh
 * @date： Created on 2019/6/15 15:57
 * @version： v1.0
 * @modified By:
 */
@Component
public class RedisMQ {
    private static Logger log = LoggerFactory.getLogger(RedisMQ.class);

    /**
     * 消息池前缀，以此前缀加上传递的消息id作为key，以消息{@link Delay}
     * 的消息体body作为值存储
     */
    public static final String MSG_POOL = "Delay:Pool:";
    /**
     * zset队列 名称 queue
     */
    public static final String QUEUE_NAME = "Delay:Queue:";

    /**
     *  临时保留2天的时间
     */
    private static final Long SEMIH = 172800*1000L;



    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存入消息池
     * @param id    唯一键
     * @param delay   消息
     * @return
     */
    public Boolean addMsgPool(String id,Delay delay) {
        long ttl = Long.valueOf(delay.getTtl())+SEMIH;
        if (null != delay) {
            redisTemplate.opsForValue().set(MSG_POOL + id, delay, ttl, TimeUnit.MILLISECONDS);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 从消息池中删除消息
     * @param id
     * @return
     */
    public void deMsgPool(String id) {
        if (redisTemplate.hasKey(id)) {
            redisTemplate.delete(id);
        }

    }

    /**
     * 向队列中添加消息
     * @param key
     * @param score 优先级
     * @param val
     * @return 返回消息id
     */
    public void enMessage(String key, long score, String val) {
        redisTemplate.opsForZSet().add(key,val,score) ;
    }

    /**
     * 从队列删除消息
     * @param id
     * @return
     */
    public void deMessage(String key, String id) {
        redisTemplate.opsForZSet().remove(key,id);
    }

}
