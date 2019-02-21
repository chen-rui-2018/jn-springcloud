package com.jn.user.userinfo.service.impl;

import com.jn.SpringCloudUserApplication;
import com.jn.user.model.UserAffiliateInfo;
import com.jn.user.model.UserCompanyInfo;
import com.jn.user.model.UserExtensionInfo;
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

    private UserAffiliateInfo userAffiliateInfo=new UserAffiliateInfo();

    private UserCompanyInfo userCompanyInfo=new UserCompanyInfo();


    @Before
    public void setUp() throws Exception {
        //获取用户扩展信息
        account="wangsong";

        //批量获取用户扩展信息
        accountList.add(account);
        accountList.add("qianqi");
        accountList.add("account01");

        //更新用户所属机构信息
        userAffiliateInfo.setAccount(account);
        userAffiliateInfo.setAffiliateCode("011111");
        userAffiliateInfo.setAffiliateName("江苏工业园");

        //更新用户所属企业信息
        userCompanyInfo.setAccount(account);
        userCompanyInfo.setCompanyCode("032222");
        userCompanyInfo.setCompanyName("江苏工业园企业");

    }

    /**
     * 获取用户扩展信息
     */
    @Test
    public void getUserExtension() {
        UserExtensionInfo userInfo = userInfoService.getUserExtension(account);
        if(userInfo!=null){
            logger.info(userInfo.toString());
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
        List<UserExtensionInfo> userInfoList = userInfoService.getMoreUserExtension(accountList);
        if (userInfoList != null) {
            for (UserExtensionInfo userInfo : userInfoList) {
                if (userInfo != null) {
                    logger.info(userInfo.toString());
                }
            }
            assertThat(userInfoList, anything());
        }
    }

    /**
     * 更新用户所属机构信息
     */
    @Test
    public void updateAffiliateInfo(){
        boolean b = userInfoService.updateAffiliateInfo(userAffiliateInfo);
        logger.info("更新用户所属机构信息是否成功：{}",b);
        assertThat(b, anything());
    }

    /**
     * 更新用户所属企业信息
     */
    @Test
    public void updateCompanyInfo(){
        boolean b = userInfoService.updateCompanyInfo(userCompanyInfo);
        logger.info("更新用户所属企业信息是否成功：{}",b);
        assertThat(b, anything());
    }
}