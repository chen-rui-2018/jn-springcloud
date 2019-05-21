package com.jn.hr.train.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.train.entity.TbManpowerTrainQuestQuestionnaireQuese;
import com.jn.hr.train.entity.TbManpowerTrainQuestionnaireQuese;

/**
 * 问题信息mapper
 *
 * @author： wangtt
 * @date：Created on  2019/04/16 07:10 
 * @version： v1.0
 * @modified By:
 **/
public interface QuestionMapper {

	/** 
	 * 跟据项目id，查询 调研项目 问题列表
	 * @param projectId
	 * @return 调研分析问题列表
	 */
	List<TbManpowerTrainQuestionnaireQuese> list(@Param("projectId") String projectId);

	/** 
	 * 跟据项目id，查询 问卷调查 问题列表
	 * @param projectId
	 * @return 问卷调查问题列表
	 */
	List<TbManpowerTrainQuestQuestionnaireQuese> listQuest(@Param("projectId") String projectId);

	/**跟据项目id和题目id查询问题
	 * @param questionnaireQuese
	 * @return
	 */
	TbManpowerTrainQuestQuestionnaireQuese selectQuestQuestion(
			TbManpowerTrainQuestQuestionnaireQuese questionnaireQuese);
}
