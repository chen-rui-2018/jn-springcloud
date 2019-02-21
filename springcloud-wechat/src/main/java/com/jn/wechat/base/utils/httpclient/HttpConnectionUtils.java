package com.jn.wechat.base.utils.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 使用RestTemplate进行远程服务调用的工具类
 *
 * @Author： cm
 * @Date： Created on 2019/1/17 14:39
 * @Version： v1.0
 * @Modified By:
 */
public class HttpConnectionUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpConnectionUtils.class);

    public static String get(final String url) {
        if(StringUtils.isBlank(url)) {
            return null;
        }
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        //移除StringHttpMessageConverter
        converterList.remove(1);
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        //convert顺序错误会导致失败
        converterList.add(1, converter);
        restTemplate.setMessageConverters(converterList);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        logger.info("requestUrl:{},responseString:{}",url,response.getBody());
        return response.getBody();
    }

    public static String post(final String url, final Object value) throws Exception {
        if(StringUtils.isBlank(url)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(value);
        logger.info("requestUrl:{},requestJson:{}",url,requestJson);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        logger.info("requestUrl:{},responseString:{}",url,response.getBody());
        return response.getBody();
    }
}
