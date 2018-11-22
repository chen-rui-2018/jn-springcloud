package com.jn.system.service;

import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.SysFile;
import com.jn.system.model.SysFileAddFileGroup;
import com.jn.system.model.SysFilePage;
import com.jn.system.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        sysFileService.selectSysFileListBySearchKey(page);
    }

    /**
     * 新增文件
     */
    @Test
    public void addTest() {
        SysFile file = new SysFile();
        file.setFileName("文件测试2");
        file.setFileUrl("xxx/xxx/a.html");
        file.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        User user=new User();
        user.setId("123");
        user.setAccount("xxx");
        sysFileService.insertSysFile(file,user);
    }

    /**
     * 修改文件
     */
    @Test
    public void updateTest() {
        SysFile file = new SysFile();
        file.setId("1cc32378-3272-4ec6-901f-c91c28e74aef");
        file.setFileName("文件测试2");
        file.setFileUrl("xxx/xxx/a.html");
        sysFileService.updateSysFileById(file);
    }

    /**
     * 批量删除文件(逻辑删除)
     */
    @Test
    public void deleteTest() {
        String[] ids = {"1cc32378-3272-4ec6-901f-c91c28e74aef"};
        sysFileService.deleteSysFileByIds(ids);
    }

    /**
     * 根据id查询文件
     */
    @Test
    public void selectByIdTest() {
        String id = "1cc32378-3272-4ec6-901f-c91c28e74aef";
        SysFile file = sysFileService.selectSysFileByIds(id);

    }

    @Test
    public void sysFileAddFileGroupTest() {

        SysFileAddFileGroup sysFileAddFileGroup = new SysFileAddFileGroup();
        sysFileAddFileGroup.setFileId("f0c9e7dc-a1fc-4172-a12c-a8511cfd1538");
        String[] fileGroupId = {"b0e96afc-7d94-4a3e-b0a4-40774244bda0"};
        sysFileAddFileGroup.setFileGroupId(fileGroupId);
        User user=new User();
        user.setId("123");
        user.setAccount("xxx");
        sysFileService.sysFileAddFileGroup(sysFileAddFileGroup,user);

    }


}
