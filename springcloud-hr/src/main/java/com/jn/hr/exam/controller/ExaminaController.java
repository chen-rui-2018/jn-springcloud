package com.jn.hr.exam.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.exam.model.ExaminaManagement;
import com.jn.hr.exam.model.ExaminaManagementAdd;
import com.jn.hr.exam.model.ExaminaManagementPage;
import com.jn.hr.exam.model.ExaminaResultPage;
import com.jn.hr.exam.model.Examinabank;
import com.jn.hr.exam.model.ExaminabankAdd;
import com.jn.hr.exam.model.ExaminabankPage;
import com.jn.hr.exam.service.ExaminaService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * 在线考试管理
 *
 * @author： wangtt
 * @date：Created on  2019/04/15 04:15 
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "在线考试管理")
@RestController
@RequestMapping("/hr/exam")
public class ExaminaController extends BaseController {
	@Autowired
	private ExaminaService examinaService;

	@ControllerLog(doAction = "试题库分页显示")
	@RequiresPermissions("/hr/exam/selectBankList")
	@ApiOperation(value = "试题库分页显示", notes = "试题库分页显示功能")
	@RequestMapping(value = "/selectBankList", method = RequestMethod.POST)
	public Result<PaginationData<List<ExaminabankAdd>>> selectBankList(@Validated @RequestBody ExaminabankPage page) {
		PaginationData<List<ExaminabankAdd>> data = examinaService.selectBankList(page);
		return new Result(data);
	}

	@ControllerLog(doAction = "导出试题库列表")
	@RequiresPermissions("/hr/exam/exportExaminabank")
	@ApiOperation(value = "导出试题库列表", notes = "导出试题库列表")
	@RequestMapping(value = "/exportExaminabank", method = RequestMethod.GET)
	public Result exportExaminabank(ExaminabankPage page, HttpServletResponse response) {
		page.setPage(1);
		page.setRows(200000);
		PaginationData<List<ExaminabankAdd>> pageList = examinaService.selectBankList(page);
		String exportTitle = "试题内容,题型,试题难度,标准答案,分数,创建时间";
		String exportColName = "examinationQuestion,testQuestionTypeStr,examinationDifficultyStr,standardAnswer,fraction,createdTimeStr";
		String fileName = "试题库列表" + DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		String sheetName = "试题库列表";
		ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
		return new Result();
	}

	@ControllerLog(doAction = "新增试题")
	@RequiresPermissions("/hr/exam/addExaminaBank")
	@ApiOperation(value = "新增试题", notes = "新增试题功能")
	@RequestMapping(value = "/addExaminaBank", method = RequestMethod.POST)
	public Result<ExaminabankAdd> addInvestiage(@Validated @RequestBody ExaminabankAdd add) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		ExaminabankAdd examinabankAdd = examinaService.addExaminaBank(add, user);
		return new Result(examinabankAdd);
	}

	@ControllerLog(doAction = "查询试题详情")
	@RequiresPermissions("/hr/exam/selectExaminabank")
	@ApiOperation(value = "查询试题详情", notes = "查询试题详情功能")
	@RequestMapping(value = "/selectExaminabank", method = RequestMethod.POST)
	public Result<ExaminabankAdd> selectExaminabank(@Validated @RequestBody Examinabank examinabank) {
		ExaminabankAdd data = examinaService.selectExaminabank(examinabank.getTestQuestionId());
		return new Result(data);
	}

	@ControllerLog(doAction = "修改题目及答案")
	@RequiresPermissions("/hr/exam/updateExaminabank")
	@ApiOperation(value = "修改题目及答案", notes = "[试题库]修改题目及答案功能")
	@RequestMapping(value = "/updateExaminabank", method = RequestMethod.POST)
	public Result updateExaminabank(@Validated @RequestBody Examinabank examinabank) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 编辑调研项目
		examinaService.updateExaminabank(examinabank, user);
		return new Result();
	}

	@ControllerLog(doAction = "删除试题")
	@RequiresPermissions("/hr/exam/deleteExaminaBank")
	@ApiOperation(value = "删除试题", notes = "删除试题功能")
	@RequestMapping(value = "/deleteExaminaBank", method = RequestMethod.POST)
	public Result deleteExaminaBank(@Validated @RequestBody Examinabank examinabank) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		examinaService.deleteExaminaBank(examinabank.getTestQuestionId(), user);
		return new Result();
	}

	@ControllerLog(doAction = "登录考试")
	@RequiresPermissions("/hr/exam/loginManagement")
	@ApiOperation(value = "登录考试", notes = "登录考试功能")
	@RequestMapping(value = "/loginManagement", method = RequestMethod.POST)
	public Result<ExaminaManagementAdd> loginManagement(@Validated @RequestBody ExaminaManagement management) {
		ExaminaManagementAdd data = examinaService.loginManagement(management);
		return new Result(data);
	}

	@ControllerLog(doAction = "提交答案")
	@RequiresPermissions("/hr/exam/insterAnswerCard")
	@ApiOperation(value = "提交答案", notes = "提交答案功能")
	@RequestMapping(value = "/insterAnswerCard", method = RequestMethod.POST)
	public Result<ExaminaManagementAdd> insterAnswerCard(@Validated @RequestBody ExaminaManagement examinaManagement) {
		ExaminaManagementAdd data = examinaService.insterAnswerCard(examinaManagement);
		return new Result(data);
	}

	@ControllerLog(doAction = "更新成绩")
	@RequiresPermissions("/hr/exam/updateResult")
	@ApiOperation(value = "更新成绩", notes = "更新成绩功能")
	@RequestMapping(value = "/updateResult", method = RequestMethod.POST)
	public Result updateResult(@Validated @RequestBody ExaminaManagement examinaManagement) {
		examinaService.updateResult(examinaManagement);
		return new Result();
	}

	@ControllerLog(doAction = "删除成绩")
	@RequiresPermissions("/hr/exam/deleteResult")
	@ApiOperation(value = "删除成绩", notes = "删除成绩功能")
	@RequestMapping(value = "/deleteResult", method = RequestMethod.POST)
	public Result deleteResult(@Validated @RequestBody ExaminaManagement examinaManagement) {
		examinaService.deleteResult(examinaManagement);
		return new Result();
	}

	@ControllerLog(doAction = "分页查看成绩")
	@RequiresPermissions("/hr/exam/selectResultList")
	@ApiOperation(value = "分页查看成绩", notes = "分页查看成绩功能")
	@RequestMapping(value = "/selectResultList", method = RequestMethod.POST)
	public Result<PaginationData<List<ExaminaManagement>>> selectResultList(
			@Validated @RequestBody ExaminaResultPage page) {
		PaginationData<List<ExaminaManagement>> data = examinaService.selectResultList(page);
		return new Result(data);
	}

	@ControllerLog(doAction = "导出成绩列表")
	@RequiresPermissions("/hr/exam/exportResultList")
	@ApiOperation(value = "导出成绩列表", notes = "导出成绩列表")
	@RequestMapping(value = "/exportResultList", method = RequestMethod.GET)
	public Result exportResultList(ExaminaResultPage page, HttpServletResponse response) {
		page.setPage(1);
		page.setRows(200000);
		PaginationData<List<ExaminaManagement>> pageList = examinaService.selectResultList(page);
		String exportTitle = "姓名,开始时间/交卷时间,用时,总分/及格分数,成绩,是否通过,考试方式,排名";
		String exportColName = "name,examinaStartEndTimeStr,useTime,totalAndPassScore,achievement,isAdoptStr,examinaMethodStr,rank";
		String fileName = "考试成绩列表" + DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		String sheetName = "考试成绩列表";
		ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, pageList.getRows());
		return new Result();
	}

	@ControllerLog(doAction = "分页查询试卷列表")
	@RequiresPermissions("/hr/exam/selectExaminaManagementList")
	@ApiOperation(value = "分页查询试卷列表", notes = "分页查询试卷列表功能")
	@RequestMapping(value = "/selectExaminaManagementList", method = RequestMethod.POST)
	public Result<PaginationData<List<ExaminaManagementAdd>>> selectExaminaManagementList(
			@Validated @RequestBody ExaminaManagementPage page) {
		PaginationData<List<ExaminaManagementAdd>> data = examinaService.selectExaminaManagementList(page);
		return new Result(data);
	}

	@ControllerLog(doAction = "查询试题及答题详情")
	@RequiresPermissions("/hr/exam/selectExamAndAnswerCard")
	@ApiOperation(value = "查询试题及答题详情", notes = "查询试题及答题详情功能")
	@RequestMapping(value = "/selectExamAndAnswerCard", method = RequestMethod.POST)
	public Result<ExaminaManagementAdd> selectExamAndAnswerCard(
			@Validated @RequestBody ExaminaManagement examinaManagement) {
		ExaminaManagementAdd data = examinaService.selectExamAndAnswerCard(examinaManagement);
		return new Result(data);
	}

	@ControllerLog(doAction = "查询试卷详情")
	@RequiresPermissions("/hr/exam/selectExamInfo")
	@ApiOperation(value = "查询试卷详情", notes = "查询试卷详情功能")
	@RequestMapping(value = "/selectExamInfo", method = RequestMethod.POST)
	public Result<ExaminaManagementAdd> selectExamInfo(@Validated @RequestBody ExaminaManagement examinaManagement) {
		ExaminaManagementAdd data = examinaService.selectExamInfo(examinaManagement.getId());
		return new Result(data);
	}

	@ControllerLog(doAction = "编辑试卷")
	@RequiresPermissions("/hr/exam/updateExamInfo")
	@ApiOperation(value = "编辑试卷", notes = "编辑试卷功能")
	@RequestMapping(value = "/updateExamInfo", method = RequestMethod.POST)
	public Result updateExamInfo(@Validated @RequestBody ExaminaManagement examinaManagement) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		examinaService.updateExamInfo(examinaManagement, user);
		return new Result();
	}

	@ControllerLog(doAction = "新增/编辑试卷")
	@RequiresPermissions("/hr/exam/addExaminaManagement")
	@ApiOperation(value = "新增/编辑试卷", notes = "新增/编辑试卷功能")
	@RequestMapping(value = "/addExaminaManagement", method = RequestMethod.POST)
	public Result<ExaminaManagement> addExaminaManagement(@Validated @RequestBody ExaminaManagement add) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		ExaminaManagement data = examinaService.addExaminaManagement(add, user);
		return new Result(data);
	}

	@ControllerLog(doAction = "删除试卷")
	@RequiresPermissions("/hr/exam/deleteExamInfo")
	@ApiOperation(value = "删除试卷", notes = "删除试卷功能")
	@RequestMapping(value = "/deleteExamInfo", method = RequestMethod.POST)
	public Result deleteExamInfo(@Validated @RequestBody ExaminaManagement add) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		examinaService.deleteExamInfo(add, user);
		return new Result();
	}

	@ControllerLog(doAction = "发布考试")
	@RequiresPermissions("/hr/exam/sendExaminaManagement")
	@ApiOperation(value = "发布考试", notes = "发布考试功能")
	@RequestMapping(value = "/sendExaminaManagement", method = RequestMethod.POST)
	public Result sendExaminaManagement(@Validated @RequestBody ExaminaManagement examinaManagement) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		examinaService.sendExaminaManagement(examinaManagement, user);
		return new Result();
	}

}
