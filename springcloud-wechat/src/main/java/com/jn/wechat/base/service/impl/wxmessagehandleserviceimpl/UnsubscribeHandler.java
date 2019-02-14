package com.jn.wechat.base.service.impl.wxmessagehandleserviceimpl;

import com.jn.wechat.base.WxConsts;
import com.jn.wechat.base.model.message.WxXmlMessage;
import com.jn.wechat.base.model.message.WxXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 取消关注用户
 *
 * @Author： cm
 * @Date： Created on 2019/1/8 15:25
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {
    @Override
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context) {
        String openId = wxMessage.getFromUser();
        this.logger.info("取消关注用户 OPENID: " + openId);
        // TODO 可以更新本地数据库为取消关注状态
        return null;
    }

    @Override
    public String getWxMessHandleCode() {
        return WxConsts.EventType.UNSUBSCRIBE;
    }
}
