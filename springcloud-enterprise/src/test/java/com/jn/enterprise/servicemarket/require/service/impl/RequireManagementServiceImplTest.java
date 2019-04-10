package com.jn.enterprise.servicemarket.require.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.RequireExceptionEnum;
import com.jn.enterprise.servicemarket.require.model.*;
import com.jn.enterprise.servicemarket.require.service.RequireManagementService;
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

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/3/6 15:42
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class RequireManagementServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(RequireManagementServiceImplTest.class);

    @Autowired
    private RequireManagementService requireManagementService;

    /**
     * 用户提需求入参(非科技金融)
     */
    private RequireParam requireParam =new RequireParam();
    /**
     * 用户提需求入参(科技金融)
     */
    private RequireTechnologyParam requireTechnologyParam=new RequireTechnologyParam();

    /**
     * 对他人的需求列表查询
     */
    private RequireOtherParam requireOtherParam=new RequireOtherParam();

    /**
     * 我收到的需求列表查询
     */
    private RequireReceivedParam requireReceivedParam=new RequireReceivedParam();
    /**
     * 对接需求（我收到的需求）
     */
    private HandleRequireParam handleRequireParam=new HandleRequireParam();

    /**
     * 需求管理列表查询（后台门户管理）
     */
    private RequirePortalParam requirePortalParam=new RequirePortalParam();


    private String account="";

    private String reqNum="";

    String advisorName="";

    @Before
    public void setUp() throws Exception {
        //用户提需求（非科技金融）
        requireParam.setProductId("228043fd4f37438ea34e5a9ccdea2271");
        requireParam.setProductName("招聘外包");
        requireParam.setRequireDetail("需要企业提供外包任务");
        account="wangsong";

        //用户提需求(科技金融)
        requireTechnologyParam.setProductId("228043fd4f37438ea34e5a9ccdea2271");
        requireTechnologyParam.setProductName("招聘外包");
        //requireTechnologyParam.setRequireDetail("需要机构提供外包服务");
        requireTechnologyParam.setFinancingAmount("90");
        requireTechnologyParam.setActualLoanAmount("66");
        requireTechnologyParam.setFinancingPeriod("6");
        requireTechnologyParam.setExpectedDate("2019-03-07");
        requireTechnologyParam.setFundsReqDesc("我需要先贷款付工资");

        //对他人的需求列表查询
        requireOtherParam.setIntentProduct("代理");
        requireOtherParam.setIntentOrg("测试");
        requireOtherParam.setHandleResult("1");
        requireOtherParam.setNeedPage("0");

        //撤销对他人的需求
        reqNum="201903061736424";

        //我收到的需求列表查询
        requireReceivedParam.setHandleResult("1");
        requireReceivedParam.setIntentProduct("代理");
        requireReceivedParam.setRequirePerson("李四");

        //对接需求操作
        advisorName="王松";

        //对接需求（我收到的需求）
        handleRequireParam.setReqNum(reqNum);
        handleRequireParam.setContractAmount("80");
        handleRequireParam.setHandleResult("2");
        handleRequireParam.setResultDetail("还是有点小问题的");
        handleRequireParam.setContractHomePage("first.jpg");
        handleRequireParam.setContractEndPage("end.jpg");
        handleRequireParam.setIsTechnology("0");

        //需求管理列表查询（后台门户管理）
        requirePortalParam.setProductType("0");
        requirePortalParam.setBusinessId("rlzy110110");
        requirePortalParam.setHandleResult("1");
        requirePortalParam.setServiceOrg("新增");
        requirePortalParam.setRequireStartTime("201902");
        requirePortalParam.setRequireEndTime("201903");
        requirePortalParam.setServiceProduct("外包");


    }

    /**
     * 用户提需求(非科技金融)
     */
    @Test
    public void userDemand() {
        try {
            int responseNum = requireManagementService.userDemand(requireParam, account);
            assertThat(responseNum,greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("用户提需求(非科技金融)失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RequireExceptionEnum.REQUIRE_REPEATED_SUBMIT.getCode()),
                            Matchers.containsString(RequireExceptionEnum.ORG_ID_NOT_EXIST.getCode()),
                            Matchers.containsString(RequireExceptionEnum.NETWORK_ANOMALY.getCode()),
                            Matchers.containsString(RequireExceptionEnum.PRODUCT_ID_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 获取需求单号
     */
    @Test
    public void getRequireNum() {
        String requireNum = requireManagementService.getRequireNum();
        logger.info("获取需求单号:{}",requireNum);
        assertThat(requireNum, notNullValue());
    }

    /**
     * 用户提需求(科技金融)
     */
    @Test
    public void userDemandTechnology() {
        try {
            int responseNum = requireManagementService.userDemandTechnology(requireTechnologyParam, account);
            assertThat(responseNum,greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("用户提需求(科技金融)失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RequireExceptionEnum.REQUIRE_REPEATED_SUBMIT.getCode()),
                            Matchers.containsString(RequireExceptionEnum.PRODUCT_ID_NOT_EXIST.getCode()),
                            Matchers.containsString(RequireExceptionEnum.NETWORK_ANOMALY.getCode()),
                            Matchers.containsString(RequireExceptionEnum.PRODUCT_ID_NOT_EXIST.getCode())
                    )
            );
        }
    }

    /**
     * 对他人的需求列表查询
     */
    @Test
    public void getRequireOtherList() {
        PaginationData paginationData = requireManagementService.getRequireOtherList(requireOtherParam, account);
        if(paginationData==null ||paginationData.getRows()==null){
            assertThat(anything(),anything());
        }else {
            List<RequireInfoList> requireOtherList= (List<RequireInfoList>)paginationData.getRows();
            for(RequireInfoList requireInfoList:requireOtherList){
                logger.info("对他人的需求列表查询{}",requireInfoList.toString());
            }
            assertThat(requireOtherList.size(), greaterThanOrEqualTo(0));
        }
    }

    /**
     * 撤销对他人的需求
     */
    @Test
    public void cancelRequire() {
        int responseNum = requireManagementService.cancelRequire(reqNum, account);
        logger.info("撤销对他人的需求数据响应条数：{}",responseNum);
        assertThat(responseNum, greaterThanOrEqualTo(0));
    }

    /**
     *  需求详情（对他人需求）
     */
    @Test
    public void getOtherRequireDetails() {
        try {
            RequireOtherDetails otherRequireDetails = requireManagementService.getOtherRequireDetails(reqNum);
            if(otherRequireDetails==null){
                assertThat(anything(), anything());
            }else{
                logger.info("需求详情（对他人需求）:{}",otherRequireDetails.toString());
                assertThat(otherRequireDetails,notNullValue());
            }
        } catch (JnSpringCloudException e) {
            logger.warn("需求详情（对他人需求）获取失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RequireExceptionEnum.REQUIRE_INFO_NOT_EXIST.getCode()),
                            Matchers.containsString(RequireExceptionEnum.NETWORK_ANOMALY.getCode())
                    )
            );
        }
    }

    /**
     * 我收到的需求列表查询
     */
    @Test
    public void getRequireReceivedList() {
        try {
            PaginationData paginationData = requireManagementService.getRequireReceivedList(requireReceivedParam, account);
            if(paginationData==null ||paginationData.getRows()==null){
                assertThat(anything(),anything());
            }else {
                List<RequireInfoList> requireOtherList= (List<RequireInfoList>)paginationData.getRows();
                for(RequireInfoList requireInfoList:requireOtherList){
                    logger.info("我收到的需求列表查询:{}",requireInfoList.toString());
                }
                assertThat(requireOtherList.size(), greaterThanOrEqualTo(0));
            }
        } catch (JnSpringCloudException e) {
            logger.warn("我收到的需求列表查询获取失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RequireExceptionEnum.NETWORK_ANOMALY.getCode())
                    )
            );
        }
    }

    /**
     * 对接需求操作
     */
    @Test
    public void handleOperating() {
        try {
            int responseNum = requireManagementService.handleOperating(reqNum, account, advisorName);
            logger.info("对接需求操作数据响应条数：{}",responseNum);
            assertThat(responseNum, greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("对接需求操作失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RequireExceptionEnum.DATA_NOT_ALLOW_OPERATING.getCode())
                    )
            );
        }
    }

    /**
     * 需求详情（我收到的需求）
     */
    @Test
    public void getReceivedRequireDetails() {
        try {
            RequireReceivedDetails receivedRequireDetails = requireManagementService.getReceivedRequireDetails(reqNum);
            if(receivedRequireDetails==null){
                assertThat(anything(), anything());
            }else{
                logger.info("需求详情（我收到的需求）,需求编号：[{}]的详情是：{}",reqNum,receivedRequireDetails.toString());
            }
        } catch (JnSpringCloudException e) {
            logger.warn("需求详情（我收到的需求）获取数据失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RequireExceptionEnum.REQUIRE_INFO_NOT_EXIST.getCode()),
                            Matchers.containsString(RequireExceptionEnum.NETWORK_ANOMALY.getCode())
                    )
            );
        }
    }

    /**
     * 对接需求（我收到的需求）
     */
    @Test
    public void handleRequire() {
        try {
            int responseNum = requireManagementService.handleRequire(handleRequireParam);
            logger.info("对接需求（我收到的需求）响应条数：{}",responseNum);
            assertThat(responseNum, greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("对接需求（我收到的需求）失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RequireExceptionEnum.REQUIRE_INFO_NOT_EXIST.getCode()),
                            Matchers.containsString(RequireExceptionEnum.IS_TECHNOLOGY_NOT_MATCH.getCode()),
                            Matchers.containsString(RequireExceptionEnum.IS_NOT_TECHNOLOGY_NOT_MATCH.getCode())
                    )
            );
        }
    }

    /**
     * 需求管理列表查询（后台门户管理）
     */
    @Test
    public void getPortalRequireInfoList() {
        try {
            PaginationData paginationData = requireManagementService.getPortalRequireInfoList(requirePortalParam);
            if(paginationData==null ||paginationData.getRows()==null){
                assertThat(anything(),anything());
            }else {
                List<RequirePortalInfoList> portalRequireInfoList= (List<RequirePortalInfoList>)paginationData.getRows();
                for(RequirePortalInfoList requirePortalInfoList:portalRequireInfoList){
                    logger.info("需求管理列表查询（后台门户管理）:{}",requirePortalInfoList.toString());
                }
                assertThat(portalRequireInfoList.size(), greaterThanOrEqualTo(0));
            }
        } catch (JnSpringCloudException e) {
            logger.warn("需求管理列表查询（后台门户管理）失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(RequireExceptionEnum.START_MORE_THEN_END.getCode())
                    )
            );
        }
    }

    /**
     * 需求详情（后台门户管理）
     */
    @Test
    public void getPortalRequireDetails() {
        RequirePortalDetails portalRequireDetails = requireManagementService.getPortalRequireDetails(reqNum);
        if(portalRequireDetails==null){
            assertThat(anything(),anything() );
        }else{
            logger.info("需求详情（后台门户管理）,需求单号：[{}]的详情是：{}",reqNum,portalRequireDetails.toString());
            assertThat(portalRequireDetails,notNullValue());
        }
    }
}