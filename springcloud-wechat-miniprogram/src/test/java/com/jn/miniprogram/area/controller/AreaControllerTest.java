package com.jn.miniprogram.area.controller;

import com.jn.miniprogram.area.entity.TbMiniProgramArea;
import com.jn.miniprogram.area.service.AreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author： shenph
 * @date： Created on 2018/12/6 21:13
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AreaControllerTest {

    private Logger logger = LoggerFactory.getLogger(AreaControllerTest.class);

    @Autowired
    private AreaService areaService;

    @Test
    public void listArea() {
        List<TbMiniProgramArea> areas = areaService.queryArea();
        logger.info("info：{}", areas.size());
    }

    @Test
    public void getAreaById() {
        String areaId = "dd2f28bf-8846-415c-ba21-227ee88d577d";
        TbMiniProgramArea area = areaService.selectByPrimaryKey(areaId);
        logger.info("info：{}", area.getAreaId());
    }

    @Test
    public void addArea() {
        TbMiniProgramArea area = new TbMiniProgramArea();
        area.setAreaName("测试");
        area.setCreateTime(new Date());
        area.setUpdateTime(new Date());
        area.setAreaId(UUID.randomUUID().toString());
        boolean isSuccess = areaService.insert(area);
        logger.info("info：{}", isSuccess);
    }

    @Test
    public void modifyArea() {
        String areaId = "dd2f28bf-8846-415c-ba21-227ee88d577d";
        TbMiniProgramArea area = new TbMiniProgramArea();
        area.setAreaId(areaId);
        area.setAreaName("测试1");
        area.setUpdateTime(new Date());
        boolean isSuccess = areaService.updateByPrimaryKeySelective(area);
        logger.info("info：{}", isSuccess);
    }

    @Test
    public void removeArea() {
        String areaId = "12345";
        boolean isSuccess = areaService.deleteByPrimaryKey(areaId);
        logger.info("info：{}", isSuccess);
    }
}