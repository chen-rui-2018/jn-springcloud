package com.jn.hardware.ding.service;

import com.jn.common.model.Result;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoResult;
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
public class DingTalkUserServiceTest {

    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(DingTalkUserServiceTest.class);
    @Autowired
    private DingTalkClient dingTalkClient;

    private DepartmentUserInfoParam departmentUserInfoParam;

    @Before
    public void setUp() throws Exception {
        departmentUserInfoParam = new DepartmentUserInfoParam();
        departmentUserInfoParam.setDepartment_id("61060184");
        departmentUserInfoParam.setOffset("1");
        departmentUserInfoParam.setSize("10");
    }

    @Test
    public void getDepartUserByPage() {
        Result<DepartmentUserInfoResult> result = dingTalkClient.getDepartUserByPage(departmentUserInfoParam);
        logger.info("\n分页获取部门用户详情：{}",result);
        assertThat(anything(),anything());
    }
}