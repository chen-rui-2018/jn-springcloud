package com.jn.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

/**
 * RestTemplateUtil 工具类
 *
 * @author： shenph
 * @date： Created on 2019/1/21 16:35
 * @version： v1.0
 * @modified By:
 */
@Component
public class RestTemplateUtil {

    private static RestTemplate restTemplate;

    @Autowired
    public RestTemplateUtil(RestTemplate restTemplate) {
        RestTemplateUtil.restTemplate = restTemplate;
    }

    /**
     * RestTemplateUtil GET
     *
     * @param url 请求地址
     * @return
     */
    public static String get(String url) {
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, setHeaders());
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return response.getBody();
    }

    /**
     * RestTemplateUtil GET
     *
     * @param url 请求地址
     * @param dynamicHeaders 动态头部
     * @return
     */
    public static String get(String url, Map<String,String> dynamicHeaders) {
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, setHeaders(dynamicHeaders));
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return response.getBody();
    }

    /**
     * RestTemplateUtil POST
     *
     * @param url  请求地址
     * @param data 请求参数
     * @param dynamicHeaders 动态头部
     * @return
     */
    public static String post(String url, String data,Map<String,String> dynamicHeaders) {
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity<String> requestEntity = new HttpEntity<String>(data, setHeaders(dynamicHeaders));
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        return response.getBody();
    }

    /**
     * RestTemplateUtil POST
     *
     * @param url  请求地址
     * @param data 请求参数
     * @return
     */
    public static String post(String url, String data) {
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpEntity<String> requestEntity = new HttpEntity<String>(data, setHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        return response.getBody();
    }

    /**
     * 动态设置请求头部HttpHeaders
     * @param dynamicHeaders 动态头部
     * @return HttpHeaders
     */
    public static HttpHeaders setHeaders(Map<String,String> dynamicHeaders) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.setContentType(type);
        if(dynamicHeaders!=null){
            Iterator<Map.Entry<String, String>> entries = dynamicHeaders.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                headers.add(entry.getKey(), entry.getValue());
            }
        }
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
        return headers;
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
