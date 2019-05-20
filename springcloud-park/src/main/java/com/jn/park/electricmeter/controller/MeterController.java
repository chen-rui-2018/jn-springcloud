package com.jn.park.electricmeter.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.electricmeter.service.MeterRulesService;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.park.electricmeter.vo.PriceRuleVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/15 11:24
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "物业管理-电表相关接口")
@RestController
@RequestMapping("/meter")
public class MeterController extends BaseController {

    @Autowired
    private MeterService meterService;
    @Autowired
    private MeterRulesService meterRulesService;

    private static Logger logger = LoggerFactory.getLogger(MeterTimerController.class);

    @ControllerLog(doAction = "手动处理指定的电表读数定时入库失败的数据")
    @ApiOperation(value = "手动定时入库",notes = "手动定时入库", httpMethod = "GET")
    @GetMapping(value = "/dealSomeOneFailByHandle")
    @RequiresPermissions("/meter/dealSomeOneFailByHandle")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dealDate",value = "日期",type = "Date" ,example = "2019-12-12",required = true),
            @ApiImplicitParam(name = "dealHour",value = "小时",type = "Integer" ,example = "12",required = true)
    })
    public void dealSomeOneFailByHandle(Date dealDate,String dealHour){

        meterService.dealSomeOneFailByHandle(dealDate,dealHour);
    }

    @ControllerLog(doAction = "手动处理所有电表读数定时入库失败的数据")
    @ApiOperation(value = "批量定时入库",notes = "批量定时入库", httpMethod = "GET")
    @GetMapping(value = "/dealAllFailByHandle")
    @RequiresPermissions("/meter/dealAllFailByHandle")
    public void dealAllFailByHandle(){
        meterService.dealAllFailByHandle();
    }

    @ControllerLog(doAction = "更新计价规则")
    @ApiOperation(value = "更新计价规则",notes = "更新计价规则", httpMethod = "GET")
    @GetMapping(value = "/updatePriceRule")
    @RequiresPermissions("/meter/updatePriceRule")
    public Result updatePriceRule(@RequestBody  PriceRuleVO priceRuleVO){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data  = meterRulesService.updatePriceRule(user,priceRuleVO);
        result.setData(data);
        return result;
    }

    @ControllerLog(doAction = "作废计价规则")
    @ApiOperation(value = "更新计价规则",notes = "更新计价规则", httpMethod = "GET")
    @GetMapping(value = "/deletePriceRule")
    @RequiresPermissions("/meter/deletePriceRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "计价规则id",type = "String" ,example = "1",required = true)
    })
    public Result deletePriceRule(String id){
        Result result = new Result();
        Integer data = meterRulesService.deletePriceRule(id);
        result.setData(data);
        return result;
    }

    /*
    @ApiOperation(value = "手动定时入库",notes = "手动定时入库", httpMethod = "GET")
    @GetMapping(value = "/getDataFromHardare")
    @RequiresPermissions("/meter/getDataFromHardare")
    public void getDataFromHardare(){
        meterService.getDataFromHardare();
    }
     */

}
