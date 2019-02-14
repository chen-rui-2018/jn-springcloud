package com.jn.wechat.base.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.RestTemplateUtil;
import com.jn.common.util.xml.XmlUtils;
import com.jn.config.WxProperties;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.wechat.base.WxConsts;
import com.jn.wechat.base.enums.WxExceptionEnums;
import com.jn.wechat.base.model.message.WxXmlMessage;
import com.jn.wechat.base.model.message.WxXmlOutMessage;
import com.jn.wechat.base.model.result.WxOAuth2AccessToken;
import com.jn.wechat.base.model.result.WxUser;
import com.jn.wechat.base.model.security.AccessToken;
import com.jn.wechat.base.service.WxHttpClientService;
import com.jn.wechat.base.service.WxInRedisConfigStorage;
import com.jn.wechat.base.service.WxMessageHandleService;
import com.jn.wechat.base.service.WxService;
import com.jn.wechat.base.service.impl.wxmessagehandleserviceimpl.WxMessageHandleBeanFactory;
import com.jn.wechat.base.utils.crypto.SHA1;
import com.jn.wechat.base.utils.httpclient.UriUtil;
import com.jn.wechat.base.utils.json.JsonStringToObjectUtil;
import com.jn.wechat.base.utils.xml.XStreamTransformer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * 微信API接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 10:14
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxServiceImpl implements WxService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxProperties wxProperties;

    @Autowired
    private WxHttpClientService wxHttpClientService;

    @Autowired
    private WxInRedisConfigStorage wxInRedisConfigStorage;

    /**
     * 校验消息的确来自微信服务器
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验消息的确来自微信服务器")
    public boolean checkSignature(String timestamp, String nonce, String signature) {
        try {
            return SHA1.gen(wxProperties.getToken(), timestamp, nonce)
                    .equals(signature);
        } catch (Exception e) {
            logger.error("校验信息是否来自微信服务器失败，原因{} :" , e.getMessage());
            return false;
        }
    }

    /**
     * 处理微信请求并组装回复消息
     * @param xml
     * @return
     */
    @Override
    @ServiceLog(doAction = "处理微信请求并组装回复消息")
    public String processRequest(String xml) {
        logger.info("\n微信推送过来的xml报文：{}",xml);
        WxXmlMessage wxXmlMessage = XStreamTransformer.fromXml(WxXmlMessage.class, xml);
        Map map = XmlUtils.xml2Map(xml);
        wxXmlMessage.setAllFieldsMap(map);
        //根据微信消息事件类型获取对应的handel处理类
        WxMessageHandleService wxMessageHandleService = getWxMessageHandleService(wxXmlMessage);
        if(null == wxMessageHandleService) {
            throw new JnSpringCloudException(WxExceptionEnums.NOT_FINDE_WX_MSG_HANDLE);
        }
        WxXmlOutMessage wxXmlOutMessage = wxMessageHandleService.handle(wxXmlMessage,null);
        if(null == wxXmlOutMessage) {
            return "";
        }
        return wxXmlOutMessage.toXml();
    }

    /**
     * 根据消息类型事件类型获取handel处理类
     * @param wxXmlMessage
     * @return
     */
    public static WxMessageHandleService getWxMessageHandleService(WxXmlMessage wxXmlMessage) {
        WxMessageHandleService wxMessageHandleService = null;
        Field[] xmlMsgTypeFields = WxConsts.XmlMsgType.class.getDeclaredFields();
        try {
            for (Field field : xmlMsgTypeFields) {
                field.setAccessible(true);
                if(field.getType().toString().endsWith("java.lang.String") && Modifier.isStatic(field.getModifiers())) {
                    if(wxXmlMessage.getMsgType().equals(field.get(WxConsts.XmlMsgType.class))) {
                        if(WxConsts.XmlMsgType.EVENT.equals(wxXmlMessage.getMsgType())) {
                            //事件消息还需细化判断
                            Field[] eventTypeFields = WxConsts.EventType.class.getDeclaredFields();
                            for(Field eventTypeField : eventTypeFields) {
                                if(wxXmlMessage.getEvent().equals(eventTypeField.get(WxConsts.EventType.class))) {
                                    wxMessageHandleService = WxMessageHandleBeanFactory.getWxMessageHandleService(wxXmlMessage.getEvent());
                                    break;
                                }
                            }
                        }else {
                            wxMessageHandleService = WxMessageHandleBeanFactory.getWxMessageHandleService(wxXmlMessage.getMsgType());
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wxMessageHandleService;
    }

    /**
     * 强制获取access_token
     * @return
     */
    @Override
    @ServiceLog(doAction = "强制获取access_token")
    public String getAccessToken() {
        String url = WxService.GET_ACCESS_TOKEN_URL;
        url = String.format(url,wxProperties.getAppId(),wxProperties.getSecret());
        String accessTokenString = null;
        try {
            String responseString = RestTemplateUtil.get(url);
            ObjectMapper objectMapper = new ObjectMapper();
            AccessToken accessToken = objectMapper.readValue(responseString, AccessToken.class);
            if(null != accessToken && com.jn.common.util.StringUtils.isNotBlank(accessToken.getAccess_token())) {
                accessTokenString = accessToken.getAccess_token();
                //缓存accessToken
                wxInRedisConfigStorage.setAccessToken(accessTokenString,accessToken.getExpires_in());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("获取access_token接口返回值{}：",accessTokenString);
        return accessTokenString;

    }

    @Override
    @ServiceLog(doAction = "构造oauth2授权的url连接.")
    public String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state) {
        return String.format(WxService.CONNECT_OAUTH2_AUTHORIZE_URL,
                wxProperties.getAppId(), UriUtil.encodeURIComponent(redirectURI), scope, StringUtils.trimToEmpty(state));

    }

    @Override
    @ServiceLog(doAction = "用code换取oauth2的access token.")
    public WxOAuth2AccessToken oauth2getAccessToken(String code) {
        String url = String.format(WxService.OAUTH2_ACCESS_TOKEN_URL, wxProperties.getAppId(), wxProperties.getSecret(), code);
        String resultString = wxHttpClientService.get(url,null);
        WxOAuth2AccessToken wxOAuth2AccessToken = JsonStringToObjectUtil.jsonToObject(resultString,new TypeReference<WxOAuth2AccessToken>(){});
        logger.info("返回WxOAuth2AccessToken对象{}",wxOAuth2AccessToken.toString());
        return wxOAuth2AccessToken;
    }

    @Override
    @ServiceLog(doAction = "用oauth2获取用户信息.")
    public WxUser oauth2getUserInfo(WxOAuth2AccessToken oAuth2AccessToken, String lang) {
        if (lang == null) {
            lang = "zh_CN";
        }
        String url = String.format(WxService.OAUTH2_USERINFO_URL, oAuth2AccessToken.getAccess_token(), oAuth2AccessToken.getOpenid(), lang);
        String resultString = wxHttpClientService.get(url);
        WxUser wxUser = JsonStringToObjectUtil.jsonToObject(resultString,new TypeReference<WxUser>(){});
        logger.info("\n返回oauth2getUserInfo接口的wxUser对象{}",wxUser.toString());
        return wxUser;
    }

}
