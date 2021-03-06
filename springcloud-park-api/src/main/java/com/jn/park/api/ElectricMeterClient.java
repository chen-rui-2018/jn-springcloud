package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.park.electricmeter.model.CompanyModel;
import com.jn.park.electricmeter.model.CostBillModel;
import com.jn.park.message.model.AddMessageModel;
import com.jn.park.property.model.PayCallBackNotify;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author： yangh
 * @date： Created on 2019/5/18 13:00
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface ElectricMeterClient {
    @RequestMapping(value = "/api/meter/getDataFromHardare", method = RequestMethod.GET)
    void getDataFromHardare();


    @RequestMapping(value = "/api/meter/setRulesInDayForCompany", method = RequestMethod.GET)
    void setRulesInDayForCompany();

    @RequestMapping(value = "/api/meter/calcCostEverday", method = RequestMethod.GET)
    void calcCostEverday();

    @RequestMapping(value = "/api/meter/setHostForMeter", method = RequestMethod.GET)
    void setHostForMeter();

    @RequestMapping(value = "/api/meter/updateBillInfo", method = RequestMethod.POST)
    Result updateBillInfo(PayCallBackNotify payCallBackNotify);

    @RequestMapping(value = "/api/meter/setWarning", method = RequestMethod.GET)
    void setWarning();

    @RequestMapping(value = "/api/meter/switchMeterTimer", method = RequestMethod.GET)
    void setSwitchMeterTimer();

    /**
     * 能耗监控程序
     */
    @RequestMapping(value = "/api/meter/monitor", method = RequestMethod.GET)
    void monitor();

    /**
     * 能耗监控程序
     */
    @RequestMapping(value = "/api/meter/getMeterInfosByCompanyId", method = RequestMethod.POST)
    Result getMeterInfosByCompanyId(CompanyModel companyModel);

    /**
     * 能耗监控程序
     */
    @RequestMapping(value = "/api/meter/updateBillCost", method = RequestMethod.POST)
    Result updateBillCost(CostBillModel companyModel);
}
