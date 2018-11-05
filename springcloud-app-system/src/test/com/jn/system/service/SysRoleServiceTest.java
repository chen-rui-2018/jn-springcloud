package com.jn.system.service;

import com.jn.common.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 角色测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysRoleServiceTest {

    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void findSysRoleAll() {
        Result result = sysRoleService.findSysRoleAll();
        System.out.println(result);
    }
}
