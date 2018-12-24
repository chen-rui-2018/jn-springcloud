package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.model.User;
import com.jn.system.permission.entity.TbSysRole;
import com.jn.system.permission.model.*;
import com.jn.system.permission.service.SysRoleService;
import com.jn.system.user.model.SysUserGroupRoleAdd;
import com.jn.system.user.model.SysUserRoleAdd;
import org.apache.commons.lang.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;


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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysRoleServiceTest {

    @Autowired
    private SysRoleService sysRoleService;

    //角色id
    private static String roleId;
    //角色名称
    private static String roleName;
    //创建者
    private static User user;
    //角色对象
    private static TbSysRole tbSysRole;


    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setId("10000");

        //初始化角色id及名称
        roleId = UUID.randomUUID().toString();
        roleName = "测试角色" + RandomStringUtils.randomNumeric(4);

        //初始化角色对象
        tbSysRole = new TbSysRole();
        tbSysRole.setId(roleId);
        tbSysRole.setCreator(user.getId());
        tbSysRole.setCreateTime(new Date());
        tbSysRole.setRoleName(roleName);
        tbSysRole.setStatus(SysStatusEnums.EFFECTIVE.getCode());
    }


    /**
     * 新增角色
     */
    @Test
    public void addTbSystemRole() {
        try {
            sysRoleService.insertTbRole(tbSysRole);
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), Matchers.startsWith("添加失败"));
        }
    }

    @Test
    public void selectRoleListBySearchKey() {
        SysRolePage page = new SysRolePage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysRoleService.selectRoleListBySearchKey(page);
        Assert.assertThat(data, Matchers.anything());
    }


    /**
     * 更新角色信息
     */
    @Test
    public void updateTbRole() {
        SysRoleUpdate role = new SysRoleUpdate();
        role.setId(roleId);
        role.setRoleName(roleName);
        role.setStatus(SysStatusEnums.INVALID.getCode());
        try {
            sysRoleService.updateTbRole(role);
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), Matchers.containsString("修改失败"));
        }
    }

    @Test
    public void roleAuthoredUser() {
        //为角色添加用户
        SysUserRoleAdd sysUserRoleAdd = new SysUserRoleAdd();
        sysUserRoleAdd.setRoleId(roleId);
        String[] userIds = {"u001", "u002"};
        sysUserRoleAdd.setUserId(userIds);
        sysRoleService.userRoleAuthorization(sysUserRoleAdd, user);

        //查询该角色具有的用户
        SysRoleUserPage page = new SysRoleUserPage();
        page.setPage(1);
        page.setRows(10);
        page.setRoleId(roleId);
        PaginationData data = sysRoleService.findUserOfRoleAndOtherUser(page);
        Assert.assertThat(Long.valueOf(data.getTotal()).doubleValue(), Matchers.greaterThanOrEqualTo(1.0));
    }

    @Test
    public void roleAuthoredGroup() {
        //为角色添加用户组信息
        SysUserGroupRoleAdd sysUserGroupRoleAdd = new SysUserGroupRoleAdd();
        sysUserGroupRoleAdd.setRoleId(roleId);
        String[] userGroupRole = {"ug001", "ug002"};
        sysUserGroupRoleAdd.setUserGroupId(userGroupRole);
        sysRoleService.userGroupRoleAuthorization(sysUserGroupRoleAdd, user);

        //查询该角色具有的用户组信息
        SysRoleUserGroupPage page = new SysRoleUserGroupPage();
        page.setPage(1);
        page.setRows(10);
        page.setRoleId(roleId);
        PaginationData data = sysRoleService.findUserGroupOfRoleAndOtherGroup(page);
        Assert.assertThat(Long.valueOf(data.getTotal()).doubleValue(), Matchers.greaterThanOrEqualTo(1.0));
    }

    @Test
    public void roleAuthoredPermission() {
        //为角色添加权限信息
        SysRolePermissionAdd sysRolePermissionAdd = new SysRolePermissionAdd();
        sysRolePermissionAdd.setRoleId(roleId);
        String[] permissionIds = {"p001", "p002"};
        sysRolePermissionAdd.setPermissionId(permissionIds);
        sysRoleService.rolePermissionAuthorization(sysRolePermissionAdd, user);

        //查询该角色具有的权限信息
        SysRolePermissionPage page = new SysRolePermissionPage();
        page.setPage(1);
        page.setRows(10);
        page.setRoleId(roleId);
        PaginationData data = sysRoleService.findPermissionOrRoleAndOtherPermission(page);
        Assert.assertThat(Long.valueOf(data.getTotal()).doubleValue(), Matchers.greaterThanOrEqualTo(1.0));
    }


    @Test
    public void checkRoleNameTest() {
        String result = sysRoleService.checkRoleName(roleName);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }

    /**
     * 批量删除角色（逻辑删除）
     */
    @Test
    public void zDeleteTbRoleById() {
        String[] roleIds = {roleId};
        sysRoleService.deleteTbRoleById(roleIds);
    }

}
