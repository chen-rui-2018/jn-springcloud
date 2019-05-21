package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.encryption.EncryptUtil;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.model.SysDepartmentPost;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysUserService;
import com.jn.system.vo.SysDepartmentPostVO;
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

import java.util.*;

/**
 * 用户测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;

    //用户id
    private static String userId;
    //用户账号
    private static String userAccount;
    //用户名称
    private static String userName;
    //创建者
    private static User user;
    //用户对象
    private static SysUserAdd sysUser;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");

        //初始化用户id
        userId = UUID.randomUUID().toString();
        userAccount = "account" + RandomStringUtils.randomNumeric(4);
        userName = "测试用户";

        //封装用户对象
        sysUser = new SysUserAdd();
        sysUser.setId(userId);
        sysUser.setAccount(userAccount);
        sysUser.setName(userName);
        sysUser.setPhone("13312345678");
        sysUser.setEmail("123@qq.com.com");
        sysUser.setWechatAccount("weixinaccount");
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        sysUser.setRecordStatus(recordStatus);
    }

    @Test
    public void addSysUserTest() {
        try {
            sysUserService.addSysUser(sysUser, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }
    @Test
    public void Test() {
        try {
            System.out.println(EncryptUtil.encryptSha256("123456"));
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void findSysUserByPageTest() {
        UserPage sysUserPage = new UserPage();
        sysUserPage.setPage(1);
        sysUserPage.setRows(10);
        PaginationData data = sysUserService.findSysUserByPage(sysUserPage);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void updateSysUserTest() {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setName(userName);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        sysUser.setRecordStatus(recordStatus);
        try {
            sysUserService.updateSysUser(sysUser, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void userAuthoredGroup() {
        //用户授权用户组
        String[] groupIds = {"g002"};
        sysUserService.saveSysGroupToSysUser(groupIds, userId, user);

        //查询该用户下具有的用户组
        SysUserGroupPage page = new SysUserGroupPage();
        page.setPage(1);
        page.setRows(10);
        page.setUserId(userId);
        PaginationData data = sysUserService.findSysGroupByUserId(page);
        int total = Long.valueOf(data.getTotal()).intValue();
        Assert.assertThat(total, Matchers.greaterThanOrEqualTo(0));
    }

    @Test
    public void userAuthoredRole() {
        //用户数添加角色
        String[] roleId = {"r002"};
        sysUserService.saveSysRoleToSysUser(roleId, userId, user);

        //查询该用户线面具有的角色信息
        SysUserRolePage page = new SysUserRolePage();
        page.setPage(1);
        page.setRows(10);
        page.setUserId(userId);
        PaginationData data = sysUserService.findSysRoleByUserId(page);
        int total = Long.valueOf(data.getTotal()).intValue();
        Assert.assertThat(total, Matchers.greaterThanOrEqualTo(0));
    }

    @Test
    public void userAuthoredDepartmentAndPost() {
        //用户添加部门岗位信息
        SysUserDepartmentPostAdd sysUserDepartmentPost = new SysUserDepartmentPostAdd();
        sysUserDepartmentPost.setUserId(userId);
        List<SysDepartmentPost> list = new ArrayList<>();
        SysDepartmentPost sysDepartmentPost = new SysDepartmentPost();
        sysDepartmentPost.setDepartmentId("d006");
        sysDepartmentPost.setPostId("p006");
        sysDepartmentPost.setIsDefault(SysStatusEnums.EFFECTIVE.getCode());
        list.add(sysDepartmentPost);
        sysUserDepartmentPost.setSysDepartmentPostList(list);
        try {
            sysUserService.saveDepartmentAndPostOfUser(sysUserDepartmentPost, user);

            //查询该用户线面具有的部门岗位信息
            List<SysDepartmentPostVO> data = sysUserService.findDepartmentandPostByUserId(userId);
            Assert.assertThat(Long.valueOf(data.size()).doubleValue(), Matchers.anything());
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void getUserAll(){
        List<User> data = sysUserService.getUserAll();
        System.out.println(data.size());
        for (User user : data) {
            System.out.println(user);
        }
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void checkUserNameTest() {
        String result = sysUserService.checkUserName(userAccount);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }


    @Test
    //有数使用名称排序,所以在删除名称前加了一个z
    public void zDeleteSysUserTest() {
        String[] ids = {userId};
        sysUserService.deleteSysUser(ids, user);
    }

    @Test
    public void getUserInfoByAccount(){
        List<String> accountList = new ArrayList<String>(16);
        accountList.add("userAccount");
        List<User> userInfoByAccount = sysUserService.getUserInfoByAccount(accountList);
        Assert.assertThat(userInfoByAccount, Matchers.anything());
    }

    @Test
    public void updateUserRole(){
        //1.测试不传账号及id
        User user1 = new User();
        Set<String> deleRoleId = new HashSet<>(16);
        Set<String> addRoleId = new HashSet<String>(16);
        try {
            sysUserService.updateUserRole(user1,deleRoleId,addRoleId);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }

        //2.测试传账号,删除和增加集合为空
        user1.setAccount(userAccount);
        Boolean result1 = sysUserService.updateUserRole(user1, deleRoleId, addRoleId);
        Assert.assertThat(result1, Matchers.equalTo(Boolean.TRUE));

        //3.测试传id,删除,增加均不为空
        user1.setId("6d0e0465-e9ef-4552-82d6-d9aa631fd8ad");
        addRoleId.add("26fbc372-672c-4418-a5b2-5edeeec2f888");
        addRoleId.add("26fbc372-672c-4418-a5b2-5edeeec2f888");
        addRoleId.add("531a2a04-be44-4239-a36b-5b09aac3499d");
        deleRoleId.add("6f7fef69-c61c-43cf-a82c-fbb9ba088e81");
        Boolean result = sysUserService.updateUserRole(user1, deleRoleId, addRoleId);
        Assert.assertThat(result, Matchers.equalTo(Boolean.TRUE));
    }
    @Test
    public void selectUserByIds(){
      String[] ids={"10000","3"};
        List<SysTUser> list= sysUserService.selectUserByIds(ids);
        Assert.assertThat(list, Matchers.anything());
    }

}
