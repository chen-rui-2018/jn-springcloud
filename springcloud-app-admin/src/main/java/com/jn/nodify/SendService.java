package com.jn.nodify;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jn.common.channel.MessageSource;
import com.jn.nodify.domain.NotifierProperties;

/**
 * 发送接口
 *
 * @author： fengxh
 * @date： Created on 2018/12/5 15:11
 * @version： v1.0
 * @modified By:
 */
public interface SendService {

    /**
     * 发送接口
     * @param messageSource   消息 输出通道
     * @param message   发送的信息
     * @param notifierProperties 配置文件
     * @throws JsonProcessingException
     */
    void sendMessage (MessageSource messageSource,String message, NotifierProperties notifierProperties) throws JsonProcessingException;
}
