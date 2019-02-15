package com.jn.nodify;

import com.jn.nodify.send.AppSend;
import com.jn.nodify.send.EmailSend;
import com.jn.nodify.send.SmsSend;
import com.jn.nodify.send.WetChatSend;

/**
 * 发送工厂
 *
 * @author： fengxh
 * @date： Created on 2018/12/5 15:33
 * @version： v1.0
 * @modified By:
 */
public class SendFactory {

    private SendFactory() {}

    public static SendFactory getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private static class SingletonInstance {
        private static final SendFactory INSTANCE = new SendFactory();
    }

    /**
     * 通过不同的类型，来生产发送实例
     * @param type
     * @return
     */
    public SendService create(String type){
        if(type== null){
            return null;
        }
        SendService sendService ;
        switch (type){
            case "app":sendService = new AppSend();break;
            case "wetChat":sendService = new WetChatSend();break;
            case "email":sendService = new EmailSend();break;
            case "sms":sendService = new SmsSend();break;
            default:sendService = null;
        }
        return sendService;
    }



}
