package com.jn.wechat.base.service.impl;

import com.jn.config.WxProperties;
import com.jn.wechat.base.service.WxUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class WxUserServiceImplTest {

    @Autowired
    private WxUserService wxUserService;

    @Autowired
    WxProperties wxProperties;

    @Test
    public void userInfo() {
        wxUserService.userInfo(wxProperties.getAppId());
    }
}