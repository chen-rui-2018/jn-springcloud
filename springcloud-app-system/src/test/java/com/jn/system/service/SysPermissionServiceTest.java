package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.model.User;
import com.jn.system.permission.entity.TbSysPermission;
import com.jn.system.permission.model.*;
import com.jn.system.permission.service.SysPermissionService;
import com.jn.system.permission.vo.SysMenuResourcesVO;
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
 * 权限测试
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 9:40
 * @version： v1.0
 * @modified By:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysPermissionServiceTest {

    @Autowired
    private SysPermissionService sysPermissionService;

    //权限id
    private static String permissionId;
    //权限名称
    private static String permissionName;
    //创建者
    private static User user;
    //权限对象
    private static TbSysPermission tbSysPermission;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setId("10000");

        //初始化你权限id及名称
        permissionId = UUID.randomUUID().toString();
        permissionName = "测试权限" + RandomStringUtils.randomNumeric(4);

        //初始换权限对象
        tbSysPermission = new TbSysPermission();
        tbSysPermission.setId(permissionId);
        tbSysPermission.setPermissionName(permissionName);
        tbSysPermission.setCreateTime(new Date());
        tbSysPermission.setCreator(user.getId());
        tbSysPermission.setStatus(SysStatusEnums.EFFECTIVE.getCode());
    }

    @Test
    public void addPermissionTest() {
        try {
            sysPermissionService.addPermission(tbSysPermission);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void updatePermission() {
        SysPermission permission = new SysPermission();
        permission.setId(permissionId);
        permission.setPermissionName(permissionName);
        permission.setStatus(SysStatusEnums.INVALID.getCode());
        try {
            sysPermissionService.updatePermission(permission);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void selectByPrimaryKey() {
        SysPermission data = sysPermissionService.selectByPrimaryKey(permissionId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void findByPage() {
        SysPermissionPage page = new SysPermissionPage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysPermissionService.findByPage(page);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void permisssionAuthoredRole() {
        //为权限添加角色信息
        SysPermissionRolesAdd sysPermissionRolesAdd = new SysPermissionRolesAdd();
        sysPermissionRolesAdd.setPermissionId(permissionId);
        String[] roleIds = {"r001", "r002"};
        sysPermissionRolesAdd.setRoleIds(roleIds);
        sysPermissionService.addRoleToPermission(sysPermissionRolesAdd, user);

        //查询该权限具有的角色信息
        SysPermissionRolePage page = new SysPermissionRolePage();
        page.setPage(1);
        page.setRows(10);
        page.setPermissionId(permissionId);
        PaginationData data = sysPermissionService.findRoleOfPermission(page);
        Assert.assertThat(Long.valueOf(data.getTotal()).doubleValue(), Matchers.greaterThanOrEqualTo(1.0));
    }

    @Test
    public void permissionAuthoredFileGroup() {
        //为权限添加文件组信息
        SysPermissionFileGroupAdd sysPermissionFileGroupAdd = new SysPermissionFileGroupAdd();
        sysPermissionFileGroupAdd.setPermissionId(permissionId);
        String[] fileGroupIds = {"f001"};
        sysPermissionFileGroupAdd.setFileGroupIds(fileGroupIds);
        sysPermissionService.addFileGroupToPermission(sysPermissionFileGroupAdd, user);

        //查询该权限具有的文件组信息
        SysPermissionFileGroupPage page = new SysPermissionFileGroupPage();
        page.setPage(1);
        page.setRows(10);
        page.setPermissionId(permissionId);
        PaginationData data = sysPermissionService.findFileGroupOfPermission(page);
        Assert.assertThat(Long.valueOf(data.getTotal()).doubleValue(), Matchers.greaterThanOrEqualTo(1.0));
    }

    @Test
    public void checkPermissionName() {
        String result = sysPermissionService.checkPermissionName(permissionName);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }

    @Test
    public void permissionAuthoredMenu() {
        //为权限添加菜单及功能信息
        SysPermissionMenuResourcesAdd menuResourcesAdd = new SysPermissionMenuResourcesAdd();
        menuResourcesAdd.setPermissionId(permissionId);
        String[] menuResourcesIds = {"m001", "r001"};
        menuResourcesAdd.setMenuAndResourcesIds(menuResourcesIds);
        sysPermissionService.addMenuAndResourcesToPermission(menuResourcesAdd, user);

        //查询该菜单下面具有的菜单功能信息
        SysMenuResourcesVO data = sysPermissionService.getMenuAndResources(permissionId);
        Assert.assertThat(data, Matchers.notNullValue());
    }

    @Test
    public void zDeletePermissionBranch() {
        String[] permissionIds = {permissionId};
        sysPermissionService.deletePermissionBranch(permissionIds);
    }

}
