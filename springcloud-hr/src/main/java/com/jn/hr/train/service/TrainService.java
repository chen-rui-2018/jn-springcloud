package com.jn.hr.train.service;

import java.util.List;

import com.jn.common.model.PaginationData;
import com.jn.hr.train.model.Management;
import com.jn.hr.train.model.ManagementAdd;
import com.jn.hr.train.model.ManagementPage;
import com.jn.hr.train.model.TrainDepartment;
import com.jn.system.model.User;

/**
 * 
 * 培训列表服务
 * 
 * @author： wangtt
 * @date：Created on  2019/04/18 03:25 
 * @version： v1.0
 * @modified By:
 **/
public interface TrainService {
	/**
	 * 获取员工信息列表
	 * @return
	 */
	public List<TrainDepartment> selectUserList();

	/** 
	 * 新建课程
	 * 
	 * @param managementAdd 新增课程实体
	 * @param user 当前登陆用户
	 */
	public String addManagement(ManagementAdd managementAdd, User user);

	/**
	 * 课程详情
	 * @param id 课程编号
	 * @return
	 */
	public ManagementAdd selectManagement(Management management);

	/**
	 * 培训记录分页查询
	 * 
	 * @param managementPage分页查询课程实体
	 * @return
	 */
	public PaginationData<List<Management>> managementList(ManagementPage managementPage);

	/**分页查询培训记录
	 * 
	 * @param managementPage
	 * @return
	 */
	public PaginationData<List<Management>> managemenRecordtList(ManagementPage managementPage);

	/**
	 * 修改课程
	 * @param managementAdd 修改课程实体
	 * @param user 当前用户
	 */
	public void updateManagement(Management management, User user);

	/**
	 * 结束课程
	 * @param managementAdd 结束课程实体
	 * @param user 当前用户
	 */
	public void deleteManagement(Management management, User user);

	/**
	 * 发送邮件
	 *
	 * @param management 邮件实体
	 * 
	 * @param user 当前登录用户
	 */
	public void sendEmail(Management management, User user);
}
