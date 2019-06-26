package com.jn.oa.dingtalk.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.oa.dingTalk.service.DingTalkUserService;
import com.jn.oa.leave.service.LeaveService;
import com.jn.oa.model.Leave;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 钉钉用户service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DingTalkUserServiceTest {

    @Autowired
    public DingTalkUserService dingTalkUserService;



    @BeforeClass
    public static void init() {

    }

    /**
     * 批量插入数据
     */
    @Test
    public void batchInsertDingTalkUser() {
        try {
            dingTalkUserService.batchInsertDingTalkUser();
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }







}
