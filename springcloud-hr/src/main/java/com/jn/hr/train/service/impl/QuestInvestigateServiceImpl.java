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
 * ??????????????????
 *
 * @author??? wangtt
 * 
 * @date???Created on 2019/04/15 04:22 @version??? v1.0
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
	 * ???????????????????????????
	 * 
	 * @param investigaAdd
	 *            ????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "???????????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public void addInvestiageAndQuestion(InvestigateAdd investigaAdd, User user) {
		addInvestiage(investigaAdd, user);
		insertQuestion(investigaAdd.getQuestionList(), investigaAdd.getProjectId());
		logger.info("[????????????] ???????????????????????????,projectId:{}", investigaAdd.getProjectId());
	}

	/**
	 * ??????????????????
	 * 
	 * @param investigaAdd
	 *            ????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String addInvestiage(InvestigateAdd investigaAdd, User user) {
		TbManpowerTrainQuestInvestiga tbInvestiga = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(investigaAdd, tbInvestiga);
		if (null == tbInvestiga.getStatus()) {
			Byte status = Byte.parseByte(InvestigateStatusEnums.DRAFT.getCode());// ?????????????????????
			tbInvestiga.setStatus(status);
		}
		if (null == tbInvestiga.getRecordStatus()) {
			Byte recordStatus = Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode());// ????????????1
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
		logger.info("[????????????] ??????????????????,projectId:{}", investigaAdd.getProjectId());
		return investigaAdd.getProjectId();
	}

	/**
	 * ??????????????????
	 * 
	 * @param questionAdd
	 *            ??????????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "????????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public void addQuestion(Investigate questionAdd, User user) {
		TbManpowerTrainQuestInvestiga tbInvestigate = selectQuestInvestigate(questionAdd.getProjectId());
		if (null != tbInvestigate) {
			List<InvestigateQuestionAdd> questionList = questionAdd.getAddQuestionList();
			insertQuestion(questionList, questionAdd.getProjectId());
		}

		logger.info("[????????????] ????????????-??????????????????,projectId:{}", questionAdd.getProjectId());
	}

	private String insertQuestion(List<InvestigateQuestionAdd> questionList, String projectId) {
		String titleId = "";
		if (null != questionList && questionList.size() > 0) {
			for (InvestigateQuestionAdd question : questionList) {
				// ??????????????????
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

				// ?????????????????????????????????
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
	 * ??????????????????
	 * 
	 * @param investigaUpd
	 *            ????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "????????????????????????")
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
		logger.info("[????????????] ????????????????????????,projectId:{}", investigaUpd.getProjectId());
	}

	/**
	 * ????????????????????????
	 * 
	 * @param questionUpd
	 *            ????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "?????????????????????????????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String updateQuestion(InvestigateQuestion questionUpd, User user) {
		String titleId = "";
		String projectId = questionUpd.getProjectId();
		// ???????????????????????????
		if (!StringUtils.isBlank(questionUpd.getTitleId())) {
			updateQuestion(questionUpd);
			updateOption(questionUpd);
			titleId = questionUpd.getTitleId();
		} else {
			// ?????????????????????
			InvestigateQuestionAdd add = new InvestigateQuestionAdd();
			BeanUtils.copyProperties(questionUpd, add);
			// ??????????????????
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
		logger.info("[????????????] ??????????????????????????????,projectId:{},titleID:{}", questionUpd.getProjectId(), questionUpd.getTitleId());
		return titleId;
	}

	@Override
	@ServiceLog(doAction = "??????????????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public void deleteQuestion(InvestigateQuestion questionUpd, User user) {
		// String projectId = questionUpd.getProjectId();
		// ???????????????????????????
		if (!StringUtils.isBlank(questionUpd.getTitleId())) {
			tbQuestQuestionnaireQueseMapper.deleteByPrimaryKey(questionUpd.getTitleId());
			titleOptionMapper.deleteQuestByTitleId(questionUpd.getTitleId());
		} else {
			logger.warn("???????????????????????????????????????{}", questionUpd.getTitleId());
			throw new JnSpringCloudException(TrainExceptionEnums.NOT_NULL_ERROR, "????????????????????????");
		}
		logger.info("[????????????] ??????????????????????????????????????????,projectId:{},titleID:{}", questionUpd.getProjectId(),
				questionUpd.getTitleId());
	}

	// /**
	// * ????????????
	// *
	// * @param investigaUpd
	// * ????????????
	// * @param user
	// * ??????????????????
	// */
	// @Override
	// @ServiceLog(doAction = "??????????????????")
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
	// // ??????????????????
	// updateQuestion(questionUpd);
	//
	// // ??????????????????
	// updateOption(questionUpd);
	// }
	// }
	// logger.info("[????????????]??????????????????,projectId:{}", investigaUpd.getProjectId());
	// }

	/**
	 * ????????????????????????
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "??????????????????????????????")
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
	 * ????????????????????????
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "??????????????????????????????")
	public InvestigatesVo selectInvestigate(Investigate investigate) {
		InvestigatesVo data = new InvestigatesVo();
		String projectId = investigate.getProjectId();
		// ??????????????????
		TbManpowerTrainQuestInvestiga tbInvestigate = selectQuestInvestigate(projectId);
		BeanUtils.copyProperties(tbInvestigate, data);
		if (null != tbInvestigate.getProjectNote()) {
			data.setProjectNote(new String(tbInvestigate.getProjectNote()));
		}
		// ??????????????????
		if (!StringUtils.isBlank(investigate.getJobNumber()) || !StringUtils.isBlank(investigate.getName())
				|| !StringUtils.isBlank(investigate.getPhone())) {
			loginAuth(tbInvestigate, investigate);
		}
		// ?????????????????????????????????????????????
		List<InvestigateQuestionAdd> questionList = questionList(projectId);
		if (null != questionList && questionList.size() > 0) {
			data.setQuestionList(questionList);
		}
		logger.info("[????????????] ????????????????????????????????????,projectId:{}", projectId);
		return data;
	}

	/**
	 * ???????????????
	 * 
	 * @param tbInvestigate
	 * @param investigate
	 */
	private void loginAuth(TbManpowerTrainQuestInvestiga tbInvestigate, Investigate investigate) {

		if (!tbInvestigate.getStatus().equals(Byte.parseByte(InvestigateStatusEnums.UNDER_WAY.getCode()))) {
			logger.warn("????????????????????????????????????????????????/?????????,project:{},status", tbInvestigate.getProjectId(),
					tbInvestigate.getStatus());
			throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "????????????????????????????????????????????????/?????????");
		}

		TbManpowerTrainQuestResearchSet researchSet = tbQuestResearchSetMapper
				.selectByPrimaryKey(tbInvestigate.getProjectId());
		if (null != researchSet
				&& InvestigateStatusEnums.REAL_NAME.getCode().equals(researchSet.getResearchMethod().toString())) {
			if (researchSet.getIsShowName().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getName())) {
					logger.warn("?????????????????????????????????????????????,project:{}", tbInvestigate.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "?????????????????????????????????????????????");

				}
			}
			if (researchSet.getIsShowJobNumber().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getJobNumber())) {
					logger.warn("?????????????????????????????????????????????,project:{}", tbInvestigate.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "?????????????????????????????????????????????");

				}
			}
			if (researchSet.getIsShowPhone().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getPhone())) {
					logger.warn("????????????????????????????????????????????????,project:{}", tbInvestigate.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "????????????????????????????????????????????????");

				}
			}
			String frequencyLimit = researchSet.getFrequencyLimit().toString();// ????????????
			if (InvestigateStatusEnums.LIMITY_ONE.getCode().equals(frequencyLimit)) {
				TbManpowerTrainQuestSurveyResult surveyResult = new TbManpowerTrainQuestSurveyResult();
				BeanUtils.copyProperties(investigate, surveyResult);
				List<TbManpowerTrainQuestSurveyResult> resultList = surveyResultMapper
						.selectUserQuestSurveyResult(surveyResult);
				if (null != resultList && resultList.size() > 0) {
					logger.warn("?????????????????????????????????????????????????????????,project:{}", tbInvestigate.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "?????????????????????????????????????????????????????????");
				}
			}
		} else {
			logger.warn("?????????????????????,project:{}", tbInvestigate.getProjectId());
			throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "?????????????????????");
		}
	}

	/**
	 * ??????????????????
	 * 
	 * @param investigaDel
	 *            ????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "????????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public void deleteInvestiage(Investigate investigaDel, User user) {
		String projectId = investigaDel.getProjectId();
		// ??????????????????
		TbManpowerTrainQuestInvestiga tbInvestiga = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(investigaDel, tbInvestiga);
		String userAccount = user.getAccount();
		tbInvestiga.setModifierAccount(userAccount);
		tbInvestiga.setModifiedTime(new Date());
		tbInvestiga.setRecordStatus(Byte.parseByte(HrStatusEnums.DELETED.getCode()));
		tbInvestiga.setProjectId(projectId);
		tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
		logger.info("[????????????] ??????????????????,projectId:{}", investigaDel.getProjectId());

	}

	/**
	 * ????????????
	 * 
	 * @param investigaAdd
	 *            
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public void endInvestiage(Investigate investigaDel, User user) {
		String projectId = investigaDel.getProjectId();
		TbManpowerTrainQuestInvestiga tbInvestiga = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(investigaDel, tbInvestiga);
		String userAccount = user.getAccount();
		tbInvestiga.setModifierAccount(userAccount);
		tbInvestiga.setModifiedTime(new Date());
		tbInvestiga.setStatus(Byte.parseByte(InvestigateStatusEnums.HAS_END.getCode()));
		tbInvestiga.setProjectId(projectId);
		tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
		logger.info("[????????????] ??????????????????,projectId:{}", investigaDel.getProjectId());
	}

	/**
	 * ????????????
	 * 
	 * @param researchSet
	 *            ??????????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public void sendInvestiage(ResearchSetAdd researchSet, User user) {

		String projectId = researchSet.getProjectId();
		TbManpowerTrainQuestResearchSet tbResearchSet = tbQuestResearchSetMapper.selectByPrimaryKey(projectId);
		if (null == tbResearchSet) {
			// ??????????????????
			tbResearchSet = new TbManpowerTrainQuestResearchSet();
			BeanUtils.copyProperties(researchSet, tbResearchSet);
			tbQuestResearchSetMapper.insertSelective(tbResearchSet);
		} else {
			// ??????????????????
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
					logger.warn("??????????????????,????????????????????????:{}", email);
					throw new JnSpringCloudException(TrainExceptionEnums.SEND_ERROR, "??????????????????,????????????????????????");
				}
			}
			EmailVo emailVo = new EmailVo();
			emailVo.setEmail(emailList);
			emailVo.setEmailSubject(researchSet.getEmailSubject());
			emailVo.setEmailContent(researchSet.getEmailContent());
			sendEmailMsg(emailVo);
		}
		// ???????????????????????????????????????
		tbHrinvestiage = new TbManpowerTrainQuestInvestiga();
		BeanUtils.copyProperties(researchSet, tbHrinvestiage);
		tbHrinvestiage.setModifierAccount(user.getAccount());
		tbHrinvestiage.setModifiedTime(new Date());
		tbHrinvestiage.setStatus(Byte.parseByte(InvestigateStatusEnums.UNDER_WAY.getCode()));
		tbQuestInvestigaMapper.updateByPrimaryKeySelective(tbHrinvestiage);
		logger.info("[????????????] ??????????????????,projectId:{}", researchSet.getProjectId());

	}

	/**
	 * ????????????
	 * 
	 * @param emailVo
	 */
	public void sendEmailMsg(EmailVo emailVo) {
		boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
		if (!sendStatus) {
			logger.warn("????????????????????????,????????????:{}", emailVo.getEmailSubject());
		}
	}

	/**
	 * ??????????????????
	 * 
	 * @param researchSet
	 *            ??????????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "????????????????????????")
	public ResearchSet loginInvestiage(String projectId) {
		ResearchSet researchSet = new ResearchSet();

		TbManpowerTrainQuestInvestiga tbInvestigate = selectQuestInvestigate(projectId);
		BeanUtils.copyProperties(tbInvestigate, researchSet);
		if (null != tbInvestigate.getProjectNote()) {
			researchSet.setProjectNote(new String(tbInvestigate.getProjectNote()));
		}
		TbManpowerTrainQuestResearchSet tbResearchSet = tbQuestResearchSetMapper.selectByPrimaryKey(projectId);
		if (null == tbResearchSet) {
			logger.warn("[????????????]??????????????????????????????????????????,projectId:{}", researchSet.getProjectId());
			throw new JnSpringCloudException(TrainExceptionEnums.RESEARCH_SET_NOT_EXIST, "??????????????????????????????????????????");
		}
		BeanUtils.copyProperties(tbResearchSet, researchSet);
		logger.info("???????????????????????????????????????,projectId:{}", researchSet.getProjectId());
		return researchSet;
	}

	/**
	 * ????????????-????????????
	 * 
	 * @param investigaAdd
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "??????????????????")
	public List<AnswerVo> questionAnswerList(String projectId) {
		List<AnswerVo> answerVos = questAnswerList(projectId);
		return answerVos;
	}

	/**
	 * ??????????????????,???????????????
	 * 
	 * @param projectId
	 * @param answerFlag
	 * @return
	 */
	private List<AnswerVo> questAnswerList(String projectId) {
		List<AnswerVo> questionAnswers = new ArrayList<AnswerVo>();
		// ??????????????????
		List<TbManpowerTrainQuestQuestionnaireQuese> tbQuestionList = questionMapper.listQuest(projectId);
		for (TbManpowerTrainQuestQuestionnaireQuese tbQuestion : tbQuestionList) {
			AnswerVo questionAnswer = new AnswerVo();
			// ????????????
			BeanUtils.copyProperties(tbQuestion, questionAnswer);
			// ????????????????????????
			List<TbManpowerTrainQuestTitleOption> tbTitleOptionList = titleOptionMapper
					.listQuest(tbQuestion.getTitleId());
			List<InvestigateTitleOptionAdd> titleOptionList = BeanCopyUtil.copyList(tbTitleOptionList,
					InvestigateTitleOptionAdd.class);
			questionAnswer.setTitleOptionList(titleOptionList);

			// ??????????????????
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
	 * ????????????????????????
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "??????????????????")
	public PaginationData<List<SurveyResultVo>> surveyResultList(SurveyResultPage surveyResultPage) {
		// ??????????????????????????????
		TbManpowerTrainQuestResearchSet tbManpowerTrainQuestResearchSet = tbQuestResearchSetMapper
				.selectByPrimaryKey(surveyResultPage.getProjectId());
		if (null != tbManpowerTrainQuestResearchSet && InvestigateStatusEnums.HIDE_NAME.getCode()
				.equals(tbManpowerTrainQuestResearchSet.getResearchMethod().toString())) {
			logger.warn("[????????????] ??????????????????????????????,?????????????????????????????????,projectId:{}", surveyResultPage.getProjectId());
			throw new JnSpringCloudException(TrainExceptionEnums.INTERFACE_NOT_EXIT, "???????????????????????????????????????");
		}
		Page<Object> objects = PageHelper.startPage(surveyResultPage.getPage(), surveyResultPage.getRows());
		List<SurveyResultVo> noticeList = surveyResultMapper.listQuest(surveyResultPage);
		for (SurveyResultVo notice : noticeList) {
			notice.setSubmitTimeStr(DateUtils.formatDate(notice.getSubmitTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		PaginationData<List<SurveyResultVo>> data = new PaginationData(noticeList, objects.getTotal());
		return data;
	}

	/**
	 * ???????????????
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "??????????????????")
	public SurveyResultVo selectSurveyResult(SurveyResultPage surveyResult) {
		// ????????????????????????
		SurveyResultVo tbSurveyResult = surveyResultMapper.selectSurveyResultQuest(surveyResult);
		// ???????????????????????????
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
	 * ????????????????????????
	 * 
	 * @param projectId
	 * @param answerFlag
	 * @return
	 */
	private List<AnswerVo> questAnswer(SurveyResultPage surveyResult) {
		List<AnswerVo> questionAnswers = new ArrayList<AnswerVo>();
		// ??????????????????
		String projectId = surveyResult.getProjectId();
		List<TbManpowerTrainQuestQuestionnaireQuese> tbQuestionList = questionMapper.listQuest(projectId);
		for (TbManpowerTrainQuestQuestionnaireQuese tbQuestion : tbQuestionList) {
			// ????????????????????????
			List<TbManpowerTrainQuestTitleOption> tbTitleOptionList = titleOptionMapper
					.listQuest(tbQuestion.getTitleId());
			List<InvestigateTitleOptionAdd> titleOptionList = new ArrayList<InvestigateTitleOptionAdd>();
			for (TbManpowerTrainQuestTitleOption tbTitleOption : tbTitleOptionList) {
				InvestigateTitleOptionAdd investigateTitleOptionAdd = new InvestigateTitleOptionAdd();
				BeanUtils.copyProperties(tbTitleOption, investigateTitleOptionAdd);
				titleOptionList.add(investigateTitleOptionAdd);
			}
			AnswerVo questionAnswer = new AnswerVo();
			// ????????????
			BeanUtils.copyProperties(tbQuestion, questionAnswer);
			// ????????????
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
	 * ??????????????????
	 * 
	 * @param investigaAdd
	 *            ????????????
	 * @param user
	 *            ??????????????????
	 */
	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public void addAnswerInfo(ResultAnswerAdd resultAnswerAdd) {
		// ?????????????????????
		if (StringUtils.isBlank(resultAnswerAdd.getId())) {
			resultAnswerAdd.setId(UUID.randomUUID().toString());
		}
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
				String jobNumber = resultAnswerAdd.getJobNumber();
				if (StringUtils.isBlank(jobNumber)) {
					jobNumber = resultAnswerAdd.getPhone();
				}
				if (StringUtils.isBlank(jobNumber)) {
					jobNumber = resultAnswerAdd.getName();
				}
				tbAnswerInfo.setJobNumber(jobNumber);
			}
			if (StringUtils.isBlank(tbAnswerInfo.getTitleId())) {
				tbAnswerInfo.setTitleId(answer.getTitleId());
			}
			if (StringUtils.isBlank(tbAnswerInfo.getOptionAnswer())) {
				tbAnswerInfo.setOptionAnswer(tbAnswerInfo.getOptionAnswer().toUpperCase());
			}
			tbQuestAnswerInfoMapper.insertSelective(tbAnswerInfo);
		}

		logger.info("[????????????] ????????????,projectId:{},name:{}", resultAnswerAdd.getProjectId(), resultAnswerAdd.getName());
	}

	/**
	 * TODO ????????????id?????????????????????
	 * 
	 * @param productId
	 * @return
	 */
	private TbManpowerTrainQuestInvestiga selectQuestInvestigate(String productId) {
		TbManpowerTrainQuestInvestiga investigate = tbQuestInvestigaMapper.selectByPrimaryKey(productId);
		if (investigate == null
				|| StringUtils.equals(HrStatusEnums.DELETED.getCode(), investigate.getRecordStatus().toString())) {
			logger.warn("[????????????] ????????????????????????????????????,???????????????????????????,projectId:{}", productId);
			throw new JnSpringCloudException(TrainExceptionEnums.MANAGEMENT_NOT_EXIST, " ????????????????????????????????????,???????????????????????????");
		}
		return investigate;
	}

	/**
	 * TODO ??????????????????
	 * 
	 * @param questionUpd
	 *            ????????????
	 */
	private void updateQuestion(InvestigateQuestion questionUpd) {
		String titleId = questionUpd.getTitleId();
		String projectId = questionUpd.getProjectId();
		TbManpowerTrainQuestQuestionnaireQuese questionnaireQuese = new TbManpowerTrainQuestQuestionnaireQuese();
		questionnaireQuese.setTitleId(titleId);
		questionnaireQuese.setProjectId(projectId);
		TbManpowerTrainQuestQuestionnaireQuese question = questionMapper.selectQuestQuestion(questionnaireQuese);
		if (null == question) {
			logger.warn("[????????????] ??????????????????????????????,????????????????????????????????????,projectId:{},titleID:{}", questionUpd.getProjectId(),
					questionUpd.getTitleId());
			throw new JnSpringCloudException(TrainExceptionEnums.NOT_NULL_ERROR, "????????????????????????,?????????????????????");
		}
		TbManpowerTrainQuestQuestionnaireQuese tbQuestion = new TbManpowerTrainQuestQuestionnaireQuese();
		BeanUtils.copyProperties(questionUpd, tbQuestion);
		tbQuestQuestionnaireQueseMapper.updateByPrimaryKeySelective(tbQuestion);
	}

	/**
	 * TODO ??????????????????
	 * 
	 * @param questionUpd
	 *            ????????????
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
					logger.warn("[????????????] ????????????????????????,???????????????id????????????,projectId:{},titleID:{}", questionUpd.getProjectId(),
							questionUpd.getTitleId());
					throw new JnSpringCloudException(TrainExceptionEnums.NOT_NULL_ERROR, "????????????????????????,???????????????id????????????");
				}
				tbQuestTitleOptionMapper.deleteByPrimaryKey(deltitleOption.getId());
			}
		}
	}

	/**
	 * ???????????????????????????
	 * 
	 * @param projectId
	 * @param answerFlag
	 * @return
	 */
	private List<InvestigateQuestionAdd> questionList(String projectId) {

		List<InvestigateQuestionAdd> questions = new ArrayList<InvestigateQuestionAdd>();
		List<TbManpowerTrainQuestQuestionnaireQuese> tbQuestionList = questionMapper.listQuest(projectId);
		for (TbManpowerTrainQuestQuestionnaireQuese tbQuestion : tbQuestionList) {
			// ???????????????????????????/??????
			InvestigateQuestionAdd question = new InvestigateQuestionAdd();
			BeanUtils.copyProperties(tbQuestion, question);

			// ???????????????????????????
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
