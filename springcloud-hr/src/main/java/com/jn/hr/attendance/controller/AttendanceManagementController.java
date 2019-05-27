package com.jn.hr.attendance.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.jn.common.util.Assert;
import com.jn.hr.model.AttendanceManageApiVo;
import com.jn.hr.model.AttendanceManagement;
import com.jn.hr.model.AttendanceManagementApiVo;
import com.jn.hr.model.VacationManagement;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.jn.common.util.DateUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.attendance.model.AttendanceManagementPage;
import com.jn.hr.attendance.model.AttendanceManagementVo;
import com.jn.hr.attendance.model.AttendanceSchedulAdd;
import com.jn.hr.attendance.model.AttendanceSchedulPage;
import com.jn.hr.attendance.model.AttendanceSchedulVo;
import com.jn.hr.attendance.model.AttendanceTimeSetAdd;
import com.jn.hr.attendance.model.AttendanceTimeSetVo;
import com.jn.hr.attendance.service.AttendanceManagementService;
import com.jn.hr.increase.enums.SalaryManagementExceptionEnums;
import com.jn.oa.api.OaClient;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "考勤管理")
@RestController
@RequestMapping("/hr/AttendanceManagement")
public class AttendanceManagementController extends BaseController{
       //OaClient
	private static final Logger logger = LoggerFactory.getLogger(AttendanceManagementController.class);
	@Autowired
    private ResourceLoader resourceLoader;
	@Autowired
	private AttendanceManagementService attendanceManagementService;
	@Autowired
	OaClient OaClient;
	
	@ControllerLog(doAction = "考勤管理分页查询")
    @RequiresPermissions("/hr/AttendanceManagement/attendanceManagementList")
	@ApiOperation(value = "考勤管理分页查询", notes = "考勤管理分页查询")
    @RequestMapping(value = "/attendanceManagementList", method = RequestMethod.POST)
	public Result<PaginationData<List<AttendanceManagementVo>>> attendanceManagementList(@Validated @RequestBody AttendanceManagementPage attendanceManagementPage){
		PaginationData<List<AttendanceManagementVo>> pageList = attendanceManagementService.attendanceManagementList(attendanceManagementPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "导出考勤列表")
    @RequiresPermissions("/hr/AttendanceManagement/exportAttendanceManagement")
	@ApiOperation(value = "导出考勤列表", notes = "导出考勤列表")
    @RequestMapping(value = "/exportAttendanceManagement", method = RequestMethod.GET)
	public void exportAttendanceManagement(AttendanceManagementPage attendanceManagementPage , HttpServletResponse response){
		attendanceManagementPage.setPage(1);
		attendanceManagementPage.setRows(200000);
		PaginationData<List<AttendanceManagementVo>> pageList = attendanceManagementService.exportAttendanceManagement(attendanceManagementPage);
		String exportTitle = "工号,部门,姓名,出勤（天）,迟到（次数）,早退（次数）,上班缺卡数,下班缺卡数,旷工(时),事假(时),病假（时）,婚假（时）,丧假（时）,产假（时）,年休假（时）,考勤日期";
		String exportColName = "jobNumber,department,name,attendance,late,leaveEarly,startMissCard,endMissCard,absenteeism,compassionateLeave,sickLeave,marriageHoliday,funeralLeave,"+
		                       "maternityLeave,annualLeave,attendanceDate";
       String fileName = "考勤信息"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "考勤信息";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
	}
	
	@ControllerLog(doAction = "旷工明细")
    @RequiresPermissions("/hr/AttendanceManagement/absenceDetailList")
	@ApiOperation(value = "旷工明细", notes = "旷工明细")
    @RequestMapping(value = "/absenceDetailList", method = RequestMethod.POST)
	public Result<List<AttendanceManagementVo>> absenceDetailList(@Validated @RequestBody AttendanceManagementPage attendanceManagementPage){
		List<AttendanceManagementVo> pageList = attendanceManagementService.absenceDetailList(attendanceManagementPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "导出旷工明细")
    @RequiresPermissions("/hr/AttendanceManagement/exportAbsenceDetailList")
	@ApiOperation(value = "导出旷工明细", notes = "导出旷工明细")
    @RequestMapping(value = "/exportAbsenceDetailList", method = RequestMethod.GET)
	public void exportAbsenceDetailList( AttendanceManagementPage attendanceManagementPage, HttpServletResponse response){
		List<AttendanceManagementVo> pageList = attendanceManagementService.absenceDetailList(attendanceManagementPage);
		String exportTitle = "部门,姓名,日期";
		String exportColName = "department,name,absenceDate";
       String fileName = "旷工明细"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "旷工明细";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList);
	}
	
	@ControllerLog(doAction = "迟到明细")
    @RequiresPermissions("/hr/AttendanceManagement/comeLateDetailList")
	@ApiOperation(value = "迟到明细", notes = "迟到明细")
    @RequestMapping(value = "/comeLateDetailList", method = RequestMethod.POST)
	public Result<List<AttendanceManagementVo>> comeLateDetailList(@Validated @RequestBody AttendanceManagementPage attendanceManagementPage){
		List<AttendanceManagementVo> pageList = attendanceManagementService.comeLateDetailList(attendanceManagementPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "导出迟到明细")
    @RequiresPermissions("/hr/AttendanceManagement/exportComeLateDetailList")
	@ApiOperation(value = "导出迟到明细", notes = "导出迟到明细")
    @RequestMapping(value = "/exportComeLateDetailList", method = RequestMethod.GET)
	public void exportComeLateDetailList(AttendanceManagementPage attendanceManagementPage, HttpServletResponse response){
		List<AttendanceManagementVo> pageList = attendanceManagementService.comeLateDetailList(attendanceManagementPage);
		String exportTitle = "部门,姓名,日期,签到时间";
		String exportColName = "department,name,absenceDate,signInAttendanceTime";
       String fileName = "迟到明细"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "迟到明细";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList);
	}
	
	@ControllerLog(doAction = "早退明细")
    @RequiresPermissions("/hr/AttendanceManagement/leaveEarlyDetailList")
	@ApiOperation(value = "早退明细", notes = "早退明细")
    @RequestMapping(value = "/leaveEarlyDetailList", method = RequestMethod.POST)
	public Result<List<AttendanceManagementVo>> leaveEarlyDetailList(@Validated @RequestBody AttendanceManagementPage attendanceManagementPage){
		List<AttendanceManagementVo> pageList = attendanceManagementService.leaveEarlyDetailList(attendanceManagementPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "导出早退明细")
    @RequiresPermissions("/hr/AttendanceManagement/exportLeaveEarlyDetailList")
	@ApiOperation(value = "导出早退明细", notes = "导出早退明细")
    @RequestMapping(value = "/exportLeaveEarlyDetailList", method = RequestMethod.GET)
	public void exportLeaveEarlyDetailList(AttendanceManagementPage attendanceManagementPage, HttpServletResponse response){
		List<AttendanceManagementVo> pageList = attendanceManagementService.leaveEarlyDetailList(attendanceManagementPage);
		String exportTitle = "部门,姓名,日期,签退时间";
		String exportColName = "department,name,absenceDate,signOutAttendanceTime";
       String fileName = "早退明细"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "早退明细";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList);
	}
	
	@ControllerLog(doAction = "缺卡明细")
    @RequiresPermissions("/hr/AttendanceManagement/notCardDetailList")
	@ApiOperation(value = "缺卡明细", notes = "缺卡明细")
    @RequestMapping(value = "/notCardDetailList", method = RequestMethod.POST)
	public Result<List<AttendanceManagementVo>> notCardDetailList(@Validated @RequestBody AttendanceManagementPage attendanceManagementPage){
		List<AttendanceManagementVo> pageList = attendanceManagementService.notCardDetailList(attendanceManagementPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "导出缺卡明细")
    @RequiresPermissions("/hr/AttendanceManagement/exportNotCardDetailList")
	@ApiOperation(value = "导出缺卡明细", notes = "导出缺卡明细")
    @RequestMapping(value = "/exportNotCardDetailList", method = RequestMethod.GET)
	public void exportNotCardDetailList(AttendanceManagementPage attendanceManagementPage, HttpServletResponse response){
		List<AttendanceManagementVo> pageList = attendanceManagementService.notCardDetailList(attendanceManagementPage);
		String exportTitle = "部门,姓名,日期,状态";
		String exportColName = "department,name,absenceDate,workStatus";
       String fileName = "缺卡明细"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "缺卡明细";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList);
	}
	
	@ControllerLog(doAction = "请假明细")
    @RequiresPermissions("/hr/AttendanceManagement/leaveDetailist")
	@ApiOperation(value = "请假明细", notes = "请假明细")
    @RequestMapping(value = "/leaveDetailist", method = RequestMethod.POST)
	public Result<List<AttendanceManagementVo>> leaveDetailist(@Validated @RequestBody AttendanceManagementPage attendanceManagementPage){
		List<AttendanceManagementVo> pageList = attendanceManagementService.leaveDetailist(attendanceManagementPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "导出请假明细")
    @RequiresPermissions("/hr/AttendanceManagement/exportLeaveDetailist")
	@ApiOperation(value = "导出请假明细", notes = "导出请假明细")
    @RequestMapping(value = "/exportLeaveDetailist", method = RequestMethod.GET)
	public void exportLeaveDetailist(AttendanceManagementPage attendanceManagementPage, HttpServletResponse response){
		List<AttendanceManagementVo> pageList = attendanceManagementService.leaveDetailist(attendanceManagementPage);
		String exportTitle = "部门,姓名,开始时间,结束时间,审核状态,请假天数,请假类型";
		String exportColName = "department,name,startTime,endTime,reviewStatus,totalDay,type";
       String fileName = "请假明细"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "请假明细";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList);
	}
	
	@ControllerLog(doAction = "添加班次")
    @RequiresPermissions("/hr/AttendanceManagement/addAttendanceTimeSet")
	@ApiOperation(value = "添加班次", notes = "添加班次")
    @RequestMapping(value = "/addAttendanceTimeSet", method = RequestMethod.POST)
	public Result addAttendanceTimeSet(@Validated @RequestBody AttendanceTimeSetAdd record){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		attendanceManagementService.addAttendanceTimeSet(record,user);
		return new Result();
	}
	
	@ControllerLog(doAction = "修改班次")
    @RequiresPermissions("/hr/AttendanceManagement/updateAttendanceTimeSet")
	@ApiOperation(value = "修改班次", notes = "修改班次")
    @RequestMapping(value = "/updateAttendanceTimeSet", method = RequestMethod.POST)
	public Result updateAttendanceTimeSet(@Validated @RequestBody AttendanceTimeSetAdd attendanceTimeSetAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		attendanceManagementService.updateAttendanceTimeSet(attendanceTimeSetAdd,user);
		return new Result();
	}
	
	@ControllerLog(doAction = "删除班次")
    @RequiresPermissions("/hr/AttendanceManagement/deleteAttendanceTimeSet")
	@ApiOperation(value = "删除班次", notes = "删除班次")
    @RequestMapping(value = "/deleteAttendanceTimeSet", method = RequestMethod.POST)
	public Result deleteAttendanceTimeSet(@Validated @RequestBody AttendanceTimeSetAdd attendanceTimeSetAdd){
		attendanceManagementService.deleteAttendanceTimeSet(attendanceTimeSetAdd);
		return new Result();
	}
	
	@ControllerLog(doAction = "查询班次")
    @RequiresPermissions("/hr/AttendanceManagement/attendanceTimeSetList")
	@ApiOperation(value = "查询班次", notes = "查询班次")
    @RequestMapping(value = "/attendanceTimeSetList", method = RequestMethod.POST)
	public Result<List<AttendanceTimeSetVo>> attendanceTimeSetList(){
		List<AttendanceTimeSetVo> timeSetList = attendanceManagementService.AttendanceTimeSetList();
		return new Result(timeSetList);
	}
	
	@ControllerLog(doAction = "排班管理页面查询")
    @RequiresPermissions("/hr/AttendanceManagement/scheduDetailistPage")
	@ApiOperation(value = "排班管理页面查询", notes = "排班管理页面查询")
    @RequestMapping(value = "/scheduDetailistPage", method = RequestMethod.POST)
	public Result<PaginationData<List<AttendanceSchedulVo>>> scheduDetailistPage(@Validated @RequestBody AttendanceSchedulPage attendanceSchedulPage){
		PaginationData<List<AttendanceSchedulVo>> pageList = attendanceManagementService.scheduDetailistPage(attendanceSchedulPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "导入排班管理")
    @RequiresPermissions("/hr/AttendanceManagement/importScheduDetailist")
	@ApiOperation(value = "导入排班管理", notes = "导入排班管理")
    @RequestMapping(value = "/importScheduDetailist", method = RequestMethod.POST)
	public Result<String> importScheduDetailist(@RequestParam("file") MultipartFile file){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String str = attendanceManagementService.importScheduDetailist(file,user);
		return new Result(str);
	}
	
	@ControllerLog(doAction = "排班明细页面查询")
    @RequiresPermissions("/hr/AttendanceManagement/scheduDetailist")
	@ApiOperation(value = "排班明细页面查询", notes = "排班明细页面查询")
    @RequestMapping(value = "/scheduDetailist", method = RequestMethod.POST)
	public Result<PaginationData<List<AttendanceSchedulVo>>> scheduDetailist(@Validated @RequestBody AttendanceSchedulPage attendanceSchedulPage){
		PaginationData<List<AttendanceSchedulVo>> pageList = attendanceManagementService.scheduDetailist(attendanceSchedulPage);
		return new Result(pageList);
	}
	
	@ControllerLog(doAction = "排班明细导出")
    @RequiresPermissions("/hr/AttendanceManagement/exportScheduDetailist")
	@ApiOperation(value = "排班明细导出", notes = "排班明细导出")
    @RequestMapping(value = "/exportScheduDetailist", method = RequestMethod.GET)
	public void exportScheduDetailist(AttendanceSchedulPage attendanceSchedulPage,HttpServletResponse response){
		PaginationData<List<AttendanceSchedulVo>> pageList = attendanceManagementService.exportScheduDetailist(attendanceSchedulPage);
		String exportTitle = "排班月份,部门ID,部门名称,工号,姓名,1号,2号,3号,4号,5号,6号,7号,8号,9号,10号,11号,12号,13号,14号,15号,16号,17号,18号,19号,20号,21号,22号,23号,24号,25号,26号,27号,28号,29号,30号,31号";
		String exportColName = "schedulMonth,departmentId,departmentName,jobNumber,name,number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,number11,"+ 
		"number12,number13,number14,number15,number16,number17,number18,number19,number20,number21,number22,number23,number24,number25,number26,number27,number28,number29,number30,number31";
       String fileName = "排班明细"+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
       String sheetName = "排班明细";
       ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
	}
	
	@ControllerLog(doAction = "修改排班明细")
    @RequiresPermissions("/hr/AttendanceManagement/updateScheduDetailist")
	@ApiOperation(value = "修改排班明细", notes = "修改排班明细")
    @RequestMapping(value = "/updateScheduDetailist", method = RequestMethod.POST)
	public Result updateScheduDetailist(@Validated @RequestBody  AttendanceSchedulAdd attendanceSchedulAdd){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		List<AttendanceSchedulPage> records = attendanceSchedulAdd.getAttendanceSchedulList();
		attendanceManagementService.updateScheduDetailist(records,user);
		return new Result();
	}
	
	@ControllerLog(doAction = "下载排班明细表excel模板")
    @RequiresPermissions("/hr/AttendanceManagement/downLoadAttendanceSchdulExcelTemplate")
    @ApiOperation(value = "下载排班明细表excel模板", notes = "下载排班明细表excel模板")
    @RequestMapping(value = "/downLoadAttendanceSchdulExcelTemplate", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downLoadAttendanceSchdulExcelTemplate() {
        try {
            Resource resource = resourceLoader.getResource("classpath:excelTemplate/attendanceSchdulTemplate.xlsx");
            File file = resource.getFile();
            String name = "排班明细表导入模板" + ExcelTypeEnum.XLSX.getValue();
            String fileName = new String(name.getBytes(), "ISO-8859-1");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/octet-stream");
            headers.add("Content-Disposition", "attachment;filename=" + fileName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("[排班明细表] ,排班明细表导入模板下载失败", e);
            throw new JnSpringCloudException(SalaryManagementExceptionEnums.DOWNLOAD_EXCEL_TEMPLATE_FAIL);
        }
    }

    @ControllerLog(doAction = "根据用户id与考勤年月查询历史考勤列表")
    @RequiresPermissions("/hr/AttendanceManagement/selectAttendanceManagementByUserId")
	@ApiOperation(value = "根据用户id与考勤年月查询历史考勤列表", notes = "根据用户id与考勤年月查询历史考勤列表")
    @RequestMapping(value = "/selectAttendanceManagementByUserId", method = RequestMethod.POST)
	public Result<List<AttendanceManagementApiVo>> selectAttendanceManagementByUserId(@Validated @RequestBody AttendanceManagement attendanceManagement){
    	Assert.notNull(attendanceManagement.getUserId(),"用户ID不能为空");
		Assert.notNull(attendanceManagement.getAttendanceMonth(),"考勤月份不能为空");
    	List<AttendanceManagementApiVo> list = attendanceManagementService.selectAttendanceManagementByUserId(attendanceManagement);
		return new Result(list);
	}
    
    @ControllerLog(doAction = "根据部门id与考勤年月查询历史考勤列表")
    @RequiresPermissions("/hr/AttendanceManagement/selectAttendanceManagementByDepartmentId")
	@ApiOperation(value = "根据部门id与考勤年月查询历史考勤列表", notes = "根据部门id与考勤年月查询历史考勤列表")
    @RequestMapping(value = "/selectAttendanceManagementByDepartmentId", method = RequestMethod.POST)
	public Result<AttendanceManageApiVo> selectAttendanceManagementByDepartmentId(@Validated @RequestBody  AttendanceManagement attendanceManagement){
    	Assert.notNull(attendanceManagement.getAttendanceMonth(),"考勤月份不能为空");
		AttendanceManageApiVo attendanceManageApiVo = attendanceManagementService.selectAttendanceManagementByDepartmentId(attendanceManagement);
		return new Result(attendanceManageApiVo);
	}

    @ControllerLog(doAction = "加班小时")
    @RequiresPermissions("/hr/AttendanceManagement/insertByOverTimeVacationmanage")
	@ApiOperation(value = "加班小时", notes = "加班小时")
    @RequestMapping(value = "/insertByOverTimeVacationmanage", method = RequestMethod.POST)
	public Result<String> insertByOverTimeVacationmanage(@Validated @RequestBody VacationManagement vacationManage){
    	Assert.notNull(vacationManage.getUserId(),"用户ID不能为空");
		Assert.notNull(vacationManage.getVacationType(),"请假类型不能为空");
		Assert.notNull(vacationManage.getVacationTime(),"请假时间不能为空");
    	String str = attendanceManagementService.insertByOverTimeVacationmanage(vacationManage);
		return new Result(str);
	}
    
    @ControllerLog(doAction = "请假扣除请假小时")
    @RequiresPermissions("/hr/AttendanceManagement/insertByLeaveVacationmanage")
	@ApiOperation(value = "请假扣除请假小时", notes = "请假扣除请假小时")
    @RequestMapping(value = "/insertByLeaveVacationmanage", method = RequestMethod.POST)
	public Result<String> insertByLeaveVacationmanage(@Validated @RequestBody  VacationManagement vacationManage){
    	Assert.notNull(vacationManage.getUserId(),"用户ID不能为空");
		Assert.notNull(vacationManage.getVacationType(),"请假类型不能为空");
		Assert.notNull(vacationManage.getVacationTime(),"请假时间不能为空");
    	String str = attendanceManagementService.insertByLeaveVacationmanage(vacationManage);
		return new Result(str);
	}
}
