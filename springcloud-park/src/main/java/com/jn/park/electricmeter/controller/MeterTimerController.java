package com.jn.park.electricmeter.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.api.ElectricMeterClient;
import com.jn.park.electricmeter.model.CompanyModel;
import com.jn.park.electricmeter.model.CostBillModel;
import com.jn.park.electricmeter.service.ElectricRulesInfoService;
import com.jn.park.electricmeter.service.MeterRulesService;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.electricmeter.service.MeterCalcCostService;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private MeterCalcCostService meterCalcCostService;

    @Autowired
    private MeterCalcCostService meterTimerService;
    @Autowired
    private ElectricRulesInfoService electricRulesInfoService;

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

    @ControllerLog(doAction = "企业电费的回掉接口")
    @Override
    public Result updateBillInfo(@RequestBody  PayCallBackNotify payCallBackNotify) {
        return meterCalcCostService.updateBillInfo(payCallBackNotify);
    }

    @ControllerLog(doAction = "企业电费余额不足告警定时任务")
    public void setWarning(){
        meterRulesService.warningBalanceShortTimer();
    }

    @ControllerLog(doAction = "电表的启动和关闭定时器接口")
    public void setSwitchMeterTimer(){
        meterRulesService.setSwitchMeterTimer();
    }

    @ControllerLog(doAction = "能耗监控程序")
    @Override
    public void monitor() {
        electricRulesInfoService.monitor();
    }
    @ControllerLog(doAction = "通过企业id获取电表信息")
    @Override
    public Result getMeterInfosByCompanyId(@RequestBody CompanyModel companyModel){
        return meterService.getMeterInfosByCompanyId(companyModel.getCompanyId());
    }


    @ControllerLog(doAction = "更新企业余额")
    @Override
    public Result updateBillCost(@RequestBody CostBillModel companyModel){
        return meterService.updateBillCost(companyModel);
    }
}
