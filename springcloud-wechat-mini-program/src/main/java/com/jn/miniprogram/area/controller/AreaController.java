package com.jn.miniprogram.area.controller;


import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.miniprogram.area.entity.TbMiniProgramArea;
import com.jn.miniprogram.area.service.AreaService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 小程序 area demo
 *
 * @author： shenph
 * @date： Created on 2018/11/24 11:13
 * @version： v1.0
 * @modified By: shenph
 */
@Api(tags = "小程序area")
@RestController
@RequestMapping("/guest/miniprogram/area")
public class AreaController extends BaseController {

    @Autowired
    private AreaService areaService;

    @ControllerLog(doAction = "查询area")
    @ApiOperation(value = "查询area", httpMethod = "GET", response = Result.class)
    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    public Result listArea() {
        List<TbMiniProgramArea> areas = areaService.queryArea();
        return new Result(areas);
    }

    @ControllerLog(doAction = "areaid查询")
    @ApiOperation(value = "areaid查询", httpMethod = "GET", response = Result.class)
    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    public Result<TbMiniProgramArea> getAreaById(String areaId) {
        Assert.hasText(areaId, "区域ID不能为空");
        TbMiniProgramArea area = areaService.selectByPrimaryKey(areaId);
        return new Result(area);
    }

    @ControllerLog(doAction = "添加area")
    @ApiOperation(value = "添加area", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    public Result addArea(@RequestBody TbMiniProgramArea area) {
        Assert.hasText(area.getAreaName(), "区域信息不能为空");
        area.setCreateTime(new Date());
        area.setUpdateTime(new Date());
        area.setAreaId(UUID.randomUUID().toString());
        boolean isSuccess = areaService.insert(area);
        return new Result(isSuccess);
    }

    @ControllerLog(doAction = "修改area")
    @ApiOperation(value = "修改area", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    public Result modifyArea(@RequestBody TbMiniProgramArea area) {
        Assert.hasText(area.getAreaId(), "区域ID不能为空");
        Assert.hasText(area.getAreaName(), "区域信息不能为空");
        area.setUpdateTime(new Date());
        boolean isSuccess = areaService.updateByPrimaryKeySelective(area);
        return new Result(isSuccess);
    }

    @ControllerLog(doAction = "删除area")
    @ApiOperation(value = "删除area", httpMethod = "GET", response = Result.class)
    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    public Result removeArea(String areaId) {
        Assert.hasText(areaId, "区域ID不能为空");
        boolean isSuccess = areaService.deleteByPrimaryKey(areaId);
        return new Result(isSuccess);
    }
}
