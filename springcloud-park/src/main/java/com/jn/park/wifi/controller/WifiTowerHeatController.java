package com.jn.park.wifi.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.wifi.service.WifiTowerHeatService;
import com.jn.server.WifiTowerHeatServerController;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/28 16:17
 * </pre>
 */
@Api(tags = "WIFI热力图")
@RestController
@RequestMapping("/wifi/")
public class WifiTowerHeatController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(WifiTowerHeatController.class);
    @Autowired
    private WifiTowerHeatService wifiTowerHeatService;

    /**
     * 采集wifi热力图信息
     * @return
     */
    @ControllerLog(doAction = "采集wifi热力图信息")
    @PostMapping(path = "/collectionHeatInfo")
    @ApiOperation(value = "采集wifi热力图信息",notes = "采集wifi热力图信息")
    @RequiresPermissions("/wifi/collectionHeatInfo")
    public Result collectionHeatInfo(){
        return wifiTowerHeatService.collectionHeatInfo();
    }

}
