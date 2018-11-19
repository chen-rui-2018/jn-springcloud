package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.model.SysPermissionAdd;
import com.jn.system.model.SysPermissionResourcePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 权限测试
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
    public void addPermissionTest(){
        SysPermissionAdd sysPermissionAdd = new SysPermissionAdd();
        sysPermissionAdd.setPermissionName("测试权限1");
        sysPermissionAdd.setStatus("1");
        sysPermissionService.addPermission(sysPermissionAdd);
    }

}
