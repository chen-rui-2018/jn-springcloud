package com.jn.redis.mq;

import com.jn.DefaultDelayMessageSend;
import com.jn.send.model.Delay;
import com.jn.utils.ChangeDate;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * 消息发送（生产者）
 *
 * @author： fengxh
 * @date： Created on 2019/6/15 16:19
 * @version： v1.0
 * @modified By:
 */
@Service
public class RedisMessageProvider extends DefaultDelayMessageSend {

    private static Logger log = LoggerFactory.getLogger(RedisMessageProvider.class);

    @Resource
    private RedisMQ redisMQ;


    @Override
    protected boolean send(Delay delay, Long ttl) {
        try {
            if (delay != null){
                delay.setTtl(String.valueOf(ttl));
                Long current = System.currentTimeMillis();
                String seqId = UUID.randomUUID().toString();
                delay.setCreateTime(String.valueOf(current));
                redisMQ.addMsgPool(seqId, delay);
                //当前时间加上延时的时间，作为score
                Long delayTime = current + Long.valueOf(delay.getTtl());
                redisMQ.enMessage(RedisMQ.QUEUE_NAME,delayTime, seqId);
                String d = DateFormatUtils.format(new Date(),ChangeDate.PATTERN);
                log.info("redis缓存机制启动，当前时间：{},消费的时间：{}" ,d,DateFormatUtils.format(delayTime, ChangeDate.PATTERN));
                return Boolean.TRUE;
            }else {
                log.warn("消息内容为空！！！！！");
            }
        }catch (Exception e){
            throw new RuntimeException(e) ;
        }
        return Boolean.FALSE;
    }
}
