package com.jn.wechat.base.service.impl.wxmessagehandleserviceimpl;

import com.jn.wechat.base.service.WxMessageHandleService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取微信消息处理类的实例
 *
 * @Author： cm
 * @Date： Created on 2019/1/8 11:36
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class WxMessageHandleBeanFactory implements ApplicationContextAware {

    private static Map<String, WxMessageHandleService> wxMessageHandleMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, WxMessageHandleService> map = applicationContext.getBeansOfType(WxMessageHandleService.class);
        wxMessageHandleMap = new HashMap<>();
        map.forEach((key, value) -> wxMessageHandleMap.put(value.getWxMessHandleCode(), value));
    }

    public static <T extends WxMessageHandleService> T getWxMessageHandleService(String code) {
        return (T)wxMessageHandleMap.get(code);
    }
}
