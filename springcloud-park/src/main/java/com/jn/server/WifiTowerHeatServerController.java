package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.api.CareClient;
import com.jn.park.api.WifiTowerHeatClient;
import com.jn.park.care.model.CareParam;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import com.jn.park.gamtopic.model.CareUserDetails;
import com.jn.park.gamtopic.service.CareService;
import com.jn.park.wifi.service.WifiTowerHeatService;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * WIFI热点
 *<pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：${DATE}
 *</pre>
 */
@RestController
public class WifiTowerHeatServerController extends BaseController implements WifiTowerHeatClient {
    private static Logger logger = LoggerFactory.getLogger(WifiTowerHeatServerController.class);

    @Autowired
    private WifiTowerHeatService wifiTowerHeatService;


    @ControllerLog(doAction = "采集wifi热力图信息")
    @Override
    public Result collectionHeatInfo() {
        return wifiTowerHeatService.collectionHeatInfo();
    }
}
