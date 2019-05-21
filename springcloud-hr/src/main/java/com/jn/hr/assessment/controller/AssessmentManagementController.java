package com.jn.hr.assessment.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.assessment.model.AssessmentManageAdd;
import com.jn.hr.assessment.model.AssessmentManagePage;
import com.jn.hr.assessment.model.AssessmentManageVo;
import com.jn.hr.assessment.model.AssessmentTemplateDetailVo;
import com.jn.hr.assessment.model.AssessmentTemplatePage;
import com.jn.hr.assessment.model.AssessmentTemplateVo;
import com.jn.hr.assessment.model.DepartmentTree;
import com.jn.hr.assessment.service.AssessmentManagementService;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "考核管理")
@RestController
@RequestMapping("/hr/AssessmentManagement")
public class AssessmentManagementController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(AssessmentManagementController.class);
	@Autowired
	AssessmentManagementService assessmentManagementService;
	
	@ControllerLog(doAction = "分页查询考核管理")
    //@RequiresPermissions("/hr/AssessmentManagement/paginationInquireAssessManage")
	@ApiOperation(value = "分页查询考核管理", notes = "分页查询考核管理")
    @RequestMapping(value = "/paginationInquireAssessManage", method = RequestMethod.POST)
	public Result<PaginationData<List<AssessmentManageVo>>> paginationInquireAssessManage(@Validated @RequestBody AssessmentManagePage assessmentManagePage){
		PaginationData<List<AssessmentManageVo>> pageList = assessmentManagementService.inquireAssessManagePage(assessmentManagePage);
		return new Result(pageList);
	}
	
	
	@ControllerLog(doAction = "发起考核")
    //@RequiresPermissions("/hr/AssessmentManagement/initiateAssess")
	@ApiOperation(value = "发起考核", notes = "发起考核")
    @RequestMapping(value = "/initiateAssess", method = RequestMethod.POST)
	public Result initiateAssess(@Validated @RequestBody AssessmentManageAdd assessmentManageAdd){	
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		assessmentManagementService.initiateAssess(assessmentManageAdd, user);
		return new Result();
	}
	
	@ControllerLog(doAction = "获取部门树")
    //@RequiresPermissions("/hr/AssessmentManagement/ObtainDepartmentTree")
	@ApiOperation(value = "获取部门树", notes = "获取部门树")
    @RequestMapping(value = "/ObtainDepartmentTree", method = RequestMethod.POST)
	public Result<List<DepartmentTree>> ObtainDepartmentTree(@Validated @RequestBody EmployeeBasicInfoPage employeeBasicInfoPage){	
		List<DepartmentTree> basicInfo = assessmentManagementService.ObtainDepartmentTree(employeeBasicInfoPage);
		return new Result(basicInfo);
	}
	
	
	@ControllerLog(doAction = "考核延期")
    //@RequiresPermissions("/hr/AssessmentManagement/assessmentExtension")
	@ApiOperation(value = "考核延期", notes = "考核延期")
    @RequestMapping(value = "/assessmentExtension", method = RequestMethod.POST)
	public Result assessmentExtension(@Validated @RequestBody AssessmentManageAdd assessmentManageAdd){	
		User user = (User) SecurityUtils.getSubject().getPrincipal();	
		assessmentManagementService.assessmentExtension(assessmentManageAdd, user);
		return new Result();
	}
	
	
	@ControllerLog(doAction = "删除考核记录")
    //@RequiresPermissions("/hr/AssessmentManagement/deleteAssessmentRecord")
	@ApiOperation(value = "删除考核记录", notes = "删除考核记录")
    @RequestMapping(value = "/deleteAssessmentRecord", method = RequestMethod.POST)
	public Result deleteAssessmentRecord(@Validated @RequestBody AssessmentManagePage assessmentManagePage){	
		assessmentManagementService.deleteAssessmentRecord(assessmentManagePage);
		return new Result();
	}
	
	@ControllerLog(doAction = "导出查看页面明细")
    //@RequiresPermissions("/hr/AssessmentManagement/exportAssessment")
	@ApiOperation(value = "导出查看页面明细", notes = "导出查看页面明细")
    @RequestMapping(value = "/exportAssessment", method = RequestMethod.GET)
	public Result exportAssessment(AssessmentManagePage assessmentManagePage,HttpServletResponse response){	
		assessmentManagePage.setPage(1);
		assessmentManagePage.setRows(200000);
		PaginationData<List<AssessmentManageVo>> pageList = assessmentManagementService.viewPageInfo(assessmentManagePage);
		String exportTitle = "部门,姓名,考核开始时间,考核结束时间,考核对象,考核人,状态";
		String exportColName = "departmentName,name,assessmentStartTime,assessmentEndTime,assessmentObject,assessmentPeople,status";
       String fileName = "查看页面明细"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "查看页面明细";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
		return new Result();
	}
	
	@ControllerLog(doAction = "查看页面分页")
    //@RequiresPermissions("/hr/AssessmentManagement/viewPageInfo")
	@ApiOperation(value = "查看页面分页", notes = "查看页面分页")
    @RequestMapping(value = "/viewPageInfo", method = RequestMethod.POST)
	public Result<PaginationData<List<AssessmentManageVo>>> viewPageInfo(@Validated @RequestBody AssessmentManagePage assessmentManagePage){	
		PaginationData<List<AssessmentManageVo>> pageList = assessmentManagementService.viewPageInfo(assessmentManagePage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "开始考核-保存")
    //@RequiresPermissions("/hr/AssessmentManagement/saveStartAssessmentPage")
	@ApiOperation(value = "开始考核-保存", notes = "开始考核-保存")
    @RequestMapping(value = "/saveStartAssessmentPage", method = RequestMethod.POST)
	public Result saveStartAssessmentPage(@Validated @RequestBody AssessmentManageAdd assessmentManageAdd){	
		assessmentManagementService.saveStartAssessmentPage(assessmentManageAdd);
		return new Result();
	}
	
	@ControllerLog(doAction = "开始考核-页面明细")
    //@RequiresPermissions("/hr/AssessmentManagement/startAssessmentPageDetails")
	@ApiOperation(value = "开始考核-页面明细", notes = "开始考核-页面明细")
    @RequestMapping(value = "/startAssessmentPageDetails", method = RequestMethod.POST)
	public Result<List<AssessmentTemplateDetailVo>> startAssessmentPageDetails(@Validated @RequestBody AssessmentManageAdd assessmentManageAdd){	
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentManagementService.startAssessmentPageDetails(assessmentManageAdd);
		return new Result(templateDetailList);
	}
	
	@ControllerLog(doAction = "归档生效")
    //@RequiresPermissions("/hr/AssessmentManagement/updateAssessment")
	@ApiOperation(value = "归档生效", notes = "归档生效")
    @RequestMapping(value = "/updateAssessment", method = RequestMethod.POST)
	public Result<String> updateAssessment(@Validated @RequestBody AssessmentManageAdd assessmentManageAdd){	
		String str = assessmentManagementService.updateAssessment(assessmentManageAdd);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "结束并归档")
    //@RequiresPermissions("/hr/AssessmentManagement/finishAndArchive")
	@ApiOperation(value = "结束并归档", notes = "结束并归档")
    @RequestMapping(value = "/finishAndArchive", method = RequestMethod.POST)
	public Result<String> finishAndArchive(@Validated @RequestBody AssessmentManageAdd assessmentManageAdd){	
		String str = assessmentManagementService.finishAndArchive(assessmentManageAdd);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "删除被考核人记录")
    //@RequiresPermissions("/hr/AssessmentManagement/deleteAppraisedPersonRecord")
	@ApiOperation(value = "删除被考核人记录", notes = "删除被考核人记录")
    @RequestMapping(value = "/deleteAppraisedPersonRecord", method = RequestMethod.POST)
	public Result deleteAppraisedPersonRecord(@Validated @RequestBody AssessmentManagePage assessmentManagePage){	
		assessmentManagementService.deleteAppraisedPersonRecord(assessmentManagePage);
		return new Result();
	}
	
	@ControllerLog(doAction = "开始考核详细页面显示")
    //@RequiresPermissions("/hr/AssessmentManagement/viewAssessmentDetails")
	@ApiOperation(value = "开始考核详细页面显示", notes = "开始考核详细页面显示")
    @RequestMapping(value = "/viewAssessmentDetails", method = RequestMethod.POST)
	public Result<List<AssessmentTemplateDetailVo>> viewAssessmentDetails(@Validated @RequestBody AssessmentManageAdd assessmentManageAdd){	
		List<AssessmentTemplateDetailVo> records = assessmentManagementService.viewAssessmentDetails(assessmentManageAdd);
		return new Result(records);
	}
	
	
	@ControllerLog(doAction = "考核模板页面显示")
    //@RequiresPermissions("/hr/AssessmentManagement/assessmentTemplatePaginationDisplay")
	@ApiOperation(value = "考核模板页面显示", notes = "考核模板页面显示")
    @RequestMapping(value = "/assessmentTemplatePaginationDisplay", method = RequestMethod.POST)
	public Result<PaginationData<List<AssessmentTemplateVo>>> assessmentTemplatePaginationDisplay(@Validated @RequestBody AssessmentTemplatePage assessmentTemplatePage){	
		PaginationData<List<AssessmentTemplateVo>> pageList = assessmentManagementService.assessmentTemplatePaginationDisplay(assessmentTemplatePage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "删除考核模板")
    //@RequiresPermissions("/hr/AssessmentManagement/deleteAssessmentTemplate")
	@ApiOperation(value = "删除考核模板", notes = "删除考核模板")
    @RequestMapping(value = "/deleteAssessmentTemplate", method = RequestMethod.POST)
	public Result deleteAssessmentTemplate(@Validated @RequestBody AssessmentTemplatePage assessmentTemplatePage){	
		assessmentManagementService.deleteAssessmentTemplate(assessmentTemplatePage);
		return new Result();
	}
	
	@ControllerLog(doAction = "考核模板详情")
    //@RequiresPermissions("/hr/AssessmentManagement/assessmentTemplateDetails")
	@ApiOperation(value = "考核模板详情", notes = "考核模板详情")
    @RequestMapping(value = "/assessmentTemplateDetails", method = RequestMethod.POST)
	public Result<AssessmentTemplateVo> assessmentTemplateDetails(@Validated @RequestBody AssessmentTemplatePage assessmentTemplatePage){	
		AssessmentTemplateVo assessment = assessmentManagementService.assessmentTemplateDetails(assessmentTemplatePage);
		return new Result(assessment);
	}
	
	//添加考核模板
	@ControllerLog(doAction = "添加考核模板")
    //@RequiresPermissions("/hr/AssessmentManagement/addAssessmentTemplate")
	@ApiOperation(value = "添加考核模板", notes = "添加考核模板")
    @RequestMapping(value = "/addAssessmentTemplate", method = RequestMethod.POST)
	public Result addAssessmentTemplate(@Validated @RequestBody AssessmentTemplatePage assessmentTemplatePage){	
		//List<AssessmentTemplateDetailAdd> recordList = assessmentTemplatePage.getRecordList();
		assessmentManagementService.addAssessmentTemplate(assessmentTemplatePage);
		return new Result();
	}
}
