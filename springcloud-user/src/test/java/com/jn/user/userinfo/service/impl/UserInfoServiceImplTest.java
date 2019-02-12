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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.anything;
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

    private List<String>accountList=new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        account="wangsong";
        accountList.add("wangsong");
        accountList.add("qianqi");
        accountList.add("account01");
    }

    /**
     * 获取用户扩展信息
     */
    @Test
    public void getUserExtension() {
        UserExtension userInfo = userInfoService.getUserExtension(account);
        if(userInfo!=null){
            if(userInfo.getUserPersonInfo()!=null){
                logger.info(userInfo.getUserPersonInfo().toString());
            }else if(userInfo.getUserCompanyInfo()!=null){
                logger.info(userInfo.getUserCompanyInfo().toString());
            }else {
                logger.info("用户信息不存在或已被删除");
            }
        }else{
            logger.info("用户信息不存在或已被删除");
        }
        assertThat(userInfo, anything());
    }

    /**
     * 批量获取用户的扩展信息
     */
    @Test
    public void getMoreUserExtension() {
        List<UserExtension> userInfoList = userInfoService.getMoreUserExtension(accountList);
        if(userInfoList!=null){
            for(UserExtension userInfo:userInfoList){
                if(userInfo.getUserPersonInfo()!=null){
                    logger.info(userInfo.getUserPersonInfo().toString());
                }else if(userInfo.getUserCompanyInfo()!=null){
                    logger.info(userInfo.getUserCompanyInfo().toString());
                }
            }
        }
        assertThat(userInfoList, anything());
    }
}