package com.jn.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关的工具类
 *
 * @author： fengxh
 * @date： Created on 2019/5/21 11:25
 * @version： v1.0
 * @modified By:
 */
public class ZuulUtils {

    /**
     * 获取IP地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        if(request == null){
            return null;
        }
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if(ip.contains(",")){
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
