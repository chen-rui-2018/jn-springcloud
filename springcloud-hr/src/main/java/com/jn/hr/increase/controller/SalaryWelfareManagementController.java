package com.jn.hr.increase.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.common.util.HrDataUtil;
import com.jn.hr.increase.enums.SalaryManagementExceptionEnums;
import com.jn.hr.increase.model.IncreaseStaff;
import com.jn.hr.increase.model.IncreaseStaffAdd;
import com.jn.hr.increase.model.IncreaseStaffPage;
import com.jn.hr.increase.model.InsureManagement;
import com.jn.hr.increase.model.InsureManagementPage;
import com.jn.hr.increase.model.InsuredDetaild;
import com.jn.hr.increase.model.InsuredDetaildPage;
import com.jn.hr.increase.model.InsuredScheme;
import com.jn.hr.increase.model.InsuredSchemeAdd;
import com.jn.hr.increase.model.InsuredSchemePage;
import com.jn.hr.increase.model.SalaryAnalysis;
import com.jn.hr.increase.model.SalaryInfo;
import com.jn.hr.increase.model.SalaryInfoAdd;
import com.jn.hr.increase.model.SalaryInfoPage;
import com.jn.hr.increase.model.SalaryPayrollPage;
import com.jn.hr.increase.model.SalaryPayrollVo;
import com.jn.hr.increase.service.SalaryManagementService;
import com.jn.hr.increase.service.WelfareManagrmentService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "薪资福利管理")
@RestController
@RequestMapping("/hr/SalaryWelfareManagement")
public class SalaryWelfareManagementController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(SalaryWelfareManagementController.class);
	@Autowired
	private SalaryManagementService salaryManagementService;
	@Autowired
	WelfareManagrmentService welfareManagrmentService;
	@Autowired
    private ResourceLoader resourceLoader;
	
	
	@ControllerLog(doAction = "分页查询薪资信息")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/paginationInquireSalaryInfo")
	@ApiOperation(value = "分页查询薪资信息", notes = "分页查询薪资信息")
    @RequestMapping(value = "/paginationInquireSalaryInfo", method = RequestMethod.POST)
	public Result<PaginationData<List<SalaryInfo>>> paginationInquireSalaryInfo(@Validated @RequestBody SalaryInfoPage salaryInfoPage){
		PaginationData<List<SalaryInfo>> pageList = salaryManagementService.paginationInquireSalaryInfo(salaryInfoPage);
		return new Result<PaginationData<List<SalaryInfo>>>(pageList);
	}
	
	@ControllerLog(doAction = "添加薪资信息")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/addSalaryInfo")
	@ApiOperation(value = "添加薪资信息", notes = "添加薪资信息")
    @RequestMapping(value = "/addSalaryInfo", method = RequestMethod.POST)
	public Result<String> addSalaryInfo(@Validated @RequestBody SalaryInfoAdd salaryInfoAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String str = salaryManagementService.addSalary(salaryInfoAdd, user);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "修改薪资信息")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/updateSalaryInfo")
	@ApiOperation(value = "修改薪资信息", notes = "修改薪资信息")
    @RequestMapping(value = "/updateSalaryInfo", method = RequestMethod.POST)
	public Result<String> updateSalaryInfo(@Validated @RequestBody SalaryInfoAdd salaryInfoAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
        String str = salaryManagementService.updateSalary(salaryInfoAdd, user);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "导入薪资信息")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/importSalaryInfo")
	@ApiOperation(value = "导入薪资信息", notes = "导入薪资信息")
    @RequestMapping(value = "/importSalaryInfo", method = RequestMethod.POST)
	public Result<String> importSalaryInfo(@RequestParam("file") MultipartFile file){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String str = salaryManagementService.importSalary(file, user);
		return new Result<String>(str);
	}
	
	@ControllerLog(doAction = "导出薪资信息")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/exportSalarInfo")
	@ApiOperation(value = "导出薪资信息", notes = "导出薪资信息")
    @RequestMapping(value = "/exportSalarInfo", method = RequestMethod.GET)
	public void exportSalarInfo(SalaryInfoPage salaryInfo, HttpServletResponse response){
		salaryInfo.setPage(1);
		salaryInfo.setRows(200000);
		PaginationData<List<SalaryInfo>> list = salaryManagementService.exportSalary(salaryInfo);
		String exportTitle = "工号,姓名,基础工资（试用期）,职务津贴（试用期）,职称津贴(试用期),工龄工资(试用期),学历津贴(试用期),工作性补贴(试用期),绩效奖金(试用期),单项奖励(试用期)," + 
                 "基础工资（转正期）,职务津贴（转正期）,职称津贴(转正期),工龄工资(转正期),学历津贴(转正期),工作性补贴(转正期),绩效奖金(转正期),单项奖励(转正期)," + 
                 "基础工资（当前工资）,职务津贴（当前工资）,职称津贴(当前工资),工龄工资(当前工资),学历津贴(当前工资),工作性补贴(当前工资),绩效奖金(当前工资),单项奖励(当前工资)";
        String exportColName = "jobNumber,name,probationBasicWage,probationDutyAllowance,probationProfessionalTitleAllowance,probationSeniorityWage,probationEducationAllowance," +
                 "probationWorkSubsidy,probationAchievementBonus,probationSingleReward," + "conversionBasicWage,conversionDutyAllowance,conversionProfessionalTitleAllowance," + 
        	     "conversionSeniorityWage,conversionEducationAllowance,conversionWorkSubsidy,conversionAchievementBonus,conversionSingleReward,currentBasicWage,currentDutyAllowance,"+
                 "currentProfessionalTitleAllowance,currentSeniorityWage,currentEducationAllowance,currentWorkSubsidy,currentAchievementBonus,currentSingleReward";
        String fileName = "薪资信息"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        String sheetName = "薪资信息";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, list.getRows());
	}
	
	@ControllerLog(doAction = "查询薪资信息详情")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/getSalaryInfoById")
	@ApiOperation(value = "查询薪资信息详情", notes = "查询薪资信息详情")
    @RequestMapping(value = "/getSalaryInfoById", method = RequestMethod.POST)
	public Result<SalaryInfo> getSalaryInfoById(@Validated @RequestBody SalaryInfoPage salaryInfo){
		Assert.notNull(salaryInfo.getJobNumber(),"jobNumber不能为空");
		SalaryInfo SalaryInfo = salaryManagementService.inquireSalaryInfo(salaryInfo.getJobNumber());
		return new Result(SalaryInfo);
	}
	
	@ControllerLog(doAction = "发放工资页面查询")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/paginationInquirePayroll")
	@ApiOperation(value = "发放工资页面查询", notes = "发放工资页面查询")
    @RequestMapping(value = "/paginationInquirePayroll", method = RequestMethod.POST)
	public Result<PaginationData<List<SalaryPayrollVo>>> paginationInquirePayroll(@Validated @RequestBody SalaryPayrollPage salaryPayrollPage){
		PaginationData<List<SalaryPayrollVo>> pageList = salaryManagementService.paginationInquirePayroll(salaryPayrollPage);
		return new Result<PaginationData<List<SalaryPayrollVo>>>(pageList);
	}
	
	@ControllerLog(doAction = "导入工资条")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/importPayroll")
	@ApiOperation(value = "导入工资条", notes = "导入工资条")
    @RequestMapping(value = "/importPayroll", method = RequestMethod.POST)
	public Result<String> importPayroll(@RequestParam("file") MultipartFile file){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String str = salaryManagementService.importPayroll(file, user);
		return new Result<String>(str);
	}
	
	@ControllerLog(doAction = "导出工资条信息")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/exportPayroll")
	@ApiOperation(value = "导出工资条信息", notes = "导出工资条信息")
    @RequestMapping(value = "/exportPayroll", method = RequestMethod.GET)
	public void exportPayroll(@Validated @RequestBody SalaryPayrollPage salaryPayrollPage, HttpServletResponse response){
		salaryPayrollPage.setPage(1);
		salaryPayrollPage.setRows(200000);
		PaginationData<List<SalaryPayrollVo>> pageList = salaryManagementService.exportPayroll(salaryPayrollPage);
		String exportTitle = "姓名,工号,部门,工资档次及金额,园区工龄工资,技术岗位津贴,职务津贴,工作性补贴,学历津贴,职称津贴,专项补贴,餐补,应发工资,代扣社会统筹保险,代扣公积金,扣个税,食堂餐费,工会会费,实发工资,入账日期";
		String exportColName = "name,jobNumber,department,basicWage,seniorityWage,technicalAllowance,dutyAllowance,workSubsidy,educationAllowance,professionalTitleAllowance,specialSubsidy," +
		         "mealSubsidy,deserveWage,pendingSocialpoolingInsurance,pendingProvidentfund,pendingPersonalTax,canteenMealFee,unionFee,realWage,entryTime";
        String fileName = "工资条"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        String sheetName = "工资条";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
	}
	
	@ControllerLog(doAction = "修改工资条")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/updatePayroll")
	@ApiOperation(value = "修改工资条", notes = "修改工资条")
    @RequestMapping(value = "/updatePayroll", method = RequestMethod.POST)
	public Result<String> updatePayroll(@Validated @RequestBody SalaryPayrollPage salaryPayrollPage){
		String str = salaryManagementService.updatePayroll(salaryPayrollPage);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "薪酬分析")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/salaryAnalysis")
	@ApiOperation(value = "薪酬分析", notes = "薪酬分析")
    @RequestMapping(value = "/salaryAnalysis", method = RequestMethod.POST)
	public Result<SalaryAnalysis> salaryAnalysis(@Validated @RequestBody SalaryPayrollPage salaryPayrollPage){
		SalaryAnalysis salaryAnalysis = salaryManagementService.salaryAnalysis(salaryPayrollPage);
		return new Result<SalaryAnalysis>(salaryAnalysis);
	}	
	
	@ControllerLog(doAction = "下载薪资表excel模板")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/downLoadSalaryInfoExcelTemplate")
    @ApiOperation(value = "下载薪资表excel模板", notes = "下载薪资表excel模板")
    @RequestMapping(value = "/downLoadSalaryInfoExcelTemplate", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downLoadSalaryInfoExcelTemplate() {
        try {
            Resource resource = resourceLoader.getResource("classpath:excelTemplate/salaryInfoTemplate.xlsx");
            File file = resource.getFile();
            String name = "薪资表导入模板" + ExcelTypeEnum.XLSX.getValue();
            String fileName = new String(name.getBytes(), "ISO-8859-1");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/octet-stream");
            headers.add("Content-Disposition", "attachment;filename=" + fileName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("[薪资表] ,薪资表导入模板下载失败", e);
            throw new JnSpringCloudException(SalaryManagementExceptionEnums.DOWNLOAD_EXCEL_TEMPLATE_FAIL);
        }
    }
    
    @ControllerLog(doAction = "下载参保明细表excel模板")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/downLoadInsuredDetailExcelTemplate")
    @ApiOperation(value = "下载参保明细表excel模板", notes = "下载参保明细表excel模板")
    @RequestMapping(value = "/downLoadInsuredDetailExcelTemplate", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downLoadInsuredDetailExcelTemplate() {
        try {
            Resource resource = resourceLoader.getResource("classpath:excelTemplate/insuredDetailTemplate.xlsx");
            File file = resource.getFile();
            String name = "参保明细表导入模板" + ExcelTypeEnum.XLSX.getValue();
            String fileName = new String(name.getBytes(), "ISO-8859-1");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/octet-stream");
            headers.add("Content-Disposition", "attachment;filename=" + fileName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("[参保明细表] ,参保明细表导入模板下载失败", e);
            throw new JnSpringCloudException(SalaryManagementExceptionEnums.DOWNLOAD_EXCEL_TEMPLATE_FAIL);
        }
    }
    
    
    
    
    
    
    
    @ControllerLog(doAction = "分页查询参保信息")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/paginationInquireWelfareInfo")
	@ApiOperation(value = "分页查询参保信息", notes = "分页查询参保信息")
    @RequestMapping(value = "/paginationInquireWelfareInfo", method = RequestMethod.POST)
	public Result<PaginationData<List<InsureManagement>>> paginationInquireWelfareInfo(@Validated @RequestBody InsureManagementPage insureManagementPage){
		PaginationData<List<InsureManagement>> pageList = welfareManagrmentService.inquireInsuredManagement(insureManagementPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "添加次月账单")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/addNextMonth")
	@ApiOperation(value = "添加次月账单", notes = "添加次月账单")
	@RequestMapping(value = "/addNextMonth", method = RequestMethod.POST)
	public Result addNextMonth(){
		
		return new Result();
	}
	
	@ControllerLog(doAction = "导入历史参保记录")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/importHistoryInsuranceRecord")
	@ApiOperation(value = "导入历史参保记录", notes = "导入历史参保记录")
	@RequestMapping(value = "/importHistoryInsuranceRecord", method = RequestMethod.POST)
	public Result<String> importHistoryInsuranceRecord(@RequestParam("file") MultipartFile file){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String str = welfareManagrmentService.importHistoryInsuranceRecord(file, user);
		return new Result<String>(str);
	}
	
	@ControllerLog(doAction = "分页查询增员计划")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/inquireAttritionPlan")
	@ApiOperation(value = "分页查询增员计划", notes = "分页查询增员计划")
	@RequestMapping(value = "/inquireAttritionPlan", method = RequestMethod.POST)
	public Result<PaginationData<List<IncreaseStaff>>> inquireAttritionPlan(@Validated @RequestBody IncreaseStaffPage increaseStaffPage){
		PaginationData<List<IncreaseStaff>> pageList= welfareManagrmentService.inquireAttritionPlan(increaseStaffPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "添加增员计划")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/addOrDeleteAttritionPlan")
	@ApiOperation(value = "添加增员计划", notes = "添加增员计划")
	@RequestMapping(value = "/addOrDeleteAttritionPlan", method = RequestMethod.POST)
	public Result<String> addOrDeleteAttritionPlan(@Validated @RequestBody IncreaseStaffAdd increaseStaffAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String str = welfareManagrmentService.addAttritionPlan(increaseStaffAdd, user);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "取消")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/deleteAttritionPlan")
	@ApiOperation(value = "取消", notes = "取消")
	@RequestMapping(value = "/deleteAttritionPlan", method = RequestMethod.POST)
	public Result<String> deleteAttritionPlan(@Validated @RequestBody IncreaseStaffPage increaseStaffPage){;
		String str = welfareManagrmentService.deleteAttritionPlan(increaseStaffPage);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "修改项目基数")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/updateInsuredCardinalNumber")
	@ApiOperation(value = "修改项目基数", notes = "修改项目基数")
	@RequestMapping(value = "/updateInsuredCardinalNumber", method = RequestMethod.POST)
	public Result<String> updateInsuredCardinalNumber(@Validated @RequestBody InsuredSchemeAdd insuredSchemeAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String str = welfareManagrmentService.updateInsurancescheme(insuredSchemeAdd, user);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "参保明细页面")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/paginationInquireInsuranceRecord")
	@ApiOperation(value = "参保明细页面", notes = "参保明细页面")
	@RequestMapping(value = "/paginationInquireInsuranceRecord", method = RequestMethod.POST)
	public Result<PaginationData<List<InsuredDetaild>>> paginationInquireInsuranceRecord(@Validated @RequestBody InsuredDetaildPage insuredDetaildPage){
		PaginationData<List<InsuredDetaild>> pageList = welfareManagrmentService.paginationInquireInsuranceRecord(insuredDetaildPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "参保明细附属页面")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/insuredDetailedSubsidiary")
	@ApiOperation(value = "参保明细附属页面", notes = "参保明细附属页面")
	@RequestMapping(value = "/insuredDetailedSubsidiary", method = RequestMethod.POST)
	public Result<InsureManagement> insuredDetailedSubsidiary(@Validated @RequestBody InsuredDetaildPage insuredDetaildPage){
		InsureManagement insureManagement = welfareManagrmentService.insuredDetailedSubsidiary(insuredDetaildPage);
		return new Result(insureManagement);
	}
	
	@ControllerLog(doAction = "导出参保明细")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/exportInsuranceRecord")
	@ApiOperation(value = "导出参保明细", notes = "导出参保明细")
	@RequestMapping(value = "/exportInsuranceRecord", method = RequestMethod.GET)
	public void exportInsuranceRecord(InsuredDetaildPage insuredDetaildPage, HttpServletResponse response){
		insuredDetaildPage.setPage(1);
		insuredDetaildPage.setRows(200000);
		PaginationData<List<InsuredDetaild>> pageList = welfareManagrmentService.exportInsuranceRecord(insuredDetaildPage);
		String exportTitle = "姓名,工号,部门,参保城市名称,个人社保费,公司社保费,个人公积金费,公司公积金费";
       String exportColName = "name,jobNumber,department,cityName,personalSocialSecurity,companySocialSecurity,personalAccumulationFund,companyAccumulationFund";
       String fileName = "参保明细"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "参保明细";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
	}
	
	
	@ControllerLog(doAction = "停止参保")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/stopInsurance")
	@ApiOperation(value = "停止参保", notes = "停止参保")
	@RequestMapping(value = "/stopInsurance", method = RequestMethod.POST)
	public Result<String> stopInsurance(@Validated @RequestBody IncreaseStaffAdd increaseStaffAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		welfareManagrmentService.stopInsurance(increaseStaffAdd, user);
		return new Result();
	}
	
	@ControllerLog(doAction = "自主参保方案页面")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/paginationInquireInsurance")
	@ApiOperation(value = "自主参保方案页面", notes = "自主参保方案页面")
	@RequestMapping(value = "/paginationInquireInsurance", method = RequestMethod.POST)
	public Result<PaginationData<List<InsuredScheme>>> paginationInquireInsurance(@Validated @RequestBody InsuredSchemePage insuredSchemePage){
		PaginationData<List<InsuredScheme>> pageList =  welfareManagrmentService.paginationInquireInsurance(insuredSchemePage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "修改参保方案")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/updateInsurancescheme")
	@ApiOperation(value = "修改参保方案", notes = "修改参保方案")
	@RequestMapping(value = "/updateInsurancescheme", method = RequestMethod.POST)
	public Result<String> updateInsurancescheme(@Validated @RequestBody InsuredSchemeAdd insuredSchemeAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String str = welfareManagrmentService.updateInsurancescheme(insuredSchemeAdd, user);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "参保方案页面明细")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/insuranceSchemeDetailed")
	@ApiOperation(value = "参保方案页面明细", notes = "参保方案页面明细")
	@RequestMapping(value = "/insuranceSchemeDetailed", method = RequestMethod.POST)
	public Result<InsuredScheme> insuranceSchemeDetailed(@Validated @RequestBody InsuredSchemePage insuredSchemePage){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		InsuredScheme insuredScheme = welfareManagrmentService.insuranceSchemeDetailed(insuredSchemePage);
		return new Result(insuredScheme);
	}
	
	@ControllerLog(doAction = "删除参保方案")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/deleteInsurancescheme")
	@ApiOperation(value = "删除参保方案", notes = "删除参保方案")
	@RequestMapping(value = "/deleteInsurancescheme", method = RequestMethod.POST)
	public Result<String> deleteInsurancescheme(@Validated @RequestBody InsuredSchemePage insuredSchemePage){
		String str = welfareManagrmentService.deleteInsurancescheme(insuredSchemePage);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "添加参保方案")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/addInsurancescheme")
	@ApiOperation(value = "添加参保方案", notes = "添加参保方案")
	@RequestMapping(value = "/addInsurancescheme", method = RequestMethod.POST)
	public Result<String> addInsurancescheme(@Validated @RequestBody InsuredSchemeAdd insuredSchemeAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		welfareManagrmentService.addInsurancescheme(insuredSchemeAdd, user);
		return new Result();
	}
	
	@ControllerLog(doAction = "参保概况")
    //@RequiresPermissions("/hr/SalaryWelfareManagement/insuredOverview")
	@ApiOperation(value = "参保概况", notes = "参保概况")
	@RequestMapping(value = "/insuredOverview", method = RequestMethod.POST)
	public Result<InsuredDetaild> insuredOverview(@Validated @RequestBody InsuredDetaildPage insuredDetaildPage){
		InsuredDetaild insuredDetaild = welfareManagrmentService.insuredOverview(insuredDetaildPage);
		return new Result(insuredDetaild);
	}
}
