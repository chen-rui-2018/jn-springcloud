package com.jn.user.userinfo.service.impl;

import com.jn.SpringCloudUserApplication;
import com.jn.user.model.UserExtension;
import com.jn.user.userinfo.service.UserInfoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * 获取用户扩展信息测试类
 * @Author: yangph
 * @Date: 2018/12/22 16:52
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudUserApplication.class})
public class UserInfoServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImplTest.class);

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 账号
     */
    private String account;


    @Before
    public void setUp() throws Exception {
        account="wangsong";
    }

    /**
     * 获取用户扩展信息
     */
    @Test
    public void getUserInfo() {
        UserExtension userInfo = userInfoService.getUserInfo(account);
        assertThat(userInfo, notNullValue());
    }
}