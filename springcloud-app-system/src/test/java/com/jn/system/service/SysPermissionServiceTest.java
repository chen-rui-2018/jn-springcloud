package com.jn.system.service;

import com.jn.system.model.User;
import com.jn.system.permission.model.SysPermissionAdd;
import com.jn.system.permission.service.SysPermissionService;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 权限测试
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 9:40
 * @version： v1.0
 * @modified By:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysPermissionServiceTest {

    private Logger logger = LoggerFactory.getLogger(SysPostServiceTest.class);

    @Autowired
    private SysPermissionService sysPermissionService;

    @Test
    public void addPermissionTest() {
        SysPermissionAdd sysPermissionAdd = new SysPermissionAdd();
        sysPermissionAdd.setPermissionName("测试权限1"+ RandomStringUtils.randomNumeric(4) );
        sysPermissionAdd.setStatus("1");
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysPermissionService.addPermission(sysPermissionAdd, user);
    }

}
