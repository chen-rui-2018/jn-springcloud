package com.jn.hr.exam.dao;

import com.jn.hr.exam.entity.TbManpowerExaminaAnswerCard;
import com.jn.hr.exam.model.Examinabank;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 05:52 
 * @version： v1.0
 * @modified By:
 **/
public interface ExaminaAnswerCardMapper {

	/**
	 * 查看答题信息
	 * @param page
	 * @return
	 */
	Examinabank selectAnswerCard(Examinabank examinabank);

	int updateAnswer(TbManpowerExaminaAnswerCard tbManpowerExaminaAnswerCard);

}
