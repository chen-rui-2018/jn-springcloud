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
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    @ApiOperation(value = "更新计价规则",notes = "更新计价规则", httpMethod = "POST")
    @PostMapping(value = "/updatePriceRule")
    @RequiresPermissions("/meter/updatePriceRule")
    public Result updatePriceRule(@RequestBody  PriceRuleVO priceRuleVO){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data  = meterRulesService.updatePriceRule(user,priceRuleVO);
        result.setData(data);
        return result;
    }

    @ControllerLog(doAction = "作废计价规则")
    @ApiOperation(value = "作废计价规则",notes = "作废计价规则", httpMethod = "GET")
    @GetMapping(value = "/deletePriceRule")
    @RequiresPermissions("/meter/deletePriceRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "计价规则id",type = "String" ,example = "1",required = true)
    })
    public Result deletePriceRule(String id){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data = meterRulesService.deletePriceRule(user,id);
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

    @ControllerLog(doAction = "企业计价规则维护-企业设置计价规则")
    @ApiOperation(value = "企业设置计价规则",notes = "企业设置计价规则", httpMethod = "POST")
    @PostMapping(value = "/setRule")
    @RequiresPermissions("/meter/setRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleId",value = "计价规则id",type = "String" ,example = "1",required = true),
            @ApiImplicitParam(name = "companyId",value = "企业id",type = "String" ,example = "1",required = true)
    })
    public Result setRule(String ruleId,String companyId){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data = meterRulesService.setRule(user,ruleId, companyId);
        result.setData(data);
        return result;
    }

    @ControllerLog(doAction = "企业计价规则维护-企业更新计价规则")
    @ApiOperation(value = "企业更新计价规则",notes = "企业更新计价规则", httpMethod = "POST")
    @PostMapping(value = "/updateCompanysRule")
    @RequiresPermissions("/meter/updateCompanysRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "记录id",type = "String" ,example = "1",required = true),
            @ApiImplicitParam(name = "ruleId",value = "计价规则id",type = "String" ,example = "1",required = true),
            @ApiImplicitParam(name = "companyId",value = "企业id",type = "String" ,example = "1",required = true)
    })
    public Result updateCompanysRule(String id,String ruleId,String companyId){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data = meterRulesService.updateCompanysRule(user,id,ruleId,companyId);
        result.setData(data);
        return result;
    }

    /*
    @ControllerLog(doAction = "企业计价规则维护-批量企业设置计价规则")
    @ApiOperation(value = "批量企业设置计价规则",notes = "批量企业设置计价规则", httpMethod = "POST")
    @PostMapping(value = "/setBatchRule")
    @RequiresPermissions("/meter/setBatchRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyIds",allowMultiple=true ,value = "企业id集合",type = "String" ,example = "1",required = true),
            @ApiImplicitParam(name = "ruleId",value = "计价规则id",type = "String" ,example = "1",required = true)
    })
    public Result setBatchRule(List<String> companyIds , String ruleId){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<String> errorCompany = meterRulesService.setBatchRule(user,companyIds,ruleId);
        result.setData(errorCompany);
        return result;
    }
    */

    @ControllerLog(doAction = "电表拉闸与恢复")
    @ApiOperation(value = "电表拉闸与恢复",notes = "电表拉闸与恢复", httpMethod = "GET")
    @GetMapping(value = "/setSwitchMeter")
    @RequiresPermissions("/meter/setSwitchMeter")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meterCode" ,value = "设备编码",type = "String" ,example = "1",required = true),
            @ApiImplicitParam(name = "status",value = "开关状态（4，5）",type = "String" ,example = "4",required = true)
    })
    public Result setSwitchMeter(String meterCode, String status) {
        return meterRulesService.SwitchMeter(meterCode,status);
    }

    @ControllerLog(doAction = "余额不足告警")
    @ApiOperation(value = "余额不足告警",notes = "余额不足告警", httpMethod = "GET")
    @GetMapping(value = "/warning")
    @RequiresPermissions("/meter/warning")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId" ,value = "企业Id",type = "String" ,example = "1",required = true)
    })
    public Result warning(String companyId) {
        return meterRulesService.warningBalanceShort(companyId);
    }



}
