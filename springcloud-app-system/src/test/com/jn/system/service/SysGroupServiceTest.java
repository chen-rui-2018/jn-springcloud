package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.vo.SysGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 11:27
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysGroupServiceTest {

    @Autowired
    private SysGroupService sysGroupService;

    @Test
    public void findSysGroupAllTest() {
        Result result = sysGroupService.findSysGroupAll();
        System.out.println(result);
    }

    @Test
    public void addSysGroupTest() {
        SysGroup sysGroup = new SysGroup();
        sysGroup.setGroupName("财务组");
        sysGroup.setStatus("1");
        sysGroupService.addSysGroup(sysGroup);
    }

    @Test
    public void deleSysGroupTest() {
        String[] groupIdS = {"g003", "g002"};
        sysGroupService.deleSysGroup(groupIdS);
    }

    @Test
    public void updateSysGroupTest() {
        SysGroup sysGroup = new SysGroup();
        sysGroup.setId("g001");
        sysGroup.setGroupName("");
        sysGroup.setCreator("系统管理员");
        sysGroupService.updateSysGroup(sysGroup);
    }


}
