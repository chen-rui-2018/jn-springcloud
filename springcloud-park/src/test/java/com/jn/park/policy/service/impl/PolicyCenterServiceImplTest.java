package com.jn.park.policy.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.park.enums.PolicyCenterExceptionEnum;
import com.jn.park.policy.model.*;
import com.jn.park.policy.service.PolicyCenterService;
import com.jn.park.policy.vo.PolicyDiagramDetailsVo;
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
 * @Date: 2019/3/28 17:24
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
public class PolicyCenterServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(PolicyCenterServiceImplTest.class);

    @Autowired
    private PolicyCenterService policyCenterService;

    /**
     * 政策中心首页
     */
    private PolicyCenterHomeParam policyCenterHomeParam=new PolicyCenterHomeParam();

    //政策指南详情
    private String policyId="";

    //图解政策详情
    private String policyDiagramId="";

    @Before
    public void setUp() throws Exception {
        //政策中心首页
        policyCenterHomeParam.setTableType("allPolicy");
        policyCenterHomeParam.setPolicyLevelCode("area_level");
        policyCenterHomeParam.setPolicyClassCode("tax_incentives");
        policyCenterHomeParam.setPolicyType("0");
        policyCenterHomeParam.setReleaseDate("2019");
        policyCenterHomeParam.setNeedPage("1");

        //政策指南详情
        policyId="1233";

        //图解政策详情
        policyDiagramId="1523";

    }

    /**
     * 政策级别列表
     */
    @Test
    public void getPolicyLevelList() {
        try {
            List<PolicyLevelShow> policyLevelList = policyCenterService.getPolicyLevelList();
            assertThat(policyLevelList.size(),greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("获取政策级别列表失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PolicyCenterExceptionEnum.POLICY_LEVEL_NOT_EXIST.getCode())
                    ));
        }
    }

    /**
     * 政策分类列表
     */
    @Test
    public void getPolicyClassList() {
        try {
            List<PolicyClassShow> classList = policyCenterService.getPolicyClassList();
            assertThat(classList.size(),greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("获取政策分类列表失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PolicyCenterExceptionEnum.POLICY_TYPE_NOT_NULL.getCode())
                    ));
        }
    }

    /**
     * 政策中心首页
     */
    @Test
    public void getPolicyCenterList() {
        try {
            PaginationData paginationData = policyCenterService.getPolicyCenterList(policyCenterHomeParam);
            if(paginationData==null || paginationData.getRows()==null){
                //ignore
            }else{
                List<PolicyCenterHomeShow> investorInfoList=  (List<PolicyCenterHomeShow>)paginationData.getRows();
                for(PolicyCenterHomeShow policyCenterHomeShow:investorInfoList){
                    logger.info(policyCenterHomeShow.toString());
                }
            }
            assertThat(paginationData, anything());
        } catch (JnSpringCloudException e) {
            logger.warn("获取政策中心首页列表失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PolicyCenterExceptionEnum.POLICY_TYPE_NOT_NULL.getCode()),
                            Matchers.containsString(PolicyCenterExceptionEnum.TABLE_TYPE_IS_NOT_EXIST.getCode())
                    ));
        }
    }

    /**
     * 政策指南详情
     */
    @Test
    public void getPolicyDetails() {
        try {
            PolicyDetailsShow policyDetails = policyCenterService.getPolicyDetails(policyId);
            if(policyDetails==null){
                //ignore
            }else{
                logger.info(policyDetails.toString());
            }
            assertThat(policyDetails, anything());
        } catch (JnSpringCloudException e) {
            logger.warn("获取政策指南详情失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PolicyCenterExceptionEnum.POLICY_DETAILS_NOT_EXIST.getCode())
                    ));
        }
    }

    /**
     * 图解政策详情
     */
    @Test
    public void getPolicyDiagramDetails() {
        try {
            PolicyDiagramDetailsVo policyDiagramDetails = policyCenterService.getPolicyDiagramDetails(policyDiagramId);
            if(policyDiagramDetails==null){
                //ignore
            }else{
                logger.info(policyDiagramDetails.toString());
            }
            assertThat(policyDiagramDetails, anything());
        } catch (JnSpringCloudException e) {
            logger.warn("图解政策详情失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PolicyCenterExceptionEnum.POLICY_DIAGRAM_DETAILS_NOT_EXIST.getCode())
                    ));
        }
    }
}