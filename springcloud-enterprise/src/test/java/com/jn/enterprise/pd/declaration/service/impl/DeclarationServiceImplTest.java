package com.jn.enterprise.pd.declaration.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.model.PersonnelProject;
import com.jn.enterprise.pd.declaration.model.DeclarationPlatformModel;
import com.jn.enterprise.pd.declaration.service.DeclarationPlatformService;
import com.jn.enterprise.pd.personnel.service.PersonnelService;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
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
import java.util.List;

/**
 * 申报平台Junit测试类
 *
 * @author： wzy
 * @date： Created on 2019/4/28 16:47
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudEnterpriseApplication.class})
public class DeclarationServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(DeclarationServiceImplTest.class);

    @Autowired
    private DeclarationPlatformService declarationPlatformService;

    private String id;
    private String account;

    @Before
    public void setUp() throws Exception {
        id = "123457";
        account = "wangsong";
    }

    @Test
    public void getDeclarationPlatformList() {
        try {
            String subordinatePlatformName = "1";
            String platformTitle = "人才";

            PaginationData getData = declarationPlatformService.selectByDeclarationPlatformList(subordinatePlatformName,platformTitle,1,5);
            List<DeclarationPlatformModel> data =  ( List<DeclarationPlatformModel>)getData.getRows();
            logger.info("获取申报平台数据{}",data);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("获取申报平台数据异常");
        }
    }

    @Test
    public void addOrEditMemorandum() {
        try {
            User user = new User();
            user.setAccount("wangsong");
            declarationPlatformService.addOrEditMemorandum("562967953339842560","admin/1",user);
            logger.info("新增or修改申报平台备忘录成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("新增or修改申报平台备忘录失败");
        }
    }
}
