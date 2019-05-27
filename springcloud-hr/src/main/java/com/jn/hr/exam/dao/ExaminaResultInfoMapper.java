package com.jn.hr.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.exam.entity.TbManpowerExaminaResultInfo;
import com.jn.hr.exam.model.ExaminaManagement;
import com.jn.hr.exam.model.ExaminaResultPage;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 05:52 
 * @version： v1.0
 * @modified By:
 **/
public interface ExaminaResultInfoMapper {

	/**
	 * 查询所有成绩列表
	 * 
	 * @param page
	 * @return
	 */
	List<Integer> listAchievement(@Param("examinaId") String examinaId);

	/**查询答题人个数
	 * @param examinaId
	 * @return
	 */
	int resultCount(@Param("examinaId") String examinaId);

	/**更新等级
	 * @param resultInfo
	 * @return
	 */
	int updateBatch(TbManpowerExaminaResultInfo resultInfoList);

	/**
	 * 查询当前用户情况
	 * @param resultInfo
	 * @return
	 */
	TbManpowerExaminaResultInfo selectUserResult(TbManpowerExaminaResultInfo resultInfo);

	/**分页查询成绩列表
	 * @param examinaResultPage
	 * @return
	 */
	List<ExaminaManagement> listResultInfo(ExaminaResultPage examinaResultPage);

	/**
	 * 查询平均成绩，最高分，最低分，答题总人数
	 * @param examinaResultPage
	 * @return
	 */
	ExaminaManagement getResultCount(ExaminaResultPage examinaResultPage);

	/**
	 * 查询及格总人数
	 * @param examinaResultPage
	 * @return
	 */
	int getAdoptCount(ExaminaResultPage examinaResultPage);

}
