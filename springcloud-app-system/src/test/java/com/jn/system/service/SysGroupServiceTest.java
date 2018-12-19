package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.User;
import com.jn.system.permission.model.SysRoleGroupAdd;
import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysGroupService;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 用户dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 11:27
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysGroupServiceTest {

    private Logger logger = LoggerFactory.getLogger(SysGroupServiceTest.class);

    @Autowired
    private SysGroupService sysGroupService;

    @Test
    public void findSysGroupAllTest() {
        SysGroupPage sysGroupPage = new SysGroupPage();
        sysGroupPage.setPage(1);
        sysGroupPage.setRows(10);
        PaginationData data = sysGroupService.findSysGroupAll(sysGroupPage);
        logger.info("测试结果:{}", data.toString());
    }

    @Test
    public void addSysGroupTest() {
        SysGroupAdd sysGroup = new SysGroupAdd();
        sysGroup.setGroupName("财务组"+ RandomStringUtils.randomNumeric(4));
        sysGroup.setStatus("1");
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysGroupService.addSysGroup(sysGroup, user);
    }

    @Test
    public void deleSysGroupTest() {
        String[] groupIdS = {"g003", "g002"};
        sysGroupService.deleSysGroup(groupIdS);
    }

    @Test
    public void updateSysGroupTest() {
        SysGroupUpdate sysGroup = new SysGroupUpdate();
        sysGroup.setId("492c6244-c103-4992-b944-569ff3870396");
        sysGroup.setGroupName("员工组24");
        sysGroupService.updateSysGroup(sysGroup);
    }

    @Test
    public void selectGroupRoleAndOtherRoleTest() {
        SysGroupRolePage sysGroupRolePage = new SysGroupRolePage();
        sysGroupRolePage.setPage(1);
        sysGroupRolePage.setRows(10);
        PaginationData data = sysGroupService.selectGroupRoleAndOtherRole(sysGroupRolePage);
        logger.info("测试结果:{}", data.toString());
    }

    @Test
    public void roleGroupAuthorizationTest() {
        SysRoleGroupAdd sysRoleGroupAdd = new SysRoleGroupAdd();
        sysRoleGroupAdd.setGroupId("g002");
        String[] roleIds = {"r001", "r002"};
        sysRoleGroupAdd.setRoleIds(roleIds);
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysGroupService.roleGroupAuthorization(sysRoleGroupAdd, user);
    }


    @Test
    public void findOtherUserByPageTest() {
        SysGroupUserPage sysGroupUserPage = new SysGroupUserPage();
        sysGroupUserPage.setGroupId("g002");
        sysGroupUserPage.setPage(1);
        sysGroupUserPage.setRows(1);
        PaginationData data = sysGroupService.findOtherUserByPage(sysGroupUserPage);
        logger.info("测试结果:{}", data.toString());
    }

    @Test
    public void userGroupAuthorization() {
        SysGroupUserAdd sysGroupUserAdd = new SysGroupUserAdd();
        sysGroupUserAdd.setGroupId("g002");
        String[] userIds = {"u003", "u004"};
        sysGroupUserAdd.setUserIds(userIds);
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysGroupService.userGroupAuthorization(sysGroupUserAdd, user);
    }

}
