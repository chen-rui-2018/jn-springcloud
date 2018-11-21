package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.entity.TbSysUserDepartmentPost;
import com.jn.system.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysUserServiceTest {

    private Logger logger = LoggerFactory.getLogger(SysUserServiceTest.class);

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void addSysUserTest() {
        SysUser sysUser = new SysUser();
        sysUser.setAccount("datang11");
        sysUser.setEmail("1233458@163.com");
        sysUser.setName("大唐");
        sysUser.setPhone("12345678998");
        sysUser.setStatus("1");
        sysUserService.addSysUser(sysUser);
    }

    @Test
    public void findSysUserByPageTest() {
        SysUserPage sysUserUserQuery = new SysUserPage();
        sysUserUserQuery.setPage(1);
        sysUserUserQuery.setRows(10);
        Result result = sysUserService.findSysUserByPage(sysUserUserQuery);
        logger.info("测试结果:" + result.getData().toString());
    }

    @Test
    public void deleteSysUserTest() {
        String[] ids = {"u003", "u004"};
        sysUserService.deleteSysUser(ids);
    }

    @Test
    public void updateSysUserTest() {
        SysUser sysUser = new SysUser();
        sysUser.setId("10000");
        sysUser.setPassword("1gfddfgsdlg");
        sysUser.setName("管理员3");
        sysUserService.updateSysUser(sysUser);
    }

    @Test
    public void findSysGroupByUserIdTest() {
        SysUserGroupPage sysUserGroupPage = new SysUserGroupPage();
        sysUserGroupPage.setPage(1);
        sysUserGroupPage.setRows(10);
        Result result = sysUserService.findSysGroupByUserId(sysUserGroupPage);
        logger.info("测试结果:" + result.getData().toString());
    }

    @Test
    public void saveSysGroupToSysUserTest() {
        String[] groupIds = {"g002", "g003"};
        sysUserService.saveSysGroupToSysUser(groupIds, "u002");
    }

    @Test
    public void findSysRoleByUserIdTest() {
        SysUserRolePage sysUserRolePage = new SysUserRolePage();
        sysUserRolePage.setPage(1);
        sysUserRolePage.setRows(10);
        Result result = sysUserService.findSysRoleByUserId(sysUserRolePage);
        logger.info("测试结果:" + result.getData().toString());
    }

    @Test
    public void saveSysRoleToSysUser() {
        String[] roleId = {"r002", "r003"};
        sysUserService.saveSysRoleToSysUser(roleId, "u002");
    }

    @Test
    public void findDepartmentandPostByUserIdTest() {
        Result result = sysUserService.findDepartmentandPostByUserId("62619962-c88c-4530-b424-ced43b30e1ea");
        logger.info("测试结果:" + result.getData().toString());
    }

    @Test
    public void saveDepartmentandPostOfUser() {
        SysUserDepartmentPostAdd sysUserDepartmentPost = new SysUserDepartmentPostAdd();
        sysUserDepartmentPost.setUserId("u002");
        List<SysDepartmentPost> list = new ArrayList<>();
        SysDepartmentPost sysDepartmentPost = new SysDepartmentPost();
        sysDepartmentPost.setDepartmentId("d006");
        sysDepartmentPost.setPostId("p006");
        list.add(sysDepartmentPost);
        sysUserDepartmentPost.setSysDepartmentPostList(list);
        sysUserService.saveDepartmentandPostOfUser(sysUserDepartmentPost);
    }

    @Test
    public void findSysUserByIdTest() {
        Result result = sysUserService.findSysUserById("10000");
        logger.info("测试结果:" + result.getData().toString());
    }

}
