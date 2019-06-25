package com.jn.hardware.ding.service;

import com.jn.common.model.Result;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoResult;
import com.jn.hardware.model.dingtalk.user.UserDetailsInfoParam;
import com.jn.hardware.model.dingtalk.user.UserDetailsInfoResult;
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

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getDepartUserByPage() {
        DepartmentUserInfoParam departmentUserInfoParam = new DepartmentUserInfoParam();
        departmentUserInfoParam.setDepartmentId("61060184");
        departmentUserInfoParam.setOffset(1L);
        departmentUserInfoParam.setSize(10L);

        Result<DepartmentUserInfoResult> result = dingTalkClient.getDepartUserByPage(departmentUserInfoParam);
        logger.info("\n分页获取部门用户详情：{}",result);
        assertThat(anything(),anything());
    }

    @Test
    public void getUserInfo() {
        UserDetailsInfoParam userInfoParam = new UserDetailsInfoParam();
        userInfoParam.setUserid("0452075464668030");
        Result<UserDetailsInfoResult> result = dingTalkClient.getUserInfo(userInfoParam);
        logger.info("\n获取用户详情：{}",result);
        logger.info("：getIsAdmin  : {}, getIsBoss : {},getIsHide : {}, getIsSenior : {}",result.getData().getIsAdmin()
                , result.getData().getIsBoss()
                ,result.getData().getIsHide()
                ,result.getData().getIsSenior());
        assertThat(anything(),anything());
    }


}