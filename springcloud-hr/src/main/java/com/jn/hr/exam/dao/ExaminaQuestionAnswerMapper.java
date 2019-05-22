package com.jn.hr.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.exam.entity.TbManpowerExaminaQuestionAnswer;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 05:52 
 * @version： v1.0
 * @modified By:
 **/
public interface ExaminaQuestionAnswerMapper {

	/**
	 * 查看当前题目答案
	 * @param testQuestionId
	 * @return
	 */
	TbManpowerExaminaQuestionAnswer answerList(@Param("testQuestionId") String testQuestionId);

}
