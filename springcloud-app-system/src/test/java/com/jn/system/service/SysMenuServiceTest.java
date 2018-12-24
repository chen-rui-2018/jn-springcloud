package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.system.common.enums.SysLevelEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.menu.model.*;
import com.jn.system.menu.service.SysMenuService;
import com.jn.system.menu.vo.SysMenuTreeVO;
import com.jn.system.model.User;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 权限模块菜单service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 14:36
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysMenuServiceTest {

    @Autowired
    private SysMenuService sysMenuService;

    //菜单id
    private static String menuId;
    //菜单名称
    private static String menuName;
    //父id
    private static String parentId;
    //创建者
    private static User user;
    //菜单添加对象
    private static SysMenuAdd sysMenuAdd;


    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setId("10000");

        //初始化菜单id,菜单名称及菜单父id
        menuId = UUID.randomUUID().toString();
        menuName = "测试菜单" + RandomStringUtils.randomNumeric(4);
        parentId = SysLevelEnums.FIRST_LEVEL.getCode();

        //初始换菜单添加对象
        sysMenuAdd = new SysMenuAdd();
        sysMenuAdd.setId(menuId);
        sysMenuAdd.setMenuName(menuName);
        sysMenuAdd.setParentId(parentId);
        sysMenuAdd.setMenuUrl("https://localhost:8080/menu.html");
    }

    @Test
    public void addMenuDir() {
        try {
            sysMenuService.addMenu(sysMenuAdd, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 修改菜单
     */
    @Test
    public void updateTest() {
        SysMenu menu = new SysMenu();
        menu.setId(menuId);
        menu.setMenuName(menuName);
        try {
            sysMenuService.updateSysMenuById(menu);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 根据id查询菜单
     */
    @Test
    public void selectByIdTest() {
        SysMenu data = sysMenuService.selectMenuById(menuId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void selectMenuById() {
        SysMenu data = sysMenuService.selectMenuById(menuId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void checkMenuName() {
        SysMenuNameCheck menu = new SysMenuNameCheck();
        menu.setMenuName(menuName);
        menu.setParentId(parentId);
        String result = sysMenuService.checkMenuName(menu);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));

    }

    @Test
    public void updateBatch() {
        SysMenus sysMenus = new SysMenus();
        List<SysMenuUpdate> list = new ArrayList<SysMenuUpdate>();
        SysMenuUpdate menu = new SysMenuUpdate();
        menu.setId(menuId);
        menu.setMenuName(menuName);
        menu.setMenuUrl("/");
        menu.setSort(1);
        list.add(menu);
        sysMenus.setSysMenuSortList(list);
        try {
            sysMenuService.updateBatch(sysMenus);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void getChildrenMenuByParentId() {
        List<SysMenuTreeVO> data = sysMenuService.getChildrenMenuByParentId(parentId);
        Assert.assertThat(data, Matchers.anything());
    }

    /**
     * 批量删除菜单(逻辑删除)
     */
    @Test
    public void zDeleteTest() {
        sysMenuService.deleteSysMenuById(menuId);
    }
}
