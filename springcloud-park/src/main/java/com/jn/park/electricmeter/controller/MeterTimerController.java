package com.jn.park.electricmeter.controller;

import com.jn.common.controller.BaseController;
import com.jn.park.api.ElectricMeterClient;
import com.jn.park.electricmeter.service.MeterRulesService;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.electricmeter.service.MeterCalcCostService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author： yangh
 * @date： Created on 2019/5/15 11:24
 * @version： v1.0
 * @modified By:
 */

@Api(tags = "物业管理-电表定时器相关接口")
@RestController
public class MeterTimerController extends BaseController implements ElectricMeterClient {
    @Autowired
    private MeterService meterService;
    @Autowired
    private MeterRulesService meterRulesService;
    private static Logger logger = LoggerFactory.getLogger(MeterTimerController.class);


    @Autowired
    private MeterCalcCostService meterTimerService;

    @ControllerLog(doAction = "电表数据定时采集接口")
    @Override
    public void getDataFromHardare(){
        meterService.getDataFromHardare();
    }

    @ControllerLog(doAction = "企业每日的计价规则维护接口")
    //@Override
    public void setRulesInDayForCompany(){
        meterRulesService.setRulesInDayForCompany();
    }

    @ControllerLog(doAction = "计算企业每日的电费")
    public void calcCostEverday(){
        meterTimerService.calcCostEverday();
    }

    @ControllerLog(doAction = "电表每日的业主")
    public void setHostForMeter(){
        meterService.setHostForMeter();
    }

}
