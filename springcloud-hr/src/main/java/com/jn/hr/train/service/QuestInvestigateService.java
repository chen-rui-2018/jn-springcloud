package com.jn.hr.train.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jn.common.model.PaginationData;
import com.jn.hr.train.model.Investigate;
import com.jn.hr.train.model.InvestigateAdd;
import com.jn.hr.train.model.InvestigatePage;
import com.jn.hr.train.model.InvestigateQuestion;
import com.jn.hr.train.model.ResearchSet;
import com.jn.hr.train.model.ResearchSetAdd;
import com.jn.hr.train.model.ResultAnswerAdd;
import com.jn.hr.train.model.SurveyResultPage;
import com.jn.hr.train.vo.AnswerVo;
import com.jn.hr.train.vo.InvestigatesVo;
import com.jn.hr.train.vo.SurveyResultVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

/**
 * 问卷调查服务
 *
 * @author： wangtt
 * @date：Created on  2019/04/15 04:40 
 * @version： v1.0
 * @modified By:
 **/
public interface QuestInvestigateService {
	/** 
	 * 新建问卷调查及题目
	 * 
	 * @param investigaAdd 问卷调查
	 * @param user 当前登陆用户
	 */
	public void addInvestiageAndQuestion(InvestigateAdd investigaAdd, User user);

	/** 
	 * 新增问卷
	 * 
	 * @param investigaAdd 问卷实体
	 * @param user 当前登陆用户
	 */
	public String addInvestiage(InvestigateAdd investigaAdd, User user);

	/** 
	 * 新增问卷题目
	 * 
	 * @param questionAdd 问卷题目实体
	 * @param user 当前登陆用户
	 */
	public void addQuestion(Investigate questionAdd, User user);

	// /**
	// * 编辑问卷
	// *
	// * @param investigaUpd 问卷实体
	// * @param user 当前登陆用户
	// */
	// public void update(Investigate investigaUpd, User user);

	/** 
	 * 编辑问卷项目
	 * 
	 * @param investigaUpd 问卷实体
	 * @param user 当前登陆用户
	 */
	public void updateInvestiage(Investigate investigaUpd, User user);

	/** 
	 * 编辑问卷项目题目更新及修改
	 * 
	 * @param questionUpd 题目实体
	 * @param user 当前登陆用户
	 */
	public String updateQuestion(InvestigateQuestion questionUpd, User user);

	/** 
	 * 编辑问卷项目题目删除
	 * 
	 * @param questionUpd 题目实体
	 * @param user 当前登陆用户
	 */
	public void deleteQuestion(InvestigateQuestion questionUpd, User user);

	/**
	 * 分页查询问卷信息
	 * 
	 * @param investigatePage
	 * @return
	 */
	public PaginationData<List<InvestigatesVo>> list(InvestigatePage investigatePage);

	/**
	 *  查询问卷详情信息
	 *  
	 * @param investigatePage
	 * @return
	 */
	public InvestigatesVo selectInvestigate(Investigate investigate);

	/** 
	 * 删除问卷调查
	 * 
	 * @param investigaDel 问卷实体
	 * @param user 当前登陆用户
	 */
	public void deleteInvestiage(Investigate investigaDel, User user);

	/**
	 * 结束问卷
	 * 
	 * @param investigaAdd
	 *            
	 * @param user
	 *            当前登陆用户
	 */
	public void endInvestiage(Investigate investigaDel, User user);

	/**
	 * 发放问卷
	 * 
	 * @param investigaAdd
	 * @param user
	 * @return
	 */
	public void sendInvestiage(ResearchSetAdd researchSet, User user);

	/**问卷页展示
	 * @param projectId 问卷项目
	 * @param user 参与问卷用户
	 * @return
	 */
	public ResearchSet loginInvestiage(String projectId);

	/**
	 * 问卷结果-汇总统计
	 * @param projectId
	 * @return
	 */
	public List<AnswerVo> questionAnswerList(String projectId);

	/**
	 * 分页查询问卷结果
	 * 
	 * @param investigatePage
	 * @return
	 */
	public PaginationData<List<SurveyResultVo>> surveyResultList(SurveyResultPage surveyResultPage);

	/**
	 * 查询单人问卷结果
	 * 
	 * @param investigatePage
	 * @return
	 */
	public SurveyResultVo selectSurveyResult(SurveyResultPage surveyResult);

	/**
	 * 新建答题信息
	 * @param answerInfo
	 * @param user
	 */
	public void addAnswerInfo(ResultAnswerAdd resultAnswerAdd);
}
