package com.jn.wechat.base.service.impl.wxmessagehandleserviceimpl;

import com.jn.common.util.StringUtils;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.user.api.MiniProgramPublicRegisterClient;
import com.jn.user.enums.IsConCornEnum;
import com.jn.user.model.WeChatRequestParam;
import com.jn.wechat.base.WxConsts;
import com.jn.wechat.base.model.message.WxXmlMessage;
import com.jn.wechat.base.model.message.WxXmlOutMessage;
import com.jn.wechat.base.utils.json.JsonStringToObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    @Override
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context) {
        String openId = wxMessage.getFromUser();
        this.logger.info("取消关注用户 OPENID: " + openId);
        WeChatRequestParam weChatRequestParam = null;
        try{
            //更新本地数据库为取消关注状态
            if(StringUtils.isNotBlank(openId)) {
                weChatRequestParam = new WeChatRequestParam();
                weChatRequestParam.setOpenId(openId);
                weChatRequestParam.setIsConcern(IsConCornEnum.CANCEL_CORN);
                Delay delay = new Delay();
                delay.setServiceId(this.USER_CLIENT);
                delay.setServiceUrl(this.USER_CLIENT_CONCERNORCANCELWECHAT_URL);
                delay.setTtl("1000");
                delay.setDataString(JsonStringToObjectUtil.objectToJson(weChatRequestParam));
                delaySendMessageClient.delaySend(delay);
            }
        }catch (Exception e) {
            logger.warn("取消关注用户保存本地数据库失败:【{}】.",weChatRequestParam);
        }
        return null;
    }

    @Override
    public String getWxMessHandleCode() {
        return WxConsts.EventType.UNSUBSCRIBE;
    }
}
