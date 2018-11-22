package com.jn.system.service;

import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 权限模块的角色单元测试
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:33
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleServiceImplTest {
    @Resource
    private SysRoleService tbRoleService;


    @Test
    public void selectRoleListBySearchKey(){
        SysRolePage rolePage =new SysRolePage();
        rolePage.setPage(1);
        rolePage.setRows(10);
        tbRoleService.selectRoleListBySearchKey(rolePage);

    }

    /**
     * 新增角色
     */
    @Test
    public void insertTbSystemRole(){
        SysRoleAdd role=new SysRoleAdd();
        role.setRoleName("普通用户");
        role.setStatus(SysStatusEnums.EFFECTIVE.getKey());
        User user=new User();
        user.setId("123");
        user.setAccount("xxx");
        tbRoleService.insertTbRole(role,user);
    }

    /**
     * 更新角色信息
     */
    @Test
    public void updateTbRole(){
        SysRoleUpdate role=new SysRoleUpdate();
        role.setId("6c877a03-fc6c-4d0b-81d3-b4040ff732b3");
        role.setRoleName("普通用户1");
        role.setStatus(SysStatusEnums.INVALID.getKey());
        tbRoleService.updateTbRole(role);
    }

    /**
     * 批量删除角色（逻辑删除）
     */
    @Test
    public void deleteTbRoleById(){
        String[] roleIds={"6c877a03-fc6c-4d0b-81d3-b4040ff732b3"};
        tbRoleService.deleteTbRoleById(roleIds);

    }

    /**
     * 添加角色授权（用户）
     */
    @Test
    public void userRoleAuthorizationTest(){
        SysUserRoleAdd sysUserRoleAdd =new SysUserRoleAdd();
        sysUserRoleAdd.setRoleId("6c877a03-fc6c-4d0b-81d3-b4040ff732b3");
        String[] userIds={"u001","u002"};
        sysUserRoleAdd.setUserId(userIds);
        User user=new User();
        user.setId("123");
        user.setAccount("xxx");
        tbRoleService.userRoleAuthorization(sysUserRoleAdd,user);

    }
    /**
     * 添加角色授权（权限）
     */
    @Test
    public void rolePermissionAuthorizationTest(){
        SysRolePermissionAdd sysRolePermissionAdd =new SysRolePermissionAdd();
        sysRolePermissionAdd.setRoleId("6c877a03-fc6c-4d0b-81d3-b4040ff732b3");
        String[] permissionIds={"p001","p002"};
        sysRolePermissionAdd.setPermissionId(permissionIds);
        User user=new User();
        user.setId("123");
        user.setAccount("xxx");
        tbRoleService.rolePermissionAuthorization(sysRolePermissionAdd,user);

    }
    /**
     * 添加角色授权（用户组）
     */
    @Test
    public void UserGroupRoleAuthorizationTest(){
        SysUserGroupRoleAdd sysUserGroupRoleAdd =new SysUserGroupRoleAdd();
        sysUserGroupRoleAdd.setRoleId("6c877a03-fc6c-4d0b-81d3-b4040ff732b3");
        String[] userGroupRole={"ug001","ug002"};
        sysUserGroupRoleAdd.setUserGroupId(userGroupRole);
        User user=new User();
        user.setId("123");
        user.setAccount("xxx");
        tbRoleService.UserGroupRoleAuthorization(sysUserGroupRoleAdd,user);

    }




}
