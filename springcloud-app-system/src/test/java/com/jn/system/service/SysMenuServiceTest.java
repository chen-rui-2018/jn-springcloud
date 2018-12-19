package com.jn.system.service;

import com.jn.system.menu.model.SysMenu;
import com.jn.system.menu.model.SysMenuResourcesAdd;
import com.jn.system.menu.service.SysMenuService;
import com.jn.system.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class SysMenuServiceTest {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 修改菜单
     */
    @Test
    public void updateTest() {
        SysMenu menu = new SysMenu();
        menu.setId("35190724-485f-4f5d-bd79-652ce8909e9e");
        menu.setMenuName("页面菜单1");
        menu.setMenuUrl("xxx/xxx/b.html");
        sysMenuService.updateSysMenuById(menu);
    }

    /**
     * 批量删除菜单(逻辑删除)
     */
    @Test
    public void deleteTest() {
        String id = "87a240e8-d425-40d0-b09e-7204460b15c5";
        sysMenuService.deleteSysMenuById(id);
    }

    /**
     * 根据id查询菜单
     */
    @Test
    public void selectByIdTest() {
        String id = "87a240e8-d425-40d0-b09e-7204460b15c5";
        SysMenu menu = sysMenuService.selectMenuById(id);
        System.out.println(menu.toString());
    }

}
