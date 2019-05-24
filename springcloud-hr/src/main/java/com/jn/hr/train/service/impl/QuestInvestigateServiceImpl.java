package com.jn.hr.train.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.jn.hr.train.dao.AnswerInfoMapper;
import com.jn.hr.train.dao.InvestigateMapper;
import com.jn.hr.train.dao.QuestionMapper;
import com.jn.hr.train.dao.SurveyResultMapper;
import com.jn.hr.train.dao.TbManpowerTrainQuestAnswerInfoMapper;
import com.jn.hr.train.dao.TbManpowerTrainQuestInvestigaMapper;
import com.jn.hr.train.dao.TbManpowerTrainQuestQuestionnaireQueseMapper;
import com.jn.hr.train.dao.TbManpowerTrainQuestResearchSetMapper;
import com.jn.hr.train.dao.TbManpowerTrainQuestSurveyResultMapper;
import com.jn.hr.train.dao.TbManpowerTrainQuestTitleOptionMapper;
import com.jn.hr.train.dao.TitleOptionMapper;
import com.jn.hr.train.enmus.InvestigateStatusEnums;
import com.jn.hr.train.enmus.TrainExceptionEnums;
import com.jn.hr.train.entity.TbManpowerTrainQuestAnswerInfo;
import com.jn.hr.train.entity.TbManpowerTrainQuestInvestiga;
import com.jn.hr.train.entity.TbManpowerTrainQuestQuestionnaireQuese;
import com.jn.hr.train.entity.TbManpowerTrainQuestResearchSet;
import com.jn.hr.train.entity.TbManpowerTrainQuestSurveyResult;
import com.jn.hr.train.entity.TbManpowerTrainQuestTitleOption;
import com.jn.hr.train.model.InvestigateAnswerAdd;
import com.jn.hr.train.model.Investigate;
import com.jn.hr.train.model.InvestigateAdd;
import com.jn.hr.train.model.InvestigateAnswer;
import com.jn.hr.train.model.InvestigatePage;
import com.jn.hr.train.model.InvestigateQuestion;
import com.jn.hr.train.model.InvestigateQuestionAdd;
import com.jn.hr.train.model.ResearchSet;
import com.jn.hr.train.model.ResearchSetAdd;
import com.jn.hr.train.model.ResultAnswerAdd;
import com.jn.hr.train.model.SurveyResultPage;
import com.jn.hr.train.model.InvestigateTitleOption;
import com.jn.hr.train.model.InvestigateTitleOptionAdd;
import com.jn.hr.train.service.QuestInvestigateService;
import com.jn.hr.train.vo.AnswerVo;
import com.jn.hr.train.vo.InvestigatesVo;
import com.jn.hr.train.vo.SurveyResultVo;
import com.jn.news.vo.EmailVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

/**
 * 问卷调查服务
 *
 * @author： wangtt
 * 
 * @date：Created on 2019/04/15 04:22 @version： v1.0
 * @modified By:
 **/
@Service
public class QuestInvestigateServiceImpl implements QuestInvestigateService {
	private static final Logger logger = LoggerFactory.getLogger(QuestInvestigateServiceImpl.class);

	@Autowired
	TbManpowerTrainQuestInvestigaMapper tbQuestInvestigaMapper;

	@Autowired
	TbManpowerTrainQuestQuestionnaireQueseMapper tbQuestQuestionnaireQueseMapper;

	@Autowired
	TbManpowerTrainQuestTitleOptionMapper tbQuestTitleOptionMapper;

	@Autowired
	TbManpowerTrainQuestAnswerInfoMapper tbQuestAnswerInfoMapper;

	@Autowired
	TbManpowerTrainQuestResearchSetMapper tbQuestResearchSetMapper;

	@Autowired
	TbManpowerTrainQuestSurveyResultMapper tbQuestSurveyResultMapper;

	@Autowired
	InvestigateMapper investigateMapper;

	@Autowired
	QuestionMapper questionMapper;

	@Autowired
	AnswerInfoMapper answerInfoMapper;

	@Autowired
	TitleOptionMapper titleOptionMapper;

	@Autowired
	SurveyResultMapper surveyResultMapper;

	@Autowired
	MessageSource messageSource;

	/**
	 * 新建问卷调查及题目
	 * 
	 * @param investigaAdd
	 *            问卷调查
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "新建问卷调查及题目")
	@Transactional(rollbackFor = Exception.class)
	public void addInvestiageAndQuestion(InvestigateAdd investigaAdd, User user) {
		addInvestiage(investigaAdd, user);
		insertQuestion(investigaAdd.getQuestionList(), investigaAdd.getProjectId());
		logger.info("[问卷调查] 新建项目及题目成功,projectId:{}", investigaAdd.getProjectId());
	}

	/**
	 * 新建问卷项目
	 * 
	 * @param investigaAdd
	 *            问卷实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "新建项目功能")
	@Transactional(rollbackFor = Exception.class)
	public String addInvestiage(InvestigateAdd investigaAdd, User user) {
		TbManpowerTrainQuestInvestiga tbInvestiga = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(investigaAdd, tbInvestiga);
		if (null == tbInvestiga.getStatus()) {
			Byte status = Byte.parseByte(InvestigateStatusEnums.DRAFT.getCode());// 首次创建的草稿
			tbInvestiga.setStatus(status);
		}
		if (null == tbInvestiga.getRecordStatus()) {
			Byte recordStatus = Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode());// 正常问卷1
			tbInvestiga.setRecordStatus(recordStatus);
		}
		String userAccount = user.getAccount();
		tbInvestiga.setCreatorAccount(userAccount);
		tbInvestiga.setCreatedTime(new Date());
		tbInvestiga.setModifierAccount(userAccount);
		tbInvestiga.setModifiedTime(new Date());
		tbInvestiga.setEffectiveTimeStart(new Date());
		if (null != tbInvestiga.getTrainDate()) {
			tbInvestiga.setEffectiveTimeEnd(tbInvestiga.getTrainDate());
		} else {
			tbInvestiga.setEffectiveTimeEnd(new Date());
		}
		if (!StringUtils.isBlank(investigaAdd.getProjectNote())) {
			tbInvestiga.setProjectNote(investigaAdd.getProjectNote().getBytes());
		}
		if (StringUtils.isBlank(tbInvestiga.getSurveyDimensional())) {
			tbInvestiga.setSurveyDimensional(tbInvestiga.getProjectId());
		}
		if (StringUtils.isBlank(tbInvestiga.getSurveyUrl())) {
			tbInvestiga.setSurveyUrl(tbInvestiga.getProjectId());
		}
		tbQuestInvestigaMapper.insertSelective(tbInvestiga);
		logger.info("[问卷调查] 新建项目成功,projectId:{}", investigaAdd.getProjectId());
		return investigaAdd.getProjectId();
	}

	/**
	 * 新增问卷题目
	 * 
	 * @param questionAdd
	 *            问卷题目实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "新增问卷题目功能")
	@Transactional(rollbackFor = Exception.class)
	public void addQuestion(Investigate questionAdd, User user) {
		TbManpowerTrainQuestInvestiga tbInvestigate = selectQuestInvestigate(questionAdd.getProjectId());
		if (null != tbInvestigate) {
			List<InvestigateQuestionAdd> questionList = questionAdd.getAddQuestionList();
			insertQuestion(questionList, questionAdd.getProjectId());
		}

		logger.info("[问卷调查] 新建项目-题目添加成功,projectId:{}", questionAdd.getProjectId());
	}

	private String insertQuestion(List<InvestigateQuestionAdd> questionList, String projectId) {
		String titleId = "";
		if (null != questionList && questionList.size() > 0) {
			for (InvestigateQuestionAdd question : questionList) {
				// 新增问卷题目
				TbManpowerTrainQuestQuestionnaireQuese tbQuestion = new TbManpowerTrainQuestQuestionnaireQuese();
				BeanUtils.copyProperties(question, tbQuestion);
				if (StringUtils.isBlank(tbQuestion.getProjectId())) {
					tbQuestion.setProjectId(projectId);
				}
				titleId = tbQuestion.getTitleId();
				if (StringUtils.isBlank(titleId)) {
					titleId = UUID.randomUUID().toString();
				}
				tbQuestion.setTitleId(titleId);
				tbQuestQuestionnaireQueseMapper.insertSelective(tbQuestion);

				// 新增问卷对应的选项信息
				List<InvestigateTitleOptionAdd> titleOptionList = question.getTitleOptionList();
				if (null != titleOptionList && titleOptionList.size() > 0) {
					for (InvestigateTitleOptionAdd titleOption : titleOptionList) {
						TbManpowerTrainQuestTitleOption tbOption = new TbManpowerTrainQuestTitleOption();
						BeanUtils.copyProperties(titleOption, tbOption);
						if (StringUtils.isBlank(tbOption.getId())) {
							tbOption.setId(UUID.randomUUID().toString());
						}
						if (StringUtils.isBlank(tbOption.getTitleId())) {
							tbOption.setTitleId(titleId);
						}
						if (!StringUtils.isBlank(tbOption.getOptionId())) {
							tbOption.setOptionId(tbOption.getOptionId().toUpperCase());
						}
						tbQuestTitleOptionMapper.insertSelective(tbOption);
					}
				}

			}
		}
		return titleId;
	}

	/**
	 * 编辑问卷项目
	 * 
	 * @param investigaUpd
	 *            问卷实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "编辑问卷项目功能")
	@Transactional(rollbackFor = Exception.class)
	public void updateInvestiage(Investigate investigaUpd, User user) {
		String projectId = investigaUpd.getProjectId();
		TbManpowerTrainQuestInvestiga tbInvestigate = selectQuestInvestigate(projectId);
		if (null != tbInvestigate) {
			TbManpowerTrainQuestInvestiga tbInvestiga = new TbManpowerTrainQuestInvestiga();
			BeanUtils.copyProperties(investigaUpd, tbInvestiga);
			String userAccount = user.getAccount();
			tbInvestiga.setModifierAccount(userAccount);
			tbInvestiga.setModifiedTime(new Date());
			if (!StringUtils.isBlank(investigaUpd.getProjectNote())) {
				tbInvestiga.setProjectNote(investigaUpd.getProjectNote().getBytes());
			}
			tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
		}
		logger.info("[问卷调查] 编辑问卷项目成功,projectId:{}", investigaUpd.getProjectId());
	}

	/**
	 * 编辑问卷项目题目
	 * 
	 * @param questionUpd
	 *            题目实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "编辑问卷项目题目更新及修改功能")
	@Transactional(rollbackFor = Exception.class)
	public String updateQuestion(InvestigateQuestion questionUpd, User user) {
		String titleId = "";
		String projectId = questionUpd.getProjectId();
		// 更新问卷问题及选项
		if (!StringUtils.isBlank(questionUpd.getTitleId())) {
			updateQuestion(questionUpd);
			updateOption(questionUpd);
			titleId = questionUpd.getTitleId();
		} else {
			// 新增问题及选项
			InvestigateQuestionAdd add = new InvestigateQuestionAdd();
			BeanUtils.copyProperties(questionUpd, add);
			// 拷贝选项列表
			List<InvestigateTitleOption> titleOptionList = questionUpd.getTitleOptionList();
			if (null != titleOptionList && titleOptionList.size() > 0) {
				List<InvestigateTitleOptionAdd> titleOptionAddList = BeanCopyUtil.copyList(titleOptionList,
						InvestigateTitleOptionAdd.class);
				add.setTitleOptionList(titleOptionAddList);
			}
			List<InvestigateQuestionAdd> questionList = new ArrayList<InvestigateQuestionAdd>();
			questionList.add(add);
			titleId = insertQuestion(questionList, projectId);

		}
		logger.info("[问卷调查] 编辑问卷项目题目成功,projectId:{},titleID:{}", questionUpd.getProjectId(), questionUpd.getTitleId());
		return titleId;
	}

	@Override
	@ServiceLog(doAction = "编辑问卷题目删除功能")
	@Transactional(rollbackFor = Exception.class)
	public void deleteQuestion(InvestigateQuestion questionUpd, User user) {
		// String projectId = questionUpd.getProjectId();
		// 更新问卷问题及选项
		if (!StringUtils.isBlank(questionUpd.getTitleId())) {
			tbQuestQuestionnaireQueseMapper.deleteByPrimaryKey(questionUpd.getTitleId());
			titleOptionMapper.deleteQuestByTitleId(questionUpd.getTitleId());
		} else {
			logger.warn("删除题目失败，题目编号为空{}", questionUpd.getTitleId());
			throw new JnSpringCloudException(TrainExceptionEnums.NOT_NULL_ERROR, "题目编号为必填项");
		}
		logger.info("[问卷调查] 编辑问卷题目删除项目题目成功,projectId:{},titleID:{}", questionUpd.getProjectId(),
				questionUpd.getTitleId());
	}

	// /**
	// * 编辑问卷
	// *
	// * @param investigaUpd
	// * 问卷实体
	// * @param user
	// * 当前登陆用户
	// */
	// @Override
	// @ServiceLog(doAction = "编辑问卷功能")
	// @Transactional(rollbackFor = Exception.class)
	// public void update(Investigate investigaUpd, User user) {
	// String projectId = investigaUpd.getProjectId();
	// TbManpowerTrainQuestInvestiga tbInvestigate =
	// selectQuestInvestigate(projectId);
	// if (null != tbInvestigate) {
	// TbManpowerTrainQuestInvestiga tbInvestiga = new
	// TbManpowerTrainQuestInvestiga();
	// BeanUtils.copyProperties(investigaUpd, tbInvestiga);
	// String userAccount = user.getAccount();
	// tbInvestiga.setModifierAccount(userAccount);
	// tbInvestiga.setModifiedTime(new Date());
	// if (!StringUtils.isBlank(investigaUpd.getProjectNote())) {
	// tbInvestiga.setProjectNote(investigaUpd.getProjectNote().getBytes());
	// }
	// tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
	//
	// List<InvestigateQuestion> questionList = investigaUpd.getQuestionList();
	// for (InvestigateQuestion questionUpd : questionList) {
	// if (StringUtils.isBlank(questionUpd.getProjectId())) {
	// questionUpd.setProjectId(tbInvestigate.getProjectId());
	// }
	// // 更新问卷问题
	// updateQuestion(questionUpd);
	//
	// // 更新问题选项
	// updateOption(questionUpd);
	// }
	// }
	// logger.info("[问卷调查]编辑问卷成功,projectId:{}", investigaUpd.getProjectId());
	// }

	/**
	 * 分页查询问卷信息
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "分页查询问卷信息功能")
	public PaginationData<List<InvestigatesVo>> list(InvestigatePage investigatePage) {
		Page<Object> objects = PageHelper.startPage(investigatePage.getPage(), investigatePage.getRows());
		List<InvestigatesVo> noticeList = investigateMapper.listQuest(investigatePage);
		for (InvestigatesVo notice : noticeList) {
			notice.setEffectiveTimeStartStr(
					DateUtils.formatDate(notice.getEffectiveTimeStart(), "yyyy-MM-dd HH:mm:ss"));
			notice.setEffectiveTimeEndStr(DateUtils.formatDate(notice.getEffectiveTimeEnd(), "yyyy-MM-dd HH:mm:ss"));
		}
		PaginationData<List<InvestigatesVo>> data = new PaginationData(noticeList, objects.getTotal());
		return data;
	}

	/**
	 * 查询问卷详情信息
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "查询问卷详情信息功能")
	public InvestigatesVo selectInvestigate(Investigate investigate) {
		InvestigatesVo data = new InvestigatesVo();
		String projectId = investigate.getProjectId();
		// 查询项目详情
		TbManpowerTrainQuestInvestiga tbInvestigate = selectQuestInvestigate(projectId);
		BeanUtils.copyProperties(tbInvestigate, data);
		if (null != tbInvestigate.getProjectNote()) {
			data.setProjectNote(new String(tbInvestigate.getProjectNote()));
		}
		// 登陆信息判断
		if (!StringUtils.isBlank(investigate.getJobNumber()) || !StringUtils.isBlank(investigate.getName())
				|| !StringUtils.isBlank(investigate.getPhone())) {
			loginAuth(tbInvestigate, investigate);
		}
		// 查询当前项目下的所有问题及选项
		List<InvestigateQuestionAdd> questionList = questionList(projectId);
		if (null != questionList && questionList.size() > 0) {
			data.setQuestionList(questionList);
		}
		logger.info("[问卷调查] 查询问卷项目详情信息成功,projectId:{}", projectId);
		return data;
	}

	/**
	 * 登陆页验证
	 * 
	 * @param tbInvestigate
	 * @param investigate
	 */
	private void loginAuth(TbManpowerTrainQuestInvestiga tbInvestigate, Investigate investigate) {

		if (!tbInvestigate.getStatus().equals(Byte.parseByte(InvestigateStatusEnums.UNDER_WAY.getCode()))) {
			logger.warn("参加问卷调查失败，当前问卷未开始/已结束,project:{},status", tbInvestigate.getProjectId(),
					tbInvestigate.getStatus());
			throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加问卷调查失败，当前问卷未开始/已结束");
		}
		// if (tbInvestigate.getEffectiveTimeStart().compareTo(new Date()) > 0)
		// {
		// logger.warn("参加问卷调查失败，当前时间未在问卷时间范围内,project:{},start~end:{}",
		// tbInvestigate.getProjectId(),
		// tbInvestigate.getEffectiveTimeStart() + "~" +
		// tbInvestigate.getEffectiveTimeEnd());
		// throw new
		// JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR);
		// }
		// if (tbInvestigate.getEffectiveTimeEnd().compareTo(new Date()) < 0) {
		// logger.warn("参加问卷调查失败，当前时间未在问卷时间范围内,project:{},start~end:{}",
		// tbInvestigate.getProjectId(),
		// tbInvestigate.getEffectiveTimeStart() + "~" +
		// tbInvestigate.getEffectiveTimeEnd());
		// throw new
		// JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR);
		// }

		TbManpowerTrainQuestResearchSet researchSet = tbQuestResearchSetMapper
				.selectByPrimaryKey(tbInvestigate.getProjectId());
		if (null != researchSet) {
			if (researchSet.getIsShowName().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getName())) {
					logger.warn("参加问卷调查失败，姓名为必填项,project:{}", tbInvestigate.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加问卷调查失败，姓名为必填项");

				}
			}
			if (researchSet.getIsShowJobNumber().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getJobNumber())) {
					logger.warn("参加问卷调查失败，工号为必填项,project:{}", tbInvestigate.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加问卷调查失败，工号为必填项");

				}
			}
			if (researchSet.getIsShowPhone().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getPhone())) {
					logger.warn("参加问卷调查失败，手机号为必填项,project:{}", tbInvestigate.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加问卷调查失败，手机号为必填项");

				}
			}
			String frequencyLimit = researchSet.getFrequencyLimit().toString();// 问卷次数
			if (InvestigateStatusEnums.LIMITY_ONE.getCode().equals(frequencyLimit)) {
				TbManpowerTrainQuestSurveyResult surveyResult = new TbManpowerTrainQuestSurveyResult();
				BeanUtils.copyProperties(investigate, surveyResult);
				List<TbManpowerTrainQuestSurveyResult> resultList = surveyResultMapper
						.selectUserQuestSurveyResult(surveyResult);
				if (null != resultList && resultList.size() > 0) {
					logger.warn("参加问卷调查失败，当前用户已参与过调查,project:{}", tbInvestigate.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加问卷调查失败，当前用户已参与过调查");
				}
			}
		} else {
			logger.warn("当前问卷未设置,project:{}", tbInvestigate.getProjectId());
			throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "当前问卷未设置");
		}
	}

	/**
	 * 结束问卷调查
	 * 
	 * @param investigaDel
	 *            问卷实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "结束问卷功能")
	@Transactional(rollbackFor = Exception.class)
	public void deleteInvestiage(Investigate investigaDel, User user) {
		String projectId = investigaDel.getProjectId();
		// // 查询问卷
		// TbManpowerTrainQuestInvestiga tbInvestigate =
		// selectQuestInvestigate(projectId);
		// if (null != tbInvestigate) {
		// 逻辑删除问卷
		TbManpowerTrainQuestInvestiga tbInvestiga = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(investigaDel, tbInvestiga);
		String userAccount = user.getAccount();
		tbInvestiga.setModifierAccount(userAccount);
		tbInvestiga.setModifiedTime(new Date());
		tbInvestiga.setRecordStatus(Byte.parseByte(HrStatusEnums.DELETED.getCode()));
		tbInvestiga.setProjectId(projectId);
		tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
		// }
		logger.info("[问卷调查] 结束问卷成功,projectId:{}", investigaDel.getProjectId());

	}

	/**
	 * 结束问卷
	 * 
	 * @param investigaAdd
	 *            
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "结束问卷功能")
	@Transactional(rollbackFor = Exception.class)
	public void endInvestiage(Investigate investigaDel, User user) {
		String projectId = investigaDel.getProjectId();
		// TbManpowerTrainInvestiga tbHrinvestiage =
		// selectQuestInvestigate(projectId);
		// if (null != tbHrinvestiage) {
		TbManpowerTrainQuestInvestiga tbInvestiga = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(investigaDel, tbInvestiga);
		String userAccount = user.getAccount();
		tbInvestiga.setModifierAccount(userAccount);
		tbInvestiga.setModifiedTime(new Date());
		tbInvestiga.setStatus(Byte.parseByte(InvestigateStatusEnums.HAS_END.getCode()));
		tbInvestiga.setProjectId(projectId);
		tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
		// }
		logger.info("[问卷调查] 删除问卷成功,projectId:{}", investigaDel.getProjectId());
	}

	/**
	 * 发放问卷
	 * 
	 * @param researchSet
	 *            问卷设置实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "发放问卷功能")
	@Transactional(rollbackFor = Exception.class)
	public void sendInvestiage(ResearchSetAdd researchSet, User user) {

		String projectId = researchSet.getProjectId();
		TbManpowerTrainQuestResearchSet tbResearchSet = tbQuestResearchSetMapper.selectByPrimaryKey(projectId);
		if (null == tbResearchSet) {
			// 新建问卷任务
			tbResearchSet = new TbManpowerTrainQuestResearchSet();
			BeanUtils.copyProperties(researchSet, tbResearchSet);
			tbQuestResearchSetMapper.insertSelective(tbResearchSet);
		} else {
			// 修改问卷任务
			tbResearchSet = new TbManpowerTrainQuestResearchSet();
			BeanUtils.copyProperties(researchSet, tbResearchSet);
			tbQuestResearchSetMapper.updateByPrimaryKeySelective(tbResearchSet);
		}

		TbManpowerTrainQuestInvestiga tbHrinvestiage = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(researchSet, tbHrinvestiage);
		tbHrinvestiage.setModifierAccount(user.getAccount());
		tbHrinvestiage.setModifiedTime(new Date());
		tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbHrinvestiage);

		if (!StringUtils.isBlank(researchSet.getEmailList()) && !StringUtils.isBlank(researchSet.getEmailSubject())
				&& !StringUtils.isBlank(researchSet.getEmailContent())) {
			String emailList = researchSet.getEmailList();
			String[] emails = emailList.split(",");
			for (String email : emails) {
				if (!ValidateUtil.isEmail(email)) {
					logger.warn("发放问卷失败,输入邮箱格式错误:{}", email);
					throw new JnSpringCloudException(TrainExceptionEnums.SEND_ERROR, "发放问卷失败,输入邮箱格式错误");
				}
			}
			EmailVo emailVo = new EmailVo();
			emailVo.setEmail(emailList);
			emailVo.setEmailSubject(researchSet.getEmailSubject());
			emailVo.setEmailContent(researchSet.getEmailContent());
			sendEmailMsg(emailVo);
		}
		// 邮件发送成功，更新问卷状态
		tbHrinvestiage = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(researchSet, tbHrinvestiage);
		tbHrinvestiage.setModifierAccount(user.getAccount());
		tbHrinvestiage.setModifiedTime(new Date());
		tbHrinvestiage.setStatus(Byte.parseByte(InvestigateStatusEnums.UNDER_WAY.getCode()));
		tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbHrinvestiage);
		logger.info("[问卷调查] 发放问卷成功,projectId:{}", researchSet.getProjectId());

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

	/**
	 * 问卷页面展示
	 * 
	 * @param researchSet
	 *            问卷设置实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "问卷页面展示功能")
	@Transactional(rollbackFor = Exception.class)
	public ResearchSet loginInvestiage(String projectId) {
		ResearchSet researchSet = new ResearchSet();

		TbManpowerTrainQuestInvestiga tbInvestigate = selectQuestInvestigate(projectId);
		BeanUtils.copyProperties(tbInvestigate, researchSet);
		if (null != tbInvestigate.getProjectNote()) {
			researchSet.setProjectNote(new String(tbInvestigate.getProjectNote()));
		}
		TbManpowerTrainQuestResearchSet tbResearchSet = tbQuestResearchSetMapper.selectByPrimaryKey(projectId);
		if (null == tbResearchSet) {
			logger.warn("[问卷调查]问卷展示失败，未设计当前问卷,projectId:{}", researchSet.getProjectId());
			throw new JnSpringCloudException(TrainExceptionEnums.RESEARCH_SET_NOT_EXIST, "问卷展示失败，未设计当前问卷");
		}
		BeanUtils.copyProperties(tbResearchSet, researchSet);
		logger.info("问卷登陆页面，展示信息成功,projectId:{}", researchSet.getProjectId());
		return researchSet;
	}

	/**
	 * 问卷结果-汇总统计
	 * 
	 * @param investigaAdd
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "汇总统计功能")
	@Transactional(rollbackFor = Exception.class)
	public List<AnswerVo> questionAnswerList(String projectId) {
		List<AnswerVo> answerVos = questAnswerList(projectId);
		return answerVos;
	}

	/**
	 * 查询所有题目,选项及答案
	 * 
	 * @param projectId
	 * @param answerFlag
	 * @return
	 */
	private List<AnswerVo> questAnswerList(String projectId) {
		List<AnswerVo> questionAnswers = new ArrayList<AnswerVo>();
		// 查询所有问题
		List<TbManpowerTrainQuestQuestionnaireQuese> tbQuestionList = questionMapper.listQuest(projectId);
		for (TbManpowerTrainQuestQuestionnaireQuese tbQuestion : tbQuestionList) {
			AnswerVo questionAnswer = new AnswerVo();
			// 题目信息
			BeanUtils.copyProperties(tbQuestion, questionAnswer);
			// 查询题目所有选项
			List<TbManpowerTrainQuestTitleOption> tbTitleOptionList = titleOptionMapper
					.listQuest(tbQuestion.getTitleId());
			List<InvestigateTitleOptionAdd> titleOptionList = BeanCopyUtil.copyList(tbTitleOptionList,
					InvestigateTitleOptionAdd.class);
			questionAnswer.setTitleOptionList(titleOptionList);

			// 查询所有答案
			List<TbManpowerTrainQuestAnswerInfo> tbAnswerInfos = answerInfoMapper.listQuest(tbQuestion.getTitleId());
			// List<InvestigateAnswerAdd> answerList =
			// BeanCopyUtil.copyList(tbAnswerInfos, InvestigateAnswerAdd.class);
			// questionAnswer.setQuestionAnswerList(answerList);

			if (InvestigateStatusEnums.SINGLE_QUEST.getCode().equals(questionAnswer.getTitleType().toString())
					|| InvestigateStatusEnums.MULTIPLE_QUEST.getCode()
							.equals(questionAnswer.getTitleType().toString())) {
				Map<String, String> percentMap = new HashMap<String, String>();
				Map<String, Integer> sizeMap = new HashMap<String, Integer>();
				int countSize = tbAnswerInfos.size();
				if (0 != countSize) {
					for (TbManpowerTrainQuestAnswerInfo tbAnswerInfo : tbAnswerInfos) {
						String optionAnswer = tbAnswerInfo.getOptionAnswer();
						if (optionAnswer.contains(",")) {
							String[] optionAnswers = optionAnswer.split(",");
							for (String answer : optionAnswers) {
								if (null != sizeMap.get(answer)) {
									sizeMap.put(answer, sizeMap.get(answer) + 1);
								} else {
									sizeMap.put(answer, 1);
								}
							}
						} else {
							if (null != sizeMap.get(tbAnswerInfo.getOptionAnswer())) {
								sizeMap.put(tbAnswerInfo.getOptionAnswer(),
										sizeMap.get(tbAnswerInfo.getOptionAnswer()) + 1);
							} else {
								sizeMap.put(tbAnswerInfo.getOptionAnswer(), 1);
							}

						}
					}
					if (null != questionAnswer.getTitleOptionList() && questionAnswer.getTitleOptionList().size() > 0) {
						for (InvestigateTitleOptionAdd tbTitleOption : questionAnswer.getTitleOptionList()) {
							if (null != sizeMap.get(tbTitleOption.getOptionId())) {
								tbTitleOption.setOptionPercent(
										HrDataUtil.getPercentStr(sizeMap.get(tbTitleOption.getOptionId()), countSize)
												+ "%");
								tbTitleOption.setOptionCount(sizeMap.get(tbTitleOption.getOptionId()));
							}
						}
					}
				}
				questionAnswer.setPercentMap(percentMap);
			}
			questionAnswers.add(questionAnswer);
		}
		return questionAnswers;
	}

	/**
	 * 分页查询问卷结果
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "单人统计功能")
	public PaginationData<List<SurveyResultVo>> surveyResultList(SurveyResultPage surveyResultPage) {
		Page<Object> objects = PageHelper.startPage(surveyResultPage.getPage(), surveyResultPage.getRows());
		List<SurveyResultVo> noticeList = surveyResultMapper.listQuest(surveyResultPage);
		for (SurveyResultVo notice : noticeList) {
			notice.setSubmitTimeStr(DateUtils.formatDate(notice.getSubmitTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		PaginationData<List<SurveyResultVo>> data = new PaginationData(noticeList, objects.getTotal());
		return data;
	}

	/**
	 * 查看详情页
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "查看详情功能")
	public SurveyResultVo selectSurveyResult(SurveyResultPage surveyResult) {
		// 查询用户问卷结果
		SurveyResultVo tbSurveyResult = surveyResultMapper.selectSurveyResultQuest(surveyResult);
		// 获取题目及答案列表
		if (null != tbSurveyResult) {
			surveyResult.setId(tbSurveyResult.getId());
			surveyResult.setProjectId(tbSurveyResult.getProjectId());
			surveyResult.setJobNumber(tbSurveyResult.getJobNumber());
			List<AnswerVo> answerList = questAnswer(surveyResult);

			if (null != answerList && answerList.size() > 0) {
				tbSurveyResult.setAnswerList(answerList);
			}
		}

		return tbSurveyResult;
	}

	/**
	 * 查询单人答题详情
	 * 
	 * @param projectId
	 * @param answerFlag
	 * @return
	 */
	private List<AnswerVo> questAnswer(SurveyResultPage surveyResult) {
		List<AnswerVo> questionAnswers = new ArrayList<AnswerVo>();
		// 查询所有问题
		String projectId = surveyResult.getProjectId();
		List<TbManpowerTrainQuestQuestionnaireQuese> tbQuestionList = questionMapper.listQuest(projectId);
		for (TbManpowerTrainQuestQuestionnaireQuese tbQuestion : tbQuestionList) {
			// 查询题目所有选项
			List<TbManpowerTrainQuestTitleOption> tbTitleOptionList = titleOptionMapper
					.listQuest(tbQuestion.getTitleId());
			List<InvestigateTitleOptionAdd> titleOptionList = new ArrayList<InvestigateTitleOptionAdd>();
			for (TbManpowerTrainQuestTitleOption tbTitleOption : tbTitleOptionList) {
				InvestigateTitleOptionAdd investigateTitleOptionAdd = new InvestigateTitleOptionAdd();
				BeanUtils.copyProperties(tbTitleOption, investigateTitleOptionAdd);
				titleOptionList.add(investigateTitleOptionAdd);
			}
			AnswerVo questionAnswer = new AnswerVo();
			// 题目信息
			BeanUtils.copyProperties(tbQuestion, questionAnswer);
			// 选项列表
			questionAnswer.setTitleOptionList(titleOptionList);
			questionAnswers.add(questionAnswer);
		}
		List<TbManpowerTrainQuestAnswerInfo> userAnswerList = answerInfoMapper.listQuestById(surveyResult);
		for (AnswerVo question : questionAnswers) {
			for (TbManpowerTrainQuestAnswerInfo userAnswer : userAnswerList) {
				if (userAnswer.getTitleId().equals(question.getTitleId())) {
					List<InvestigateAnswerAdd> answerList = new ArrayList<InvestigateAnswerAdd>();
					InvestigateAnswerAdd investigateAnswerAdd = new InvestigateAnswerAdd();
					BeanUtils.copyProperties(userAnswer, investigateAnswerAdd);
					answerList.add(investigateAnswerAdd);
					question.setQuestionAnswerList(answerList);
				}
			}
		}
		return questionAnswers;
	}

	/**
	 * 新建答题信息
	 * 
	 * @param investigaAdd
	 *            问卷实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "新建答题信息")
	@Transactional(rollbackFor = Exception.class)
	public void addAnswerInfo(ResultAnswerAdd resultAnswerAdd) {
		TbManpowerTrainQuestSurveyResult tbResult = new TbManpowerTrainQuestSurveyResult();
		BeanUtils.copyProperties(resultAnswerAdd, tbResult);
		if (null == tbResult.getSubmitTime()) {
			tbResult.setSubmitTime(new Date());
		}
		if (null == tbResult.getIsEffective()) {
			tbResult.setIsEffective(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
		}
		tbQuestSurveyResultMapper.insertSelective(tbResult);

		List<InvestigateQuestion> answerInfoList = resultAnswerAdd.getAnswerInfoList();

		for (InvestigateQuestion answer : answerInfoList) {
			TbManpowerTrainQuestAnswerInfo tbAnswerInfo = new TbManpowerTrainQuestAnswerInfo();

			InvestigateAnswer reqAnswer = null;
			List<InvestigateAnswer> answerList = answer.getAnswerList();
			if (null != answerList && answerList.size() > 0) {
				reqAnswer = answerList.get(0);
			}
			BeanUtils.copyProperties(reqAnswer, tbAnswerInfo);
			if (StringUtils.isBlank(tbAnswerInfo.getAnswerId())) {
				tbAnswerInfo.setAnswerId(UUID.randomUUID().toString());
			}
			if (StringUtils.isBlank(tbAnswerInfo.getId())) {
				tbAnswerInfo.setId(tbResult.getId());
			}
			if (StringUtils.isBlank(tbAnswerInfo.getJobNumber())) {
				tbAnswerInfo.setJobNumber(resultAnswerAdd.getJobNumber());
			}
			if (StringUtils.isBlank(tbAnswerInfo.getTitleId())) {
				tbAnswerInfo.setTitleId(answer.getTitleId());
			}
			if (StringUtils.isBlank(tbAnswerInfo.getOptionAnswer())) {
				tbAnswerInfo.setOptionAnswer(tbAnswerInfo.getOptionAnswer().toUpperCase());
			}
			tbQuestAnswerInfoMapper.insertSelective(tbAnswerInfo);
		}

		logger.info("[问卷调查] 答题成功,projectId:{},name:{}", resultAnswerAdd.getProjectId(), resultAnswerAdd.getName());
	}

	/**
	 * TODO 跟据项目id，查询项目详情
	 * 
	 * @param productId
	 * @return
	 */
	private TbManpowerTrainQuestInvestiga selectQuestInvestigate(String productId) {
		TbManpowerTrainQuestInvestiga investigate = tbQuestInvestigaMapper.selectByPrimaryKey(productId);
		if (investigate == null
				|| StringUtils.equals(HrStatusEnums.DELETED.getCode(), investigate.getRecordStatus().toString())) {
			logger.warn("[问卷调查] 查询问卷项目详情信息失败,当前问卷项目不存在,projectId:{}", productId);
			throw new JnSpringCloudException(TrainExceptionEnums.MANAGEMENT_NOT_EXIST, " 查询问卷项目详情信息失败,当前问卷项目不存在");
		}
		return investigate;
	}

	/**
	 * TODO 更新问卷问题
	 * 
	 * @param questionUpd
	 *            问题实体
	 */
	private void updateQuestion(InvestigateQuestion questionUpd) {
		String titleId = questionUpd.getTitleId();
		String projectId = questionUpd.getProjectId();
		TbManpowerTrainQuestQuestionnaireQuese questionnaireQuese = new TbManpowerTrainQuestQuestionnaireQuese();
		questionnaireQuese.setTitleId(titleId);
		questionnaireQuese.setProjectId(projectId);
		TbManpowerTrainQuestQuestionnaireQuese question = questionMapper.selectQuestQuestion(questionnaireQuese);
		if (null == question) {
			logger.warn("[问卷调查] 编辑问卷项目题目失败,编辑的问卷项目问题不存在,projectId:{},titleID:{}", questionUpd.getProjectId(),
					questionUpd.getTitleId());
			throw new JnSpringCloudException(TrainExceptionEnums.NOT_NULL_ERROR, "编辑问卷项目题目失败,编辑的问卷项目问题不存在");
		}
		TbManpowerTrainQuestQuestionnaireQuese tbQuestion = new TbManpowerTrainQuestQuestionnaireQuese();
		BeanUtils.copyProperties(questionUpd, tbQuestion);
		tbQuestQuestionnaireQueseMapper.updateByPrimaryKeySelective(tbQuestion);
	}

	/**
	 * TODO 更新问题选项
	 * 
	 * @param questionUpd
	 *            问题实体
	 */
	private void updateOption(InvestigateQuestion questionUpd) {
		List<InvestigateTitleOption> titleOptionList = questionUpd.getTitleOptionList();
		if (null != titleOptionList && titleOptionList.size() > 0) {
			for (InvestigateTitleOption titleOption : titleOptionList) {
				if (StringUtils.isBlank(titleOption.getTitleId())) {
					titleOption.setTitleId(questionUpd.getTitleId());
				}
				if (StringUtils.isBlank(titleOption.getId())) {
					TbManpowerTrainQuestTitleOption tbOption = new TbManpowerTrainQuestTitleOption();
					BeanUtils.copyProperties(titleOption, tbOption);
					if (StringUtils.isBlank(tbOption.getId())) {
						tbOption.setId(UUID.randomUUID().toString());
					}
					if (!StringUtils.isBlank(tbOption.getOptionId())) {
						tbOption.setOptionId(tbOption.getOptionId().toUpperCase());
					}
					tbQuestTitleOptionMapper.insertSelective(tbOption);
				} else {
					TbManpowerTrainQuestTitleOption tbOption = new TbManpowerTrainQuestTitleOption();
					BeanUtils.copyProperties(titleOption, tbOption);
					if (!StringUtils.isBlank(tbOption.getOptionId())) {
						tbOption.setOptionId(tbOption.getOptionId().toUpperCase());
					}
					tbQuestTitleOptionMapper.updateByPrimaryKeySelective(tbOption);
				}
			}
		}

		List<InvestigateTitleOption> deltitleOptionList = questionUpd.getDeltitleOptionList();
		if (null != deltitleOptionList && deltitleOptionList.size() > 0) {
			for (InvestigateTitleOption deltitleOption : deltitleOptionList) {
				if (StringUtils.isBlank(deltitleOption.getId())) {
					logger.warn("[问卷调查] 删除问卷选项失败,删除时选项id不能为空,projectId:{},titleID:{}", questionUpd.getProjectId(),
							questionUpd.getTitleId());
					throw new JnSpringCloudException(TrainExceptionEnums.NOT_NULL_ERROR, "删除问卷选项失败,删除时选项id不能为空");
				}
				tbQuestTitleOptionMapper.deleteByPrimaryKey(deltitleOption.getId());
			}
		}
	}

	/**
	 * 查询所有题目及选项
	 * 
	 * @param projectId
	 * @param answerFlag
	 * @return
	 */
	private List<InvestigateQuestionAdd> questionList(String projectId) {

		List<InvestigateQuestionAdd> questions = new ArrayList<InvestigateQuestionAdd>();
		List<TbManpowerTrainQuestQuestionnaireQuese> tbQuestionList = questionMapper.listQuest(projectId);
		for (TbManpowerTrainQuestQuestionnaireQuese tbQuestion : tbQuestionList) {
			// 填充返回的题目名称/类型
			InvestigateQuestionAdd question = new InvestigateQuestionAdd();
			BeanUtils.copyProperties(tbQuestion, question);

			// 填充题目对应的选项
			List<InvestigateTitleOptionAdd> titleOptionList = new ArrayList<InvestigateTitleOptionAdd>();
			List<TbManpowerTrainQuestTitleOption> tbTitleOptionList = titleOptionMapper
					.listQuest(tbQuestion.getTitleId());
			if (null != tbTitleOptionList && tbTitleOptionList.size() > 0) {
				for (TbManpowerTrainQuestTitleOption tbTitleOption : tbTitleOptionList) {
					InvestigateTitleOptionAdd titleOption = new InvestigateTitleOptionAdd();
					BeanUtils.copyProperties(tbTitleOption, titleOption);
					titleOptionList.add(titleOption);
				}
			}
			question.setTitleOptionList(titleOptionList);

			List<InvestigateAnswerAdd> answerList = new ArrayList<InvestigateAnswerAdd>();
			InvestigateAnswerAdd answerAdd = new InvestigateAnswerAdd();
			answerAdd.setTitleId(tbQuestion.getTitleId());
			answerList.add(answerAdd);
			question.setAnswerList(answerList);

			questions.add(question);
		}
		return questions;
	}

}
