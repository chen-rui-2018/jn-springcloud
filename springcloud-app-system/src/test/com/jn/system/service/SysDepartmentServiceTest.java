package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.entity.TbSysDepartment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysDepartmentServiceTest {

    private Logger logger = LoggerFactory.getLogger(SysDepartmentServiceTest.class);

    @Autowired
    public SysDepartmentService sysDepartmentService;

    @Test
    public void findSysDepartmentAll() {
        Result result = sysDepartmentService.findSysDepartmentAll();
        logger.info("测试结果:" + result.getData().toString());
    }

    @Test
    public void selectByPrimaryKeyTest() {
        Result result = sysDepartmentService.selectByPrimaryKey("d001");
        logger.info("测试结果:" + result.getData().toString());
    }

    @Test
    public void deleteTest() {
        String[] ids = {"d001", "d002"};
        sysDepartmentService.delete(ids);
    }

    @Test
    public void updateTest() {
        TbSysDepartment tbSysDepartment = new TbSysDepartment();
        tbSysDepartment.setId("d002");
        tbSysDepartment.setStatus("-1");
        tbSysDepartment.setCreateTime(new Date());
        tbSysDepartment.setCreator("管理员");
        tbSysDepartment.setDepartmentName("工程部");
        tbSysDepartment.setParentId("2");
        sysDepartmentService.update(tbSysDepartment);
    }
}
