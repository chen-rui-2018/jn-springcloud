package com.jn.park.electricmeter.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.company.model.ServiceCompany;
import com.jn.hardware.api.ElectricMeterClient;
import com.jn.park.electricmeter.model.*;
import com.jn.park.electricmeter.service.MeterCalcCostService;
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
import org.springframework.validation.annotation.Validated;
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
    @Autowired
    private MeterCalcCostService meterCalcCostService;
    @Autowired
    private ElectricMeterClient electricMeterClient;

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
    @ApiOperation(value = "作废计价规则",notes = "作废计价规则", httpMethod = "POST")
    @PostMapping(value = "/deletePriceRule")
    @RequiresPermissions("/meter/deletePriceRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "计价规则id",type = "String" ,example = "1",required = true)
    })
    public Result deletePriceRule(@RequestBody MeterIdParam model){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data = meterRulesService.deletePriceRule(user,model.getId());
        result.setData(data);
        return result;
    }

    @ControllerLog(doAction = "企业计价规则维护-企业设置计价规则")
    @ApiOperation(value = "企业设置计价规则",notes = "企业设置计价规则", httpMethod = "POST")
    @PostMapping(value = "/setRule")
    @RequiresPermissions("/meter/setRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleId",value = "计价规则id",type = "String" ,example = "1",required = true),
            @ApiImplicitParam(name = "companyId",value = "企业id",type = "String" ,example = "1",required = true)
    })
    public Result setRule(@RequestBody PriceRuleParam model){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data = meterRulesService.setRule(user,model.getRuleId(), model.getCompanyId());
        result.setData(data);
        return result;
    }

    @ControllerLog(doAction = "企业计价规则维护-作废企业设置计价规则")
    @ApiOperation(value = "作废企业设置计价规则",notes = "作废企业设置计价规则", httpMethod = "POST")
    @PostMapping(value = "/deleteLinks")
    @RequiresPermissions("/meter/deleteLinks")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "关系id",type = "String" ,example = "1",required = true)
    })
    public Result deleteLinks(@RequestBody PriceRuleParam model ){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data = meterRulesService.deleteLinks(user,model.getId());
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
    public Result updateCompanysRule(@RequestBody PriceRuleParam model){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer data = meterRulesService.updateCompanysRule(user,model.getId(),model.getRuleId(), model.getCompanyId());
        result.setData(data);
        return result;
    }

    @ControllerLog(doAction = "电表的启动和关闭定时器接口")
    @ApiOperation(value = "电表的启动和关闭定时器接口",notes = "电表的启动和关闭定时器接口", httpMethod = "GET")
    @GetMapping(value = "/setSwitchMeter")
    @RequiresPermissions("/meter/setSwitchMeter")
    public void setSwitchMeterTimer(){
        meterRulesService.setSwitchMeterTimer();
    }

    @ControllerLog(doAction = "余额不足告警")
    @ApiOperation(value = "余额不足告警",notes = "余额不足告警", httpMethod = "POST")
    @PostMapping(value = "/warning")
    @RequiresPermissions("/meter/warning")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId" ,value = "企业Id",type = "String" ,example = "1",required = true)
    })
    public Result warning(@RequestBody MeterCompanyIdParam model ) {
        return meterRulesService.warningBalanceShort(model.getCompanyId());
    }


    //定时计价部分接口

    @ControllerLog(doAction = "电费账单催缴")
    @ApiOperation(value = "电费账单催缴",notes = "电费账单催缴", httpMethod = "POST")
    @PostMapping(value = "/setUrgeCall")
    @RequiresPermissions("/meter/setUrgeCall")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "账单id",type = "String" ,example = "1",required = true)
    })
    public Result setUrgeCall(@RequestBody MeterIdParam model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return meterCalcCostService.setUrgeCall(user,model.getId());
    }


    @ControllerLog(doAction = "手动调用定时计价接口，进行指定企业的电费和电量计算")
    @ApiOperation(value = "手动调用定时计价接口，进行指定企业的电费和电量计算",notes = "手动调用定时计价接口，进行指定企业的电费和电量计算", httpMethod = "POST")
    @PostMapping(value = "/calcCostEverdayByHandler")
    @RequiresPermissions("/meter/calcCostEverdayByHandler")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId" ,value = "企业id",type = "String" ,example = "1",required = true),
            @ApiImplicitParam(name = "day" ,value = "计算日期",type = "Date" ,example = "1",required = true)
    })
    public Result calcCostEverdayByHandler(@RequestBody CompanyFailModelParam param){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return meterCalcCostService.calcCostEverdayByHandler( user,  param.getCompanyId(),  param.getDay());
    }

    //电表业主维护

    @ControllerLog(doAction = "电表业主维护")
    @ApiOperation(value = "电表业主维护",notes = "电表业主维护", httpMethod = "POST")
    @PostMapping(value = "/insertMeterInfo")
    @RequiresPermissions("/meter/insertMeterInfo")
    public Result insertMeterInfo(@RequestBody MeterInfoModel model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return meterService.insertMeterInfo( user,model);
    }

    @ControllerLog(doAction = "电表信息作废")
    @ApiOperation(value = "电表信息作废",notes = "电表信息作废", httpMethod = "POST")
    @PostMapping(value = "/deleteMeterInfo")
    @RequiresPermissions("/meter/deleteMeterInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "记录id",type = "String" ,example = "1",required = true)
    })
    public Result deleteMeterInfo(@RequestBody MeterIdParam model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return meterService.deleteMeterInfo( user, model.getId());
    }

    @ControllerLog(doAction = "电表信息更新")
    @ApiOperation(value = "电表信息更新",notes = "电表信息更新", httpMethod = "POST")
    @PostMapping(value = "/updateMeterInfo")
    @RequiresPermissions("/meter/updateMeterInfo")
    public Result updateMeterInfo(@RequestBody MeterInfoModel model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return meterService.updateMeterInfo( user,model);
    }

    //能耗统计
    @ControllerLog(doAction = "分组统计图表")
    @ApiOperation(value = "分组统计图表",notes = "分组统计图表", httpMethod = "GET")
    @GetMapping(value = "/groupChart")
    @RequiresPermissions("/meter/groupChart")
    public Result groupChart(){
        return meterService.groupChart();
    }

    @ControllerLog(doAction = "分类统计图表")
    @ApiOperation(value = "分类统计图表",notes = "分类统计图表", httpMethod = "GET")
    @GetMapping(value = "/categaryChart")
    @RequiresPermissions("/meter/categaryChart")
    public Result categaryChart(){
        return meterService.categaryChart();
    }

    @ControllerLog(doAction = "趋势明细图表")
    @ApiOperation(value = "趋势明细图表",notes = "趋势明细图表", httpMethod = "POST")
    @PostMapping(value = "/trendChartDetail")
    @RequiresPermissions("/meter/trendChartDetail")
    public Result trendChartDetail(@RequestBody @Validated TrendChartPageParam param){
        return meterService.trendChartDetail(param);
    }

    @ControllerLog(doAction = "趋势图表")
    @ApiOperation(value = "趋势图表",notes = "趋势图表", httpMethod = "POST")
    @PostMapping(value = "/trendChart")
    @RequiresPermissions("/meter/trendChart")
    public Result trendChart(@RequestBody @Validated TrendChartParam param){
        return meterService.trendChart(param);
    }

    @ControllerLog(doAction = "手动调用电表定时计价无参数")
    @ApiOperation(value = "手动调用电表定时计价无参数",notes = "手动调用电表定时计价无参数", httpMethod = "GET")
    @GetMapping(value = "/calcCostEverday")
    @RequiresPermissions("/meter/calcCostEverday")
    public void calcCostEverday(){
        meterCalcCostService.calcCostEverday();
    }

    @ControllerLog(doAction = "今日用电情况")
    @ApiOperation(value = "今日用电情况", notes = "今日用电情况")
    @GetMapping(path = "/todayelectro")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyid", value = "企业ID", dataType = "String", paramType = "query", example = "583060576549208064"),
    })
    public Result todayelectro(String companyid){
        return meterService.todayelectro(companyid);
    }

    @ControllerLog(doAction = "本月用电情况")
    @ApiOperation(value = "本月用电情况", notes = "本月用电情况")
    @GetMapping(path = "/monthelectro")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyid", value = "企业ID", dataType = "String", paramType = "query", example = "583060576549208064"),
    })
    public Result monthelectro(String companyid){
        return meterService.monthelectro(companyid);
    }

    @ControllerLog(doAction = "今年用电情况")
    @ApiOperation(value = "今年用电情况", notes = "今年用电情况")
    @GetMapping(path = "/yearelectro")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyid", value = "企业ID", dataType = "String", paramType = "query", example = "583060576549208064"),
    })
    public Result yearelectro(String companyid){
        return meterService.yearelectro(companyid);
    }



    @ControllerLog(doAction = "查询电表的使用状态")
    @ApiOperation(value = "查询电表的使用状态", notes = "查询电表的使用状态")
    @GetMapping(path = "/getMeterStatus")
    public Result getMeterStatus(String meterCode){
        return electricMeterClient.getElectricMeterStatus(meterCode);
    }

    @ControllerLog(doAction = "通过电表号，日期，小时采集数据")
    @ApiOperation(value = "通过电表号，日期，小时采集数据", notes = "通过电表号，日期，小时采集数据")
    @GetMapping(path = "/dealAllFailByDealHourAndDealDateAndMeterCode")
    public Result dealAllFailByDealHourAndDealDateAndMeterCode(Date dealDate,String dealHour,String meterCode){
        return meterService.dealAllFailByDealHourAndDealDateAndMeterCode( dealDate,dealHour,meterCode);
    }

}
