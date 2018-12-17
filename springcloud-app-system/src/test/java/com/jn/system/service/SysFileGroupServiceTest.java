package com.jn.system.service;

import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.model.SysFileGroup;
import com.jn.system.file.model.SysFileGroupFileAdd;
import com.jn.system.file.model.SysFileGroupPage;
import com.jn.system.file.service.SysFileGroupService;
import com.jn.system.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

/**
 * 权限模块文件组service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 14:36
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysFileGroupServiceTest {
    @Autowired
    private SysFileGroupService sysFileGroupService;

    /**
     * 搜索关键字分页查询文件组列表
     */
    @Test
    public void selectListBySearchKeyTest() {
        SysFileGroupPage page = new SysFileGroupPage();
        page.setPage(1);
        page.setRows(10);
        sysFileGroupService.selectSysFileGroupListBySearchKey(page);
    }

    /**
     * 新增文件组
     */
    @Test
    public void addTest() {
        SysFileGroup sysFileGroup = new SysFileGroup();
        sysFileGroup.setFileGroupName("文件测试"+ RandomStringUtils.randomNumeric(4));
        sysFileGroup.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysFileGroupService.insertSysFileGroup(sysFileGroup, user);
    }

    /**
     * 修改文件组
     */
    @Test
    public void updateTest() {
        SysFileGroup sysFileGroup = new SysFileGroup();
        sysFileGroup.setId("17a66583-c67f-401e-bff0-ad7e042e62a2");
        sysFileGroup.setFileGroupName("文件96");
        sysFileGroup.setStatus(SysStatusEnums.INVALID.getCode());
        sysFileGroupService.updateSysFileGroupById(sysFileGroup);
    }

    /**
     * 批量删除文件组(逻辑删除)
     */
    @Test
    public void deleteTest() {
        String[] ids = {"b0e96afc-7d94-4a3e-b0a4-40774244bda0"};
        sysFileGroupService.deleteSysFileGroupByIds(ids);
    }

    /**
     * 根据id查询文件组
     */
    @Test
    public void selectByIdTest() {
        String id = "b0e96afc-7d94-4a3e-b0a4-40774244bda0";
        SysFileGroup fileGroup = sysFileGroupService.selectSysFileGroupByIds(id);
    }

    /**
     * 文件组添加文件
     */
    @Test
    public void sysFileGroupFileAdd() {
        SysFileGroupFileAdd sysFileGroupFileAdd = new SysFileGroupFileAdd();
        sysFileGroupFileAdd.setFileGroupId("b0e96afc-7d94-4a3e-b0a4-40774244bda0");
        String[] fileIds = {"1cc32378-3272-4ec6-901f-c91c28e74aef", "f0c9e7dc-a1fc-4172-a12c-a8511cfd1538"};
        sysFileGroupFileAdd.setFileId(fileIds);
        User user = new User();
        user.setId("123");
        user.setAccount("xxx");
        sysFileGroupService.sysFileGroupFileAdd(sysFileGroupFileAdd, user);
    }


}
