package com.jn.news.sms.controller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
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

    /**
     * 获取短信平台推送的短信回复信息
     */
    @RequestMapping("/receive/answer")
    public String receiveAnswer(HttpServletRequest request) throws IOException, DocumentException {
        System.out.println(getRemoteIpAddr(request));
        Map m = parseXml(request);
        return "";
    }

    /**
     * 获取短信平台推送的短信状态报告
     */
    @RequestMapping("/receive/report")
    public void receiveReport(HttpServletRequest request) throws IOException, DocumentException {
        System.out.println(getRemoteIpAddr(request));
        Map m = parseXml(request);
        String str = "";
    }

    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws IOException, DocumentException {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            if(null != inputStream){
                // 读取输入流
                SAXReader reader = new SAXReader();
                Document document = reader.read(inputStream);
                // 得到xml根元素
                Element root = document.getRootElement();
                // 得到根元素的所有子节点
                List<Element> elementList = root.elements();
                // 遍历所有子节点
                for (Element e : elementList){
                    map.put(e.getName(), e.getText());
                }
                map.put("xml", document.asXML());
            }
        } catch (IOException e) {
            throw e;
        } catch (DocumentException e) {
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
