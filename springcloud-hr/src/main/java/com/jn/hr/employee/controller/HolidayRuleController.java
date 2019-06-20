package com.jn.hr.employee.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.attendance.model.VacationManagePage;
import com.jn.hr.attendance.model.VacationManageVo;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.hr.employee.model.HolidayRule;
import com.jn.hr.employee.model.HolidayRuleAdd;
import com.jn.hr.employee.service.EmployeeBasicInfoService;
import com.jn.hr.employee.service.HolidayRuleService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author dt
 * @create 2019-04-23 下午 2:55
 */
@Api(tags = "假期管理")
@RestController
@RequestMapping("/hr/holidayRule")
public class HolidayRuleController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(HolidayRuleController.class);
    @Autowired
    private HolidayRuleService holidayRuleService;
    @Autowired
    private EmployeeBasicInfoService employeeBasicInfoService;


    @ControllerLog(doAction = "添加假期规则")
    @RequiresPermissions("/hr/holidayRule/addHolidayRule")
    @ApiOperation(value = "添加假期规则", notes = "添加假期规则")
    @PostMapping(value = "/addHolidayRule")
    public Result addHolidayRule(@Validated @RequestBody HolidayRuleAdd holidayRuleAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String ruleId=holidayRuleService.addHolidayRule(holidayRuleAdd,user);
        return new Result(ruleId);
    }
    @ControllerLog(doAction = "修改假期规则")
    @RequiresPermissions("/hr/holidayRule/updateHolidayRule")
    @ApiOperation(value = "修改假期规则", notes = "修改假期规则")
    @PostMapping(value = "/updateHolidayRule")
    public Result updateHolidayRule(@Validated @RequestBody HolidayRuleAdd holidayRuleAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.hasText(holidayRuleAdd.getRuleId(),"ruleId不能为空");
        holidayRuleService.updateHolidayRule(holidayRuleAdd,user);
        return new Result();
    }


    @ControllerLog(doAction = "查询假期规则列表")
    @RequiresPermissions("/hr/holidayRule/getHolidayRules")
    @ApiOperation(value = "查询假期规则列表", notes = "查询假期规则列表")
    @PostMapping(value = "/getHolidayRules")
    public Result<List<HolidayRule>> getHolidayRules() {
        List<HolidayRule> holidayRules = holidayRuleService.getHolidayRules();
        return new Result(holidayRules);
    }


    @ControllerLog(doAction = "删除假期规则")
    @RequiresPermissions("/hr/holidayRule/deleteHolidayRule")
    @ApiOperation(value = "删除假期规则", notes = "删除假期规则")
    @GetMapping(value = "/deleteHolidayRule")
    public Result delete(@RequestParam("id") String departmentId) {
        Assert.hasText(departmentId,"departmentId不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        holidayRuleService.delete(departmentId, user);
        return new Result();
    }

    @ControllerLog(doAction = "假期审查列表")
    @RequiresPermissions("/hr/holidayRule/list")
    @ApiOperation(value = "假期审查列表", notes = "假期审查列表")
    @PostMapping(value = "/list")
    public Result<PaginationData<List<EmployeeBasicInfo>>> list(@Validated @RequestBody EmployeeBasicInfoPage employeeBasicInfoPage) {
        PaginationData<List<EmployeeBasicInfo>> data = employeeBasicInfoService.list(employeeBasicInfoPage,true);
        return new Result(data);
    }
    @ControllerLog(doAction = "导出假期审查")
    @RequiresPermissions("/hr/holidayRule/exportEmployeHoliday")
    @ApiOperation(value = "导出假期审查", notes = "导出假期审查")
    @GetMapping(value = "/exportEmployeHoliday")
    public void exportEmployeHoliday(EmployeeBasicInfoPage employeeBasicInfoPage,
                                        HttpServletResponse response) {
        employeeBasicInfoPage.setPage(1);
        employeeBasicInfoPage.setRows(200000);
        PaginationData<List<EmployeeBasicInfo>> pageList= employeeBasicInfoService.list(employeeBasicInfoPage,true);
        String exportTitle = "姓名,工号,部门,职位,联系电话,工龄,年休假";
        String exportColName = "name,jobNumber,departmentName,jobName,phone,workingAge,annualLeave";
        String fileName = "假期审查"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        String sheetName = "假期审查";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
    }

    @ControllerLog(doAction = "假期查询")
    @RequiresPermissions("/hr/holidayRule/inquireVacationManage")
    @ApiOperation(value = "假期查询", notes = "假期查询")
    @PostMapping(value = "/inquireVacationManage")
    public Result<PaginationData<List<VacationManageVo>>> inquireVacationManage(@Validated @RequestBody VacationManagePage vacationManagePage) {
    	PaginationData<List<VacationManageVo>> data = holidayRuleService.inquireVacationManage(vacationManagePage);
        return new Result(data);
    }
    
    @ControllerLog(doAction = "假期修改")
    @RequiresPermissions("/hr/holidayRule/updateVacationManage")
    @ApiOperation(value = "假期修改", notes = "假期修改")
    @PostMapping(value = "/updateVacationManage")
    public Result updateVacationManage(@Validated @RequestBody VacationManagePage vacationManagePage) {
    	holidayRuleService.updateVacationManage(vacationManagePage);
        return new Result();
    }
}
