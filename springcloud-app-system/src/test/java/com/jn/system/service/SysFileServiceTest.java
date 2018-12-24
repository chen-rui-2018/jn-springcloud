package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.model.SysFile;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.service.SysFileService;
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
 * 权限模块文件service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 14:36
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysFileServiceTest {

    @Autowired
    private SysFileService sysFileService;

    //文件id
    private static String fileId;
    //文件名称
    private static String fileName;
    //创建者
    private static User user;
    //文件对象
    private static SysFile sysFile;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setId("10000");

        //初始化文件id及文件对象
        fileId = UUID.randomUUID().toString();
        fileName = "测试文件" + RandomStringUtils.randomNumeric(4);

        //初始化文件对象
        sysFile = new SysFile();
        sysFile.setId(fileId);
        sysFile.setFileName(fileName);
        sysFile.setFileUrl("https://localhost:8080/picture.png");
        sysFile.setCreateTime(new Date());
        sysFile.setCreator(user.getId());
        sysFile.setStatus(SysStatusEnums.EFFECTIVE.getCode());
    }

    /**
     * 新增文件
     */
    @Test
    public void addTest() {
        try {
            sysFileService.insertSysFile(sysFile);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 搜索关键字分页查询文件列表
     */
    @Test
    public void selectListBySearchKeyTest() {
        SysFilePage page = new SysFilePage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysFileService.selectSysFileListBySearchKey(page);
        Assert.assertThat(data, Matchers.anything());
    }


    /**
     * 修改文件
     */
    @Test
    public void updateTest() {
        SysFile file = new SysFile();
        file.setId(fileId);
        file.setFileName(fileName);
        try {
            sysFileService.updateSysFileById(file);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 根据id查询文件
     */
    @Test
    public void selectByIdTest() {
        SysFile data = sysFileService.selectSysFileByIds(fileId);
        Assert.assertThat(data, Matchers.anything());
    }

    /**
     * 批量删除文件(逻辑删除)
     */
    @Test
    public void zDeleteTest() {
        String[] ids = {fileId};
        sysFileService.deleteSysFileByIds(ids);
    }

}
