package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.dept.entity.TbSysPostType;
import com.jn.system.dept.model.SysPostType;
import com.jn.system.dept.model.SysPostTypeAdd;
import com.jn.system.dept.model.SysPostTypePage;
import com.jn.system.dept.service.SysPostTypeService;
import com.jn.system.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysPostTypeServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(SysPostTypeServiceImplTest.class);

    @Autowired
    private SysPostTypeService sysPostTypeService;

    @Test
    public void add() {
        SysPostTypeAdd postTypeAdd = new SysPostTypeAdd();
        postTypeAdd.setPostTypeName("xxx"+ RandomStringUtils.randomNumeric(4));
        postTypeAdd.setStatus("1");
        User user = new User();
        user.setId("10000");
        sysPostTypeService.add(postTypeAdd,user);
    }

    @Test
    public void getPostTypeByPage() {
        SysPostTypePage sysPostTypePage = new SysPostTypePage();
        sysPostTypePage.setPage(1);
        sysPostTypePage.setRows(10);
        PaginationData postTypeByPage = sysPostTypeService.getPostTypeByPage(sysPostTypePage);
        logger.info("测试结果:{}",postTypeByPage);
    }

    @Test
    public void checkPostTypeName() {
        String resule = sysPostTypeService.checkPostTypeName("xxx");
        logger.info("测试结果:{}",resule);
    }

    @Test
    public void update() {
        SysPostType sysPostType = new SysPostType();
        sysPostType.setId("f0d34f97-4c5b-4252-83c3-723d46c37c9e");
        sysPostType.setPostTypeName("公司高层8");
        sysPostType.setStatus("1");
        sysPostTypeService.update(sysPostType);
    }

    @Test
    public void delete() {
        sysPostTypeService.delete("ff25c5df-b30d-4a83-9cd0-4dcf631bedcd");
    }

    @Test
    public void getPostTypeAll() {
        List<TbSysPostType> postTypeAll = sysPostTypeService.getPostTypeAll();
        logger.info("测试结果:{}",postTypeAll);
    }
}