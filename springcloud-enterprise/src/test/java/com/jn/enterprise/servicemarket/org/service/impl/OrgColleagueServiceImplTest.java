package com.jn.enterprise.servicemarket.org.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueInfo;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueParam;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/4/10 14:29
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudEnterpriseApplication.class})
public class OrgColleagueServiceImplTest {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgColleagueServiceImplTest.class);

    @Autowired
    private OrgColleagueService orgColleagueService;
    /**
     * 登录用户账号
     */
    private String loginAccount;

    private String  account;
    /**
     * 机构同事列表查询入参
     */
    private OrgColleagueParam orgColleagueParam =new OrgColleagueParam();
    /**
     * 删除顾问或联系人
     */
    private String[] accountList={"18674398739","18565007009"};

    @Before
    public void setUp() throws Exception {
        loginAccount="18073856620";
        account="18674398739";
        //机构同事列表查询
        orgColleagueParam.setNeedPage("1");
    }

    /**
     * 机构同事列表查询
     */
    @Test
    public void getOrgColleagueList() {
        PaginationData paginationData = orgColleagueService.getOrgColleagueList(account, orgColleagueParam);
        if(paginationData==null || paginationData.getRows()==null){
            //ignore
        }else{
            List<OrgColleagueInfo> orgColleagueInfoList=(List<OrgColleagueInfo>) paginationData.getRows();
            for(OrgColleagueInfo orgColleagueInfo:orgColleagueInfoList){
                logger.info("机构同事列表:{}",orgColleagueInfo.toString());
            }
        }
        assertThat(paginationData,anything());
    }

    /**
     * 设置为联系人
     */
    @Test
    public void setAsContact() {
        try {
            int responseNum = orgColleagueService.setAsContact(loginAccount,account);
            logger.info("设置为联系人数据响应条数:{}",responseNum);
            assertThat(responseNum, greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("设置为联系人失败");
            assertThat(e.getCode(), Matchers.anyOf(
                    Matchers.containsString(OrgExceptionEnum.LOGIN_ACCOUNT_NOT_ORG_MANAGE.getCode()),
                    Matchers.containsString(OrgExceptionEnum.ACCOUNT_NOT_ORG_ADVISOR.getCode()),
                    Matchers.containsString(OrgExceptionEnum.NETWORK_ANOMALY.getCode())
            ));
        }
    }

    /**
     * 取消联系人
     */
    @Test
    public void cancelAsContact() {
        try {
            int responseNum = orgColleagueService.cancelAsContact(loginAccount,account);
            logger.info("取消联系人数据响应条数:{}",responseNum);
            assertThat(responseNum, greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("取消联系人失败");
            assertThat(e.getCode(), Matchers.anyOf(
                    Matchers.containsString(OrgExceptionEnum.LOGIN_ACCOUNT_NOT_ORG_MANAGE.getCode()),
                    Matchers.containsString(OrgExceptionEnum.ACCOUNT_NOT_ORG_CONTACT.getCode()),
                    Matchers.containsString(OrgExceptionEnum.NETWORK_ANOMALY.getCode())
            ));
        }
    }

    /**
     * 删除联系人或顾问
     */
    @Test
    public void deleteContactOrAdvisor() {
        try {
            int responseNum = orgColleagueService.deleteContactOrAdvisor(loginAccount, accountList);
            logger.info("删除联系人或顾问数据响应条数:{}",responseNum);
        } catch (JnSpringCloudException e) {
            logger.warn("删除联系人或顾问的账号不能为空");
            assertThat(e.getCode(), Matchers.anyOf(
                    Matchers.containsString(OrgExceptionEnum.LOGIN_ACCOUNT_NOT_ORG_MANAGE.getCode()),
                    Matchers.containsString(OrgExceptionEnum.ACCOUNT_NOT_NULL.getCode()),
                    Matchers.containsString(OrgExceptionEnum.NETWORK_ANOMALY.getCode())
            ));
        }
    }
}