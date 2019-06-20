package com.jn.park.utils;

import com.jn.common.util.StringUtils;

/**
 * 特殊字符转义工具
 * @Author: huxw
 * @Date: 2019-6-18 11:03:36
 * @Version v1.0
 * @modified By:
 */
public class HtmlUtils extends org.springframework.web.util.HtmlUtils {

    /**
     * 获取富文本简介
     * @param details
     * @return
     */
    public static String getBriefIntroduction(String details) {
        if (StringUtils.isBlank(details)) {
            return details;
        }
        return details.replaceAll("</?[^>]+>", "").replaceAll("&nbsp;","\\ ");
    }

}
