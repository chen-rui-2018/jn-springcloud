package com.jn.hr.train.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.hr.train.model.Investigate;
import com.jn.hr.train.model.InvestigateAdd;
import com.jn.hr.train.model.InvestigatePage;
import com.jn.hr.train.model.InvestigateQuestion;
import com.jn.hr.train.model.ResearchSet;
import com.jn.hr.train.model.ResearchSetAdd;
import com.jn.hr.train.model.ResultAnswerAdd;
import com.jn.hr.train.model.SurveyResultPage;
import com.jn.hr.train.service.TrainInvestigateService;
import com.jn.hr.train.vo.AnswerVo;
import com.jn.hr.train.vo.InvestigatesVo;
import com.jn.hr.train.vo.SurveyResultVo;
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

import java.util.List;
import java.util.UUID;

/**
 * 调研分析管理
 *
 * @author： wangtt
 * @date：Created on  2019/04/15 04:15 
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "调研分析管理")
@RestController
@RequestMapping("/hr/train")
public class TrainInvestigateController extends BaseController {
	@Autowired
	private TrainInvestigateService investigateService;

	@ControllerLog(doAction = "调研分析-列表显示")
	@RequiresPermissions("/hr/train/listInvestigate")
	@ApiOperation(value = "调研项目信息列表", notes = "调研分析功能")
	@RequestMapping(value = "/listInvestigate", method = RequestMethod.POST)
	public Result<PaginationData<List<InvestigatesVo>>> listInvestigate(
			@Validated @RequestBody InvestigatePage investigatePage) {
		PaginationData<List<InvestigatesVo>> data = investigateService.list(investigatePage);
		return new Result(data);
	}

	@ControllerLog(doAction = "项目详情")
	@RequiresPermissions("/hr/train/selectInvestigate")
	@ApiOperation(value = "项目详情", notes = "调研分析-项目详情功能")
	@RequestMapping(value = "/selectInvestigate", method = RequestMethod.POST)
	public Result<InvestigatesVo> selectInvestigate(@Validated @RequestBody Investigate investigate) {
		InvestigatesVo data = investigateService.selectInvestigate(investigate);
		return new Result(data);
	}

	@ControllerLog(doAction = "新建项目及题目")
	@RequiresPermissions("/hr/train/addInvestiageAndQuestion")
	@ApiOperation(value = "新建项目及题目", notes = "[调研分析]新建项目及题目功能")
	@RequestMapping(value = "/addInvestiageAndQuestion", method = RequestMethod.POST)
	public Result addInvestiageAndQuestion(@Validated @RequestBody InvestigateAdd investigaAdd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 新增设置项目编号
		if (StringUtils.isBlank(investigaAdd.getProjectId())) {
			investigaAdd.setProjectId(UUID.randomUUID().toString());
		}
		investigateService.addInvestiageAndQuestion(investigaAdd, user);
		return new Result();
	}

	// @ControllerLog(doAction = "新建项目-项目信息")
	// // @RequiresPermissions("/hr/train/addInvestiage")
	// @ApiOperation(value = "新建项目-项目信息", notes = "[调研分析]新建项目-项目信息功能")
	// @RequestMapping(value = "/addInvestiage", method = RequestMethod.POST)
	// public Result<String> addInvestiage(@Validated @RequestBody
	// InvestigateAdd investigaAdd) {
	// // 获取当前用户信息
	// User user = (User) SecurityUtils.getSubject().getPrincipal();
	//
	// // 新增设置项目编号
	// if (StringUtils.isBlank(investigaAdd.getProjectId())) {
	// investigaAdd.setProjectId(UUID.randomUUID().toString());
	// }
	//
	// // 返回新建的调研项目
	// String productId = investigateService.addInvestiage(investigaAdd, user);
	// return new Result(productId);
	// }

	// @ControllerLog(doAction = "新建项目-问题信息")
	// // @RequiresPermissions("/hr/train/addQuestion")
	// @ApiOperation(value = "新建项目-问题信息", notes = "[调研分析]新建项目-问题信息功能")
	// @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	// public Result addQuestion(@Validated @RequestBody Investigate
	// questionAdd) {
	// // 获取当前用户信息
	// User user = (User) SecurityUtils.getSubject().getPrincipal();
	// investigateService.addQuestion(questionAdd, user);
	// return new Result();
	// }

	@ControllerLog(doAction = "编辑项目")
	@RequiresPermissions("/hr/train/update")
	@ApiOperation(value = "编辑项目", notes = "[调研分析]编辑项目功能")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result update(@Validated @RequestBody Investigate investigaUpd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 编辑调研项目
		investigateService.update(investigaUpd, user);
		return new Result();
	}

	@ControllerLog(doAction = "编辑项目详情")
	@RequiresPermissions("/hr/train/updateInvestiage")
	@ApiOperation(value = "编辑项目", notes = "[调研分析]编辑项目功能")
	@RequestMapping(value = "/updateInvestiage", method = RequestMethod.POST)
	public Result updateInvestiage(@Validated @RequestBody Investigate investigaAdd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 编辑调研项目
		investigateService.updateInvestiage(investigaAdd, user);
		return new Result();
	}

	@ControllerLog(doAction = "编辑问题--新增或修改")
	@RequiresPermissions("/hr/train/updateQuestion")
	@ApiOperation(value = "编辑问题--新增或修改", notes = "[调研分析]编辑项目(编辑调研问题)功能")
	@RequestMapping(value = "/updateQuestion", method = RequestMethod.POST)
	public Result<String> updateQuestion(@Validated @RequestBody InvestigateQuestion questionUpd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String titleId = investigateService.updateQuestion(questionUpd, user);
		return new Result(titleId);
	}

	@ControllerLog(doAction = "编辑问题--删除题目")
	@RequiresPermissions("/hr/train/deleteQuestion")
	@ApiOperation(value = "编辑调研项目题目-删除", notes = "[调研分析]编辑项目(编辑调研问题)功能")
	@RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
	public Result deleteQuestion(@Validated @RequestBody InvestigateQuestion questionUpd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		investigateService.deleteQuestion(questionUpd, user);
		return new Result();
	}

	@ControllerLog(doAction = "删除调研")
	@RequiresPermissions("/hr/train/daleteInvestigate")
	@ApiOperation(value = "删除调研", notes = "删除调研功能")
	@RequestMapping(value = "/daleteInvestigate", method = RequestMethod.POST)
	public Result daleteInvestigate(@Validated @RequestBody Investigate investigaDel) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		investigateService.deleteInvestiage(investigaDel, user);
		return new Result();
	}

	@ControllerLog(doAction = "结束调研")
	@RequiresPermissions("/hr/train/endInvestiage")
	@ApiOperation(value = "结束调研", notes = "结束调研功能")
	@RequestMapping(value = "/endInvestiage", method = RequestMethod.POST)
	public Result endInvestiage(@Validated @RequestBody Investigate investigaDel) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		investigateService.endInvestiage(investigaDel, user);
		return new Result();
	}

	@ControllerLog(doAction = "发放调研")
	@RequiresPermissions("/hr/train/sendInvestiage")
	@ApiOperation(value = "发放调研", notes = "发放调研功能")
	@RequestMapping(value = "/sendInvestiage", method = RequestMethod.POST)
	public Result sendInvestiage(@Validated @RequestBody ResearchSetAdd researchSet) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		investigateService.sendInvestiage(researchSet, user);
		return new Result();
	}

	@ControllerLog(doAction = "调研结果-汇总统计")
	@RequiresPermissions("/hr/train/questionAnswerList")
	@ApiOperation(value = "汇总统计", notes = "调研结果功能")
	@RequestMapping(value = "/questionAnswerList", method = RequestMethod.POST)
	public Result<List<AnswerVo>> questionAnswerList(@Validated @RequestBody Investigate investigate) {
		List<AnswerVo> data = investigateService.questionAnswerList(investigate.getProjectId());
		return new Result(data);
	}

	@ControllerLog(doAction = "调研结果-单人统计-列表")
	@RequiresPermissions("/hr/train/surveyResultList")
	@ApiOperation(value = "单人统计-列表", notes = "单人统计功能")
	@RequestMapping(value = "/surveyResultList", method = RequestMethod.POST)
	public Result<PaginationData<List<SurveyResultVo>>> surveyResultList(
			@Validated @RequestBody SurveyResultPage surveyResultPage) {
		PaginationData<List<SurveyResultVo>> data = investigateService.surveyResultList(surveyResultPage);
		return new Result(data);
	}

	@ControllerLog(doAction = "调研结果-单人统计-详情页")
	@RequiresPermissions("/hr/train/selectSurveyResult")
	@ApiOperation(value = "单人统计-详情页", notes = "查看页面功能")
	@RequestMapping(value = "/selectSurveyResult", method = RequestMethod.POST)
	public Result<SurveyResultVo> selectSurveyResult(@Validated @RequestBody SurveyResultPage surveyResult) {
		SurveyResultVo data = investigateService.selectSurveyResult(surveyResult);
		return new Result(data);
	}

	@ControllerLog(doAction = "调研登陆页")
	@RequiresPermissions("/hr/train/loginInvestiage")
	@ApiOperation(value = "调研登陆页", notes = "登陆调研功能")
	@RequestMapping(value = "/loginInvestiage", method = RequestMethod.POST)
	public Result<ResearchSet> loginInvestiage(@Validated @RequestBody Investigate investigate) {
		// 获取当前用户信息
		ResearchSet data = investigateService.loginInvestiage(investigate.getProjectId());
		return new Result(data);
	}

	@ControllerLog(doAction = "web端-新增答题记录")
	@RequiresPermissions("/hr/train/addAnswerInfo")
	@ApiOperation(value = "web端-新增答题记录", notes = "[调研分析]web端-答题页面功能")
	@RequestMapping(value = "/addAnswerInfo", method = RequestMethod.POST)
	public Result addAnswerInfo(@Validated @RequestBody ResultAnswerAdd resultAnswerAdd) {
		// 设置答题卡编号
		if (StringUtils.isBlank(resultAnswerAdd.getId())) {
			resultAnswerAdd.setId(UUID.randomUUID().toString());
		}
		investigateService.addAnswerInfo(resultAnswerAdd);
		return new Result();
	}
}
