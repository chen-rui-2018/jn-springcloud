package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.*;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementPortalService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorManagementDetailsVo;
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
 * @Date: 2019/2/28 16:12
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class AdvisorManagementPortalServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(AdvisorManagementPortalServiceImplTest.class);

    @Autowired
    private AdvisorManagementPortalService advisorManagementPortalService;

    private AdvisorManagementPortalParam advisorManagementParam =new AdvisorManagementPortalParam();

    private String advisorAccount;

    @Before
    public void setUp() throws Exception {
        advisorAccount="wangsong";

        //服务专员管理列表查询
        //需要分页
        advisorManagementParam.setNeedPage("1");
        //专员名称
        advisorManagementParam.setAdvisorName("王");
        //提交结束时间
        advisorManagementParam.setSubmitStartTime("201901");
        //提交开始时间
        advisorManagementParam.setSubmitEndTime("201903");
        //是否认证 0:未认证   1：通过
        advisorManagementParam.setIsCertification("0");

    }

    /**
     * 服务专员管理列表查询
     */
    @Test
    public void getAdvisorManagementInfoList() {
        try {
            PaginationData paginationData = advisorManagementPortalService.getAdvisorManagementInfoList(advisorManagementParam);
            List<AdvisorServiceManagementInfo> list= (List<AdvisorServiceManagementInfo>)paginationData.getRows();
            if(list!=null){
                for(AdvisorServiceManagementInfo advisorServiceManagementInfo:list){
                    logger.info(advisorServiceManagementInfo.toString());
                }
                assertThat(list.size(),greaterThanOrEqualTo(0));
            }else{
                assertThat(anything(),anything());
            }
        } catch (JnSpringCloudException e) {
            logger.warn("服务专员管理列表查询失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.START_MORE_THEN_END.getCode())
                    )
            );
        }
    }

    /**
     * 服务专员详情
     */
    @Test
    public void getAdvisorManagementDetails() {

        try {
            AdvisorManagementDetailsVo advisorManagementDetails = advisorManagementPortalService.getAdvisorManagementDetails(advisorAccount);
            if(advisorManagementDetails!=null && advisorManagementDetails.getAdvisorIntroduction()!=null){
                logger.info(advisorManagementDetails.getAdvisorIntroduction().toString());
            }
            if(advisorManagementDetails!=null && advisorManagementDetails.getAdvisorBaseInfoParam()!=null){
                logger.info(advisorManagementDetails.getAdvisorBaseInfoParam().toString());
            }
            if(advisorManagementDetails!=null && advisorManagementDetails.getServiceHonorList()!=null){
                for(ServiceHonor serviceHonor:advisorManagementDetails.getServiceHonorList()){
                    logger.info(serviceHonor.toString());
                }

            }
            if(advisorManagementDetails!=null && advisorManagementDetails.getServiceProjectExperienceList()!=null){
                for(ServiceProjectExperience serviceProjectExperience:advisorManagementDetails.getServiceProjectExperienceList()){
                    logger.info(serviceProjectExperience.toString());
                }

            }
            if(advisorManagementDetails!=null && advisorManagementDetails.getServiceExperienceList()!=null){
                for(ServiceExperience serviceExperience:advisorManagementDetails.getServiceExperienceList()){
                    logger.info(serviceExperience.toString());
                }

            }
            assertThat(advisorManagementDetails,notNullValue());
        } catch (JnSpringCloudException e) {
            logger.warn("服务专员详情获取失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST.getCode()),
                            Matchers.containsString(AdvisorExceptionEnum.ADVISOR_INFO_NOT_EXIST.getCode())
                    )
            );
        }
    }
}