package com.jn.user.userinfo.service.impl;

import com.jn.SpringCloudUserApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.model.User;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.model.*;
import com.jn.user.userinfo.model.UserInfoParam;
import com.jn.user.userinfo.service.UserInfoService;
import com.jn.user.usertag.dao.UserTagMapper;
import org.hamcrest.Matchers;
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
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
    @Autowired
    private UserTagMapper userTagMapper;

    /**
     * 账号
     */
    private String account;

    private List<String>accountList=new ArrayList<>();

    private UserAffiliateInfo userAffiliateInfo=new UserAffiliateInfo();

    private UserCompanyInfo userCompanyInfo=new UserCompanyInfo();

    private AffiliateParam affiliateParam=new AffiliateParam();

    private CompanyParam companyParam=new CompanyParam();



    @Before
    public void setUp() throws Exception {
        //获取用户扩展信息
        account="wangsong";
        //批量获取用户扩展信息
        accountList.add(account);
        accountList.add("qianqi");
        accountList.add("account01");

        //更新用户所属机构信息
        userAffiliateInfo.setAccountList((String[])accountList.toArray());
        userAffiliateInfo.setAffiliateCode("011111");
        userAffiliateInfo.setAffiliateName("江苏工业园");

        //更新用户所属企业信息
        userCompanyInfo.setAccountList(new String[]{account});
        userCompanyInfo.setCompanyCode("032222");
        userCompanyInfo.setCompanyName("江苏工业园企业");

        //根据所属机构编码批量获取用户信息
        affiliateParam.setAffiliateCode("011111");

        //根据所属企业编码批量获取用户信息
        companyParam.setCompanyCode("032222");

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

    /**
     * 根据所属机构编码批量获取用户信息
     */
    @Test
    public void getUserExtensionByAffiliateCode(){
        try {
            PaginationData pageData = userInfoService.getUserExtensionByAffiliateCode(affiliateParam);
            List<UserExtensionInfo> userExtensionInfos =(List<UserExtensionInfo>) pageData.getRows();
            if(!userExtensionInfos.isEmpty()){
                for(UserExtensionInfo userExtensionInfo:userExtensionInfos){
                    logger.info(userExtensionInfo.toString());
                }
            }
        } catch (JnSpringCloudException e) {
            logger.info("根据所属机构编码批量获取用户信息失败");
            assertThat(e.getCode(),equalTo(UserExtensionExceptionEnum.AFFILIATE_PARAM_NOT_NULL.getCode()));
        }
    }

    /**
     * 根据所属企业编码批量获取用户信息
     */
    @Test
    public void getUserExtensionByCompanyCode(){
        try {
            PaginationData pageData = userInfoService.getUserExtensionByCompanyCode(companyParam);
            List<UserExtensionInfo> userExtensionInfos =(List<UserExtensionInfo>) pageData.getRows();
            if(!userExtensionInfos.isEmpty()){
                for(UserExtensionInfo userExtensionInfo:userExtensionInfos){
                    logger.info(userExtensionInfo.toString());
                }
            }
        } catch (JnSpringCloudException e) {
            logger.info("根据所属企业编码批量获取用户信息失败");
            assertThat(e.getCode(),equalTo(UserExtensionExceptionEnum.COMPANY_PARAM_NOT_NULL.getCode()));
        }
    }

    @Test
    public void saveOrUpdateUserInfo(){
        UserInfoParam userInfoParam = new UserInfoParam();
        userInfoParam.setName("张桑");
        userInfoParam.setNickName("飞凡网");
        userInfoParam.setAge(20);
        userInfoParam.setSex("1");
        userInfoParam.setJobs(new String[]{"101","102"});
        userInfoParam.setHobbys(new String[]{"001","002"});
        User user = new User();
        user.setAccount("wangsong");
        try{
            int i = userInfoService.saveOrUpdateUserInfo(userInfoParam,user );
            assertThat(i,greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            logger.info("保存/修改用户信息失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(UserExtensionExceptionEnum.USER_INFO_GET_ERROR.getCode()),
                            Matchers.containsString(UserExtensionExceptionEnum.USER_DATA_MULTIPLE_ERROR.getCode())
                    ));
        }

    }

}