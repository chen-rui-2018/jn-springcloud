package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementParam;
import com.jn.enterprise.servicemarket.advisor.model.ApprovalParam;
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

    private String loginAccount ="";
    private String registerAccount="";

    private AdvisorManagementParam advisorManagementParam =new AdvisorManagementParam();

    private ApprovalParam approvalParam =new ApprovalParam();

    @Before
    public void setUp() throws Exception {
        //顾问邀请
        loginAccount="18073856620";
        registerAccount="18674398739";

        //顾问管理  审批状态(rejected：已拒绝    noFeedBack：未反馈   pending：待审批   approvalNotPassed：审批不通过)
        advisorManagementParam.setApprovalStatus("pending");
        //不要分页
        advisorManagementParam.setNeedPage("0");

        //顾问审批
        approvalParam.setAdvisorAccount(registerAccount);
        //审批结果(approved:审批通过   approvalNotPassed:审批不通过)
        approvalParam.setApprovalResults("approved");
        //审批说明
        approvalParam.setApprovalDesc("审批通过");

    }


    /**
     * 顾问邀请
     */
    @Test
    public void inviteAdvisor(){
        try {
            advisorManagementService.inviteAdvisor(registerAccount,loginAccount);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.warn("邀请顾问失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.GET_ADVISOR_INFO_FAIL.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.ADVISOR_IS_EXIT.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.ACCOUNT_NOT_ORG_MANAGE.getCode())
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
            PaginationData paginationData = advisorManagementService.getAdvisorManagementInfo(advisorManagementParam);
            List<TbServiceAdvisor> list= (List<TbServiceAdvisor>)paginationData.getRows();
            if(list!=null){
                for(TbServiceAdvisor advisor:list){
                    logger.info(advisor.toString());
                }
                assertThat(list.size(),greaterThanOrEqualTo(0));
            }else{
                assertThat(anything(),anything());
            }
        } catch (JnSpringCloudException e) {
            logger.warn("顾问管理查询失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.APPROVAL_STATUS_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 顾问审批
     */
    @Test
    public void approvalAdvisorInfo(){
        try {
            advisorManagementService.approvalAdvisorInfo(approvalParam);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.warn("顾问审批失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.PENDING_ADVISOR_NOT_EXIT.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.APPROVAL_DESC_NOT_NULL.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.PENDING_ADVISOR_NOT_EXIT.getCode())
                    )
            );
        }

    }

    /**
     * 再次邀请
     */
    @Test
    public void inviteAgain(){
        try {
            advisorManagementService.inviteAgain(registerAccount,loginAccount);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.warn("再次邀请顾问失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.GET_ADVISOR_INFO_FAIL.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.ACCOUNT_STATUS_NOT_REJECTED.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.ACCOUNT_NOT_ORG_MANAGE.getCode())
                    )
            );
        }
    }

}