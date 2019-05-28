package com.jn.miniprogram.base.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.miniprogram.base.enums.WxExceptionEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 调用微信接口拼接access_token（微信大多数接口都需要access_token）
 *
 * @Author： cm
 * @Date： Created on 2019/1/24 12:01
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class WxWithAccessToken {
    @Autowired
    private WxInRedisConfigStorage wxInRedisConfigStorage;

    @Autowired
    private WxMiniService wxMiniService;

    /**
     * 接口地址拼接access_token
     * @param url
     * @return
     */
    public String withAccessToken(String url) {
        if (url.contains("access_token=")) {
            throw new JnSpringCloudException(WxExceptionEnums.NOT_ALLOW_ACCESS_TOKEN);
        }
        //先校验access_token是否存在,不存在则调微信接口获取
        String accessToken = wxInRedisConfigStorage.getAccessToken();
        if(StringUtils.isBlank(accessToken)) {
            accessToken = wxMiniService.getAccessToken();
        }
        return url + (url.contains("?") ? "&" : "?") + "access_token=" + accessToken;
    }

}
