package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.model.SysFileGroup;
import com.jn.system.file.model.SysFileGroupPage;
import com.jn.system.file.service.SysFileGroupService;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysFileGroupServiceTest {

    @Autowired
    private SysFileGroupService sysFileGroupService;

    //文件组id
    private static String fileGroupId;
    //文件组名称
    private static String fileGroupName;
    //创建者
    private static User user;
    //文件组对象
    private static TbSysFileGroup tbSysFileGroup;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setId("10000");

        //初始换文件组id及文件组名称
        fileGroupId = UUID.randomUUID().toString();
        fileGroupName = "测试文件组" + RandomStringUtils.randomNumeric(4);

        //初始化文件组对象
        tbSysFileGroup = new TbSysFileGroup();
        tbSysFileGroup.setId(fileGroupId);
        tbSysFileGroup.setFileGroupName(fileGroupName);
        tbSysFileGroup.setCreateTime(new Date());
        tbSysFileGroup.setCreator(user.getId());
        tbSysFileGroup.setFileGroupDescribe("这是junit文件组测试");
        tbSysFileGroup.setStatus(SysStatusEnums.EFFECTIVE.getCode());
    }

    /**
     * 新增文件组
     */
    @Test
    public void addTest() {
        try {
            sysFileGroupService.insertSysFileGroup(tbSysFileGroup);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 搜索关键字分页查询文件组列表
     */
    @Test
    public void selectListBySearchKeyTest() {
        SysFileGroupPage page = new SysFileGroupPage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysFileGroupService.selectSysFileGroupListBySearchKey(page);
        Assert.assertThat(data, Matchers.anything());
    }

    /**
     * 修改文件组
     */
    @Test
    public void updateTest() {
        SysFileGroup sysFileGroup = new SysFileGroup();
        sysFileGroup.setId(fileGroupId);
        sysFileGroup.setFileGroupName(fileGroupName);
        sysFileGroup.setStatus(SysStatusEnums.INVALID.getCode());
        try {
            sysFileGroupService.updateSysFileGroupById(sysFileGroup);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 根据id查询文件组
     */
    @Test
    public void selectByIdTest() {
        SysFileGroup data = sysFileGroupService.selectSysFileGroupByIds(fileGroupId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void checkFileGroupName() {
        String result = sysFileGroupService.checkFileGroupName(fileGroupName);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }

    /**
     * 批量删除文件组(逻辑删除)
     */
    @Test
    public void zDeleteTest() {
        String[] ids = {fileGroupId};
        sysFileGroupService.deleteSysFileGroupByIds(ids);
    }

}
