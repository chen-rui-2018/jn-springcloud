package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dict.entity.TbSysDict;
import com.jn.system.dict.model.SysDictEdit;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.dict.model.SysDictKeyValue;
import com.jn.system.dict.model.SysDictPage;
import com.jn.system.dict.service.SysDictService;
import com.jn.system.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 数据字典单元测试
 *
 * @author： shaobao
 * @date： Created on 2018/11/6 14:36
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysDictServiceTest {

    @Autowired
    private SysDictService sysDictService;

    //数据字典id
    private static String dictId;
    //数据字典键
    private static String dictKey;
    //数据字典值
    private static String dictValue;
    //归属模块
    private static String moduleCode;
    //父分组编码
    private static String parentGroupCode;
    //分组编码
    private static String groupCode;
    //创建者
    private static User user;
    //数据字典对象
    private static TbSysDict tbSysDict;

    @BeforeClass
    public static void init() {
        //初始化用户
        user = new User();
        user.setAccount("wangsong");

        //初始化数据字典属性
        dictId = UUID.randomUUID().toString();
        dictKey = RandomStringUtils.randomNumeric(4);
        dictValue = "测试数据字典";
        moduleCode = "test_module_code";
        parentGroupCode = "test_parent_group_code";
        groupCode = "test_group_code";

        //初始化数据中字典对象
        tbSysDict = new TbSysDict();
        tbSysDict.setId(dictId);
        tbSysDict.setDictKey(dictKey);
        tbSysDict.setDictValue(dictValue);
        tbSysDict.setModuleCode(moduleCode);
        tbSysDict.setParentGroupCode(parentGroupCode);
        tbSysDict.setGroupCode(groupCode);
    }

    @Test
    public void add() {
        try {
            tbSysDict.setCreatorAccount(user.getAccount());
            tbSysDict.setCreatedTime(new Date());
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            tbSysDict.setRecordStatus(recordStatus);
            sysDictService.add(tbSysDict);
        } catch (Exception e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void update() {
        try {
            tbSysDict.setModifiedTime(new Date());
            tbSysDict.setModifierAccount(user.getAccount());
            sysDictService.update(tbSysDict);
        } catch (Exception e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void sortByGroup() {
        SysDictEdit dictEdit = new SysDictEdit();
        BeanUtils.copyProperties(tbSysDict, dictEdit);
        List<SysDictEdit> list = new ArrayList<SysDictEdit>();
        list.add(dictEdit);
        sysDictService.sortByGroup(list, user);
    }

    @Test
    public void getDictByPage() {
        SysDictPage page = new SysDictPage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysDictService.getDictByPage(page);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void getDict() {
        SysDictInvoke dictInvoke = new SysDictInvoke();
        BeanUtils.copyProperties(tbSysDict, dictInvoke);
        List<SysDictKeyValue> data = sysDictService.getDict(dictInvoke);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void zDelete() {
        sysDictService.delete(dictId, user);
    }
}