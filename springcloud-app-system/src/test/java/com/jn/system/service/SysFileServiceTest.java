package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.service.SysFileService;
import com.jn.system.model.SysFile;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


    private static SysFile sysFile;

    @BeforeClass
    public static void init() {
        //初始数据
        sysFile=new SysFile();
        sysFile.setId(UUID.randomUUID().toString());
        sysFile.setFileName("测试文件");
        sysFile.setFileGroupId("b21ff0d6-7971-44b3-9409-d7478e5a404c");
        sysFile.setFileUrl("https://xxx.xxxx.png");
        sysFile.setUserId("10000");

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
     * 搜索关键字分页查询文件列表
     */
    @Test
    @Ignore
    public void insertSysFile() {
        sysFileService.insertSysFile(sysFile);
    }


}
