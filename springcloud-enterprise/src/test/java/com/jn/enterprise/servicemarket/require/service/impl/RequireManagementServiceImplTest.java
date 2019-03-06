package com.jn.enterprise.servicemarket.require.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.enterprise.enums.RequireExceptionEnum;
import com.jn.enterprise.servicemarket.require.model.RequireParam;
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

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;
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
     * 用户提需求入参
     */
    private RequireParam requireParam =new RequireParam();

    private String account="";

    @Before
    public void setUp() throws Exception {
        //用户提需求（非科技金融）
        requireParam.setProductId("228043fd4f37438ea34e5a9ccdea2271");
        requireParam.setProductName("招聘外包");
        requireParam.setRequireDetail("需要企业提供外包任务");

        account="qianqi";
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
    }

    /**
     * 对他人的需求列表查询
     */
    @Test
    public void getRequireOtherList() {
    }

    /**
     * 撤销对他人的需求
     */
    @Test
    public void cancelRequire() {
    }

    /**
     *  需求详情（对他人需求）
     */
    public void getOtherRequireDetails() {
    }

    /**
     * 我收到的需求列表查询
     */
    @Test
    public void getRequireReceivedList() {
    }

    /**
     * 对接需求操作
     */
    @Test
    public void handleOperating() {
    }

    /**
     * 需求详情（我收到的需求）
     */
    @Test
    public void getReceivedRequireDetails() {
    }

    /**
     * 对接需求（我收到的需求）
     */
    @Test
    public void handleRequire() {
    }

    /**
     * 需求管理列表查询（后台门户管理）
     */
    @Test
    public void getPortalRequireInfoList() {
    }

    /**
     * 需求详情（后台门户管理）
     */
    @Test
    public void getPortalRequireDetails() {
    }
}