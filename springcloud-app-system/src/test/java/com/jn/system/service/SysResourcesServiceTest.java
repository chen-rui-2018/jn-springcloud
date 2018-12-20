package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.menu.model.SysResources;
import com.jn.system.menu.model.SysResourcesPage;
import com.jn.system.menu.service.SysResourcesService;
import com.jn.system.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 权限模块功能service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 14:36
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysResourcesServiceTest {
    @Autowired
    private SysResourcesService sysResourcesService;

    /**
     * 搜索关键字分页查询功能列表
     */
    @Test
    public void selectListBySearchKeyTest() {
        SysResourcesPage page = new SysResourcesPage();
        page.setPage(1);
        page.setRows(10);
        page.setResourcesName("");
        PaginationData data = sysResourcesService.selectResourcesListBySearchKey(page);
    }

    /**
     * 新增功能
     */
    @Test
    public void addTest() {
        SysResources resources = new SysResources();
        resources.setResourcesName("功能测试"+ RandomStringUtils.randomNumeric(4));
        resources.setResourcesUrl("xxx/xxx/a.html");
        resources.setMenuId("1");
        resources.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysResourcesService.insertResources(resources, user);
    }

    /**
     * 修改功能
     */
    @Test
    public void updateTest() {
        SysResources resources = new SysResources();
        resources.setId("067f36d3-ee53-4d44-9d97-247ab5b6cb72");
        resources.setResourcesName("这是一个神奇的功能1");
        resources.setResourcesUrl("xxx/xxx/a.html");
        resources.setMenuId("1111");
        resources.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        sysResourcesService.updateResourcesById(resources);
    }

    /**
     * 批量删除功能(逻辑删除)
     */
    @Test
    public void deleteTest() {
        String[] ids = {"17ff9b4e-a920-4866-8cf8-35eab5c8ccde"};
        sysResourcesService.deleteResourcesById(ids);
    }

    /**
     * 根据id查询功能
     */
    @Test
    public void selectByIdTest() {
        String id = "17ff9b4e-a920-4866-8cf8-35eab5c8ccde";
        SysResources resources = sysResourcesService.selectSysResourcesById(id);
        System.out.println(resources.toString());
    }


}
