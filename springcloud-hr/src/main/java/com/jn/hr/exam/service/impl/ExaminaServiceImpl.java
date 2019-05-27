package com.jn.hr.exam.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import com.jn.hr.common.util.BeanCopyUtil;
import com.jn.hr.common.util.HrDataUtil;
import com.jn.hr.common.util.ValidateUtil;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.exam.dao.ExaminaAnswerCardMapper;
import com.jn.hr.exam.dao.ExaminaBankMapper;
import com.jn.hr.exam.dao.ExaminaExamQuestionMapper;
import com.jn.hr.exam.dao.ExaminaManagementMapper;
import com.jn.hr.exam.dao.ExaminaQuestionAnswerMapper;
import com.jn.hr.exam.dao.ExaminaResultInfoMapper;
import com.jn.hr.exam.dao.ExaminaTitleOptionMapper;
import com.jn.hr.exam.dao.TbManpowerExaminaAnswerCardMapper;
import com.jn.hr.exam.dao.TbManpowerExaminaBankMapper;
import com.jn.hr.exam.dao.TbManpowerExaminaExamQuestionMapper;
import com.jn.hr.exam.dao.TbManpowerExaminaManagementMapper;
import com.jn.hr.exam.dao.TbManpowerExaminaQuestionAnswerMapper;
import com.jn.hr.exam.dao.TbManpowerExaminaResultInfoMapper;
import com.jn.hr.exam.dao.TbManpowerExaminaTitleOptionMapper;
import com.jn.hr.exam.enmus.ExaminaExceptionEnums;
import com.jn.hr.exam.enmus.ExaminaStatusEnmus;
import com.jn.hr.exam.entity.TbManpowerExaminaAnswerCard;
import com.jn.hr.exam.entity.TbManpowerExaminaBank;
import com.jn.hr.exam.entity.TbManpowerExaminaExamQuestion;
import com.jn.hr.exam.entity.TbManpowerExaminaManagement;
import com.jn.hr.exam.entity.TbManpowerExaminaQuestionAnswer;
import com.jn.hr.exam.entity.TbManpowerExaminaResultInfo;
import com.jn.hr.exam.entity.TbManpowerExaminaTitleOption;
import com.jn.hr.exam.model.ExaminaManagement;
import com.jn.hr.exam.model.ExaminaManagementAdd;
import com.jn.hr.exam.model.ExaminaManagementPage;
import com.jn.hr.exam.model.ExaminaOption;
import com.jn.hr.exam.model.ExaminaOptionAdd;
import com.jn.hr.exam.model.ExaminaResultPage;
import com.jn.hr.exam.model.Examinabank;
import com.jn.hr.exam.model.ExaminabankAdd;
import com.jn.hr.exam.model.ExaminabankPage;
import com.jn.hr.exam.service.ExaminaService;
import com.jn.news.vo.EmailVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.upload.api.UploadClient;

/**
 * 
 * 考试页服务
 * @author： wangtt
 * 
 * @date：Created on 2019/04/20 04:00 @version： v1.0
 * @modified By:
 **/
@Service
@EnableBinding(value = { MessageSource.class })
public class ExaminaServiceImpl implements ExaminaService {
	private Logger logger = LoggerFactory.getLogger(ExaminaServiceImpl.class);

	@Autowired
	TbManpowerExaminaBankMapper tbManpowerExaminaBankMapper;
	@Autowired
	TbManpowerExaminaTitleOptionMapper tbManpowerExaminaTitleOptionMapper;
	@Autowired
	TbManpowerExaminaQuestionAnswerMapper tbManpowerExaminaQuestionAnswerMapper;
	@Autowired
	TbManpowerExaminaManagementMapper tbManpowerExaminaManagementMapper;
	@Autowired
	TbManpowerExaminaExamQuestionMapper tbManpowerExaminaExamQuestionMapper;
	@Autowired
	TbManpowerExaminaAnswerCardMapper tbManpowerExaminaAnswerCardMapper;
	@Autowired
	TbManpowerExaminaResultInfoMapper tbManpowerExaminaResultInfoMapper;

	@Autowired
	ExaminaResultInfoMapper examinaResultInfoMapper;
	@Autowired
	ExaminaBankMapper examinaBankMapper;
	@Autowired
	ExaminaTitleOptionMapper examinaTitleOptionMapper;
	@Autowired
	ExaminaQuestionAnswerMapper examinaQuestionAnswerMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	ExaminaAnswerCardMapper examinaAnswerCardMapper;
	@Autowired
	ExaminaManagementMapper examinaManagementMapper;
	@Autowired
	ExaminaExamQuestionMapper examinaExamQuestionMapper;
	@Autowired
	MessageSource messageSource;
	@Autowired
	UploadClient uploadClient;

	/**
	 * 新增试题
	 * 
	 * @param add
	 *            题目信息实体
	 * @param user
	 *            当前用户
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "新增试题")
	@Transactional(rollbackFor = Exception.class)
	public ExaminabankAdd addExaminaBank(ExaminabankAdd add, User user) {
		ExaminabankAdd examinabankAdd = new ExaminabankAdd();
		if (StringUtils.isBlank(add.getTestQuestionId())) {
			add.setTestQuestionId(UUID.randomUUID().toString());
		}
		// 新建题目
		TbManpowerExaminaBank tbBank = new TbManpowerExaminaBank();
		BeanUtils.copyProperties(add, tbBank);
		if (null == tbBank.getRecordStatus()) {
			Byte recordStatus = Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode());// 正常调研1
			tbBank.setRecordStatus(recordStatus);
		}
		String userAccount = user.getAccount();
		tbBank.setCreatorAccount(userAccount);
		tbBank.setCreatedTime(new Date());
		tbBank.setModifierAccount(userAccount);
		tbBank.setModifiedTime(new Date());
		tbManpowerExaminaBankMapper.insertSelective(tbBank);
		BeanUtils.copyProperties(tbBank, examinabankAdd);
		// 返回题目类型
		examinabankAdd.setTestQuestionTypeStr(getQuestType(examinabankAdd.getTestQuestionType()));
		// 题目选项
		List<ExaminaOptionAdd> optionList = add.getOptionList();
		if (null != optionList && optionList.size() > 0) {
			for (ExaminaOptionAdd option : optionList) {
				if (StringUtils.isBlank(option.getId())) {
					option.setId(UUID.randomUUID().toString());
				}
				if (StringUtils.isBlank(option.getTestQuestionId())) {
					option.setTestQuestionId(add.getTestQuestionId());
				}
				TbManpowerExaminaTitleOption tbOption = new TbManpowerExaminaTitleOption();
				BeanUtils.copyProperties(option, tbOption);
				if (StringUtils.isBlank(tbOption.getOptionId())) {
					tbOption.setOptionId(tbOption.getOptionId().toUpperCase());
				}
				tbManpowerExaminaTitleOptionMapper.insertSelective(tbOption);
			}
		}

		// 题目答案信息
		TbManpowerExaminaQuestionAnswer tbAnswer = new TbManpowerExaminaQuestionAnswer();
		BeanUtils.copyProperties(add, tbAnswer);
		tbAnswer.setId(UUID.randomUUID().toString());
		if (StringUtils.isBlank(tbAnswer.getTestQuestionId())) {
			add.setTestQuestionId(add.getTestQuestionId());
		}
		if (!StringUtils.isBlank(tbAnswer.getAnswerNumber())) {
			tbAnswer.setAnswerNumber(tbAnswer.getAnswerNumber().toUpperCase());
		}
		tbManpowerExaminaQuestionAnswerMapper.insertSelective(tbAnswer);
		if (!StringUtils.isBlank(tbAnswer.getId())) {
			examinabankAdd.setAnswerId(tbAnswer.getId());
		}
		if (!StringUtils.isBlank(tbAnswer.getAnswerNumber())) {
			if (tbAnswer.getAnswerNumber().equals("N")) {
				tbAnswer.setAnswerNumber("×");
			} else if (tbAnswer.getAnswerNumber().equals("Y")) {
				tbAnswer.setAnswerNumber("√");
			}
			examinabankAdd.setAnswerNumber(tbAnswer.getAnswerNumber());
		}
		if (!StringUtils.isBlank(tbAnswer.getAnswerHtml())) {
			examinabankAdd.setAnswerHtml(tbAnswer.getAnswerHtml());
		}
		logger.info("新增试题成功,testQuestionId:{}", tbBank.getTestQuestionId());
		return examinabankAdd;
	}

	/**获取题目类型
	 * @param questType
	 * @return
	 */
	private String getQuestType(String questType) {
		String questTypeStr = "";
		if (!StringUtils.isBlank(questType)) {
			if (questType.equals(ExaminaStatusEnmus.TYPE_ONE.getCode())) {
				questTypeStr = ExaminaStatusEnmus.TYPE_ONE.getMessage();
			} else if (questType.equals(ExaminaStatusEnmus.TYPE_TWO.getCode())) {
				questTypeStr = ExaminaStatusEnmus.TYPE_TWO.getMessage();
			} else if (questType.equals(ExaminaStatusEnmus.TYPE_THREE.getCode())) {
				questTypeStr = ExaminaStatusEnmus.TYPE_THREE.getMessage();
			} else if (questType.equals(ExaminaStatusEnmus.TYPE_FOUR.getCode())) {
				questTypeStr = ExaminaStatusEnmus.TYPE_FOUR.getMessage();
			} else {
				throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "参数异常，当前题目类型错误");
			}
		} else {
			throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "参数异常，题目类型不能为空");
		}
		return questTypeStr;
	}

	/**
	 * 查询试题详情
	 * 
	 * @param testQuestionId
	 *            试题编号
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "查询试题详情")
	public ExaminabankAdd selectExaminabank(String testQuestionId) {
		ExaminabankAdd data = new ExaminabankAdd();

		// 查询试题信息
		TbManpowerExaminaBank tbExaminaBank = selectExaminaBank(testQuestionId);
		BeanUtils.copyProperties(tbExaminaBank, data);

		// 查询题目所有选项
		List<TbManpowerExaminaTitleOption> tbOptionList = examinaTitleOptionMapper.optionList(testQuestionId);
		if (null != tbOptionList && tbOptionList.size() > 0) {
			List<ExaminaOptionAdd> optionList = BeanCopyUtil.copyList(tbOptionList, ExaminaOptionAdd.class);
			data.setOptionList(optionList);
		}

		// 查询题目答案列表
		TbManpowerExaminaQuestionAnswer tbAnswer = examinaQuestionAnswerMapper.answerList(testQuestionId);
		if (null != tbAnswer) {
			data.setAnswerId(tbAnswer.getId());
			if (!StringUtils.isBlank(tbAnswer.getAnswerHtml())) {
				data.setAnswerHtml(tbAnswer.getAnswerHtml());
				data.setStandardAnswer(tbAnswer.getAnswerHtml());
			}
			if (!StringUtils.isBlank(tbAnswer.getAnswerNumber())) {
				data.setAnswerNumber(tbAnswer.getAnswerNumber());
				data.setStandardAnswer(tbAnswer.getAnswerNumber());
			}
		} else {
			logger.warn("查询试题答案失败，试题未设置答案,testQuestionId:{}", testQuestionId);
			throw new JnSpringCloudException(ExaminaExceptionEnums.BANK_ANSWER_NOT_EXIST, "查询试题答案失败，试题未设置答案");
		}
		logger.info("查询试题详情成功,testQuestionId:{}", testQuestionId);
		return data;
	}

	/**
	 * 修改试题
	 * 
	 * @param examinabank
	 *            试题
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "修改试题功能")
	@Transactional(rollbackFor = Exception.class)
	public void updateExaminabank(Examinabank examinabank, User user) {
		String testQuestionId = examinabank.getTestQuestionId();

		// 编辑题目信息
		TbManpowerExaminaBank tbBank = selectExaminaBank(testQuestionId);
		tbBank = new TbManpowerExaminaBank();
		BeanUtils.copyProperties(examinabank, tbBank);
		String userAccount = user.getAccount();
		tbBank.setModifierAccount(userAccount);
		tbBank.setModifiedTime(new Date());
		if (!StringUtils.isBlank(tbBank.getStandardAnswer())) {
			tbBank.setStandardAnswer(null);
		}
		tbManpowerExaminaBankMapper.updateByPrimaryKeySelective(tbBank);

		// 编辑题目选项
		// 新增/编辑选项
		List<ExaminaOption> optionList = examinabank.getOptionList();
		if (null != optionList && optionList.size() != 0) {
			for (ExaminaOption option : optionList) {
				if (StringUtils.isBlank(option.getId())) {
					TbManpowerExaminaTitleOption tbOption = new TbManpowerExaminaTitleOption();
					BeanUtils.copyProperties(option, tbOption);
					if (StringUtils.isBlank(tbOption.getId())) {
						tbOption.setId(UUID.randomUUID().toString());
					}
					if (StringUtils.isBlank(tbOption.getTestQuestionId())) {
						tbOption.setTestQuestionId(examinabank.getTestQuestionId());
					}
					tbManpowerExaminaTitleOptionMapper.insertSelective(tbOption);
				} else {
					TbManpowerExaminaTitleOption tbOption = new TbManpowerExaminaTitleOption();
					BeanUtils.copyProperties(option, tbOption);
					tbManpowerExaminaTitleOptionMapper.updateByPrimaryKeySelective(tbOption);
				}

			}
		}
		// 删除选项
		List<ExaminaOption> delOptionList = examinabank.getDelOptionList();
		if (null != delOptionList && delOptionList.size() != 0) {
			for (ExaminaOption delOption : delOptionList) {
				tbManpowerExaminaTitleOptionMapper.deleteByPrimaryKey(delOption.getId());
			}
		}

		// 编辑题目答案
		String answerId = examinabank.getAnswerId();
		TbManpowerExaminaQuestionAnswer tbQuestionAnswer = getQuestionAnswer(answerId);
		tbQuestionAnswer = new TbManpowerExaminaQuestionAnswer();
		BeanUtils.copyProperties(examinabank, tbQuestionAnswer);
		tbQuestionAnswer.setId(answerId);
		tbManpowerExaminaQuestionAnswerMapper.updateByPrimaryKeySelective(tbQuestionAnswer);
		logger.info("编辑题目信息成功,testQuestionId:{}", examinabank.getTestQuestionId());
	}

	/**
	 * 删除试题
	 * 
	 * @param testQuestionId
	 *            试题编号
	 * @param user
	 *            当前用户
	 */
	@Override
	@ServiceLog(doAction = "删除题目功能")
	@Transactional(rollbackFor = Exception.class)
	public void deleteExaminaBank(String testQuestionId, User user) {
		// 判断当前题目是否存在
		TbManpowerExaminaBank tbBank = selectExaminaBank(testQuestionId);
		tbBank = new TbManpowerExaminaBank();
		String userAccount = user.getAccount();
		tbBank.setTestQuestionId(testQuestionId);
		tbBank.setModifierAccount(userAccount);
		tbBank.setModifiedTime(new Date());
		tbBank.setRecordStatus(Byte.parseByte(HrStatusEnums.DELETED.getCode()));
		tbManpowerExaminaBankMapper.updateByPrimaryKeySelective(tbBank);
		logger.info("删除试题成功,testQuestionId:{}", testQuestionId);
	}

	/**
	 * 分页查询试题列表
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "分页查询试题列表")
	public PaginationData<List<ExaminabankAdd>> selectBankList(ExaminabankPage page) {

		if (!StringUtils.isBlank(page.getStartDateStr())) {
			page.setStartDate(DateUtils.parseDate(page.getStartDateStr()));
		}
		if (!StringUtils.isBlank(page.getEndDateStr())) {
			page.setEndDate(HrDataUtil.getEndOfDayTime(DateUtils.parseDate(page.getEndDateStr())));
		}

		Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
		List<ExaminabankAdd> examinabankList = examinaBankMapper.list(page);
		for (ExaminabankAdd examinabank : examinabankList) {
			if (!StringUtils.isBlank(examinabank.getAnswerNumber())) {
				examinabank.setStandardAnswer(examinabank.getAnswerNumber());
			} else if (!StringUtils.isBlank(examinabank.getAnswerHtml())) {
				examinabank.setStandardAnswer(examinabank.getAnswerHtml());
			}
			examinabank.setCreatedTimeStr(DateUtils.formatDate(examinabank.getCreatedTime(), "yyyy-MM-dd HH:mm:ss"));

		}
		PaginationData<List<ExaminabankAdd>> data = new PaginationData(examinabankList, objects.getTotal());
		logger.info("查询试题列表成功!");
		return data;
	}

	/**
	 * 跟据答案编号，查询答案信息
	 * @param answerId
	 * @return
	 */
	private TbManpowerExaminaQuestionAnswer getQuestionAnswer(String answerId) {
		TbManpowerExaminaQuestionAnswer tbQuestionAnswer = tbManpowerExaminaQuestionAnswerMapper
				.selectByPrimaryKey(answerId);
		if (null == tbQuestionAnswer) {
			logger.warn("查询试题答案失败，当前试题未设置答案,answerId:{}", answerId);
			throw new JnSpringCloudException(ExaminaExceptionEnums.BANK_ANSWER_NOT_EXIST, "查询试题答案失败，当前试题未设置答案");
		}
		return tbQuestionAnswer;
	}

	/**
	 * 创建考试
	 *
	 * @param add
	 *            新增考试实体
	 * @param user
	 *            当前用户
	 */
	@Override
	@ServiceLog(doAction = "创建考试功能")
	@Transactional(rollbackFor = Exception.class)
	public ExaminaManagement addExaminaManagement(ExaminaManagement add, User user) {
		ExaminaManagement examinaManagement = new ExaminaManagement();
		if (StringUtils.isBlank(add.getId())) {
			add.setId(UUID.randomUUID().toString());
			// 新建试卷
			TbManpowerExaminaManagement management = new TbManpowerExaminaManagement();
			BeanUtils.copyProperties(add, management);
			String account = user.getAccount();
			management.setCreatorAccount(account);
			management.setCreatedTime(new Date());
			management.setModifierAccount(account);
			management.setModifiedTime(new Date());
			if (null == management.getIsRelease()) {
				management.setIsRelease(Byte.parseByte(ExaminaStatusEnmus.UN_SEND.getCode()));
			}
			if (null == management.getStatus()) {
				String status = getStatus(management);
				management.setStatus(Byte.parseByte(status));
			}
			if (null == management.getRecordStatus()) {
				management.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
			}
			if (!StringUtils.isBlank(management.getExaminaDimensional())) {
				management.setExaminaDimensional(management.getExaminaDimensional() + "?id=" + management.getId());
			}
			if (!StringUtils.isBlank(management.getExaminaUrl())) {
				management.setExaminaUrl(management.getExaminaUrl() + "?id=" + management.getId());
			}
			tbManpowerExaminaManagementMapper.insertSelective(management);

			// 写考试题目关联信息
			List<Examinabank> examinabankList = add.getExaminabanksList();
			if (null != examinabankList && examinabankList.size() > 0) {
				for (Examinabank examinabank : examinabankList) {
					TbManpowerExaminaExamQuestion examQuestion = new TbManpowerExaminaExamQuestion();
					examQuestion.setId(UUID.randomUUID().toString());
					examQuestion.setExaminaId(add.getId());
					examQuestion.setTestQuestionId(examinabank.getTestQuestionId());
					examQuestion.setFraction(examinabank.getFraction());
					tbManpowerExaminaExamQuestionMapper.insertSelective(examQuestion);
				}
			}
			BeanUtils.copyProperties(management, examinaManagement);
		} else {
			// 编辑考试
			updateExamInfo(add, user);
			TbManpowerExaminaManagement tbExaminaManagement = selectExaminaManagement(add.getId());
			BeanUtils.copyProperties(tbExaminaManagement, examinaManagement);
		}

		logger.info("设计试卷试题成功,试卷id:{}", add.getId());
		return examinaManagement;
	}

	/**
	 * 查询试卷详情
	 * 
	 * @param id
	 *            试卷编号
	 */
	@Override
	@ServiceLog(doAction = "查询试卷详情功能")
	@Transactional(rollbackFor = Exception.class)
	public ExaminaManagementAdd selectExamInfo(String id) {
		ExaminaManagementAdd examinaAnswerAdd = new ExaminaManagementAdd();
		TbManpowerExaminaManagement tbExaminaManagement = selectExaminaManagement(id);
		BeanUtils.copyProperties(tbExaminaManagement, examinaAnswerAdd);
		Examinabank examinabank = new Examinabank();
		examinabank.setExaminaId(id);
		List<Examinabank> examinabanksList = selectBankByExaminaIdList(examinabank);

		// 查询考试题目关联信息
		// List<TbManpowerExaminaExamQuestion> tbManpowerExaminaExamQuestions =
		// examinaExamQuestionMapper
		// .selectListByExaminaId(id);
		//
		// List<Examinabank> examinabanksList = new ArrayList<Examinabank>();
		// for (TbManpowerExaminaExamQuestion tbManpowerExaminaExamQuestion :
		// tbManpowerExaminaExamQuestions) {
		// Examinabank examinabank = new Examinabank();
		// examinabank.setExamQuestionId(tbManpowerExaminaExamQuestion.getId());
		// examinabank.setTestQuestionId(tbManpowerExaminaExamQuestion.getTestQuestionId());
		// examinabank.setExaminaId(id);
		// // 题目信息
		// ExaminabankAdd examinabankAdd = selectExaminabank(examinabank);
		// BeanUtils.copyProperties(examinabankAdd, examinabank);
		//
		// // 选项列表
		// List<ExaminaOptionAdd> optionAddList =
		// examinabankAdd.getOptionList();
		// if (null != optionAddList && optionAddList.size() > 0) {
		// List<ExaminaOption> optionList = BeanCopyUtil.copyList(optionAddList,
		// ExaminaOption.class);
		// examinabank.setOptionList(optionList);
		// }
		// examinabanksList.add(examinabank);
		// }
		examinaAnswerAdd.setExaminabanksList(examinabanksList);
		logger.info("查看试卷信息成功成功.id{}", id);
		return examinaAnswerAdd;
	}

	/**查询当前题目所有试题信息
	 * @param examinabank
	 * @return
	 */
	private List<Examinabank> selectBankByExaminaIdList(Examinabank examinabank) {
		List<Examinabank> tbExaminaBankList = examinaBankMapper.selectBankByExaminaId(examinabank);
		if (null != tbExaminaBankList && tbExaminaBankList.size() > 0) {
			for (Examinabank tbExaminaBank : tbExaminaBankList) {
				if (!StringUtils.isBlank(tbExaminaBank.getAnswerHtml())) {
					tbExaminaBank.setStandardAnswer(tbExaminaBank.getAnswerHtml());
				}
				// 查询题目所有选项
				List<TbManpowerExaminaTitleOption> tbOptionList = examinaTitleOptionMapper
						.optionList(tbExaminaBank.getTestQuestionId());
				if (null != tbOptionList && tbOptionList.size() > 0) {
					List<ExaminaOption> optionList = BeanCopyUtil.copyList(tbOptionList, ExaminaOption.class);
					tbExaminaBank.setOptionList(optionList);
				}
			}
		}
		return tbExaminaBankList;
	}

	/**
	 * 编辑试卷
	 * 
	 * @param id
	 *            试卷编号
	 */
	@Override
	@ServiceLog(doAction = "编辑试卷功能")
	@Transactional(rollbackFor = Exception.class)
	public void updateExamInfo(ExaminaManagement examinaManagement, User user) {

		TbManpowerExaminaManagement updExaminaManagement = new TbManpowerExaminaManagement();
		BeanUtils.copyProperties(examinaManagement, updExaminaManagement);
		updExaminaManagement.setModifiedTime(new Date());
		updExaminaManagement.setModifierAccount(user.getAccount());
		if (null == updExaminaManagement.getStatus()) {
			String status = getStatus(updExaminaManagement);
			updExaminaManagement.setStatus(Byte.parseByte(status));
		}
		tbManpowerExaminaManagementMapper.updateByPrimaryKeySelective(updExaminaManagement);

		// 查询考试题目关联信息
		List<TbManpowerExaminaExamQuestion> tbManpowerExaminaExamQuestions = examinaExamQuestionMapper
				.selectListByExaminaId(updExaminaManagement.getId());
		Map<String, String> map = new HashMap<String, String>();
		List<String> testQuestionIdList = new ArrayList<String>();// 已添加题目
		for (TbManpowerExaminaExamQuestion tbManpowerExaminaExamQuestion : tbManpowerExaminaExamQuestions) {
			testQuestionIdList.add(tbManpowerExaminaExamQuestion.getTestQuestionId());
			map.put(tbManpowerExaminaExamQuestion.getTestQuestionId(), tbManpowerExaminaExamQuestion.getId());
		}

		// 试题列表
		List<String> updtestQuestionIdList = new ArrayList<String>();
		List<Examinabank> examinabanksList = examinaManagement.getExaminabanksList();
		if (null != examinabanksList && examinabanksList.size() > 0) {
			for (Examinabank examinabank : examinabanksList) {
				// 新加试题
				if (StringUtils.isBlank(examinabank.getTestQuestionId())) {
					TbManpowerExaminaExamQuestion tbManpowerExaminaExamQuestion = new TbManpowerExaminaExamQuestion();
					tbManpowerExaminaExamQuestion.setId(UUID.randomUUID().toString());
					tbManpowerExaminaExamQuestion.setTestQuestionId(examinabank.getTestQuestionId());
					tbManpowerExaminaExamQuestion.setExaminaId(updExaminaManagement.getId());
					tbManpowerExaminaExamQuestion.setFraction(examinabank.getFraction());
					tbManpowerExaminaExamQuestionMapper.insertSelective(tbManpowerExaminaExamQuestion);
				} else {
					// 修改试题信息
					updtestQuestionIdList.add(examinabank.getTestQuestionId());
					String id = map.get(examinabank.getTestQuestionId());
					TbManpowerExaminaExamQuestion tbManpowerExaminaBank = new TbManpowerExaminaExamQuestion();
					tbManpowerExaminaBank.setId(id);
					tbManpowerExaminaBank.setFraction(examinabank.getFraction());
					tbManpowerExaminaExamQuestionMapper.updateByPrimaryKeySelective(tbManpowerExaminaBank);
				}
			}
		}
		// 删除的题目id
		List<String> deltestQuestionIdList = HrDataUtil.getRemoveAll(testQuestionIdList, updtestQuestionIdList);
		for (String deltestQuestionId : deltestQuestionIdList) {
			String id = map.get(deltestQuestionId);
			tbManpowerExaminaExamQuestionMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 删除试卷
	 * 
	 * @param id
	 *            试卷编号
	 */
	@Override
	@ServiceLog(doAction = "删除试卷功能")
	@Transactional(rollbackFor = Exception.class)
	public void deleteExamInfo(ExaminaManagement examinaManagement, User user) {
		TbManpowerExaminaManagement updExaminaManagement = new TbManpowerExaminaManagement();
		updExaminaManagement.setModifiedTime(new Date());
		updExaminaManagement.setModifierAccount(user.getAccount());
		updExaminaManagement.setId(examinaManagement.getId());
		updExaminaManagement.setRecordStatus(Byte.parseByte(HrStatusEnums.DELETED.getCode()));
		tbManpowerExaminaManagementMapper.updateByPrimaryKeySelective(updExaminaManagement);
	}

	/**
	 * 发放考试
	 * 
	 * @param examinaManagement
	 *            试卷实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "发放考试功能")
	@Transactional(rollbackFor = Exception.class)
	public void sendExaminaManagement(ExaminaManagement examinaManagement, User user) {
		String id = examinaManagement.getId();
		TbManpowerExaminaManagement tbExaminaManagement = selectExaminaManagement(id);
		Date startDate = tbExaminaManagement.getEffectiveTimeStart();
		Date endDate = tbExaminaManagement.getEffectiveTimeEnd();
		Date xtsj = new Date();
		if (startDate.compareTo(xtsj) < 0) {
			logger.warn("发放考试失败，当前考试已开始,examinaName:{}", tbExaminaManagement.getExaminaName());
			if (!tbExaminaManagement.getStatus().equals(Byte.parseByte(ExaminaStatusEnmus.UNDER_WAY.getCode()))) {
				TbManpowerExaminaManagement updExaminaManagement = new TbManpowerExaminaManagement();
				updExaminaManagement.setId(id);
				updExaminaManagement.setStatus(Byte.parseByte(ExaminaStatusEnmus.UNDER_WAY.getCode()));
				tbManpowerExaminaManagementMapper.updateByPrimaryKeySelective(updExaminaManagement);
			}
			throw new JnSpringCloudException(ExaminaExceptionEnums.SEND_MANAGEMENT_ERROR, "发放考试失败，当前考试已开始");
		}
		if (endDate.compareTo(xtsj) < 0) {
			logger.warn("发放考试失败，当前考试已结束,examinaName:{}", tbExaminaManagement.getExaminaName());
			if (!tbExaminaManagement.getStatus().equals(Byte.parseByte(ExaminaStatusEnmus.HAS_END.getCode()))) {
				TbManpowerExaminaManagement updExaminaManagement = new TbManpowerExaminaManagement();
				updExaminaManagement.setId(id);
				updExaminaManagement.setStatus(Byte.parseByte(ExaminaStatusEnmus.HAS_END.getCode()));
				tbManpowerExaminaManagementMapper.updateByPrimaryKeySelective(updExaminaManagement);
			}
			throw new JnSpringCloudException(ExaminaExceptionEnums.SEND_MANAGEMENT_ERROR, "发放考试失败，当前考试已结束");
		}

		if (!StringUtils.isBlank(examinaManagement.getEmailList())
				&& !StringUtils.isBlank(examinaManagement.getEmailSubject())
				&& !StringUtils.isBlank(examinaManagement.getEmailContent())) {
			String emailList = examinaManagement.getEmailList();
			String[] emails = emailList.split(",");
			for (String email : emails) {
				if (!ValidateUtil.isEmail(email)) {
					logger.warn("发放考试失败,输入邮箱格式错误(注意:邮箱请使用‘,’分隔):{}", email);
					throw new JnSpringCloudException(ExaminaExceptionEnums.SEND_MANAGEMENT_ERROR,
							"发放考试失败,输入邮箱格式错误(注意:邮箱请使用‘,’分隔)");
				}
			}
			EmailVo emailVo = new EmailVo();
			emailVo.setEmail(emailList);
			emailVo.setEmailSubject(examinaManagement.getEmailSubject());
			emailVo.setEmailContent(examinaManagement.getEmailContent());
			boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
			if (!sendStatus) {
				logger.warn("发送邮件通知失败：{}", tbExaminaManagement.getExaminaName());
				throw new JnSpringCloudException(ExaminaExceptionEnums.SEND_MANAGEMENT_ERROR, "发送邮件通知失败");

			}
		}

		// 更新考试状态为已发送
		TbManpowerExaminaManagement updExaminaManagement = new TbManpowerExaminaManagement();
		updExaminaManagement.setId(id);
		updExaminaManagement.setIsRelease(Byte.parseByte(ExaminaStatusEnmus.IS_SEND.getCode()));
		updExaminaManagement.setModifierAccount(user.getAccount());
		updExaminaManagement.setModifiedTime(new Date());
		tbManpowerExaminaManagementMapper.updateByPrimaryKeySelective(updExaminaManagement);
		logger.info("发布考试通知成功.id{},name:{}", tbExaminaManagement.getId(), tbExaminaManagement.getExaminaName());
	}

	/**
	 * 分页查询试卷列表
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "分页查询试卷列表")
	public PaginationData<List<ExaminaManagementAdd>> selectExaminaManagementList(ExaminaManagementPage page) {
		List<TbManpowerExaminaManagement> tbList = examinaManagementMapper.listManagement();
		for (TbManpowerExaminaManagement tbManagement : tbList) {
			String status = getStatus(tbManagement);
			if (!tbManagement.getStatus().toString().equals(status)) {
				tbManagement.setStatus(Byte.parseByte(status));
				tbManpowerExaminaManagementMapper.updateByPrimaryKeySelective(tbManagement);
				continue;
			}
		}
		// 获取各状态数据条数
		List<ExaminaManagement> managementList = examinaManagementMapper.selectByStatus(page);
		Integer statusCount = 0;// 总条数
		Integer notStartStatusCount = 0;// 未开始条数
		Integer underWayStatusCount = 0;// 进行中条数
		Integer hasEndStatusCount = 0;// 已结束条数
		if (null != managementList && managementList.size() > 0) {
			for (ExaminaManagement management : managementList) {
				if (management.getStatus().toString().equals(ExaminaStatusEnmus.NOT_START.getCode())) {
					notStartStatusCount += management.getStatusCount();
					continue;
				}
				if (management.getStatus().toString().equals(ExaminaStatusEnmus.UNDER_WAY.getCode())) {
					underWayStatusCount += management.getStatusCount();
					continue;
				}
				if (management.getStatus().toString().equals(ExaminaStatusEnmus.HAS_END.getCode())) {
					hasEndStatusCount += management.getStatusCount();
					continue;
				}
			}
			statusCount = underWayStatusCount + hasEndStatusCount + notStartStatusCount;
		}

		Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
		List<ExaminaManagementAdd> examinabankList = examinaManagementMapper.list(page);
		if (null != examinabankList && examinabankList.size() > 0) {
			for (ExaminaManagementAdd examinabank : examinabankList) {
				Integer resultCount = examinaResultInfoMapper.resultCount(examinabank.getId());
				examinabank.setResultCount(resultCount.toString());
				examinabank.setEffectiveTimeStartStr(
						DateUtils.formatDate(examinabank.getEffectiveTimeStart(), "yyyy-MM-dd HH:mm:ss"));
				examinabank.setEffectiveTimeEndStr(
						DateUtils.formatDate(examinabank.getEffectiveTimeEnd(), "yyyy-MM-dd HH:mm:ss"));
				examinabank.setStatusCount(statusCount);
				examinabank.setNotStartStatusCount(notStartStatusCount);
				examinabank.setUnderWayStatusCount(underWayStatusCount);
				examinabank.setHasEndStatusCount(hasEndStatusCount);
			}
		} else {
			examinabankList = new ArrayList<ExaminaManagementAdd>();
			ExaminaManagementAdd examinabank = new ExaminaManagementAdd();
			examinabank.setStatusCount(statusCount);
			examinabank.setNotStartStatusCount(notStartStatusCount);
			examinabank.setUnderWayStatusCount(underWayStatusCount);
			examinabank.setHasEndStatusCount(hasEndStatusCount);
			examinabankList.add(examinabank);
		}

		PaginationData<List<ExaminaManagementAdd>> data = new PaginationData(examinabankList, objects.getTotal());
		logger.info("查询试题列表成功!");
		return data;
	}

	/**
	 * 跟据时间获取状态
	 * @param tbManagement
	 * @return
	 */
	private String getStatus(TbManpowerExaminaManagement tbManagement) {
		String status = ExaminaStatusEnmus.NOT_START.getCode();
		if (null != tbManagement.getEffectiveTimeStart()) {
			if (tbManagement.getEffectiveTimeStart().compareTo(new Date()) > 0) {
				status = ExaminaStatusEnmus.NOT_START.getCode();
			}
		}
		if (null != tbManagement.getEffectiveTimeEnd()) {
			if (tbManagement.getEffectiveTimeEnd().compareTo(new Date()) < 0) {
				status = ExaminaStatusEnmus.HAS_END.getCode();
			}
		}
		if (null != tbManagement.getEffectiveTimeStart() && null != tbManagement.getEffectiveTimeEnd()) {
			if (tbManagement.getEffectiveTimeStart().compareTo(new Date()) < 0
					&& tbManagement.getEffectiveTimeEnd().compareTo(new Date()) > 0) {
				status = ExaminaStatusEnmus.UNDER_WAY.getCode();
			}
		}
		return status;
	}

	/**
	 * 跟据试卷id和题目id查询试卷题目信息
	 * @param examinabank
	 * @return
	 */
	private ExaminabankAdd selectExaminabank(Examinabank examinabank) {

		// 查询试题信息
		ExaminabankAdd tbExaminaBank = selectExaminaBankByExaminaId(examinabank);

		// 查询题目所有选项
		List<TbManpowerExaminaTitleOption> tbOptionList = examinaTitleOptionMapper
				.optionList(tbExaminaBank.getTestQuestionId());
		if (null != tbOptionList && tbOptionList.size() > 0) {
			List<ExaminaOptionAdd> optionList = BeanCopyUtil.copyList(tbOptionList, ExaminaOptionAdd.class);
			tbExaminaBank.setOptionList(optionList);
		}

		logger.info("查询试题详情成功,testQuestionId:{}", tbExaminaBank.getTestQuestionId());
		return tbExaminaBank;
	}

	/**
	 * 登录答题页
	 * 
	 * @param id
	 *            试卷编号
	 */
	@Override
	@ServiceLog(doAction = "登录答题页功能")
	@Transactional(rollbackFor = Exception.class)
	public ExaminaManagementAdd loginManagement(ExaminaManagement management) {
		ExaminaManagementAdd examinaAnswerAdd = new ExaminaManagementAdd();
		String id = management.getId();
		TbManpowerExaminaManagement tbExaminaManagement = selectExaminaManagement(id);
		if (!StringUtils.isBlank(management.getJobNumber())) {
			if (tbExaminaManagement.getEffectiveTimeStart().compareTo(new Date()) > 0) {
				logger.warn("参加考试失败，当前考试未开始,id:{}", tbExaminaManagement.getId());
				throw new JnSpringCloudException(ExaminaExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加考试失败,当前考试未开始");
			}

			if (tbExaminaManagement.getEffectiveTimeEnd().compareTo(new Date()) < 0) {
				logger.warn("参加考试失败，当前考试已结束,id:{}", tbExaminaManagement.getId());
				throw new JnSpringCloudException(ExaminaExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加考试失败,当前考试已结束");
			}
			TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = employeeBasicInfoMapper
					.selectByJobNumber(management.getJobNumber());// 查询用户信息
			if (null == tbManpowerEmployeeBasicInfo) {
				logger.warn("参加考试失败,当前工号不存在,jobNumber:{}", management.getJobNumber());
				throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "参加考试失败,当前工号不存在");
			}

			TbManpowerExaminaResultInfo resultInfo = new TbManpowerExaminaResultInfo();
			resultInfo.setExaminaId(id);
			resultInfo.setJobNumber(management.getJobNumber());
			TbManpowerExaminaResultInfo tbResultInfo = examinaResultInfoMapper.selectUserResult(resultInfo);
			if (null != tbResultInfo) {
				logger.warn("参加考试失败，已完成当前考试,id:{},jobNumber:{}", tbExaminaManagement.getId(),
						management.getJobNumber());
				throw new JnSpringCloudException(ExaminaExceptionEnums.EXIST_RESULT_INFO, "参加考试失败，已完成当前考试");
			}
			examinaAnswerAdd.setJobNumber(management.getJobNumber());
			BeanUtils.copyProperties(tbExaminaManagement, examinaAnswerAdd);
			// 查询考试题目及答案信息
			Examinabank examinabank = new Examinabank();
			examinabank.setExaminaId(id);
			List<Examinabank> examinabanksList = selectBankByExaminaIdList(examinabank);
			examinaAnswerAdd.setExaminabanksList(examinabanksList);
		} else {
			BeanUtils.copyProperties(tbExaminaManagement, examinaAnswerAdd);
			logger.info("查看试卷信息成功.id{}", id);
			return examinaAnswerAdd;
		}
		logger.info("查看试卷信息成功.id{}", id);
		return examinaAnswerAdd;
	}

	/**
	 * 提交答案
	 * 
	 * @param examinaManagement
	 *            答案实体
	 */
	@Override
	@ServiceLog(doAction = "提交答案功能")
	@Transactional(rollbackFor = Exception.class)
	public ExaminaManagementAdd insterAnswerCard(ExaminaManagement examinaManagement) {
		ExaminaManagementAdd examinaManagementAdd = new ExaminaManagementAdd();
		String id = examinaManagement.getId();
		if (StringUtils.isBlank(id)) {
			logger.warn("试卷编号不能为空");
			throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "试卷编号不能为空");
		}
		if (StringUtils.isBlank(examinaManagement.getJobNumber())) {
			logger.warn("用户工号不能为空,jobNumber:{}", examinaManagement.getJobNumber());
			throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "用户工号不能为空");
		}
		TbManpowerExaminaResultInfo resultInfo = new TbManpowerExaminaResultInfo();
		resultInfo.setExaminaId(examinaManagement.getId());
		resultInfo.setJobNumber(examinaManagement.getJobNumber());
		TbManpowerExaminaResultInfo tbResultInfo = examinaResultInfoMapper.selectUserResult(resultInfo);
		if (null != tbResultInfo) {
			logger.warn("用户已完成当前考试,id:{},jobNumber:{}", examinaManagement.getId(), examinaManagement.getJobNumber());
			examinaManagementAdd = getSuccessAnswer(examinaManagement, tbResultInfo);
		} else {
			// 查询考试信息
			TbManpowerExaminaManagement tbManagement = selectExaminaManagement(id);
			BeanUtils.copyProperties(tbManagement, examinaManagementAdd);

			List<Examinabank> examinabankAddList = new ArrayList<Examinabank>();
			List<Examinabank> examinabanksList = examinaManagement.getExaminabanksList();

			TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = employeeBasicInfoMapper
					.selectByJobNumber(examinaManagement.getJobNumber());// 查询用户信息
			if (null == tbManpowerEmployeeBasicInfo) {
				logger.warn("参加考试失败,当前工号不存在jobNumber:{}", examinaManagement.getJobNumber());
				throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "参加考试失败,当前工号不存在");
			}
			float achievement = 0;// 得分
			Integer examinabankSize = 0;// 试题个数
			double notErrorexaminBankSize = 0;// 正确个数
			if (null != examinabanksList && examinabanksList.size() > 0) {
				List<TbManpowerExaminaAnswerCard> cardList = new ArrayList<TbManpowerExaminaAnswerCard>();
				for (Examinabank examinabank : examinabanksList) {
					examinabankSize++;
					// 查询试题信息
					Examinabank examinabankAdd = new Examinabank();
					examinabank.setExaminaId(id);
					ExaminabankAdd tbExaminaBank = selectExaminaBankByExaminaId(examinabank);
					BeanUtils.copyProperties(tbExaminaBank, examinabankAdd);

					// 计算成绩
					Float achievementStr = 0f;
					String answerType = ExaminaStatusEnmus.TYPE_TRUE.getCode();// 题目类型--正确
					if (!StringUtils.isBlank(tbExaminaBank.getStandardAnswer())) {
						String answer = examinabank.getAnswer();// 答案信息
						if (StringUtils.isBlank(answer)) {
							answer = "";
							examinabank.setAnswer(answer);
						}
						Float fraction = Float.parseFloat(tbExaminaBank.getFraction());// 题目分数
						String tbAnswerStr = tbExaminaBank.getStandardAnswer();// 题目答案
						if (!StringUtils.isBlank(tbExaminaBank.getAnswerHtml())) {
							// 判断是否是问答题
							achievementStr = HrDataUtil.getSimilarityRatio(answer, tbAnswerStr, fraction);
						} else {
							achievementStr = HrDataUtil.examinee(answer, tbAnswerStr, fraction);
						}
						if (achievementStr != 0) {
							if (achievementStr.equals(fraction)) {
								notErrorexaminBankSize++;
							} else {
								answerType = ExaminaStatusEnmus.TYPE_FALSE.getCode();
								notErrorexaminBankSize = notErrorexaminBankSize + 0.5;
							}
							int achievementInt = (int) Math.ceil(achievementStr);
							achievementStr = (float) achievementInt;
							achievement += achievementStr;
						} else {
							answerType = ExaminaStatusEnmus.TYPE_TRUE.getCode();
						}

						TbManpowerExaminaAnswerCard tbManpowerExaminaAnswerCard = new TbManpowerExaminaAnswerCard();
						tbManpowerExaminaAnswerCard.setId(UUID.randomUUID().toString());
						tbManpowerExaminaAnswerCard.setAnswer(examinabank.getAnswer());
						tbManpowerExaminaAnswerCard.setTestQuestId(examinabank.getTestQuestionId());
						tbManpowerExaminaAnswerCard.setTestPaperId(examinaManagement.getId());
						tbManpowerExaminaAnswerCard.setJobNumber(tbManpowerEmployeeBasicInfo.getJobNumber());
						if (achievementStr.compareTo(fraction) > 0) {
							achievementStr = fraction;
						}
						tbManpowerExaminaAnswerCard.setTitleScore(achievementStr.intValue() + "");
						tbManpowerExaminaAnswerCard.setAnswerType(answerType);
						cardList.add(tbManpowerExaminaAnswerCard);
						// tbManpowerExaminaAnswerCardMapper.insertSelective(tbManpowerExaminaAnswerCard);
						examinabankAddList.add(examinabankAdd);
					}
				}
				if (null != cardList && cardList.size() > 0) {
					examinaAnswerCardMapper.insertBatch(cardList);
				}
			}
			examinaManagementAdd.setExaminabanksList(examinabankAddList);

			TbManpowerExaminaResultInfo examinaResultInfo = new TbManpowerExaminaResultInfo();
			BeanUtils.copyProperties(examinaManagement, examinaResultInfo);
			examinaResultInfo.setId(UUID.randomUUID().toString());
			examinaResultInfo.setExaminaId(examinaManagement.getId());
			if (null != tbManpowerEmployeeBasicInfo) {
				examinaResultInfo.setJobNumber(tbManpowerEmployeeBasicInfo.getJobNumber());
				examinaResultInfo.setName(tbManpowerEmployeeBasicInfo.getName());
			}
			examinaResultInfo.setAchievement((int) achievement);
			if (tbManagement.getTotalScore().compareTo((int) achievement) < 0) {
				examinaResultInfo.setAchievement(tbManagement.getTotalScore());
			}
			if (tbManagement.getPassScore().compareTo(examinaResultInfo.getAchievement()) <= 0) {
				examinaResultInfo.setIsAdopt(Byte.parseByte(ExaminaStatusEnmus.IS_ADOPT.getCode()));
			} else {
				examinaResultInfo.setIsAdopt(Byte.parseByte(ExaminaStatusEnmus.UN_ADOPT.getCode()));
			}
			if (null == examinaResultInfo.getExaminaEndTime()) {
				examinaResultInfo.setExaminaEndTime(new Date());
			}
			if (null == examinaResultInfo.getUseTime()) {
				Long startTime = examinaResultInfo.getExaminaStartTime().getTime();
				Long endTime = examinaResultInfo.getExaminaEndTime().getTime();
				int useTime = (int) ((endTime - startTime) / 1000 / 60);
				examinaResultInfo.setUseTime(useTime);
			}

			if (null == examinaResultInfo.getRank()) {
				Integer rank = getRank(id, examinaResultInfo.getAchievement());
				examinaResultInfo.setRank(rank);
			}
			examinaResultInfo.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
			tbManpowerExaminaResultInfoMapper.insertSelective(examinaResultInfo);

			examinaManagementAdd.setResultId(examinaResultInfo.getId());
			examinaManagementAdd.setIsAdopt(examinaResultInfo.getIsAdopt());
			examinaManagementAdd.setUseTime(examinaResultInfo.getUseTime());
			examinaManagementAdd.setAchievement(examinaResultInfo.getAchievement());
			examinaManagementAdd.setYesExaminaBankSize(notErrorexaminBankSize);
			examinaManagementAdd.setExaminabankSize(examinabankSize);
			examinaManagementAdd.setAccuracyRate(
					HrDataUtil.getDoublePercentStr(notErrorexaminBankSize, examinabankSize.doubleValue()) + "%");
			examinaManagementAdd.setScoreRate(
					HrDataUtil.getPercentStr(examinaResultInfo.getAchievement(), tbManagement.getTotalScore()) + "%");
		}
		return examinaManagementAdd;
	}

	/**
	 * 获取答题后界面
	 * 
	 * @param examinaManagement
	 * @param tbResultInfo
	 * @return
	 */
	private ExaminaManagementAdd getSuccessAnswer(ExaminaManagement examinaManagement,
			TbManpowerExaminaResultInfo tbResultInfo) {
		ExaminaManagementAdd examinaManagementAdd = new ExaminaManagementAdd();
		TbManpowerExaminaManagement tbManagement = selectExaminaManagement(examinaManagement.getId());
		BeanUtils.copyProperties(tbResultInfo, examinaManagementAdd);
		examinaManagementAdd.setResultId(tbResultInfo.getId());

		Examinabank tbExaminabank = new Examinabank();
		tbExaminabank.setJobNumber(examinaManagement.getJobNumber());
		tbExaminabank.setTestPaperId(examinaManagement.getId());
		List<TbManpowerExaminaAnswerCard> tbAnswerCardList = examinaAnswerCardMapper
				.selectAnswerCardList(tbExaminabank);
		double notErrorexaminBankSize = 0f;
		Integer examinabankSize = 0;

		for (TbManpowerExaminaAnswerCard tbAnswerCard : tbAnswerCardList) {
			if (tbAnswerCard.getAnswerType().equals(ExaminaStatusEnmus.TYPE_TRUE.getCode())) {
				notErrorexaminBankSize++;
			}
			examinabankSize++;
		}
		examinaManagementAdd.setYesExaminaBankSize(notErrorexaminBankSize);
		examinaManagementAdd.setExaminabankSize(examinabankSize);
		examinaManagementAdd.setAccuracyRate(
				HrDataUtil.getDoublePercentStr(notErrorexaminBankSize, examinabankSize.doubleValue()) + "%");
		examinaManagementAdd.setScoreRate(
				HrDataUtil.getPercentStr(tbResultInfo.getAchievement(), tbManagement.getTotalScore()) + "%");
		return examinaManagementAdd;
	}

	/**
	 * 更新成绩
	 * 
	 * @param examinaManagement
	 *            答案实体
	 */
	@Override
	@ServiceLog(doAction = "更新成绩功能")
	@Transactional(rollbackFor = Exception.class)
	public void updateResult(ExaminaManagement examinaManagement) {
		// 查询考试信息
		TbManpowerExaminaManagement tbManagement = selectExaminaManagement(examinaManagement.getId());
		// 查询成绩信息
		if (StringUtils.isBlank(examinaManagement.getJobNumber())) {
			logger.warn("工号不能为空,examinaId:{}", tbManagement.getId());
			throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "工号不能为空");
		}
		TbManpowerExaminaResultInfo resultInfo = new TbManpowerExaminaResultInfo();
		resultInfo.setExaminaId(tbManagement.getId());
		resultInfo.setJobNumber(examinaManagement.getJobNumber());
		TbManpowerExaminaResultInfo tbResultInfo = examinaResultInfoMapper.selectUserResult(resultInfo);
		if (tbResultInfo == null) {
			logger.warn("该成绩不存在,,examinaId:{}", tbManagement.getId());
			throw new JnSpringCloudException(ExaminaExceptionEnums.RESULT_NOT_EXIST, "该成绩不存在");
		}
		Integer achievement = 0;// 变更的分数
		Float titleScore = 0f;
		List<Examinabank> examinabanksList = examinaManagement.getExaminabanksList();
		if (null != examinabanksList && examinabanksList.size() > 0) {
			for (Examinabank examinabank : examinabanksList) {
				if (examinabank.isUpdateFlag()) {
					examinabank.setExaminaId(tbManagement.getId());
					ExaminabankAdd tbExaminabank = selectExaminaBankByExaminaId(examinabank);
					achievement = achievement + (int) Math.ceil(Float.parseFloat(examinabank.getTitleScore()));
					TbManpowerExaminaAnswerCard card = new TbManpowerExaminaAnswerCard();
					// card.setAnswer(tbExaminabank.getStandardAnswer());
					card.setJobNumber(tbResultInfo.getJobNumber());
					card.setTestPaperId(tbResultInfo.getExaminaId());
					card.setTestQuestId(tbExaminabank.getTestQuestionId());
					card.setTitleScore((int) Math.ceil(Float.parseFloat(examinabank.getTitleScore())) + "");
					if (examinabank.isErrorFlag()) {
						card.setAnswerType(ExaminaStatusEnmus.TYPE_FALSE.getCode());
					} else {
						card.setAnswerType(ExaminaStatusEnmus.TYPE_TRUE.getCode());
					}
					TbManpowerExaminaAnswerCard tbCard = examinaAnswerCardMapper.selectAnswer(card);
					titleScore = titleScore + Float.parseFloat(tbCard.getTitleScore());
					examinaAnswerCardMapper.updateAnswer(card);
				}
			}
		}

		if (!achievement.equals(0)) {
			// 更新成绩
			achievement = achievement + tbResultInfo.getAchievement() - titleScore.intValue();
			if (achievement.compareTo(tbManagement.getTotalScore()) > 0) {
				achievement = tbManagement.getTotalScore();
			}
			tbResultInfo.setAchievement(achievement);
			if (tbManagement.getPassScore().compareTo(tbResultInfo.getAchievement()) <= 0) {
				tbResultInfo.setIsAdopt(Byte.parseByte(ExaminaStatusEnmus.IS_ADOPT.getCode()));
			} else {
				tbResultInfo.setIsAdopt(Byte.parseByte(ExaminaStatusEnmus.UN_ADOPT.getCode()));
			}
			Integer rank = getRank(examinaManagement.getId(), achievement);
			tbResultInfo.setRank(rank);
			tbManpowerExaminaResultInfoMapper.updateByPrimaryKeySelective(tbResultInfo);
		}
	}

	/**
	 *删除成绩
	 * 
	 * @param examinaManagement
	 *            答案实体
	 */
	@Override
	@ServiceLog(doAction = "删除成绩功能")
	@Transactional(rollbackFor = Exception.class)
	public void deleteResult(ExaminaManagement examinaManagement) {
		// 查询成绩信息
		if (StringUtils.isBlank(examinaManagement.getResultId())) {
			logger.warn("成绩表id不能为空,examinaId:{}", examinaManagement.getResultId());
			throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "成绩表id不能为空");
		}
		TbManpowerExaminaResultInfo tbResultInfo = tbManpowerExaminaResultInfoMapper
				.selectByPrimaryKey(examinaManagement.getResultId());
		if (tbResultInfo == null) {
			logger.warn("该成绩不存在,examinaId:{}", examinaManagement.getResultId());
			throw new JnSpringCloudException(ExaminaExceptionEnums.RESULT_NOT_EXIST, "该成绩不存在");
		}
		tbResultInfo.setRecordStatus(Byte.parseByte(HrStatusEnums.DELETED.getCode()));
		tbManpowerExaminaResultInfoMapper.updateByPrimaryKeySelective(tbResultInfo);
	}

	// private void authExaminBank(Examinabank examinabank) {
	// if (StringUtils.isBlank(examinabank.getFraction())) {
	// logger.warn("当前题目分数不能为空,examinabank.fraction:{}",
	// examinabank.getFraction());
	// throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR,
	// "当前题目分数不能为空");
	// }
	// if (StringUtils.isBlank(examinabank.getStandardAnswer())) {
	// logger.warn("当前题目标准答案不能为空,examinabank.standardAnswer:{}",
	// examinabank.getStandardAnswer());
	// throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR,
	// "当前题目标准答案不能为空");
	// }
	// if (StringUtils.isBlank(examinabank.getCardId())) {
	// logger.warn("答题卡id不能为空,examinabank.id:{}", examinabank.getCardId());
	// throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR,
	// "答题卡id不能为空");
	// }
	// }

	/**
	 * 查询试卷及答题详情
	 * 
	 * @param id
	 *            试卷编号
	 */
	@Override
	@ServiceLog(doAction = "查询试卷及答题详情功能")
	@Transactional(rollbackFor = Exception.class)
	public ExaminaManagementAdd selectExamAndAnswerCard(ExaminaManagement examinaManagement) {

		ExaminaManagementAdd examinaAnswerAdd = selectExamInfo(examinaManagement.getId());
		List<Examinabank> examinabanksList = examinaAnswerAdd.getExaminabanksList();
		// 答题卡信息
		double noErrorSize = 0;// 正确的题数
		Integer countSize = 0;// 总题数
		for (Examinabank examinabank : examinabanksList) {
			countSize++;
			Examinabank tbExaminabank = new Examinabank();
			tbExaminabank.setJobNumber(examinaManagement.getJobNumber());
			tbExaminabank.setTestQuestId(examinabank.getTestQuestionId());
			tbExaminabank.setTestPaperId(examinaManagement.getId());
			TbManpowerExaminaAnswerCard tbAnswerCard = examinaAnswerCardMapper.selectAnswerCard(tbExaminabank);
			examinabank.setCardId(tbAnswerCard.getId());
			examinabank.setAnswer(tbAnswerCard.getAnswer());
			examinabank.setTitleScore(tbAnswerCard.getTitleScore());
			String answerType = tbAnswerCard.getAnswerType();
			if (answerType.equals(ExaminaStatusEnmus.TYPE_FALSE.getCode())) {
				examinabank.setErrorFlag(true);
			}
			String titleScore = tbAnswerCard.getTitleScore();// 题目得分
			String fraction = examinabank.getFraction();// 题目分数
			if (Float.parseFloat(titleScore) == Float.parseFloat(fraction)) {
				noErrorSize++;
			} else {
				if (Float.parseFloat(titleScore) > 0) {
					noErrorSize = noErrorSize + 0.5;
				}
			}
		}
		// 成绩信息
		TbManpowerExaminaResultInfo resultInfo = new TbManpowerExaminaResultInfo();
		resultInfo.setExaminaId(examinaManagement.getId());
		resultInfo.setJobNumber(examinaManagement.getJobNumber());
		TbManpowerExaminaResultInfo tbResultInfo = examinaResultInfoMapper.selectUserResult(resultInfo);
		examinaAnswerAdd.setResultId(tbResultInfo.getId());
		examinaAnswerAdd.setName(tbResultInfo.getName());
		examinaAnswerAdd.setAchievement(tbResultInfo.getAchievement());
		examinaAnswerAdd.setIsAdopt(tbResultInfo.getIsAdopt());
		examinaAnswerAdd.setExaminabankSize(countSize);
		examinaAnswerAdd.setYesExaminaBankSize(noErrorSize);
		examinaAnswerAdd.setJobNumber(examinaManagement.getJobNumber());
		examinaAnswerAdd.setUseTime(tbResultInfo.getUseTime());
		examinaAnswerAdd.setAccuracyRate(HrDataUtil.getDoublePercentStr(noErrorSize, countSize.doubleValue()) + "%");
		if (tbResultInfo.getAchievement().compareTo(examinaAnswerAdd.getTotalScore()) > 0) {
			resultInfo = new TbManpowerExaminaResultInfo();
			resultInfo.setId(tbResultInfo.getId());
			resultInfo.setAchievement(examinaAnswerAdd.getTotalScore());
			tbManpowerExaminaResultInfoMapper.updateByPrimaryKeySelective(resultInfo);
			tbResultInfo.setAchievement(examinaAnswerAdd.getTotalScore());
		}
		examinaAnswerAdd.setScoreRate(
				HrDataUtil.getPercentStr(tbResultInfo.getAchievement(), examinaAnswerAdd.getTotalScore()) + "%");
		logger.info("查看试卷信息及答题详情成功.id{}", examinaManagement.getId());
		return examinaAnswerAdd;
	}

	/**
	 * 分页查看成绩
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "分页查看成绩列表")
	public PaginationData<List<ExaminaManagement>> selectResultList(ExaminaResultPage page) {
		ExaminaManagement examinaManagement = examinaResultInfoMapper.getResultCount(page);
		int yesAdoptCount = examinaResultInfoMapper.getAdoptCount(page);// 通过人数
		String countStr = "0";// 总人数
		if (!StringUtils.isBlank(examinaManagement.getCountStr())) {
			countStr = examinaManagement.getCountStr();
		}
		String notAdoptCountStr = (Integer.parseInt(countStr) - yesAdoptCount) + "";// 未通过人数

		String minStr = "0";// 最低分
		if (!StringUtils.isBlank(examinaManagement.getMinStr())) {
			minStr = examinaManagement.getMinStr();
		}
		String maxStr = "0";// 最高分
		if (!StringUtils.isBlank(examinaManagement.getMaxStr())) {
			maxStr = examinaManagement.getMaxStr();
		}
		String avgStr = "0";// 平均分
		if (!StringUtils.isBlank(examinaManagement.getAvgStr())) {
			avgStr = examinaManagement.getAvgStr();
		}
		String yesAdoptRateStr = HrDataUtil.getPercentStr(yesAdoptCount, Integer.parseInt(countStr)) + "%";

		Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
		List<ExaminaManagement> managementList = examinaResultInfoMapper.listResultInfo(page);
		for (ExaminaManagement management : managementList) {
			management.setExaminaStartTimeStr(
					DateUtils.formatDate(management.getExaminaStartTime(), "yyyy-MM-dd HH:mm:ss"));
			management
					.setExaminaEndTimeStr(DateUtils.formatDate(management.getExaminaEndTime(), "yyyy-MM-dd HH:mm:ss"));
			management.setExaminaStartEndTimeStr(
					DateUtils.formatDate(management.getExaminaStartTime(), "yyyy-MM-dd HH:mm:ss") + "~"
							+ DateUtils.formatDate(management.getExaminaEndTime(), "yyyy-MM-dd HH:mm:ss"));
			management.setTotalAndPassScore(management.getTotalScore() + "/" + management.getPassScore());
			management.setCountStr(countStr);
			management.setYesAdoptCountStr(yesAdoptCount + "");
			management.setNotAdoptCountStr(notAdoptCountStr);
			management.setYesAdoptRateStr(yesAdoptRateStr);
			management.setMinStr(minStr);
			management.setMaxStr(maxStr);
			management.setAvgStr(avgStr);
		}
		PaginationData<List<ExaminaManagement>> data = new PaginationData(managementList, objects.getTotal());
		logger.info("查询成绩列表!");
		return data;
	}

	/**
	 * 查看成绩等级
	 * 
	 * @param achievementList
	 * @param achievement
	 * @return
	 */
	private static Map<Integer, Integer> achievementRank(List<Integer> achievementList, Integer achievement) {
		Map<Integer, Integer> mapList = new HashMap<Integer, Integer>();
		Integer rank = 0;
		achievementList.add(achievement);
		Set<Integer> set = new HashSet<>(achievementList);
		achievementList = new ArrayList<>(set);
		Collections.sort(achievementList, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1.compareTo(o2) > 0) {
					return -1;
				}
				return 1;
			}
		});
		for (int i = 0; i < achievementList.size(); i++) {
			rank = i + 1;
			mapList.put(achievementList.get(i), rank);
		}
		return mapList;
	}

	/**获取当前分数等级
	 * @param id
	 * @param achievement
	 * @return
	 */
	private Integer getRank(String id, Integer achievement) {
		List<Integer> achievementList = examinaResultInfoMapper.listAchievement(id);
		Map<Integer, Integer> rankMap = achievementRank(achievementList, achievement);
		for (Integer tbAch : rankMap.keySet()) {
			TbManpowerExaminaResultInfo tbinfo = new TbManpowerExaminaResultInfo();
			tbinfo.setExaminaId(id);
			tbinfo.setAchievement(tbAch);
			tbinfo.setRank(rankMap.get(tbAch));
			examinaResultInfoMapper.updateBatch(tbinfo);
		}
		return rankMap.get(achievement);
	}

	/**
	 * 查询试卷详情
	 * 
	 * @param id
	 *            试卷编号
	 * @return
	 */
	private TbManpowerExaminaManagement selectExaminaManagement(String id) {
		if (StringUtils.isBlank(id)) {
			logger.warn("查寻试卷详情失败，试卷编号不能为空");
			throw new JnSpringCloudException(ExaminaExceptionEnums.NOT_NULL_ERROR, "查寻试卷详情失败，试卷编号不能为空");
		}
		TbManpowerExaminaManagement tbExaminaManagement = tbManpowerExaminaManagementMapper.selectByPrimaryKey(id);
		if (tbExaminaManagement == null || StringUtils.equals(HrStatusEnums.DELETED.getCode(),
				tbExaminaManagement.getRecordStatus().toString())) {
			logger.warn("查寻试卷详情失败，当前考试不存在,id:{}", id);
			throw new JnSpringCloudException(ExaminaExceptionEnums.EXAMINA_NOT_EXIST, "查寻试卷详情失败，当前考试不存在");
		}
		return tbExaminaManagement;
	}

	/**
	 * 查询试题详情
	 * 
	 * @param testQuestionId
	 *            试题编号
	 * @return
	 */
	private TbManpowerExaminaBank selectExaminaBank(String testQuestionId) {
		TbManpowerExaminaBank tbExaminaBank = tbManpowerExaminaBankMapper.selectByPrimaryKey(testQuestionId);
		if (tbExaminaBank == null
				|| StringUtils.equals(HrStatusEnums.DELETED.getCode(), tbExaminaBank.getRecordStatus().toString())) {
			logger.warn("查寻试题详情失败，当前试题不存在,testQuestionId:{}", testQuestionId);
			throw new JnSpringCloudException(ExaminaExceptionEnums.EXAMINA_BANK_NOT_EXIST, "查寻试题详情失败，当前试题不存在");
		}
		return tbExaminaBank;
	}

	/**查询指定试卷题目信息
	 * @param examinabank
	 * @return
	 */
	private ExaminabankAdd selectExaminaBankByExaminaId(Examinabank examinabank) {
		ExaminabankAdd tbExaminaBank = examinaBankMapper.selectBankByExaminaIdAndQuestionId(examinabank);
		if (tbExaminaBank == null
				|| StringUtils.equals(HrStatusEnums.DELETED.getCode(), tbExaminaBank.getRecordStatus().toString())) {
			logger.warn("查寻试题详情失败，当前试题不存在,testQuestionId:{}", tbExaminaBank.getTestQuestionId());
			throw new JnSpringCloudException(ExaminaExceptionEnums.EXAMINA_BANK_NOT_EXIST, "查寻试题详情失败，当前试题不存在");
		}
		if (!StringUtils.isBlank(tbExaminaBank.getAnswerHtml())) {
			tbExaminaBank.setStandardAnswer(tbExaminaBank.getAnswerHtml());
		}
		if (StringUtils.isBlank(tbExaminaBank.getStandardAnswer())) {
			tbExaminaBank.setStandardAnswer("");
		}
		// if (!StringUtils.isBlank(tbExaminaBank.getAnswerNumber())) {
		// tbExaminaBank.setStandardAnswer(tbExaminaBank.getAnswerNumber().toUpperCase());
		// }
		return tbExaminaBank;
	}

	/**
	 * 附件批量上传
	 *
	 * @param files
	 */
	// @Override
	// @ServiceLog(doAction = "员工档案附件批量上传")
	// public List<FileAttachment> uploadAttachment(List<MultipartFile> files,
	// String fileId, User user) {
	// List<FileAttachment> fileAttachmentList = new
	// ArrayList<FileAttachment>();
	// for (MultipartFile file : files) {
	// if (file.isEmpty()) {
	// logger.warn("[员工档案管理] 附件上传失败");
	// throw new JnSpringCloudException(HrExceptionEnums.FILE_IS_NULL);
	// } else {
	// try {
	// FileAttachment fileObj = new FileAttachment();
	// TbManpowerFileAttachment fileAttachment = new TbManpowerFileAttachment();
	// String title = file.getOriginalFilename();
	// String[] split = title.split("\\.");
	// String str = DateUtils.formatDate(new Date(), "yyyyMMdd");
	// String fileName = split[0] + str + RandomStringUtils.randomNumeric(4) +
	// "." + split[1];
	// Result<String> result = uploadClient.uploadFile(file, true, "hr");
	// fileAttachment.setFileId(fileId);
	// fileAttachment.setCreateTime(new Date());
	// fileAttachment.setFileName(split[0]);
	// fileAttachment.setFilePath(result.getData());
	// fileAttachment.setFileSize(String.valueOf(file.getSize()));
	// fileAttachment.setFileType(split[1]);
	// fileAttachment.setFounder(user.getAccount());
	// fileAttachment.setId(UUID.randomUUID().toString());
	// tbManpowerFileAttachmentMapper.insert(fileAttachment);
	// BeanUtils.copyProperties(fileAttachment, fileObj);
	// fileAttachmentList.add(fileObj);
	// } catch (Exception e) {
	// logger.error("员工档案附件上传失败:" + e.getMessage(), e);
	// throw new JnSpringCloudException(HrExceptionEnums.UPLOAD_FILE_ERRPR);
	// }
	// }
	// }
	// return fileAttachmentList;
	// }
}
