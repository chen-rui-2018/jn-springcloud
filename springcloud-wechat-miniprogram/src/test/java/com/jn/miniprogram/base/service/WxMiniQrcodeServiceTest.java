package com.jn.miniprogram.base.service;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WxMiniQrcodeServiceTest {

    @Autowired
    private WxMiniQrcodeService wxMiniQrcodeService;

    @Test
    @Ignore
    public void createWxaCode() {
        String url = wxMiniQrcodeService.createWxaCodeUnlimit("111","https://www.baidu.com");
        Assert.assertThat(url, CoreMatchers.anything());
    }

}