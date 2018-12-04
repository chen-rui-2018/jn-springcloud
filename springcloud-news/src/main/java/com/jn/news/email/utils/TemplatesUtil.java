package com.jn.news.email.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

/**
 * 模板数据渲染
 *
 * @Author： cm
 * @Date： Created on 2018/11/17 16:47
 * @Version： v1.0
 * @Modified By:
 */
public class TemplatesUtil {

    /**
     *
     * @param dataMap 渲染数据原
     * @param templatesName 模板名,模板文件的名称
     * @param templateEngine   模板操作类
     * @return
     */
    public static String createTemplates(Map<String,Object> dataMap, String templatesName, TemplateEngine templateEngine){
        //context 对象用于注入要在模板上渲染的信息
        Context context = new Context();
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            context.setVariable(entry.getKey(), entry.getValue());
        }
        String emailText = templateEngine.process(templatesName,context);
        System.out.println(emailText);
        //返回模板源代码 String 类型
        return emailText;
    }
}
