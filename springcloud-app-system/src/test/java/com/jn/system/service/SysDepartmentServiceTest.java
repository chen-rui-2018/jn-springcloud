package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.entity.TbSysDepartment;
import com.jn.system.model.SysDepartment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysDepartmentServiceTest {

    private Logger logger = LoggerFactory.getLogger(SysDepartmentServiceTest.class);

    @Autowired
    public SysDepartmentService sysDepartmentService;

    @Test
    public void findSysDepartmentAll() {
        List<SysDepartment> data = sysDepartmentService.findSysDepartmentAll();
        logger.info("测试结果:{}",data.toString());
    }

    @Test
    public void selectByPrimaryKeyTest() {
        SysDepartment data = sysDepartmentService.selectByPrimaryKey("d001");
        logger.info("测试结果:{}",data.toString());
    }

    @Test
    public void deleteTest() {
        String[] ids = {"d001", "d002"};
        sysDepartmentService.delete(ids);
    }

    @Test
    public void updateTest() {
        SysDepartment SysDepartment = new SysDepartment();
        SysDepartment.setId("d002");
        SysDepartment.setStatus("-1");
        SysDepartment.setCreateTime(new Date());
        SysDepartment.setDepartmentName("工程部");
        SysDepartment.setParentId("2");
        sysDepartmentService.update(SysDepartment);
    }
}
