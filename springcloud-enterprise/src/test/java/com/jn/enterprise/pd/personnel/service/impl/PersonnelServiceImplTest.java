package com.jn.enterprise.pd.personnel.service.impl;

import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.model.PersonnelProject;
import com.jn.enterprise.pd.personnel.service.PersonnelService;
import com.jn.enterprise.servicemarket.comment.model.Rating;
import com.jn.enterprise.servicemarket.comment.model.RatingParameter;
import com.jn.park.hatch.api.HatchhomeConfigClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * 人才服务Junit测试类
 *
 * @author： wzy
 * @date： Created on 2019/4/28 16:47
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudEnterpriseApplication.class})
public class PersonnelServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(PersonnelServiceImplTest.class);

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private HatchhomeConfigClient hatchhomeConfigClient;


    private String id;
    private String account;

    @Before
    public void setUp() throws Exception {
        id = "123457";
        account = "wangsong";
    }

    @Test
    public void getPersonnelProjectList() {
        try {
            PersonnelProject personnelProject = new PersonnelProject();
            personnelProject.setName("测试");
            personnelProject.setType("1");
            personnelProject.setStepId((short) 8060);
            personnelProject.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-04-10 15:21:32"));
            List<PersonnelProject> personnelProjects = personnelService.selectByPersonnelProjectList(personnelProject);
            logger.info("获取人才申报数据{}");
        } catch (ParseException e) {
            e.printStackTrace();
            logger.info("获取人才申报数据异常");
        }

    }

    @Test
    public void updateEnrolmentActivit() {
        logger.info("凌晨4点执行执行,更新在孵企业（团队）报名活动项");
        hatchhomeConfigClient.updateEnrolmentActivit();
    }

    @Test
    public void updatePolicyDeclarate() {
        logger.info("凌晨4点执行执行,更新在孵企业（团队）政策申报项");
        hatchhomeConfigClient.updatePolicyDeclarate();
    }


}
