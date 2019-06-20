package com.jn.hr.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.exam.entity.TbManpowerExaminaTitleOption;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/21 04:26 
 * @version： v1.0
 * @modified By:
 **/
public interface ExaminaTitleOptionMapper {

	/** 查询当前题目所有选项
	 * @param testQuestionId
	 * @return
	 */
	List<TbManpowerExaminaTitleOption> optionList(@Param("testQuestionId") String testQuestionId);

	/**
	 * 删除当前题目所有选项
	 * 
	 * @param testQuestionId
	 */
	void deleteByTestQuestionId(@Param("testQuestionId") String testQuestionId);
}
