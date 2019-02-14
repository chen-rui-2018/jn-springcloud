package com.jn.wechat.base.service.impl.wxmessagehandleserviceimpl;

import com.jn.wechat.base.service.WxMessageHandleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理微信消息基类
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 22:20
 * @Version： v1.0
 * @Modified By:
 */
public abstract class AbstractHandler implements WxMessageHandleService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

}
