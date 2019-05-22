package com.jn.hr.exam.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jn.common.model.PaginationData;
import com.jn.hr.exam.model.ExaminaManagement;
import com.jn.hr.exam.model.ExaminaManagementAdd;
import com.jn.hr.exam.model.ExaminaManagementPage;
import com.jn.hr.exam.model.ExaminaResultPage;
import com.jn.hr.exam.model.Examinabank;
import com.jn.hr.exam.model.ExaminabankAdd;
import com.jn.hr.exam.model.ExaminabankPage;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 04:17 
 * @version： v1.0
 * @modified By:
 **/

public interface ExaminaService {
	/**
	 * 新增试题
	 * @param add 题目信息实体
	 * @param user 当前用户
	 * @return
	 */
	public ExaminabankAdd addExaminaBank(ExaminabankAdd add, User user);

	/** 分页查询试题列表
	 * @param page 分页查询试题对象
	 * @return
	 */
	public PaginationData<List<ExaminabankAdd>> selectBankList(ExaminabankPage page);

	/** 
	 * 查询试题详情
	 * @param testQuestionId 试题编号
	 * @return
	 */
	public ExaminabankAdd selectExaminabank(String testQuestionId);

	/**
	 * 修改试题信息
	 * @param examinabankAdd
	 * @param user
	 */
	public void updateExaminabank(Examinabank examinabank, User user);

	/**
	 * 删除试题
	 * 
	 * @param testQuestionId 试题编号
	 * @param user 当前用户
	 */
	public void deleteExaminaBank(String testQuestionId, User user);

	/**
	 * 创建考试，新建试卷
	 * 
	 * @param add 新增考试实体
	 * @param user 当前用户
	 */
	public ExaminaManagement addExaminaManagement(ExaminaManagement add, User user);

	/**
	 * 发放考试
	 * @param examinaManagement 考试实体
	 * @param user 当前用户
	 */
	public void sendExaminaManagement(ExaminaManagement examinaManagement, User user);

	/**分页查询试卷列表
	 * @param page
	 * @return
	 */
	public PaginationData<List<ExaminaManagementAdd>> selectExaminaManagementList(ExaminaManagementPage page);

	/**查询试卷详情
	 * 
	 * @param id 试卷编号
	 * @return
	 */
	public ExaminaManagementAdd selectExamInfo(String id);

	/**
	 * 编辑试卷功能
	 * @param examinaManagement
	 */
	public void updateExamInfo(ExaminaManagement examinaManagement, User user);

	/**
	 * 删除试卷
	 * 
	 * @param examinaManagement
	 *            试卷信息
	 */
	public void deleteExamInfo(ExaminaManagement examinaManagement, User user);

	/** 
	 * 登录答题页
	 * 
	 * @param id 试卷编号
	 */
	public ExaminaManagementAdd loginManagement(ExaminaManagement management);

	/**
	 * 新增答题
	 * 
	 * @param examinabank 答题实体
	 */
	public ExaminaManagementAdd insterAnswerCard(ExaminaManagement examinaManagement);

	/**
	 * 更新成绩及排名
	 * 
	 * @param examinaManagement
	 */
	public void updateResult(ExaminaManagement examinaManagement);

	/**分页查看成绩
	 * @param page 查看成绩请求实体
	 * @return
	 */
	public PaginationData<List<ExaminaManagement>> selectResultList(ExaminaResultPage page);

	/**
	 * 查询试题及答题详情
	 * @param id
	 * @return
	 */
	public ExaminaManagementAdd selectExamAndAnswerCard(ExaminaManagement examinaManagement);

}
