package com.jn.hr.exam.dao;

import java.util.List;

import com.jn.hr.exam.entity.TbManpowerExaminaManagement;
import com.jn.hr.exam.model.ExaminaManagement;
import com.jn.hr.exam.model.ExaminaManagementAdd;
import com.jn.hr.exam.model.ExaminaManagementPage;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 05:52 
 * @version： v1.0
 * @modified By:
 **/
public interface ExaminaManagementMapper {

	/**分页试卷列表
	 * @param page
	 * @return
	 */
	List<ExaminaManagementAdd> list(ExaminaManagementPage page);

	List<TbManpowerExaminaManagement> listManagement();

	/**跟据状态计数
	 * @return
	 */
	List<ExaminaManagement> selectByStatus(ExaminaManagementPage examinaManagementPage);

}
