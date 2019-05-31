package com.jn.enterprise.common.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.enterprise.common.service.CommonService;
import com.jn.enterprise.common.vo.CodeVO;
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
 * @Author: huxw
 * @Date: 2019-4-3 2019-4-3 15:41:39
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class CommonServiceImplTest {

    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(CommonServiceImplTest.class);

    @Autowired
    private CommonService commonService;

    // 码表分组ID
    String groupId;

    @Before
    public void setUp() throws Exception {
        groupId = "recruitType";
    }

    @Test
    public void getCodeList() {
        try {
            List<CodeVO> codeList = commonService.getCodeList(groupId);
            assertThat(codeList.size(),greaterThanOrEqualTo(1));
        } catch (JnSpringCloudException e) {
            logger.info("获取码表数据失败");
        }
    }
}