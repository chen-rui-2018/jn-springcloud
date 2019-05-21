package com.jn.hr.train.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.train.model.Management;
import com.jn.hr.train.model.ManagementAdd;
import com.jn.hr.train.model.ManagementPage;
import com.jn.hr.train.model.TrainDepartment;
import com.jn.hr.train.service.TrainService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

/**
 * 培训列表管理
 *
 * @author： wangtt
 * @date：Created on  2019/04/15 04:15 
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "培训列表管理")
@RestController
@RequestMapping("/hr/train/list")
public class TrainController extends BaseController {
	@Autowired
	private TrainService trainService;

	@ControllerLog(doAction = "获取通知人员列表")
	// @RequiresPermissions("/hr/train/list/selectUserList")
	@ApiOperation(value = "获取通知人员列表", notes = "[培训列表]获取通知人员列表功能")
	@RequestMapping(value = "/selectUserList", method = RequestMethod.POST)
	public Result<List<TrainDepartment>> selectUserList() {
		List<TrainDepartment> data = trainService.selectUserList();
		return new Result(data);
	}

	@ControllerLog(doAction = "分页查询培训列表")
	// @RequiresPermissions("/hr/train/list/managementList")
	@ApiOperation(value = "分页查询培训列表", notes = "[培训列表]培训列表功能")
	@RequestMapping(value = "/managementList", method = RequestMethod.POST)
	public Result<PaginationData<List<Management>>> managementList(
			@Validated @RequestBody ManagementPage managementPage) {
		PaginationData<List<Management>> data = trainService.managementList(managementPage);
		return new Result(data);
	}

	@ControllerLog(doAction = "分页查询培训记录")
	// @RequiresPermissions("/hr/train/list/managemenRecordtList")
	@ApiOperation(value = "分页查询培训记录", notes = "[培训列表]培训记录功能")
	@RequestMapping(value = "/managemenRecordtList", method = RequestMethod.POST)
	public Result<PaginationData<List<Management>>> managemenRecordtList(
			@Validated @RequestBody ManagementPage managementPage) {
		PaginationData<List<Management>> data = trainService.managemenRecordtList(managementPage);
		return new Result(data);
	}

	@ControllerLog(doAction = "导出培训记录")
	// @RequiresPermissions("/hr/train/list/exportManagement")
	@ApiOperation(value = "导出培训记录", notes = "导出培训记录")
	@RequestMapping(value = "/exportManagement", method = RequestMethod.GET)
	public void exportManagement(ManagementPage managementPage, HttpServletResponse response) {
		managementPage.setPage(1);
		managementPage.setRows(200000);
		PaginationData<List<Management>> pageList = trainService.managemenRecordtList(managementPage);
		String exportTitle = "部门,姓名,课程名称,培训开始时间,培训结束时间,培训老师,发布人,发布时间";
		String exportColName = "trainerDepartment,trainerName,courseTitle,"
				+ "trainStartTimeStr,trainEndTimeStr,trainTeacher,modifierAccount,modifiedTimeStr";
		String fileName = "培训记录" + DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		String sheetName = "培训记录";
		ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
	}

	@ControllerLog(doAction = "课程详情")
	// @RequiresPermissions("/hr/train/list/selectManagement")
	@ApiOperation(value = "课程详情", notes = "[培训列表]课程详情功能")
	@RequestMapping(value = "/selectManagement", method = RequestMethod.POST)
	public Result<ManagementAdd> selectManagement(@Validated @RequestBody Management management) {
		ManagementAdd data = trainService.selectManagement(management);
		return new Result(data);
	}

	@ControllerLog(doAction = "新建课程")
	// @RequiresPermissions("/hr/train/list/addManagement")
	@ApiOperation(value = "新建课程", notes = "[培训列表]制定课程功能")
	@RequestMapping(value = "/addManagement", method = RequestMethod.POST)
	public Result<String> addManagement(@Validated @RequestBody ManagementAdd managementAdd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 新增设置课程编号
		if (StringUtils.isBlank(managementAdd.getId())) {
			managementAdd.setId(UUID.randomUUID().toString());
		}
		String data = trainService.addManagement(managementAdd, user);
		return new Result(data);
	}

	@ControllerLog(doAction = "修改课程")
	// @RequiresPermissions("/hr/train/list/updateManagement")
	@ApiOperation(value = "修改课程", notes = "[培训列表]修改功能")
	@RequestMapping(value = "/updateManagement", method = RequestMethod.POST)
	public Result updateManagement(@Validated @RequestBody Management management) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 编辑调研项目
		trainService.updateManagement(management, user);
		return new Result();
	}

	@ControllerLog(doAction = "结束课程")
	// @RequiresPermissions("/hr/train/list/deleteManagement")
	@ApiOperation(value = "结束课程", notes = "[培训列表]删除功能")
	@RequestMapping(value = "/deleteManagement", method = RequestMethod.POST)
	public Result deleteManagement(@Validated @RequestBody Management management) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		trainService.deleteManagement(management, user);
		return new Result();
	}

	@ControllerLog(doAction = "邮件发送培训通知")
	// @RequiresPermissions("/hr/train/list/emailList")
	@ApiOperation(value = "邮件发送培训通知", notes = "发送通知功能")
	@RequestMapping(value = "/emailList", method = RequestMethod.POST)
	public Result emailList(@Validated @RequestBody Management management) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		trainService.sendEmail(management, user);
		return new Result();
	}
}
