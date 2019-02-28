package com.jn.news.sms.controller;

import com.jn.common.util.xml.XmlUtils;
import com.jn.news.sms.model.SmsAnswerResult;
import com.jn.news.sms.vo.SmsAnswersResult;
import com.jn.news.sms.vo.SmsReportsResult;
import com.jn.news.utils.xml.XStreamTransformer;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 提供短信平台的接口，用于短信平台推送信息过来
 *
 * @Author： cm
 * @Date： Created on 2019/2/21 16:39
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/guest/news/sms")
public class SmsController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取短信平台推送的短信回复信息
     */
    @RequestMapping("/receive/answer")
    public void receiveAnswer(HttpServletRequest request) throws IOException, DocumentException {
        String result = parseXmlToString(request);
        SmsAnswersResult smsAnswersResult = XStreamTransformer.fromXml(SmsAnswersResult.class, result);
        logger.info("被动接受短信平台发送的回复消息内容{}",smsAnswersResult.toString());
    }

    /**
     * 获取短信平台推送的短信状态报告
     */
    @RequestMapping("/receive/report")
    public void receiveReport(HttpServletRequest request) throws IOException {
        String result = parseXmlToString(request);
        SmsReportsResult smsReportsResult = XStreamTransformer.fromXml(SmsReportsResult.class, result);
        logger.info("被动接受短信平台发送的回复消息内容{}",smsReportsResult.toString());
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseXml(HttpServletRequest request) throws IOException, DocumentException {
        // 将解析结果存储在HashMap中
        Map<String, Object> map = new HashMap<String, Object>();
        // 从request中取得输入流
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            if(null != inputStream){
                map = XmlUtils.xml2Map(inputStream);
            }
        } catch (IOException e) {
            throw e;
        }finally{
            if(null != inputStream){
                try {
                    // 释放资源
                    inputStream.close();
                } catch (IOException e) {
                    throw new IOException("inputStream 未正常关闭",e);
                }finally{
                    inputStream = null;
                }
            }
        }
        return map;
    }

    public static String parseXmlToString(HttpServletRequest request) throws IOException {
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        if(null != inputStream) {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString(StandardCharsets.UTF_8.name());
        }

        return "";
    }

    public static String getRemoteIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
