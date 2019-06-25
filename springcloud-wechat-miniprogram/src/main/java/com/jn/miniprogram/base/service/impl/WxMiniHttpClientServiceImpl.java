package com.jn.miniprogram.base.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.RestTemplateUtil;
import com.jn.miniprogram.base.enums.WxExceptionEnums;
import com.jn.miniprogram.base.service.WxMiniHttpClientService;
import com.jn.miniprogram.base.service.WxWithAccessToken;
import com.jn.miniprogram.base.utils.QrcodeRestTemplateUtil;
import com.jn.miniprogram.base.utils.json.JacksonJsonTransformUtil;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;


/**
 * 统一处理调用微信接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/1/17 10:49
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxMiniHttpClientServiceImpl implements WxMiniHttpClientService {

    @Autowired
    private WxWithAccessToken wxWithAccessToken;

    @Override
    @ServiceLog(doAction = "GET请求微信api接口，url参数中不允许有access_token.")
    public String get(String url, String queryParam) {
        String uriWithAccessToken = wxWithAccessToken.withAccessToken(url);
        if (null != queryParam) {
            uriWithAccessToken += uriWithAccessToken.endsWith("?") ? queryParam : '&' + queryParam;
        }
        return this.get(uriWithAccessToken);
    }

    @Override
    @ServiceLog(doAction = "GET请求微信api接口,URL为完整接口地址.")
    public String get(String url) {
        return RestTemplateUtil.get(url);
    }

    @Override
    @ServiceLog(doAction = "POST请求微信api接口.")
    public String post(String url, Object postObj) {
        try {
            return this.post(url,JacksonJsonTransformUtil.objectToJson(postObj));
        } catch (JsonProcessingException e) {
            throw new JnSpringCloudException(WxExceptionEnums.JSON_PROCESS_FAIL);
        }

    }

    @Override
    @ServiceLog(doAction = "POST请求微信api接口.")
    public String post(String url, String postParam) {
        return RestTemplateUtil.post(wxWithAccessToken.withAccessToken(url),postParam);
    }

    @Override
    @ServiceLog(doAction = "POST请求微信api接口.")
    public InputStream postRequestReturnInputStream(String url, Object postParam) {
        try {
            return this.postRequestReturnInputStream(url,JacksonJsonTransformUtil.objectToJson(postParam));
        } catch (JsonProcessingException e) {
            throw new JnSpringCloudException(WxExceptionEnums.JSON_PROCESS_FAIL);
        }
    }

    @Override
    @ServiceLog(doAction = "POST请求微信api接口.")
    public InputStream postRequestReturnInputStream(String url, String postParam) {
        try {
            return QrcodeRestTemplateUtil.postRequestReturnInputStream(wxWithAccessToken.withAccessToken(url),postParam);
        } catch (IOException e) {
            throw new JnSpringCloudException(WxExceptionEnums.GET_WX_MINI_QR_CODE_FAIL);
        }
    }

    @Override
    @ServiceLog(doAction = "GET请求微信api接口,URL为完整接口地址.")
    public InputStream getRequestReturnInputStream(String url) {
        try {
            return QrcodeRestTemplateUtil.getRequestReturnInputStream(wxWithAccessToken.withAccessToken(url));
        } catch (IOException e) {
            throw new JnSpringCloudException(WxExceptionEnums.GET_WX_MINI_QR_CODE_FAIL);
        }
    }

    @Override
    @ServiceLog(doAction = "GET请求微信api接口，url参数中不允许有access_token.")
    public InputStream getRequestReturnInputStream(String url, String queryParam) {
        String uriWithAccessToken = wxWithAccessToken.withAccessToken(url);
        if (null != queryParam) {
            uriWithAccessToken += uriWithAccessToken.endsWith("?") ? queryParam : '&' + queryParam;
        }
        return this.getRequestReturnInputStream(uriWithAccessToken);
    }

}
