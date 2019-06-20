package com.jn.wechat.base.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.util.RestTemplateUtil;
import com.jn.config.WxProperties;
import com.jn.wechat.base.model.result.WxOAuth2AccessToken;
import com.jn.wechat.base.service.WxService;
import com.jn.wechat.base.utils.json.JsonStringToObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 验证链接是否已绑定用户信息
 *
 * @Author： cm
 * @Date： Created on 2019/6/17 19:35
 * @Version： v1.0
 * @Modified By:
 */
public class WxAuthFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(WxAuthFilter.class);
    @Autowired
    private WxProperties wxProperties;

    private String exclusionsWxUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        exclusionsWxUrl = filterConfig.getInitParameter("exclusions_wx_url");
        logger.info("\n============WxAuthFilter验证是否绑定用户信息过滤器初始化=============");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String requestURI = httpRequest.getRequestURI();
        String queryString = httpRequest.getQueryString();
        logger.info("\n=============requestURI:【{}】,queryString:【{}】",requestURI,queryString);

        if(HttpMethod.GET.toString().equals(httpRequest.getMethod())) {
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }
        if(StringUtils.isNotBlank(exclusionsWxUrl)) {
            List<String> ignore = Arrays.asList(exclusionsWxUrl.split(","));
            if (null != ignore) {
                int i = 0;
                for (String url : ignore) {
                    if (requestURI.startsWith(httpRequest.getContextPath() + url)) {
                        i = i+1;
                        break;
                    }
                }
                if(i>0) {
                    filterChain.doFilter(httpRequest, httpResponse);
                    return;
                }
            }
        }

        //根据code获取access_token、openid
        String code = httpRequest.getParameter("code");
        if(StringUtils.isNotBlank(code)) {
            String oauth2AccessTokenUrl = String.format(WxService.OAUTH2_ACCESS_TOKEN_URL,wxProperties.getAppId(),wxProperties.getSecret(),code);
            String oauth2AccessTokenString = RestTemplateUtil.get(oauth2AccessTokenUrl);
            WxOAuth2AccessToken wxOAuth2AccessToken = JsonStringToObjectUtil.jsonToObject(oauth2AccessTokenString,new TypeReference<WxOAuth2AccessToken>(){});
            logger.info("返回WxOAuth2AccessToken对象{}",wxOAuth2AccessToken.toString());
            //检验授权凭证（access_token）是否有效
            String openId = wxOAuth2AccessToken.getOpenid();
            String access_token = wxOAuth2AccessToken.getAccess_token();
            String oauth2JudgeEffectiveUrl = String.format(WxService.OAUTH2_JUDGE_EFFECTIVE_URL,access_token,openId);
            JSONObject oauth2JudgeEffectiveJson = RestTemplateUtil.request(oauth2JudgeEffectiveUrl, HttpMethod.GET,null,null, MediaType.APPLICATION_FORM_URLENCODED);
            LinkedHashMap linkedHashMap = ((LinkedHashMap) oauth2JudgeEffectiveJson.get("data"));
            String errcode = linkedHashMap.get("errcode").toString();
            String errmsg = linkedHashMap.get("errmsg").toString();
            if(!("0".equals(errcode) && "ok".equals(errmsg))) {
                //无效 刷新access_token
                String refresh_token = wxOAuth2AccessToken.getRefresh_token();
                String oauth2RefreshTokenUrl = String.format(WxService.OAUTH2_REFRESH_TOKEN_URL,wxProperties.getAppId(),refresh_token);
                JSONObject oauth2RefreshTokenJson = RestTemplateUtil.request(oauth2RefreshTokenUrl, HttpMethod.GET,null,null, MediaType.APPLICATION_FORM_URLENCODED);
                openId = ((LinkedHashMap) oauth2RefreshTokenJson.get("data")).get("openid").toString();
            }
            Random r = new Random();
            //todo 根据openid判断是否绑定用户信息
            if(r.nextBoolean()) {
                //重定向绑定手机页面
                httpResponse.sendRedirect("https://www.baidu.com");
                return;
            }
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }else {
            //从微信进行授权登录，获取openid
            filterChain.doFilter(httpRequest, httpResponse);
            /*httpResponse.sendRedirect("https://mp.weixin.qq.com/");*/
            return;
        }
    }

    @Override
    public void destroy() {
        logger.info("\n============WxAuthFilter验证是否绑定用户信息过滤器销毁=============");
    }
}
