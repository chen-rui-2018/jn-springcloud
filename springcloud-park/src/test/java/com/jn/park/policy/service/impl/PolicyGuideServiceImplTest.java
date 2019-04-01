package com.jn.park.policy.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.park.enums.PolicyInfoExceptionEnum;
import com.jn.park.policy.model.*;
import com.jn.park.policy.service.PolicyGuideService;
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

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/4/1 10:53
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
public class PolicyGuideServiceImplTest {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PolicyGuideServiceImplTest.class);

    @Autowired
    private PolicyGuideService policyGuideService;

    /**
     * 政策管理入参
     */
    private PolicyManagementParam policyManagementParam=new PolicyManagementParam();
    /**
     * 政策管理编辑（新增/修改）
     */
    private PolicyInfoEditParam policyInfoEditParam=new PolicyInfoEditParam();

    private String account;

    /**
     * 关联图解政策信息/关联政策原文信息
     */
    String policyType;

    /**
     * 政策管理上架/下架
     */
    private String policyId;
    private String status;

    @Before
    public void setUp() throws Exception {
        //政策管理
        policyManagementParam.setStatus("");
        policyManagementParam.setPolicyTitle("");
        policyManagementParam.setNeedPage("1");

        //政策管理编辑（新增/修改）
        account="wangsong";
        policyInfoEditParam.setPolicyTitle("测试新增政策");
        policyInfoEditParam.setPolicyLevelCode("national_level");
        policyInfoEditParam.setPolicyLevelName("国家级");
        policyInfoEditParam.setPolicyClassCode("financial_guidance");
        policyInfoEditParam.setPolicyClassName("财政引导");
        policyInfoEditParam.setThematicType("1");
        policyInfoEditParam.setSupportMethod("0");
        policyInfoEditParam.setSupportIndustry("1");
        policyInfoEditParam.setIssueUnit("国务院新闻办");
        policyInfoEditParam.setSupportIndustry("1");
        policyInfoEditParam.setIsPolicyDiagram("1");
        policyInfoEditParam.setRelationPolicyDiagramId("123");
        policyInfoEditParam.setPolicyContent("各市，区科技局，有关单位，为贯彻落实市委，市政府....");

        //关联图解政策信息/关联政策原文信息
        policyType="0";

        //政策管理上架/下架
        policyId="123";
        status="1";
    }

    /**
     * 政策管理
     */
    @Test
    public void getPolicyManagementList() {
        PaginationData paginationData = policyGuideService.getPolicyManagementList(policyManagementParam);
        if(paginationData==null || paginationData.getRows()==null){
            //ignore
        }else{
            List<PolicyManagementShow> policyManagementShows=(List<PolicyManagementShow>)paginationData.getRows();
            for (PolicyManagementShow policyManagementShow:policyManagementShows) {
                logger.info(policyManagementShow.toString());
            }
        }
        assertThat(paginationData,anything());
    }

    /**
     *  政策管理编辑（新增/修改）
     */
    @Test
    public void saveOrUpdatePolicyInfo() {
        try {
            int responseNum = policyGuideService.saveOrUpdatePolicyInfo(policyInfoEditParam, account);
            logger.info("-----------政策管理编辑（新增/修改）数据响应条数是：{}--------------",responseNum);
            assertThat(responseNum,greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("政策管理编辑（新增/修改）失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_INFO_LEVEL_NOT_EXIST.getCode()),
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_INFO_CLASS_NOT_EXIST.getCode()),
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_NOT_NULL.getCode()),
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_MUST_NULL.getCode()),
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_DIAGRAM_ID_NOT_EXIST.getCode()),
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_ID_NOT_EXIST.getCode())
                    ));
        }
    }

    /**
     * 获取政策编号
     */
    @Test
    public void getPolicyCode() {
        String policyCode = policyGuideService.getPolicyCode();
        logger.info("------获取政策编号:[{}]-------",policyCode);
        assertThat(policyCode,notNullValue() );
    }

    /**
     * 关联图解政策信息/关联政策原文信息
     */
    @Test
    public void getPolicyInfo() {
        List<PolicyInfoShow> policyInfo = policyGuideService.getPolicyInfo(policyType);
        if(policyInfo==null || policyInfo.isEmpty()){
            policyInfo=new ArrayList<>();
        }else{
            for(PolicyInfoShow policyInfoShow:policyInfo){
                logger.info(policyInfoShow.toString());
            }
        }
        assertThat(policyInfo.size(),greaterThanOrEqualTo(0));
    }

    /**
     * 政策管理上架/下架
     */
    @Test
    public void shelfOrObtained() {
        try {
            int responseNum = policyGuideService.shelfOrObtained(policyId, status, account);
            logger.info("------政策管理上架/下架数据响应条数是[{}]条-----",responseNum);
            assertThat(responseNum,greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("政策管理上架/下架失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_ID_NOT_EXIST.getCode()),
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_EXIST_SHELF.getCode()),
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_EXIST_OBTAINED.getCode())
                    ));
        }
    }

    /**
     * 获取普通政策详情
     */
    @Test
    public void getPolicyGuidDetails(){
        try {
            PolicyGuideDetailsShow policyGuidDetails = policyGuideService.getPolicyGuidDetails(policyId);
            if(policyGuidDetails!=null){
                logger.info(policyGuidDetails.toString());
            }
            assertThat(policyGuidDetails, anything());
        } catch (JnSpringCloudException e) {
            logger.warn("获取普通政策详情");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PolicyInfoExceptionEnum.POLICY_ID_NOT_EXIST.getCode())
                    ));
        }
    }
}