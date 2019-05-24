package com.jn.hr.train.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.train.entity.TbManpowerTrainAnswerInfo;
import com.jn.hr.train.entity.TbManpowerTrainQuestAnswerInfo;
import com.jn.hr.train.model.SurveyResultPage;

/**
 * 
 * 答案
 * @author： wangtt
 * @date：Created on  2019/04/16 06:43 
 * @version： v1.0
 * @modified By:
 **/
public interface AnswerInfoMapper {
	/** 
	 * 跟据题目id，查询 调研项目 答案列表
	 * @param titleId
	 * @return 调研分析 答案列表
	 */
	List<TbManpowerTrainAnswerInfo> list(@Param("titleId") String titleId);

	/**
	 * 查询指定用户答题信息(调研分析)
	 * @param surveyResultPage
	 * @return
	 */
	List<TbManpowerTrainAnswerInfo> listById(SurveyResultPage surveyResultPage);

	/** 
	 * 跟据题目id，查询 问卷调查  答案列表
	 * @param titleId
	 * @return 问卷调查答案列表
	 */
	List<TbManpowerTrainQuestAnswerInfo> listQuest(@Param("titleId") String titleId);

	/**
	 * 查询指定用户答题信息(问卷调查)
	 * @param surveyResultPage
	 * @return
	 */
	List<TbManpowerTrainQuestAnswerInfo> listQuestById(SurveyResultPage surveyResultPage);
}
