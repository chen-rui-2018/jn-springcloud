package com.jn.hardware.ding.service;

/**
 * 钉钉基础接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/14 21:42
 * @Version： v1.0
 * @Modified By:
 */
public interface DingTalkBaseService {
    /**
     * 获取access_token接口地址
     */
    String GET_ACCESS_TOKEN_URL = "https://oapi.dingtalk.com/gettoken?appkey=%s&appsecret=%s";

    /**
     * 强制获取钉钉access_token
     * @return
     */
    String getAccessToken();

}
