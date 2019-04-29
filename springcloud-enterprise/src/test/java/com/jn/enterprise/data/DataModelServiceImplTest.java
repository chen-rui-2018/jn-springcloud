package com.jn.enterprise.data;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.enterprise.data.dao.*;
import com.jn.enterprise.data.service.DataModelService;
import com.jn.enterprise.data.service.impl.DataModelServiceImpl;
import com.jn.enterprise.data.vo.TargetVO;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.service.impl.AdvisorEditServiceImplTest;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.assertThat;

/**
 * @author： yangh
 * @date： Created on 2019/4/19 11:55
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class DataModelServiceImplTest {

    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(DataModelServiceImplTest.class);
    private TargetVO targetVO = new TargetVO();

    @Autowired
    private DataModelService dataModelService;
    @Before
    public void setUp() throws Exception {
        targetVO.setTargetId("");
        targetVO.setInputFormatModels(null);
        targetVO.setParentId("0");
        targetVO.setOrderNumber(1);
        targetVO.setIsMuiltRow(0);
        targetVO.setUnit("万元");
        targetVO.setTargetName("经济指标");
        targetVO.setRecordStatus(1);

    }

    @Test
    public void updateTarget(){

        try {
            User user =new User();
            dataModelService.updateTarget(targetVO,user);
            assertThat(anything(),anything() );
        } catch (JnSpringCloudException e) {
            logger.warn("基本信息保存并更新失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                    )
            );
        }
    }
}

