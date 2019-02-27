package com.jn.wechat.base.service.impl;

import com.jn.config.WxProperties;
import com.jn.wechat.base.service.WxService;
import com.jn.wechat.base.utils.httpclient.HttpConnectionUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WxHttpClientServiceImplTest {

    @Autowired
    private WxProperties wxProperties;

    @Test
    @Ignore
    public void getAccessToken() {
        String url = WxService.GET_ACCESS_TOKEN_URL;
        url = String.format(url,wxProperties.getAppId(),wxProperties.getSecret());
        String responseString = null;
        try {
            responseString = HttpConnectionUtils.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(responseString);
    }
}