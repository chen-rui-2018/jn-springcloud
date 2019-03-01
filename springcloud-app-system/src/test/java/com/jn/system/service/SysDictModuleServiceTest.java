package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dict.entity.TbSysDictModule;
import com.jn.system.dict.model.SysDictModule;
import com.jn.system.dict.model.SysDictModulePage;
import com.jn.system.dict.service.SysDictModuleService;
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
import java.util.UUID;

/**
 * 模块管理单元测试
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 11:27
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysDictModuleServiceTest {

    @Autowired
    private SysDictModuleService sysDictModuleService;

    //模块id
    private static String moduleId;
    //模块编码
    private static String moduleCode;
    //模块名称
    private static String moduleValue;
    //创建者
    private static User user;
    //模块对象
    private static TbSysDictModule tbSysModule;

    @BeforeClass
    public static void init() {
        //初始化模块
        user = new User();
        user.setAccount("wangsong");

        //初始换模块id,编码,名称
        moduleId = UUID.randomUUID().toString();
        moduleCode = RandomStringUtils.randomNumeric(4);
        moduleValue = "测试模块";

        //初始化模块对象对象
        tbSysModule = new TbSysDictModule();
        tbSysModule.setId(moduleId);
        tbSysModule.setModuleCode(moduleCode);
        tbSysModule.setModuleValue(moduleValue);
    }

    @Test
    public void add() {
        try {
            //设置时间状态及添加账号
            tbSysModule.setCreatedTime(new Date());
            tbSysModule.setCreatorAccount(user.getAccount());
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            tbSysModule.setRecordStatus(recordStatus);
            sysDictModuleService.add(tbSysModule);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void update() {
        try {
            //设置最新更新人及更新时间
            tbSysModule.setModifiedTime(new Date());
            tbSysModule.setModifierAccount(user.getAccount());
            sysDictModuleService.update(tbSysModule);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void getModuleByPage() {
        SysDictModulePage page = new SysDictModulePage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysDictModuleService.getModuleByPage(page);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void getAll() {
        List<SysDictModule> data = sysDictModuleService.getAll();
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void zDelete() {
        try {
            sysDictModuleService.delete(moduleId, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }
}