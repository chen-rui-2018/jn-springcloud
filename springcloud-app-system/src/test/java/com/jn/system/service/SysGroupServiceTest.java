package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.model.User;
import com.jn.system.permission.model.SysRoleGroupAdd;
import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysGroupService;
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
 * 用户dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 11:27
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysGroupServiceTest {

    @Autowired
    private SysGroupService sysGroupService;

    //用户组id
    private static String groupId;
    //用户组名称
    private static String groupName;
    //创建者对象
    private static User user;
    //用户组对象
    private static TbSysGroup tbSysGroup;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("10000");

        //初始化用户组id及名称
        groupId = UUID.randomUUID().toString();
        groupName = "测试用户组" + RandomStringUtils.randomNumeric(4);

        //封装用户组对象
        tbSysGroup = new TbSysGroup();
        tbSysGroup.setId(groupId);
        tbSysGroup.setCreatedTime(new Date());
        tbSysGroup.setCreatorAccount(user.getAccount());
        tbSysGroup.setGroupName(groupName);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysGroup.setRecordStatus(recordStatus);
    }

    @Test
    public void addSysGroupTest() {
        try {
            sysGroupService.addSysGroup(tbSysGroup);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void findSysGroupAllTest() {
        SysGroupPage page = new SysGroupPage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysGroupService.findSysGroupAll(page);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void updateSysGroupTest() {
        SysGroupUpdate sysGroup = new SysGroupUpdate();
        sysGroup.setId(groupId);
        sysGroup.setGroupName(groupName);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.INVALID.getCode());
        sysGroup.setRecordStatus(recordStatus);
        try {
            sysGroupService.updateSysGroup(sysGroup,user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void groupAuthoredRole() {
        //为用户组添加角色信息
        SysRoleGroupAdd sysRoleGroupAdd = new SysRoleGroupAdd();
        sysRoleGroupAdd.setGroupId(groupId);
        String[] roleIds = {"r001", "r002"};
        sysRoleGroupAdd.setRoleIds(roleIds);
        sysGroupService.roleGroupAuthorization(sysRoleGroupAdd, user);

        //查询该用户组具有的角色信息
        SysGroupRolePage page = new SysGroupRolePage();
        page.setPage(1);
        page.setRows(10);
        page.setGroupId(groupId);
        PaginationData data = sysGroupService.selectGroupRoleAndOtherRole(page);
        int total = Long.valueOf(data.getTotal()).intValue();
        Assert.assertThat(total, Matchers.greaterThanOrEqualTo(0));
    }

    @Test
    public void groupAuthoredUser() {
        //为用户组添加用户信息
        SysGroupUserAdd sysGroupUserAdd = new SysGroupUserAdd();
        sysGroupUserAdd.setGroupId(groupId);
        String[] userIds = {"u003", "u004"};
        sysGroupUserAdd.setUserIds(userIds);
        sysGroupService.userGroupAuthorization(sysGroupUserAdd, user);

        //查询用户组具有的用户组信息
        SysGroupUserPage page = new SysGroupUserPage();
        page.setGroupId(groupId);
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysGroupService.findOtherUserByPage(page);
        int total = Long.valueOf(data.getTotal()).intValue();
        Assert.assertThat(total, Matchers.greaterThanOrEqualTo(0));

        //清除用户组添加的用户
        sysGroupUserAdd.setUserIds(null);
        sysGroupService.userGroupAuthorization(sysGroupUserAdd, user);
    }

    @Test
    public void checkGroupNameTest() {
        String result = sysGroupService.checkGroupName(groupName);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }

    @Test
    public void zDeleSysGroupTest() {
        String[] groupIdS = {groupId};
        sysGroupService.deleSysGroup(groupIdS,user);
    }
}
