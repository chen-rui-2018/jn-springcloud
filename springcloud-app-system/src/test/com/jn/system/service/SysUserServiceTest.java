package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.model.QueryVo;
import com.jn.system.vo.TbSysUser;
import com.jn.system.vo.TbSysUserDepartmentPost;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void addSysUserTest() {
        TbSysUser sysUser = new TbSysUser();
        sysUser.setAccount("datang05");
        sysUser.setEmail("123345678@163.com");
        sysUser.setName("大唐");
        sysUser.setPhone("12345678998");
        sysUser.setStatus("1");
        sysUserService.addSysUser(sysUser);
    }

    @Test
    public void findSysUserByPageTest(){
        QueryVo sysUserQueryVo = new QueryVo();
        sysUserQueryVo.setPage(0);
        sysUserQueryVo.setRows(10);
        Result result = sysUserService.findSysUserByPage(sysUserQueryVo);
        System.out.println(result);
    }

    @Test
    public void deleteSysUserTest(){
        String[] ids = {"u003","u004"};
        sysUserService.deleteSysUser(ids);
    }

    @Test
    public void updateSysUserTest(){
        TbSysUser sysUser = new TbSysUser();
        sysUser.setId("u002");
        sysUser.setPassword("45677");
        sysUser.setName("大唐006");
        sysUserService.updateSysUser(sysUser);
    }

    @Test
    public void findSysGroupByUserIdTest(){
        Result result = sysUserService.findSysGroupByUserId("u002");
        System.out.println(result);
    }

    @Test
    public void saveSysGroupToSysUserTest(){
        String[] groupIds = {"g002","g003"};
        sysUserService.saveSysGroupToSysUser(groupIds,"u002");
    }

    @Test
    public void findSysRoleByUserIdTest(){
        Result result = sysUserService.findSysRoleByUserId("u002");
        System.out.println(result);
    }

    @Test
    public void saveSysRoleToSysUser(){
        String[] roleId = {"r002","r003"};
        sysUserService.saveSysRoleToSysUser(roleId,"u002");
    }

    @Test
    public void findDepartmentandPostByUserIdTest(){
        Result result = sysUserService.findDepartmentandPostByUserId("u002");
        System.out.println(result);
    }

    @Test
    public void saveDepartmentandPostOfUser(){
        TbSysUserDepartmentPost sysUserDepartmentPost = new TbSysUserDepartmentPost();
        sysUserDepartmentPost.setDepartmentId("d004");
        sysUserDepartmentPost.setPostId("p004");
        List<TbSysUserDepartmentPost> list = new ArrayList<>();
        list.add(sysUserDepartmentPost);
        sysUserService.saveDepartmentandPostOfUser("u002",list);
    }

    @Test
    public void findSysUserByIdTest(){
        Result result = sysUserService.findSysUserById("u002");
        System.out.println(result);
    }
}
