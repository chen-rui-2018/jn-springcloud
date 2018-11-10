package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.entity.TbSysGroup;
import com.jn.system.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        Result result = sysGroupService.findSysGroupAll(sysGroupPage);
        logger.info("测试结果:"+result.getData().toString());
    }

    @Test
    public void addSysGroupTest() {
        TbSysGroup sysGroup = new TbSysGroup();
        sysGroup.setGroupName("财务组");
        sysGroup.setStatus("1");
        sysGroupService.addSysGroup(sysGroup);
    }

    @Test
    public void deleSysGroupTest() {
        String[] groupIdS = {"g003", "g002"};
        sysGroupService.deleSysGroup(groupIdS);
    }

    @Test
    public void updateSysGroupTest() {
        TbSysGroup sysGroup = new TbSysGroup();
        sysGroup.setId("g001");
        sysGroup.setGroupName("");
        sysGroup.setCreator("系统管理员");
        sysGroupService.updateSysGroup(sysGroup);
    }

    @Test
    public void selectGroupRoleAndOtherRoleTest(){
        Result result = sysGroupService.selectGroupRoleAndOtherRole("g002");
        logger.info("测试结果:"+result.getData().toString());
    }

    @Test
    public void roleGroupAuthorizationTest(){
        SysRoleGroupAdd sysRoleGroupAdd = new SysRoleGroupAdd();
        sysRoleGroupAdd.setGroupId("g002");
        String[] roleIds = {"r001","r002"};
        sysRoleGroupAdd.setRoleIds(roleIds);
        sysGroupService.roleGroupAuthorization(sysRoleGroupAdd);
    }

    @Test
    public void findUserOfGroupTest(){
        Result result = sysGroupService.findUserOfGroup("g002");
        logger.info("测试结果:"+result.getData().toString());
    }

    @Test
    public void findOtherUserByPageTest(){
        SysGroupUserPage sysGroupUserPage = new SysGroupUserPage();
        sysGroupUserPage.setGroupId("g002");
        sysGroupUserPage.setPage(1);
        sysGroupUserPage.setRows(1);
        Result result = sysGroupService.findOtherUserByPage(sysGroupUserPage);
        logger.info("测试结果:"+result.getData().toString());
    }

    @Test
    public void userGroupAuthorization(){
        SysGroupUserAdd sysGroupUserAdd = new SysGroupUserAdd();
        sysGroupUserAdd.setGroupId("g002");
        String[] userIds = {"u003","u004"};
        sysGroupUserAdd.setUserIds(userIds);
        sysGroupService.userGroupAuthorization(sysGroupUserAdd);
    }

}
