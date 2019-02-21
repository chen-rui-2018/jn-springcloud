package com.jn.wechat.base.service.impl.wxmessagehandleserviceimpl;

import com.jn.config.WxProperties;
import com.jn.wechat.base.WxConsts;
import com.jn.wechat.base.model.message.WxXmlMessage;
import com.jn.wechat.base.model.message.WxXmlOutMessage;
import com.jn.wechat.base.model.message.WxXmlOutTextMessage;
import com.jn.wechat.base.model.result.WxUser;
import com.jn.wechat.base.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 新关注用户
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 22:22
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class SubscribeHandler extends AbstractHandler {

    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private WxProperties wxProperties;

    @Override
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context) {
        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());
        // 获取微信用户基本信息
        WxUser userWxInfo = wxUserService.userInfo(wxMessage.getFromUser());
        if (userWxInfo != null) {
            // TODO 可以添加关注用户到本地数据库
        }
        WxXmlOutTextMessage wxXmlOutTextMessage = new WxXmlOutTextMessage();
        wxXmlOutTextMessage.setContent(null==wxProperties.getSubscribe()?"感谢关注":wxProperties.getSubscribe());
        wxXmlOutTextMessage.setCreateTime(System.currentTimeMillis());
        wxXmlOutTextMessage.setFromUserName(wxMessage.getToUser());
        wxXmlOutTextMessage.setToUserName(wxMessage.getFromUser());
        return wxXmlOutTextMessage;
    }

    @Override
    public String getWxMessHandleCode() {
        return WxConsts.EventType.SUBSCRIBE;
    }

}
