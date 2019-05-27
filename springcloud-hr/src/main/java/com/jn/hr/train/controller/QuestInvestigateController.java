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
import com.jn.hr.train.service.QuestInvestigateService;
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
 * 问卷调查管理
 *
 * @author： wangtt
 * @date：Created on  2019/04/15 04:15 
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "问卷调查管理")
@RestController
@RequestMapping("/hr/train/quest")
public class QuestInvestigateController extends BaseController {
	@Autowired
	private QuestInvestigateService investigateService;

	@ControllerLog(doAction = "问卷调查-列表显示")
	@RequiresPermissions("/hr/train/listInvestigateQuest")
	@ApiOperation(value = "问卷项目信息列表", notes = "问卷调查功能")
	@RequestMapping(value = "/listInvestigateQuest", method = RequestMethod.POST)
	public Result<PaginationData<List<InvestigatesVo>>> listInvestigateQuest(
			@Validated @RequestBody InvestigatePage investigatePage) {
		PaginationData<List<InvestigatesVo>> data = investigateService.list(investigatePage);
		return new Result(data);
	}

	@ControllerLog(doAction = "项目详情")
	@RequiresPermissions("/hr/train/quest/selectInvestigateQuest")
	@ApiOperation(value = "项目详情", notes = "问卷调查-项目详情功能")
	@RequestMapping(value = "/selectInvestigateQuest", method = RequestMethod.POST)
	public Result<InvestigatesVo> selectInvestigateQuest(@Validated @RequestBody Investigate investigate) {
		InvestigatesVo data = investigateService.selectInvestigate(investigate);
		return new Result(data);
	}

	@ControllerLog(doAction = "新建项目及问题信息")
	@RequiresPermissions("/hr/train/quest/addInvestiageAndQuestionQuest")
	@ApiOperation(value = "新建项目及问题信息", notes = "[问卷调查]新建项目及问题信息功能")
	@RequestMapping(value = "/addInvestiageAndQuestionQuest", method = RequestMethod.POST)
	public Result addInvestiageAndQuestionQuest(@Validated @RequestBody InvestigateAdd investigaAdd) {
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
	// // @RequiresPermissions("/hr/train/quest/addInvestiage")
	// @ApiOperation(value = "新建项目-项目信息", notes = "[问卷调查]新建项目-项目信息功能")
	// @RequestMapping(value = "/addInvestiage", method = RequestMethod.POST)
	// public Result<String> addInvestiageQuest(@Validated @RequestBody
	// InvestigateAdd investigaAdd) {
	// // 获取当前用户信息
	// User user = (User) SecurityUtils.getSubject().getPrincipal();
	//
	// // 新增设置项目编号
	// if (StringUtils.isBlank(investigaAdd.getProjectId())) {
	// investigaAdd.setProjectId(UUID.randomUUID().toString());
	// }
	//
	// // 返回新建的问卷项目
	// String productId = investigateService.addInvestiage(investigaAdd, user);
	// return new Result(productId);
	// }

	// @ControllerLog(doAction = "新建项目-问题信息")
	// // @RequiresPermissions("/hr/train/quest/addQuestion")
	// @ApiOperation(value = "新建项目-问题信息", notes = "[问卷调查]新建项目-问题信息功能")
	// @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	// public Result addQuestionQuest(@Validated @RequestBody Investigate
	// questionAdd) {
	// // 获取当前用户信息
	// User user = (User) SecurityUtils.getSubject().getPrincipal();
	// investigateService.addQuestion(questionAdd, user);
	// return new Result();
	// }

	// @ControllerLog(doAction = "编辑项目及项目问题")
	// // @RequiresPermissions("/hr/train/quest/update")
	// @ApiOperation(value = "编辑项目及项目问题", notes = "[问卷调查]编辑项目及项目问题功能")
	// @RequestMapping(value = "/update", method = RequestMethod.POST)
	// public Result updateQuest(@Validated @RequestBody Investigate
	// investigaUpd) {
	// // 获取当前用户信息
	// User user = (User) SecurityUtils.getSubject().getPrincipal();
	// // 编辑问卷项目
	// investigateService.update(investigaUpd, user);
	// return new Result();
	// }

	@ControllerLog(doAction = "编辑项目详情")
	@RequiresPermissions("/hr/train/quest/updateInvestiageQuest")
	@ApiOperation(value = "编辑项目", notes = "[问卷调查]编辑项目功能")
	@RequestMapping(value = "/updateInvestiageQuest", method = RequestMethod.POST)
	public Result updateInvestiageQuest(@Validated @RequestBody Investigate investigaAdd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 编辑问卷项目
		investigateService.updateInvestiage(investigaAdd, user);
		return new Result();
	}

	@ControllerLog(doAction = "编辑问卷项目题目-更新及修改")
	@RequiresPermissions("/hr/train/quest/updateQuestionQuest")
	@ApiOperation(value = "编辑问卷项目题目-更新及修改", notes = "[问卷调查]编辑项目(编辑问卷问题)功能")
	@RequestMapping(value = "/updateQuestionQuest", method = RequestMethod.POST)
	public Result<String> updateQuestionQuest(@Validated @RequestBody InvestigateQuestion questionUpd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String titleId = investigateService.updateQuestion(questionUpd, user);
		return new Result(titleId);
	}

	@ControllerLog(doAction = "编辑问卷项目题目-删除")
	@RequiresPermissions("/hr/train/quest/deleteQuestionQuest")
	@ApiOperation(value = "编辑问卷项目题目-删除", notes = "[问卷调查]编辑项目(编辑问卷问题)功能")
	@RequestMapping(value = "/deleteQuestionQuest", method = RequestMethod.POST)
	public Result deleteQuestionQuest(@Validated @RequestBody InvestigateQuestion questionUpd) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		investigateService.deleteQuestion(questionUpd, user);
		return new Result();
	}

	@ControllerLog(doAction = "删除问卷")
	@RequiresPermissions("/hr/train/quest/daleteInvestigateQuest")
	@ApiOperation(value = "删除问卷", notes = "删除问卷功能")
	@RequestMapping(value = "/daleteInvestigateQuest", method = RequestMethod.POST)
	public Result daleteInvestigateQuest(@Validated @RequestBody Investigate investigaDel) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		investigateService.deleteInvestiage(investigaDel, user);
		return new Result();
	}

	@ControllerLog(doAction = "结束问卷")
	@RequiresPermissions("/hr/train/quest/endInvestiageQuest")
	@ApiOperation(value = "结束问卷", notes = "结束问卷功能")
	@RequestMapping(value = "/endInvestiageQuest", method = RequestMethod.POST)
	public Result endInvestiageQuest(@Validated @RequestBody Investigate investigaDel) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		investigateService.endInvestiage(investigaDel, user);
		return new Result();
	}

	@ControllerLog(doAction = "发放问卷")
	@RequiresPermissions("/hr/train/quest/sendInvestiageQuest")
	@ApiOperation(value = "发放问卷", notes = "发放问卷功能")
	@RequestMapping(value = "/sendInvestiageQuest", method = RequestMethod.POST)
	public Result sendInvestiageQuest(@Validated @RequestBody ResearchSetAdd researchSet) {
		// 获取当前用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		investigateService.sendInvestiage(researchSet, user);
		return new Result();
	}

	@ControllerLog(doAction = "问卷结果-汇总统计")
	@RequiresPermissions("/hr/train/quest/questionAnswerListQuest")
	@ApiOperation(value = "汇总统计", notes = "问卷结果功能")
	@RequestMapping(value = "/questionAnswerListQuest", method = RequestMethod.POST)
	public Result<List<AnswerVo>> questionAnswerListQuest(@Validated @RequestBody Investigate investigate) {
		List<AnswerVo> data = investigateService.questionAnswerList(investigate.getProjectId());
		return new Result(data);
	}

	@ControllerLog(doAction = "问卷结果-单人统计-列表")
	@RequiresPermissions("/hr/train/quest/surveyResultListQuest")
	@ApiOperation(value = "单人统计-列表", notes = "单人统计功能")
	@RequestMapping(value = "/surveyResultListQuest", method = RequestMethod.POST)
	public Result<PaginationData<List<SurveyResultVo>>> surveyResultListQuest(
			@Validated @RequestBody SurveyResultPage surveyResultPage) {
		PaginationData<List<SurveyResultVo>> data = investigateService.surveyResultList(surveyResultPage);
		return new Result(data);
	}

	@ControllerLog(doAction = "问卷结果-单人统计-详情页")
	@RequiresPermissions("/hr/train/quest/selectSurveyResultQuest")
	@ApiOperation(value = "单人统计-详情页", notes = "查看页面功能")
	@RequestMapping(value = "/selectSurveyResultQuest", method = RequestMethod.POST)
	public Result<SurveyResultVo> selectSurveyResultQuest(@Validated @RequestBody SurveyResultPage surveyResult) {
		SurveyResultVo data = investigateService.selectSurveyResult(surveyResult);
		return new Result(data);
	}

	@ControllerLog(doAction = "web端/app 问卷登陆页")
	@RequiresPermissions("/hr/train/quest/loginInvestiageQuest")
	@ApiOperation(value = "问卷登陆页", notes = "登陆问卷功能")
	@RequestMapping(value = "/loginInvestiageQuest", method = RequestMethod.POST)
	public Result<ResearchSet> loginInvestiageQuest(@Validated @RequestBody Investigate investigate) {
		// 获取当前用户信息
		ResearchSet data = investigateService.loginInvestiage(investigate.getProjectId());
		return new Result(data);
	}

	@ControllerLog(doAction = "web端/app 新增答题记录")
	@RequiresPermissions("/hr/train/quest/addAnswerInfoQuest")
	@ApiOperation(value = "web端/app 新增答题记录", notes = "[问卷调查]web端-答题页面功能")
	@RequestMapping(value = "/addAnswerInfoQuest", method = RequestMethod.POST)
	public Result addAnswerInfoQuest(@Validated @RequestBody ResultAnswerAdd resultAnswerAdd) {
		// 设置答题卡编号
		if (StringUtils.isBlank(resultAnswerAdd.getId())) {
			resultAnswerAdd.setId(UUID.randomUUID().toString());
		}
		investigateService.addAnswerInfo(resultAnswerAdd);
		return new Result();
	}
}
