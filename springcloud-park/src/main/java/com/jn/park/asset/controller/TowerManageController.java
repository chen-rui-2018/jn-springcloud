package com.jn.park.asset.controller;

import com.jn.common.model.Result;
import com.jn.park.asset.model.TowerInformationModel;
import com.jn.park.asset.service.TowerManageService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* 楼宇管理
* @author： zhuyz
* @date： Created on 2019/4/19 12:18
* @version： v1.0
* @modified By:
*/
@Api(tags = "楼宇管理")
@RestController
@RequestMapping("/guest/tower")
public class TowerManageController {

    @Autowired
    private TowerManageService towerManageService;

    @ControllerLog(doAction = "楼宇列表")
    @ApiOperation(value = "楼宇列表",notes = "返回楼宇列表")
    @GetMapping(value = "/towerList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parkId",value ="园区id",example = "568531381404041216")
    })
    public Result<List<TowerInformationModel>> towerList(String parkId){
        List<TowerInformationModel> towerInformationModelList = towerManageService.towerList(parkId);
        return new Result<>(towerInformationModelList);
    }




}
