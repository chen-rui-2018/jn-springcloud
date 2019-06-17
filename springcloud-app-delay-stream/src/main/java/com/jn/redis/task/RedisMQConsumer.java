package com.jn.redis.task;


import com.alibaba.fastjson.JSON;
import com.jn.channel.DelayMessageSend;
import com.jn.channel.QueueConfig;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.LoadBalancerUtil;
import com.jn.common.util.StringUtils;
import com.jn.common.util.lock.LockAnnotation;
import com.jn.redis.mq.RedisMQ;
import com.jn.send.model.Delay;
import com.jn.utils.ChangeDate;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * 消息队列监听器<br>
 *
 */
@Component
public class RedisMQConsumer {


	
	private static final Logger logger = LoggerFactory.getLogger(RedisMQConsumer.class);

	@Autowired
	private RedisTemplate<String,Object> redisTemplate ;
	@Autowired
	private RedisMQ redisMQ;
    @Autowired
    private RabbitTemplate rabbitTemplate;

	private final static Integer START = 0;


    public static CountDownLatch latch;



    @Scheduled(fixedDelay = 1000L)
    @LockAnnotation(lockPrefix = "monitor", timeOut = 3)
    public void monitor() {
        Set<Object> set = rangeByScore(RedisMQ.QUEUE_NAME, START, System.currentTimeMillis());
        if (null != set) {
            long current = System.currentTimeMillis();
            for (Object id : set) {
                long  score = getScore(RedisMQ.QUEUE_NAME, id.toString()).longValue();
                if (current >= score) {
                    // 已超时的消息拿出来消费
                    Delay delay = null;
                    String json ;
                    try {
                        logger.info(RedisMQ.MSG_POOL + id.toString());
                        delay = (Delay)redisTemplate.opsForValue().get(RedisMQ.MSG_POOL + id.toString());
                        logger.info("消费了:{},消费的时间：{}" ,delay.toString() , DateFormatUtils.format(current, ChangeDate.PATTERN));
                        this.processMessage(delay);
                    } catch (Exception e) {
                        logger.error("消费消息失败了,将消息推送到失败队列",e);
                        Map<String,Object> errorMap = new HashMap();
                        errorMap.put("delay",delay);
                        errorMap.put("exception", ExceptionUtils.getStackTrace(e));
                        rabbitTemplate.convertAndSend(QueueConfig.DLQ, errorMap);
                    } finally {
                        redisMQ.deMessage(RedisMQ.QUEUE_NAME, id.toString());
                        redisMQ.deMsgPool(RedisMQ.MSG_POOL+id.toString());
                    }
                }
            }
        }
    }

    @Autowired
    private LoadBalancerUtil loadBalancerUtil;

    @Qualifier("mqMessageSend")
    @Autowired
    private DelayMessageSend delayMessageSend;

    /**
     * 模拟消息处理。如果当消息内容为FAIL_MESSAGE的话，则需要抛出异常
     * @param realMessage
     * @throws Exception
     */
    private void processMessage(Delay realMessage) {
        delayMessageSend.send(realMessage);

        if (latch!=null){
            latch.countDown();
        }
    }


    /**
     * 获取范围的元素来自start于end从下令从低分到高分排序集。
     * @param key
     * @param start
     * @param end
     * @return
     */
    private Set<Object> rangeByScore(String key, long start, long end) {

        return redisTemplate.opsForZSet().rangeByScore(key, start, end);

    }

    /**
     * 获取分数
     * @param key
     * @param member
     * @return
     */
    private Double getScore(String key, String member) {
        return redisTemplate.opsForZSet().score(key, member);
    }



}
