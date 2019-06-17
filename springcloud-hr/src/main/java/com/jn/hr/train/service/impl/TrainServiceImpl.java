package com.jn.hr.train.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.hr.common.enums.HrStatusEnums;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.TbManpowerDepartmentMapper;
import com.jn.hr.employee.entity.TbManpowerDepartment;
import com.jn.hr.employee.entity.TbManpowerDepartmentCriteria;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.hr.train.dao.ManagementMapper;
import com.jn.hr.train.dao.TbManpowerTrainManagementMapper;
import com.jn.hr.train.dao.TbManpowerTrainRecordMapper;
import com.jn.hr.train.dao.TrainRecordMapper;
import com.jn.hr.train.enmus.InvestigateStatusEnums;
import com.jn.hr.train.enmus.TrainExceptionEnums;
import com.jn.hr.train.entity.TbManpowerTrainManagement;
import com.jn.hr.train.entity.TbManpowerTrainRecord;
import com.jn.hr.train.model.Management;
import com.jn.hr.train.model.ManagementAdd;
import com.jn.hr.train.model.ManagementPage;
import com.jn.hr.train.model.TrainDepartment;
import com.jn.hr.train.service.TrainService;
import com.jn.news.vo.EmailVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

/**
 * 培训列表服务
 *
 * @author： wangtt
 * 
 * @date：Created on 2019/04/18 03:35 @version： v1.0
 * @modified By:
 **/
@Service
@EnableBinding(value = { MessageSource.class })
public class TrainServiceImpl implements TrainService {
	private Logger logger = LoggerFactory.getLogger(TrainServiceImpl.class);
	@Autowired
	TbManpowerTrainManagementMapper tbManpowerTrainManagementMapper;
	@Autowired
	TbManpowerTrainRecordMapper tbManpowerTrainRecordMapper;
	@Autowired
	TbManpowerDepartmentMapper tbManpowerDepartmentMapper;
	@Autowired
	TrainRecordMapper trainRecordMapper;
	@Autowired
	ManagementMapper managementMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	MessageSource messageSource;

	/**
	 * 获取员工列表
	 * 
	 */
	@Override
	@ServiceLog(doAction = "选择通知人员功能")
	public List<TrainDepartment> selectUserList() {
		List<TrainDepartment> departments = new ArrayList<TrainDepartment>();
		TbManpowerDepartmentCriteria example = new TbManpowerDepartmentCriteria();
		List<TbManpowerDepartment> tbFileClass = tbManpowerDepartmentMapper.selectByExample(example);
		for (TbManpowerDepartment tbFile : tbFileClass) {
			TrainDepartment department = new TrainDepartment();
			BeanUtils.copyProperties(tbFile, department);
			EmployeeBasicInfoPage basicInfo = new EmployeeBasicInfoPage();
			basicInfo.setDepartmentId(tbFile.getDepartmentId());
			List<EmployeeBasicInfo> list = employeeBasicInfoMapper.list(basicInfo);
			department.setEmployeeBasicInfoList(list);
			departments.add(department);
		}
		logger.info("[培训列表] 获取通知人员列表成功");
		return departments;

	}

	/**
	 * 新建课程
	 * 
	 * @param managementAdd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "新建课程功能")
	@Transactional(rollbackFor = Exception.class)
	public String addManagement(ManagementAdd managementAdd, User user) {
		TbManpowerTrainManagement tbManagement = new TbManpowerTrainManagement();
		BeanUtils.copyProperties(managementAdd, tbManagement);
		if (null == tbManagement.getStatus()) {
			Byte status = Byte.parseByte(InvestigateStatusEnums.UN_SEND.getCode());// 首次创建的草稿
			tbManagement.setStatus(status);
		}
		if (null == tbManagement.getRecordStatus()) {
			Byte recordStatus = Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode());// 正常调研1
			tbManagement.setRecordStatus(recordStatus);
		}
		if (!StringUtils.isBlank(managementAdd.getTrainInfo())) {
			tbManagement.setTrainInfo(managementAdd.getTrainInfo().getBytes());
		}

		String userAccount = user.getAccount();
		tbManagement.setCreatorAccount(userAccount);
		tbManagement.setCreatedTime(new Date());
		tbManagement.setModifierAccount(userAccount);
		tbManagement.setModifiedTime(new Date());
		tbManpowerTrainManagementMapper.insertSelective(tbManagement);
		logger.info("[培训列表] 制定课程成功,课程编号id:{}", managementAdd.getId());
		return tbManagement.getId();

	}

	/**
	 * 课程详情
	 * 
	 * @param id
	 *            课程编号
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "课程详情功能")
	public ManagementAdd selectManagement(Management management) {
		ManagementAdd managementSel = new ManagementAdd();
		TbManpowerTrainManagement tbManagement = tbManpowerTrainManagementMapper.selectByPrimaryKey(management.getId());
		BeanUtils.copyProperties(tbManagement, managementSel);
		if (null != tbManagement.getTrainInfo()) {
			managementSel.setTrainInfo(new String(tbManagement.getTrainInfo()));
		}
		logger.info("[培训列表] 查询课程详情成功,课程编号id:{}", management.getId());
		return managementSel;
	}

	/**
	 * 分页查询培训列表
	 * 
	 * @param managementPage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "分页查询培训列表")
	public PaginationData<List<Management>> managementList(ManagementPage managementPage) {
		Page<Object> objects = PageHelper.startPage(managementPage.getPage(), managementPage.getRows());
		List<Management> noticeList = managementMapper.listManagement(managementPage);
		for (Management notice : noticeList) {
			Integer countRecord = trainRecordMapper.selectCountByMangementId(notice.getId());
			notice.setManagementTrainRecord(countRecord.toString());// 培训人员个数
			notice.setTrainStartTimeStr(DateUtils.formatDate(notice.getTrainStartTime(), "yyyy-MM-dd HH:mm:ss"));
			notice.setTrainEndTimeStr(DateUtils.formatDate(notice.getTrainEndTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		PaginationData<List<Management>> data = new PaginationData(noticeList, objects.getTotal());
		logger.info("[培训列表] 分页查询培训列表成功");
		return data;
	}

	/**
	 * 分页查询培训记录
	 * 
	 * @param managementPage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "分页查询培训记录")
	public PaginationData<List<Management>> managemenRecordtList(ManagementPage managementPage) {
		Page<Object> objects = PageHelper.startPage(managementPage.getPage(), managementPage.getRows());
		List<Management> noticeList = trainRecordMapper.listMangementAndRecord(managementPage);
		for (Management notice : noticeList) {
			notice.setTrainStartTimeStr(DateUtils.formatDate(notice.getTrainStartTime(), "yyyy-MM-dd HH:mm:ss"));
			notice.setTrainEndTimeStr(DateUtils.formatDate(notice.getTrainEndTime(), "yyyy-MM-dd HH:mm:ss"));
			notice.setCreatedTimeStr(DateUtils.formatDate(notice.getCreatedTime(), "yyyy-MM-dd HH:mm:ss"));
			notice.setModifiedTimeStr(DateUtils.formatDate(notice.getModifiedTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		PaginationData<List<Management>> data = new PaginationData(noticeList, objects.getTotal());
		logger.info("[培训列表] 分页查询培训记录成功");
		return data;
	}

	/**
	 * 修改课程
	 * 
	 * @param managementAdd
	 *            修改课程实体
	 * @param user
	 *            当前用户
	 */
	@Override
	@ServiceLog(doAction = "修改课程功能")
	@Transactional(rollbackFor = Exception.class)
	public void updateManagement(Management management, User user) {
		String id = management.getId();
		TbManpowerTrainManagement tbManagement = getManagement(id);
		// 填充需改信息
		tbManagement = new TbManpowerTrainManagement();
		BeanUtils.copyProperties(management, tbManagement);
		String userAccount = user.getAccount();
		tbManagement.setModifierAccount(userAccount);
		tbManagement.setModifiedTime(new Date());
		tbManpowerTrainManagementMapper.updateByPrimaryKeySelective(tbManagement);
		logger.info("[培训列表] 修改课程成功,id:{}", management.getId());
	}

	/**
	 * 结束课程
	 * 
	 * @param investigaAdd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "结束课程功能")
	@Transactional(rollbackFor = Exception.class)
	public void deleteManagement(Management management, User user) {
		String id = management.getId();
		TbManpowerTrainManagement tbManagement = getManagement(id);
		tbManagement.setModifierAccount(user.getAccount());
		tbManagement.setModifiedTime(new Date());
		tbManagement.setRecordStatus(Byte.parseByte(HrStatusEnums.DELETED.getCode()));
		tbManpowerTrainManagementMapper.updateByPrimaryKeySelective(tbManagement);
		logger.info("[培训列表] 结束课程成功,id:{}", tbManagement.getId());
	}

	/**查询课程详情
	 * 
	 * @param id
	 * @return
	 */
	private TbManpowerTrainManagement getManagement(String id) {
		TbManpowerTrainManagement tbManagement = tbManpowerTrainManagementMapper.selectByPrimaryKey(id);
		if (tbManagement == null
				|| StringUtils.equals(HrStatusEnums.DELETED.getCode(), tbManagement.getRecordStatus().toString())) {
			logger.warn("[培训列表] 获取课程信息失败，当前课程不存在,id:{}", tbManagement.getId());
			throw new JnSpringCloudException(TrainExceptionEnums.MANAGEMENT_NOT_EXIST);
		}
		return tbManagement;
	}

	/**
	 * 发送邮件
	 *
	 * @param management
	 *            邮件实体
	 * @param user
	 *            当前登录用户
	 */
	@Override
	@ServiceLog(doAction = "发送通知功能")
	@Transactional(rollbackFor = Exception.class)
	public void sendEmail(Management management, User user) {
		TbManpowerTrainManagement tbManagement = tbManpowerTrainManagementMapper.selectByPrimaryKey(management.getId());
		if (tbManagement == null
				|| StringUtils.equals(HrStatusEnums.DELETED.getCode(), tbManagement.getRecordStatus().toString())) {
			logger.warn("[培训列表]发放培训通知失败，当前课程不存在,id:{}", tbManagement.getId());
			throw new JnSpringCloudException(TrainExceptionEnums.SEND_ERROR);
		}

		List<EmployeeBasicInfo> employeeBasicInfoList = management.getEmployeeBasicInfoList();
		StringBuffer userEmails = new StringBuffer();
		for (EmployeeBasicInfo employeeBasicInfo : employeeBasicInfoList) {
			userEmails.append(employeeBasicInfo.getMailbox()).append(",");
		}
		String userEmailInfo = userEmails.substring(0, userEmails.length() - 1);
		EmailVo emailVo = new EmailVo();
		emailVo.setEmail(userEmailInfo);
		emailVo.setEmailSubject(tbManagement.getCourseTitle());
		String emailContent = tbManagement.getCourseTitle() + "," + tbManagement.getTrainTeacher() + ","
				+ tbManagement.getTrainVenue() + "," + tbManagement.getTrainStartTime() + "~"
				+ tbManagement.getTrainEndTime();
		emailVo.setEmailContent(emailContent);
		sendEmailMsg(emailVo);

		// 添加培训记录
		for (EmployeeBasicInfo employeeBasicInfo : employeeBasicInfoList) {
			TbManpowerTrainRecord tbManpowerTrainRecord = new TbManpowerTrainRecord();
			tbManpowerTrainRecord.setManagementId(tbManagement.getId());
			tbManpowerTrainRecord.setTrainerJobNumber(employeeBasicInfo.getJobNumber());
			int i = trainRecordMapper.listByMangementIdAndJobNumber(tbManpowerTrainRecord);
			if (i == 0) {
				tbManpowerTrainRecord.setId(UUID.randomUUID().toString());
				tbManpowerTrainRecord.setTrainerDepartment(employeeBasicInfo.getDepartmentName());
				tbManpowerTrainRecord.setTrainerName(employeeBasicInfo.getName());
				tbManpowerTrainRecordMapper.insertSelective(tbManpowerTrainRecord);
			}
		}

		// 更新培训状态
		if (tbManagement.getStatus().equals(Byte.parseByte(InvestigateStatusEnums.UN_SEND.getCode()))) {
			TbManpowerTrainManagement updManagement = new TbManpowerTrainManagement();
			updManagement.setId(management.getId());
			String userAccount = user.getAccount();
			updManagement.setModifierAccount(userAccount);
			updManagement.setModifiedTime(new Date());
			updManagement.setStatus(Byte.parseByte(InvestigateStatusEnums.IS_SEND.getCode()));
			tbManpowerTrainManagementMapper.updateByPrimaryKeySelective(updManagement);
		}
		logger.info("[培训列表] 发送邮件通知【{}】成功。", tbManagement.getCourseTitle());
	}

	/**
	 * 发送邮件
	 * 
	 * @param emailVo
	 */
	public void sendEmailMsg(EmailVo emailVo) {
		boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
		if (!sendStatus) {
			logger.warn("发送邮件通知失败,邮件主题:{}", emailVo.getEmailSubject());
		}
	}

}
