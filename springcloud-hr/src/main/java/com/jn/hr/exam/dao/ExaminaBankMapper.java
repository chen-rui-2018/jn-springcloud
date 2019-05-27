package com.jn.hr.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.exam.entity.TbManpowerExaminaBank;
import com.jn.hr.exam.model.Examinabank;
import com.jn.hr.exam.model.ExaminabankAdd;
import com.jn.hr.exam.model.ExaminabankPage;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 05:52 
 * @version： v1.0
 * @modified By:
 **/
public interface ExaminaBankMapper {

	/**分页查询所有题目
	 * @param page
	 * @return
	 */
	List<ExaminabankAdd> list(ExaminabankPage page);

	/**查询当前考卷的所有题目
	 * @param examinaId
	 * @return
	 */
	List<TbManpowerExaminaBank> examinaBankList(@Param("examinaId") String examinaId);

	/**
	 * 根绝题目编号和试卷id查询题目详情
	 * @param examinaManagement
	 * @return
	 */
	ExaminabankAdd selectBankByExaminaIdAndQuestionId(Examinabank examinabank);

	List<Examinabank> selectBankByExaminaId(Examinabank examinabank);
}
