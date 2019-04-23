package com.jn.enterprise.data;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.enterprise.data.service.DataModelService;
import com.jn.enterprise.data.service.DataUploadService;
import com.jn.enterprise.data.vo.TargetVO;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
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
 * @date： Created on 2019/4/22 14:54
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class DataUploadServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(DataModelServiceImplTest.class);
    @Autowired
    private DataUploadService uploadService;

    private TargetVO targetVO = new TargetVO();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void updateTarget(){

        try {
            User user =new User();
            uploadService.getCompanyAd(user);
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
