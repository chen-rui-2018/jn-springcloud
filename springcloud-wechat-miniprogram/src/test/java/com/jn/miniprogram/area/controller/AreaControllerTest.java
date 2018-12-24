package com.jn.miniprogram.area.controller;

import com.jn.miniprogram.area.entity.TbMiniProgramArea;
import com.jn.miniprogram.area.service.AreaService;
import org.hamcrest.CoreMatchers;
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

/**
 * @author： shenph
 * @date： Created on 2018/12/6 21:13
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AreaControllerTest {

    @Autowired
    private AreaService areaService;

    private static String areaId;

    @BeforeClass
    public static void setUp() {
        areaId = UUID.randomUUID().toString();
    }

    @Test
    public void AlistArea() {
        List<TbMiniProgramArea> areas = areaService.queryArea();
        Assert.assertThat(areas, CoreMatchers.anything());
    }

    @Test
    public void BaddArea() {
        TbMiniProgramArea area = new TbMiniProgramArea();
        area.setAreaName("测试");
        area.setCreateTime(new Date());
        area.setUpdateTime(new Date());
        area.setAreaId(areaId);
        boolean isSuccess = areaService.insert(area);
        Assert.assertTrue(isSuccess);
    }

    @Test(timeout = 3000)
    public void CgetAreaById() {
        TbMiniProgramArea area = areaService.selectByPrimaryKey(areaId);
        Assert.assertThat(area, CoreMatchers.anything());
    }

    @Test
    public void DmodifyArea() {
        TbMiniProgramArea area = new TbMiniProgramArea();
        area.setAreaId(areaId);
        area.setAreaName("测试1");
        area.setUpdateTime(new Date());
        boolean isSuccess = areaService.updateByPrimaryKeySelective(area);
        Assert.assertTrue(isSuccess);
    }

    @Test(timeout = 2000)
    public void EremoveArea() {
        boolean isSuccess = areaService.deleteByPrimaryKey(areaId);
        Assert.assertTrue(isSuccess);
    }
}