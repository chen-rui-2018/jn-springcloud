package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.dept.model.SysDepartmentPost;
import com.jn.system.dept.vo.SysDepartmentPostVO;
import com.jn.system.model.User;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysUserService;
import com.jn.system.user.vo.SysUserRoleVO;
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
        User user = new User();
        user.setId("10000");
        sysUserService.addSysUser(sysUser, user);
    }

    @Test
    public void findSysUserByPageTest() {
        SysUserPage sysUserUserQuery = new SysUserPage();
        sysUserUserQuery.setPage(1);
        sysUserUserQuery.setRows(10);
        PaginationData data = sysUserService.findSysUserByPage(sysUserUserQuery);
        logger.info("测试结果:{}", data.toString());
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
        PaginationData data = sysUserService.findSysGroupByUserId(sysUserGroupPage);
        logger.info("测试结果:{}", data.toString());
    }

    @Test
    public void saveSysGroupToSysUserTest() {
        String[] groupIds = {"g002", "g003"};
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysUserService.saveSysGroupToSysUser(groupIds, "u002", user);
    }

    @Test
    public void findSysRoleByUserIdTest() {
        SysUserRolePage sysUserRolePage = new SysUserRolePage();
        sysUserRolePage.setPage(1);
        sysUserRolePage.setRows(10);
        PaginationData data = sysUserService.findSysRoleByUserId(sysUserRolePage);
        logger.info("测试结果:{}", data.toString());
    }

    @Test
    public void saveSysRoleToSysUser() {
        String[] roleId = {"r002", "r003"};
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysUserService.saveSysRoleToSysUser(roleId, "u002", user);
    }

    @Test
    public void findDepartmentandPostByUserIdTest() {
        List<SysDepartmentPostVO> data = sysUserService.findDepartmentandPostByUserId("10000");
        logger.info("测试结果:" + data.toString());
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
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysUserService.saveDepartmentAndPostOfUser(sysUserDepartmentPost, user);
    }

    @Test
    public void findSysUserByIdTest() {
        SysUser data = sysUserService.findSysUserById("10000");
        logger.info("测试结果:", data.toString());
    }

}
