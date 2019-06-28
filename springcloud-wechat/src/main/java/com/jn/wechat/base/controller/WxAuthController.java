package com.jn.wechat.base.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.RestTemplateUtil;
import com.jn.config.WxProperties;
import com.jn.user.api.MiniProgramPublicRegisterClient;
import com.jn.wechat.base.model.result.WxError;
import com.jn.wechat.base.model.result.WxOAuth2AccessToken;
import com.jn.wechat.base.service.WxInRedisConfigStorage;
import com.jn.wechat.base.service.WxService;
import com.jn.wechat.base.utils.json.JsonStringToObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 拦截目标链接，验证openid是否已绑定用户信息
 *
 * @Author： cm
 * @Date： Created on 2019/6/25 10:08
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/guest/wechat/auth")
public class WxAuthController {

    private static final Logger logger = LoggerFactory.getLogger(WxAuthController.class);

    @Autowired
    private WxProperties wxProperties;
    @Autowired
    private MiniProgramPublicRegisterClient miniProgramPublicRegisterClient;
    @Autowired
    private WxInRedisConfigStorage wxInRedisConfigStorage;

    @RequestMapping("/checkIsBindingUser")
    public void checkIsBindingUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String requestURI = httpRequest.getRequestURI();
        //获取参数
        Map<String,String[]> map = httpRequest.getParameterMap();
        if(null == map || null == map.get("url") ||  map.get("url").length==0) {
            //从微信进行授权登录，获取openid
            this.writeMsg(httpResponse,"菜单链接异常,没有目标页面.");
            return;
        }
        String targetUrl = map.get("url")[0];
        logger.info("\n=============requestURI:【{}】,queryString:【{}】",requestURI);
        //根据code获取access_token、openid
        String code = httpRequest.getParameter("code");
        if(StringUtils.isNotBlank(code)) {
            String oauth2AccessTokenUrl = String.format(WxService.OAUTH2_ACCESS_TOKEN_URL,wxProperties.getAppId(),wxProperties.getSecret(),code);
            String oauth2AccessTokenString = RestTemplateUtil.get(oauth2AccessTokenUrl);
            WxOAuth2AccessToken wxOAuth2AccessToken = JsonStringToObjectUtil.jsonToObject(oauth2AccessTokenString,new TypeReference<WxOAuth2AccessToken>(){});
            logger.info("\n返回WxOAuth2AccessToken对象{}",wxOAuth2AccessToken.toString());
            //检验授权凭证（access_token）是否有效
            String openId = wxOAuth2AccessToken.getOpenid();
            String access_token = wxOAuth2AccessToken.getAccess_token();
            String oauth2JudgeEffectiveUrl = String.format(WxService.OAUTH2_JUDGE_EFFECTIVE_URL,access_token,openId);
            String oauth2JudgeEffectiveJson = RestTemplateUtil.get(oauth2JudgeEffectiveUrl);
            WxError wxError = JsonStringToObjectUtil.jsonToObject(oauth2JudgeEffectiveJson,new TypeReference<WxError>(){});
            if(!("0".equals(wxError.getErrcode()) && "ok".equals(wxError.getErrmsg()))) {
                //无效 刷新access_token
                String refresh_token = wxOAuth2AccessToken.getRefresh_token();
                String oauth2RefreshTokenUrl = String.format(WxService.OAUTH2_REFRESH_TOKEN_URL,wxProperties.getAppId(),refresh_token);
                String oauth2RefreshTokenJson = RestTemplateUtil.get(oauth2RefreshTokenUrl);
                wxOAuth2AccessToken = JsonStringToObjectUtil.jsonToObject(oauth2RefreshTokenJson,new TypeReference<WxOAuth2AccessToken>(){});
                openId = wxOAuth2AccessToken.getOpenid();
            }
            //根据openid判断是否绑定用户信息
            Result<String> result = miniProgramPublicRegisterClient.openIdIsBindingAccount(openId);
            //判断微信用户信息是否已绑定用户信息，已绑定则直接跳转目标页面，未绑定则重定向注册绑定页面
            if(null != result && GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
                try {
                    if(StringUtils.isNotBlank(result.getData())) {
                        //说明已经存绑定用户信息 重定向目标页面
                        httpResponse.sendRedirect(targetUrl);
                    }else {
                        //重定向绑定手机页面
                        StringBuffer stringBuffer = new StringBuffer();
                        String userFlag = UUID.randomUUID().toString();
                        wxInRedisConfigStorage.setCacheValue(WxInRedisConfigStorage.WX_OPENID_KEY+userFlag,openId,12*60*60);
                        stringBuffer.append(wxProperties.getRegisterUrl()).append("?").append("targetUrl=").append(targetUrl).append("&userFlag=").append(userFlag);
                        httpResponse.sendRedirect(stringBuffer.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            //从微信进行授权登录，获取openid
            this.writeMsg(httpResponse,"请从微信进行授权登录");
        }
    }

    public void writeMsg(HttpServletResponse httpResponse,String content) {
        try {
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setHeader("Content-Type", "text/html; charset=UTF-8");
            httpResponse.getWriter().write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
