package com.jn.common.util.log;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.*;

/**
 * 解锁的Kafka日志
 *
 * @author： fengxh
 * @date： Created on 2019/5/13 11:01
 * @version： v1.0
 * @modified By:
 */
public class UnblockedKafkaAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {


    private KafkaTemplate<String, String> kafkaTemplate;
    /**
     * kafka的链接
     */
    private String url ;
    /**
     * 系统名字
     */
    private String systemName ;
    /**
     * top
     */
    private String top = "springcloud-log";
    /**
     * kafka的超时时间
     */
    private String requestTimeout = "1000";
    /**
     * 重试
     */
    private Integer retriesConfig = 0;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(String requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public Integer getRetriesConfig() {
        return retriesConfig;
    }

    public void setRetriesConfig(Integer retriesConfig) {
        this.retriesConfig = retriesConfig;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public void start() {
        super.start();
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,this.getUrl());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, this.getRequestTimeout());
        props.put(ProducerConfig.RETRIES_CONFIG, this.getRetriesConfig());
        kafkaTemplate = new KafkaTemplate<>(new DefaultKafkaProducerFactory<String, String>(props));
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    protected void append(ILoggingEvent event) {

        LogBackKafkaVo logStr = LogBackKafkaVo.build(event,systemName);
        if (logStr != null) {
            kafkaTemplate.send(this.getTop(), logStr.toString());
        }
    }
}
