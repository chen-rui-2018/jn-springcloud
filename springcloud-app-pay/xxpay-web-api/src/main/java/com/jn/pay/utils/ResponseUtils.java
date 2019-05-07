package com.jn.pay.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName：响应工具
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/7 14:30
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class ResponseUtils {

    /**
     * 业务系统回调地址响应方法
     * @Descript 业务系统处理后同步返回给支付中心，返回字符串 success 则表示成功，
     *  返回非success则表示处理失败，支付中心会再次通知业务系统。（通知频率为60/120/180/240/300,单位：秒）
     *
     * @param response
     * @param content  响应值(根据RspEnum枚举返回值)
     *
    * */
    static void outResult(HttpServletResponse response, String content) {
        response.setContentType("text/html");
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(content);
        } catch (IOException e) {
        }
    }
}
