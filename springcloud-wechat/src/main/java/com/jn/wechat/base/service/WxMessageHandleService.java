package com.jn.wechat.base.service;

import com.jn.wechat.base.model.message.WxXmlMessage;
import com.jn.wechat.base.model.message.WxXmlOutMessage;

import java.util.Map;

/**
 * 处理微信消息请求
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 16:18
 * @Version： v1.0
 * @Modified By:
 */
public interface WxMessageHandleService {

    /**
     * 处理微信消息请求
     * @param wxMessage
     * @param context
     * @return
     */
    WxXmlOutMessage handle(WxXmlMessage wxMessage,Map<String, Object> context);

    /**
     * 查询哪种handle编码，取到对应的消息实现类处理微信的消息
     * @return
     */
    String getWxMessHandleCode();

}
