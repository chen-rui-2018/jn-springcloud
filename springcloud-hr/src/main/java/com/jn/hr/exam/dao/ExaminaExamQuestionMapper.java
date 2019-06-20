package com.jn.hr.exam.dao;

import java.util.List;

import com.jn.hr.exam.entity.TbManpowerExaminaExamQuestion;

import feign.Param;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 05:52 
 * @version： v1.0
 * @modified By:
 **/
public interface ExaminaExamQuestionMapper {

	/**
	 * 删除试题关联信息
	 * @param page
	 * @return
	 */
	int deleteByTitleId(TbManpowerExaminaExamQuestion tbManpowerExaminaExamQuestion);

	/**查询考试题目关联信息
	 * @param examinaId
	 * @return
	 */
	List<TbManpowerExaminaExamQuestion> selectListByExaminaId(@Param("examinaId") String examinaId);

}
