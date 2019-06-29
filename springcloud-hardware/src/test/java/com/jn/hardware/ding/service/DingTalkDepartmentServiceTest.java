package com.jn.hardware.ding.service;

import com.jn.common.model.Result;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.model.dingtalk.user.DepartmentDetailsInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentDetailsInfoResult;
import com.jn.hardware.model.dingtalk.user.DepartmentListParam;
import com.jn.hardware.model.dingtalk.user.DepartmentListResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DingTalkDepartmentServiceTest {

    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(DingTalkDepartmentServiceTest.class);
    @Autowired
    private DingTalkClient dingTalkClient;

    @Before
    public void setUp() throws Exception {

    }


    /**
     * 获取部门列表
     * */
    @Test
    public void getDepartmentList() {

        DepartmentListParam departmentListParam = new DepartmentListParam();
        Result<DepartmentListResult> result = dingTalkClient.getDepartmentList(departmentListParam);

        logger.info("\n获取部门列表：{}",result);
    }

    /**
     * 获取部门详情
    * */
    @Test
    public void getDepartmentDetails() {
        DepartmentDetailsInfoParam departmentDetailsInfoParam = new DepartmentDetailsInfoParam();
        departmentDetailsInfoParam.setId("119696142");
        Result<DepartmentDetailsInfoResult> result = dingTalkClient.getDepartmentDetails(departmentDetailsInfoParam);
        logger.info("\n获取部门详情：{}",result);
        assertThat(anything(),anything());
    }




}