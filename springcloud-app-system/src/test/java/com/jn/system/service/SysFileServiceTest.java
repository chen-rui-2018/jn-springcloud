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
}
