package com.jn.user.usertag.service;

import com.jn.SpringCloudUserApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.model.*;
import com.jn.user.userinfo.model.UserInfoParam;
import com.jn.user.userinfo.service.UserInfoService;
import com.jn.user.usertag.dao.UserTagMapper;
import com.jn.user.usertag.model.TagCode;
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * 获取用户扩展信息测试类
 * @Author: yangph
 * @Date: 2018/12/22 16:52
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudUserApplication.class})
public class UserTagServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(UserTagServiceImplTest.class);

    @Autowired
    private UserTagService userTagService;

    @Test
    public void getTagCodeList(){
        List<TagCode> tagCodeList = userTagService.getTagCodeList();
        logger.info("用户字典标签数据查询成功，共{}条",tagCodeList.size());
        assertThat(tagCodeList.size(),greaterThanOrEqualTo(0));
    }

}