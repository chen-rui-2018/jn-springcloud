package com.jn.wechat.base.service.impl.wxmessagehandleserviceimpl;

import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.config.WxProperties;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.user.api.MiniProgramPublicRegisterClient;
import com.jn.user.enums.IsConCornEnum;
import com.jn.user.model.WeChatRequestParam;
import com.jn.wechat.base.WxConsts;
import com.jn.wechat.base.model.message.WxXmlMessage;
import com.jn.wechat.base.model.message.WxXmlOutMessage;
import com.jn.wechat.base.model.message.WxXmlOutTextMessage;
import com.jn.wechat.base.model.result.WxUser;
import com.jn.wechat.base.service.WxUserService;
import com.jn.wechat.base.utils.json.JsonStringToObjectUtil;
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
    @Autowired
    private MiniProgramPublicRegisterClient miniProgramPublicRegisterClient;
    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    @Override
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context) {
        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());
        // 获取微信用户基本信息
        WxUser userWxInfo = wxUserService.userInfo(wxMessage.getFromUser());
        WeChatRequestParam weChatRequestParam = null;
        try{
            if (userWxInfo != null) {
                weChatRequestParam = new WeChatRequestParam();
                //添加关注用户到本地数据库
                weChatRequestParam.setOpenId(userWxInfo.getOpenid());
                weChatRequestParam.setUnionId(userWxInfo.getUnionid());
                weChatRequestParam.setCity(userWxInfo.getCity());
                weChatRequestParam.setCountry(userWxInfo.getCountry());
                weChatRequestParam.setGender(userWxInfo.getSex());
                weChatRequestParam.setAvatarUrl(userWxInfo.getHeadimgurl());
                weChatRequestParam.setProvince(userWxInfo.getProvince());
                weChatRequestParam.setLanguage(userWxInfo.getLanguage());
                weChatRequestParam.setNickName(userWxInfo.getNickname());
                weChatRequestParam.setIsConcern(IsConCornEnum.CORN);
                weChatRequestParam.setSubscribeTime(userWxInfo.getSubscribe_time());
                Delay delay = new Delay();
                delay.setServiceId(this.USER_CLIENT);
                delay.setServiceUrl(this.USER_CLIENT_CONCERNORCANCELWECHAT_URL);
                delay.setTtl("1000");
                delay.setDataString(JsonStringToObjectUtil.objectToJson(weChatRequestParam));
                delaySendMessageClient.delaySend(delay);
            }
        }catch (Exception e) {
            logger.warn("新关注用户保存本地数据库失败:【{}】.",weChatRequestParam);
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
