package com.jn.miniprogram.base.utils;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 小程序码接口调用工具类
 *
 * @author： cm
 * @date： Created on 2019/05/29 16:35
 * @version： v1.0
 * @modified By:
 */
@Component
public class QrcodeRestTemplateUtil {

    private static RestTemplate restTemplate;

    @Autowired
    public QrcodeRestTemplateUtil(RestTemplate restTemplate) {
        QrcodeRestTemplateUtil.restTemplate = restTemplate;
    }

    /**
     * RestTemplateUtil GET
     *
     * @param url 请求地址
     * @return
     */
    public static InputStream getRequestReturnInputStream(String url) throws IOException {
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, setHeaders());
        ResponseEntity<Resource> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Resource.class);
        return response.getBody().getInputStream();
    }

    /**
     * RestTemplateUtil POST
     *
     * @param url  请求地址
     * @param data 请求参数
     * @return
     */
    public static InputStream postRequestReturnInputStream(String url, String data) throws IOException {
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity<String> requestEntity = new HttpEntity<String>(data, setHeaders());
        ResponseEntity<Resource> response = restTemplate.postForEntity(url, requestEntity, Resource.class);
        return response.getBody().getInputStream();
    }

    /**
     * 设置请求头部HttpHeaders
     *
     * @return HttpHeaders
     */
    public static HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.setContentType(type);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
        return headers;
    }

}
