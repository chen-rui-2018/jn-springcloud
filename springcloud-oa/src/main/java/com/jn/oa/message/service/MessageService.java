package com.jn.oa.message.service;


import com.jn.oa.message.model.MessageCode;

/**
 * @author： yuanyy
 * @date： Created on 2019/6/16 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface MessageService {

    /**
     * 发送指定验证码
     * @param messageCode
     */
    void sendMessageCode(MessageCode messageCode);


}
