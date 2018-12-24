package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.menu.entity.TbSysResources;
import com.jn.system.menu.model.SysResourceCheckName;
import com.jn.system.menu.model.SysResources;
import com.jn.system.menu.service.SysResourcesService;
import com.jn.system.model.MenuResources;
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

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysResourcesServiceTest {

    @Autowired
    private SysResourcesService sysResourcesService;

    //功能id
    private static String resourcesId;
    //功能名称
    private static String resourcesName;
    //菜单id
    private static String menuId;
    //创建者
    private static User user;
    //功能对象
    private static TbSysResources tbSysResources;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setId("10000");

        //初始化功能id及功能名称
        resourcesId = UUID.randomUUID().toString();
        resourcesName = "测试功能" + RandomStringUtils.randomNumeric(4);
        menuId = "m001";

        //初始化功能对象
        tbSysResources = new TbSysResources();
        tbSysResources.setId(resourcesId);
        tbSysResources.setResourcesName(resourcesName);
        tbSysResources.setCreateTime(new Date());
        tbSysResources.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        tbSysResources.setCreator(user.getId());
        tbSysResources.setMenuId(menuId);
        tbSysResources.setResourcesUrl("/xxx/xxx");
    }

    /**
     * 新增功能
     */
    @Test
    public void addTest() {
        try {
            sysResourcesService.insertResources(tbSysResources);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 修改功能
     */
    @Test
    public void updateTest() {
        SysResources resources = new SysResources();
        resources.setId(resourcesId);
        resources.setResourcesName(resourcesName);
        resources.setMenuId(menuId);
        try {
            sysResourcesService.updateResourcesById(resources);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 根据id查询功能
     */
    @Test
    public void selectSysResourcesById() {
        SysResources data = sysResourcesService.selectSysResourcesById(resourcesId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void findPermissionsUrlById() {
        String permissionId = "P001";
        Set<String> data = sysResourcesService.findPermissionsUrlById(permissionId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void getMenuResourcesUrlById() {
        String userId = "10000";
        List<MenuResources> data = sysResourcesService.getMenuResourcesUrlById(userId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void checkResourceName() {
        SysResourceCheckName resource = new SysResourceCheckName();
        resource.setMenuId(menuId);
        resource.setResourceName(resourcesName);
        String result = sysResourcesService.checkResourceName(resource);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }

    @Test
    public void findResourcesByMenuId() {
        List<TbSysResources> data = sysResourcesService.findResourcesByMenuId(menuId);
        Assert.assertThat(data, Matchers.anything());
    }

    /**
     * 批量删除功能(逻辑删除)
     */
    @Test
    public void zdeleteTest() {
        String[] ids = {resourcesId};
        sysResourcesService.deleteResourcesById(ids);
    }

}
