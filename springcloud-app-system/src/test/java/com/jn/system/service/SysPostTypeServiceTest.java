package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.entity.TbSysPostType;
import com.jn.system.dept.model.SysPostType;
import com.jn.system.dept.model.SysPostTypePage;
import com.jn.system.dept.service.SysPostTypeService;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysPostTypeServiceTest {

    @Autowired
    private SysPostTypeService sysPostTypeService;

    //岗位类行id
    private static String postTypeId;
    //岗位类型名称
    private static String postTypeName;
    //创建者
    private static User user;
    //岗位类型对象
    private static TbSysPostType tbSysPostType;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setId("10000");

        //初始换岗位类型id及岗位类型名称
        postTypeId = UUID.randomUUID().toString();
        postTypeName = "岗位类型" + RandomStringUtils.randomNumeric(4);

        //初始化岗位类型对象
        tbSysPostType = new TbSysPostType();
        tbSysPostType.setId(postTypeId);
        tbSysPostType.setCreateTime(new Date());
        tbSysPostType.setCreator(user.getId());
        tbSysPostType.setPostTypeName(postTypeName);
        tbSysPostType.setStatus(SysStatusEnums.EFFECTIVE.getCode());
    }

    @Test
    public void add() {
        try {
            sysPostTypeService.add(tbSysPostType);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void getPostTypeByPage() {
        SysPostTypePage sysPostTypePage = new SysPostTypePage();
        sysPostTypePage.setPage(1);
        sysPostTypePage.setRows(10);
        PaginationData data = sysPostTypeService.getPostTypeByPage(sysPostTypePage);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void checkPostTypeName() {
        String result = sysPostTypeService.checkPostTypeName(postTypeName);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }

    @Test
    public void update() {
        SysPostType sysPostType = new SysPostType();
        sysPostType.setId(postTypeId);
        sysPostType.setPostTypeName(postTypeName);
        sysPostType.setStatus(SysStatusEnums.INVALID.getCode());
        try {
            sysPostTypeService.update(sysPostType);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void getPostTypeAll() {
        List<TbSysPostType> data = sysPostTypeService.getPostTypeAll();
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void zDelete() {
        sysPostTypeService.delete(postTypeId);
    }
}