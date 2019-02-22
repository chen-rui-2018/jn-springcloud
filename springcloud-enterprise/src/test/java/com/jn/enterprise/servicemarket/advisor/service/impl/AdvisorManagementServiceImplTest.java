package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementQuery;
import com.jn.enterprise.servicemarket.advisor.model.InviteAdvisorInfo;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementService;
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

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/2/22 12:44
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class AdvisorManagementServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(AdvisorManagementServiceImplTest.class);

    @Autowired
    private AdvisorManagementService advisorManagementService;

    private InviteAdvisorInfo inviteAdvisorInfo=new InviteAdvisorInfo();

    private AdvisorManagementQuery advisorManagementQuery=new AdvisorManagementQuery();

    @Before
    public void setUp() throws Exception {
        //顾问邀请
        inviteAdvisorInfo.setInviteAccount("123");
        inviteAdvisorInfo.setRegisterAccount("wangsong11");

        //顾问管理  审批状态(rejected：已拒绝    noFeedBack：未反馈   pending：待审批   approvalNotPassed：审批不通过)
        advisorManagementQuery.setApprovalStatus("pending");
        //不要分页
        advisorManagementQuery.setNeedPage("0");
    }


    /**
     * 顾问邀请
     */
    @Test
    public void inviteAdvisor(){
        try {
            advisorManagementService.inviteAdvisor(inviteAdvisorInfo);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.warn("邀请顾问失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.GET_ADVISOR_INFO_FAIL.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.ADVISOR_IS_EXIT.getCode())
                    )
            );
        }
    }



    /**
     * 顾问管理
     */
    @Test
    public void getAdvisorManagementInfo() {
        try {
            PaginationData paginationData = advisorManagementService.getAdvisorManagementInfo(advisorManagementQuery);
            List<TbServiceAdvisor> list= (List<TbServiceAdvisor>)paginationData.getRows();
            if(list!=null){
                for(TbServiceAdvisor advisor:list){
                    logger.info(advisor.toString());
                }
            }
            assertThat(list.size(),greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("顾问管理查询失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.APPROVAL_STATUS_NOT_EXIST.getCode())
                    )
            );
        }
    }

}