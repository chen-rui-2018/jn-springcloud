package com.jn.wechat.base.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.RestTemplateUtil;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.wechat.base.enums.WxExceptionEnums;
import com.jn.wechat.base.service.WxHttpClientService;
import com.jn.wechat.base.service.WxWithAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 统一处理调用微信接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/1/17 10:49
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxHttpClientServiceImpl implements WxHttpClientService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WxWithAccessToken wxWithAccessToken;

    @Override
    @ServiceLog(doAction = "GET请求微信api接口，url参数中不允许有access_token.")
    public String get(String url, String queryParam) {
        String responseString = null;
        try {
            String uriWithAccessToken = wxWithAccessToken.withAccessToken(url);
            if (null != queryParam) {
                uriWithAccessToken += uriWithAccessToken.endsWith("?") ? queryParam : '&' + queryParam;
            }
            responseString = RestTemplateUtil.get(uriWithAccessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseString;
    }

    @Override
    @ServiceLog(doAction = "GET请求微信api接口,URL为完整接口地址.")
    public String get(String url) {
        String responseString = null;
        try {
            responseString = RestTemplateUtil.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseString;
    }

    @Override
    @ServiceLog(doAction = "POST请求微信api接口,参数为实体类对象.")
    public String post(String url, Object postObj) {
        //对象转json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json ;
        try {
            json = objectMapper.writeValueAsString(postObj);
        } catch (JsonProcessingException e) {
            logger.error("post请求微信接口时，对象转json字符串失败",e);
            throw new JnSpringCloudException(WxExceptionEnums.JSON_PROCESS_FAL);
        }
        return RestTemplateUtil.post(wxWithAccessToken.withAccessToken(url),json);
    }

    @Override
    @ServiceLog(doAction = "POST请求微信api接口,参数为String类型.")
    public String post(String url, String postParam) {
        return RestTemplateUtil.post(wxWithAccessToken.withAccessToken(url),postParam);
    }

}
