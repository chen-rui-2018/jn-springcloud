package com.jn.hr.train.dao;

import java.util.List;

import com.jn.hr.train.entity.TbManpowerTrainQuestSurveyResult;
import com.jn.hr.train.entity.TbManpowerTrainSurveyResult;
import com.jn.hr.train.model.SurveyResultPage;
import com.jn.hr.train.vo.SurveyResultVo;

/**
 * 结果
 *
 * @author： wangtt
 * @date：Created on  2019/04/17 05:49 
 * @version： v1.0
 * @modified By:
 **/
public interface SurveyResultMapper {

	/** 
	 * 调研分析-单人统计列表查询
	 * 
	 * @param surveyResult
	 * @return
	 */
	List<SurveyResultVo> list(SurveyResultPage surveyResult);

	/**
	 * 调研分析-查询答案
	 * @param surveyResult
	 * @return
	 */
	SurveyResultVo selectSurveyResult(SurveyResultPage surveyResult);

	/**
	 * 查询用户调研答题情况
	 * @param surveyResult
	 * @return
	 */
	List<TbManpowerTrainSurveyResult> selectUserSurveyResult(TbManpowerTrainSurveyResult surveyResult);

	/** 
	 * 问卷调查-单人统计列表查询
	 * 
	 * @param surveyResult
	 * @return
	 */
	List<SurveyResultVo> listQuest(SurveyResultPage surveyResult);

	/**
	 * 问卷调查-查询答案
	 * @param surveyResult
	 * @return
	 */
	SurveyResultVo selectSurveyResultQuest(SurveyResultPage surveyResult);

	/**
	 * 查询用户问卷答题情况
	 * @param surveyResult
	 * @return
	 */
	List<TbManpowerTrainQuestSurveyResult> selectUserQuestSurveyResult(TbManpowerTrainQuestSurveyResult surveyResult);
}
