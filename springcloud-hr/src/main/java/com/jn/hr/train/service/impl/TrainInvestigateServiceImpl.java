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
import com.jn.hr.train.dao.TbManpowerTrainAnswerInfoMapper;
import com.jn.hr.train.dao.TbManpowerTrainInvestigaMapper;
import com.jn.hr.train.dao.TbManpowerTrainQuestionnaireQueseMapper;
import com.jn.hr.train.dao.TbManpowerTrainResearchSetMapper;
import com.jn.hr.train.dao.TbManpowerTrainSurveyResultMapper;
import com.jn.hr.train.dao.TbManpowerTrainTitleOptionMapper;
import com.jn.hr.train.dao.TitleOptionMapper;
import com.jn.hr.train.enmus.InvestigateStatusEnums;
import com.jn.hr.train.enmus.TrainExceptionEnums;
import com.jn.hr.train.entity.TbManpowerTrainAnswerInfo;
import com.jn.hr.train.entity.TbManpowerTrainInvestiga;
import com.jn.hr.train.entity.TbManpowerTrainQuestionnaireQuese;
import com.jn.hr.train.entity.TbManpowerTrainResearchSet;
import com.jn.hr.train.entity.TbManpowerTrainSurveyResult;
import com.jn.hr.train.entity.TbManpowerTrainTitleOption;
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
import com.jn.hr.train.service.TrainInvestigateService;
import com.jn.hr.train.vo.AnswerVo;
import com.jn.hr.train.vo.InvestigatesVo;
import com.jn.hr.train.vo.SurveyResultVo;
import com.jn.news.vo.EmailVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

/**
 * 调研分析服务
 *
 * @author： wangtt
 * 
 * @date：Created on 2019/04/15 04:22 @version： v1.0
 * @modified By:
 **/
@Service
public class TrainInvestigateServiceImpl implements TrainInvestigateService {
	private static final Logger logger = LoggerFactory.getLogger(TrainInvestigateServiceImpl.class);

	@Autowired
	TbManpowerTrainInvestigaMapper tbManpowerTrainInvestigaMapper;

	@Autowired
	TbManpowerTrainQuestionnaireQueseMapper tbManpowerTrainQuestionnaireQueseMapper;

	@Autowired
	TbManpowerTrainResearchSetMapper tbManpowerTrainResearchSetMapper;

	@Autowired
	TbManpowerTrainTitleOptionMapper tbManpowerTrainTitleOptionMapper;

	@Autowired
	TbManpowerTrainAnswerInfoMapper tbManpowerTrainAnswerInfoMapper;

	@Autowired
	TbManpowerTrainSurveyResultMapper tbManpowerTrainSurveyResultMapper;
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
	 * 新建调研项目及题目
	 * 
	 * @param investigaAdd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "新建调研项目及题目功能")
	@Transactional(rollbackFor = Exception.class)
	public void addInvestiageAndQuestion(InvestigateAdd investigaAdd, User user) {
		addInvestiage(investigaAdd, user);
		insertQuestion(investigaAdd.getQuestionList(), investigaAdd.getProjectId());
		logger.info("[调研分析] 新建项目及题目成功,projectId:{}", investigaAdd.getProjectId());
	}

	/**
	 * 新建调研项目
	 * 
	 * @param investigaAdd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	// @Override
	// @ServiceLog(doAction = "新建项目功能")
	// @Transactional(rollbackFor = Exception.class)
	// public String addInvestiage(InvestigateAdd investigaAdd, User user) {
	private String addInvestiage(InvestigateAdd investigaAdd, User user) {
		TbManpowerTrainInvestiga tbInvestiga = new TbManpowerTrainInvestiga();
		BeanUtils.copyProperties(investigaAdd, tbInvestiga);
		if (null == tbInvestiga.getStatus()) {
			Byte status = Byte.parseByte(InvestigateStatusEnums.DRAFT.getCode());// 首次创建的草稿
			tbInvestiga.setStatus(status);
		}
		if (null == tbInvestiga.getRecordStatus()) {
			Byte recordStatus = Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode());// 正常调研1
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
		tbManpowerTrainInvestigaMapper.insertSelective(tbInvestiga);
		logger.info("[调研分析] 新建项目成功,projectId:{}", investigaAdd.getProjectId());
		return investigaAdd.getProjectId();
	}

	/**
	 * 新增调研项目题目
	 * 
	 * @param questionAdd
	 *            调研题目实体
	 * @param user
	 *            当前登陆用户
	 */
	// @Override
	// @ServiceLog(doAction = "新建项目题目功能")
	// @Transactional(rollbackFor = Exception.class)
	// public void addQuestion(Investigate questionAdd, User user) {
	// private void addQuestion(Investigate questionAdd, User user) {
	// TbManpowerTrainInvestiga tbHrinvestiage =
	// selectQuestInvestigate(questionAdd.getProjectId());
	// if (null != tbHrinvestiage) {
	// List<InvestigateQuestionAdd> questionList =
	// questionAdd.getAddQuestionList();
	// insertQuestion(questionList, questionAdd.getProjectId());
	// }
	// logger.info("[调研分析] 新建项目-题目添加成功,projectId:{}",
	// questionAdd.getProjectId());
	// }

	/**
	 * 新建项目问题及选项
	 * 
	 * @param questionList
	 * @param projectId
	 */
	private String insertQuestion(List<InvestigateQuestionAdd> questionList, String projectId) {
		String titleId = "";
		if (null != questionList) {
			for (InvestigateQuestionAdd question : questionList) {
				// 新增调研题目
				TbManpowerTrainQuestionnaireQuese tbQuestion = new TbManpowerTrainQuestionnaireQuese();
				BeanUtils.copyProperties(question, tbQuestion);
				if (StringUtils.isBlank(tbQuestion.getProjectId())) {
					tbQuestion.setProjectId(projectId);
				}
				titleId = tbQuestion.getTitleId();
				if (StringUtils.isBlank(titleId)) {
					titleId = UUID.randomUUID().toString();
				}
				tbQuestion.setTitleId(titleId);
				tbManpowerTrainQuestionnaireQueseMapper.insertSelective(tbQuestion);

				// 新增调研对应的选项信息
				List<InvestigateTitleOptionAdd> titleOptionList = question.getTitleOptionList();
				if (null != titleOptionList && titleOptionList.size() > 0) {
					for (InvestigateTitleOptionAdd titleOption : titleOptionList) {
						TbManpowerTrainTitleOption tbOption = new TbManpowerTrainTitleOption();
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
						tbManpowerTrainTitleOptionMapper.insertSelective(tbOption);
					}
				}
			}
		}
		return titleId;
	}

	/**
	 * 编辑调研项目
	 * 
	 * @param investigaAdd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "编辑调研功能")
	@Transactional(rollbackFor = Exception.class)
	public void updateInvestiage(Investigate investigaUpd, User user) {
		TbManpowerTrainInvestiga tbHrinvestiage = selectQuestInvestigate(investigaUpd.getProjectId());
		if (null != tbHrinvestiage) {
			TbManpowerTrainInvestiga tbInvestiga = new TbManpowerTrainInvestiga();
			BeanUtils.copyProperties(investigaUpd, tbInvestiga);
			String userAccount = user.getAccount();
			tbInvestiga.setModifierAccount(userAccount);
			tbInvestiga.setModifiedTime(new Date());
			if (!StringUtils.isBlank(investigaUpd.getProjectNote())) {
				tbInvestiga.setProjectNote(investigaUpd.getProjectNote().getBytes());
			}
			tbManpowerTrainInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
		}
		logger.info("[调研分析] 编辑调研成功,projectId:{}", investigaUpd.getProjectId());

	}

	/**
	 * 编辑调研题目
	 * 
	 * @param questionAdd
	 *            调研题目实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "编辑调研题目新增或修改功能")
	@Transactional(rollbackFor = Exception.class)
	public String updateQuestion(InvestigateQuestion questionUpd, User user) {
		String titleId = "";
		String projectId = questionUpd.getProjectId();
		// 更新调研问题及选项
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
		logger.info("[调研分析] 编辑调研题目新增或修改项目题目成功,projectId:{},titleID:{}", questionUpd.getProjectId(),
				questionUpd.getTitleId());
		return titleId;
	}

	@Override
	@ServiceLog(doAction = "编辑调研题目删除功能")
	@Transactional(rollbackFor = Exception.class)
	public void deleteQuestion(InvestigateQuestion questionUpd, User user) {
		// String projectId = questionUpd.getProjectId();
		// 更新调研问题及选项
		if (!StringUtils.isBlank(questionUpd.getTitleId())) {
			tbManpowerTrainQuestionnaireQueseMapper.deleteByPrimaryKey(questionUpd.getTitleId());
			titleOptionMapper.deleteByTitleId(questionUpd.getTitleId());
		} else {
			logger.warn("删除题目失败，题目编号为空{}", questionUpd.getTitleId());
			throw new JnSpringCloudException(TrainExceptionEnums.NOT_NULL_ERROR, "删除题目失败，题目编号为空");
		}
		logger.info("[调研分析] 编辑调研题目删除项目题目成功,projectId:{},titleID:{}", questionUpd.getProjectId(),
				questionUpd.getTitleId());
	}

	/**
	 * 编辑调研
	 * 
	 * @param investigaUpd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "编辑调研功能")
	@Transactional(rollbackFor = Exception.class)
	public void update(Investigate investigaUpd, User user) {
		String projectId = investigaUpd.getProjectId();
		TbManpowerTrainInvestiga tbHrinvestiage = selectQuestInvestigate(projectId);
		if (null != tbHrinvestiage) {
			TbManpowerTrainInvestiga tbInvestiga = new TbManpowerTrainInvestiga();
			BeanUtils.copyProperties(investigaUpd, tbInvestiga);
			String userAccount = user.getAccount();
			tbInvestiga.setModifierAccount(userAccount);
			tbInvestiga.setModifiedTime(new Date());
			if (!StringUtils.isBlank(investigaUpd.getProjectNote())) {
				tbInvestiga.setProjectNote(investigaUpd.getProjectNote().getBytes());
			}
			tbManpowerTrainInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);

			// 新增或修改问题
			List<InvestigateQuestion> questionList = investigaUpd.getQuestionList();
			if (null != questionList && questionList.size() > 0) {
				for (InvestigateQuestion questionUpd : questionList) {
					updateQuestion(questionUpd);
					updateOption(questionUpd);
				}
			}

			// 删除问题
			List<InvestigateQuestion> delquestionList = investigaUpd.getDeleteQuestionList();
			if (null != delquestionList && delquestionList.size() > 0) {
				for (InvestigateQuestion delquestion : delquestionList) {
					deleteQuestion(delquestion, user);
				}
			}
		}
		logger.info("[调研分析] 编辑调研成功,projectId:{}", investigaUpd.getProjectId());
	}

	/**
	 * 分页查询调研项目信息
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "分页查询调研项目信息")
	public PaginationData<List<InvestigatesVo>> list(InvestigatePage investigatePage) {
		Page<Object> objects = PageHelper.startPage(investigatePage.getPage(), investigatePage.getRows());
		List<InvestigatesVo> noticeList = investigateMapper.list(investigatePage);
		for (InvestigatesVo notice : noticeList) {
			notice.setEffectiveTimeStartStr(
					DateUtils.formatDate(notice.getEffectiveTimeStart(), "yyyy-MM-dd HH:mm:ss"));
			notice.setEffectiveTimeEndStr(DateUtils.formatDate(notice.getEffectiveTimeEnd(), "yyyy-MM-dd HH:mm:ss"));
		}
		PaginationData<List<InvestigatesVo>> data = new PaginationData(noticeList, objects.getTotal());
		return data;
	}

	/**
	 * 查询调研项目详情信息[查看页面]
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "查询调研项目详情信息[查看页面]")
	public InvestigatesVo selectInvestigate(Investigate investigate) {
		InvestigatesVo data = new InvestigatesVo();
		String projectId = investigate.getProjectId();
		// 查询项目详情
		TbManpowerTrainInvestiga tbHrinvestiage = selectQuestInvestigate(projectId);
		BeanUtils.copyProperties(tbHrinvestiage, data);
		if (null != tbHrinvestiage.getProjectNote()) {
			data.setProjectNote(new String(tbHrinvestiage.getProjectNote()));
		}
		// 是否是登录页
		if (!StringUtils.isBlank(investigate.getJobNumber()) || !StringUtils.isBlank(investigate.getName())
				|| !StringUtils.isBlank(investigate.getPhone())) {
			loginAuth(tbHrinvestiage, investigate);
		}

		// 查询当前项目下的所有问题及选项
		List<InvestigateQuestionAdd> questionList = questionList(projectId);
		if (null != questionList && questionList.size() > 0) {
			data.setQuestionList(questionList);
		}
		logger.info("[调研分析] 查询调研项目详情信息成功,projectId:{}", projectId);
		return data;
	}

	/**
	 * 登陆页验证
	 * 
	 * @param tbHrinvestiage
	 * @param investigate
	 */
	private void loginAuth(TbManpowerTrainInvestiga tbHrinvestiage, Investigate investigate) {

		if (!tbHrinvestiage.getStatus().equals(Byte.parseByte(InvestigateStatusEnums.UNDER_WAY.getCode()))) {
			logger.warn("参加调研分析失败，当前调研未开始/已结束,project:{},status", tbHrinvestiage.getProjectId(),
					tbHrinvestiage.getStatus());
			throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加调研分析失败，当前调研未开始/已结束");
		}

		TbManpowerTrainResearchSet researchSet = tbManpowerTrainResearchSetMapper
				.selectByPrimaryKey(tbHrinvestiage.getProjectId());
		if (null != researchSet
				&& InvestigateStatusEnums.REAL_NAME.getCode().equals(researchSet.getResearchMethod().toString())) {
			if (researchSet.getIsShowName().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getName())) {
					logger.warn("参加调研分析失败，姓名为必填项,project:{}", tbHrinvestiage.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加调研分析失败，姓名为必填项");

				}
			}
			if (researchSet.getIsShowJobNumber().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getJobNumber())) {
					logger.warn("参加调研分析失败，工号为必填项,project:{}", tbHrinvestiage.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加调研分析失败，工号为必填项");

				}
			}
			if (researchSet.getIsShowPhone().toString().equals(InvestigateStatusEnums.DISPLAY.getCode())) {
				if (StringUtils.isBlank(investigate.getPhone())) {
					logger.warn("参加调研分析失败，手机号为必填项,project:{}", tbHrinvestiage.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加调研分析失败，手机号为必填项");

				}
			}
			String frequencyLimit = researchSet.getFrequencyLimit().toString();// 调研次数
			if (InvestigateStatusEnums.LIMITY_ONE.getCode().equals(frequencyLimit)) {
				TbManpowerTrainSurveyResult surveyResult = new TbManpowerTrainSurveyResult();
				BeanUtils.copyProperties(investigate, surveyResult);
				List<TbManpowerTrainSurveyResult> resultList = surveyResultMapper.selectUserSurveyResult(surveyResult);
				if (null != resultList && resultList.size() > 0) {
					logger.warn("参加调研分析失败，当前用户已参与过调查,project:{}", tbHrinvestiage.getProjectId());
					throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加调研分析失败，当前用户已参与过调查");
				}
			}
		} else {
			logger.warn("当前调研未设置,project:{}", tbHrinvestiage.getProjectId());
			throw new JnSpringCloudException(TrainExceptionEnums.JOIN_MANAGEMENT_ERROR, "参加调研分析失败，当前调研未发放");
		}
	}

	/**
	 * 删除调研
	 * 
	 * @param investigaAdd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "删除调研功能")
	@Transactional(rollbackFor = Exception.class)
	public void deleteInvestiage(Investigate investigaDel, User user) {
		String projectId = investigaDel.getProjectId();
		// TbManpowerTrainInvestiga tbHrinvestiage =
		// selectQuestInvestigate(projectId);
		// if (null != tbHrinvestiage) {
		TbManpowerTrainInvestiga tbInvestiga = new TbManpowerTrainInvestiga();
		BeanUtils.copyProperties(investigaDel, tbInvestiga);
		String userAccount = user.getAccount();
		tbInvestiga.setModifierAccount(userAccount);
		tbInvestiga.setModifiedTime(new Date());
		tbInvestiga.setRecordStatus(Byte.parseByte(HrStatusEnums.DELETED.getCode()));
		tbInvestiga.setProjectId(projectId);
		tbManpowerTrainInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
		// }
		logger.info("[调研分析] 删除调研成功,projectId:{}", investigaDel.getProjectId());
	}

	/**
	 * 结束调研
	 * 
	 * @param investigaAdd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "结束调研功能")
	@Transactional(rollbackFor = Exception.class)
	public void endInvestiage(Investigate investigaDel, User user) {
		String projectId = investigaDel.getProjectId();
		// TbManpowerTrainInvestiga tbHrinvestiage =
		// selectQuestInvestigate(projectId);
		// if (null != tbHrinvestiage) {
		TbManpowerTrainInvestiga tbInvestiga = new TbManpowerTrainInvestiga();
		BeanUtils.copyProperties(investigaDel, tbInvestiga);
		String userAccount = user.getAccount();
		tbInvestiga.setModifierAccount(userAccount);
		tbInvestiga.setModifiedTime(new Date());
		tbInvestiga.setStatus(Byte.parseByte(InvestigateStatusEnums.HAS_END.getCode()));
		tbInvestiga.setProjectId(projectId);
		tbManpowerTrainInvestigaMapper.updateByPrimaryKeySelective(tbInvestiga);
		// }
		logger.info("[调研分析] 结束调研成功,projectId:{}", investigaDel.getProjectId());
	}

	/**
	 * 发放调研
	 * 
	 * @param researchSet
	 *            调研设置实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "发放调研功能")
	@Transactional(rollbackFor = Exception.class)
	public void sendInvestiage(ResearchSetAdd researchSet, User user) {

		String projectId = researchSet.getProjectId();
		TbManpowerTrainResearchSet tbResearchSet = tbManpowerTrainResearchSetMapper.selectByPrimaryKey(projectId);
		if (null == tbResearchSet) {
			// 新建调研任务
			tbResearchSet = new TbManpowerTrainResearchSet();
			BeanUtils.copyProperties(researchSet, tbResearchSet);
			tbManpowerTrainResearchSetMapper.insertSelective(tbResearchSet);
		} else {
			// 修改调研任务
			tbResearchSet = new TbManpowerTrainResearchSet();
			BeanUtils.copyProperties(researchSet, tbResearchSet);
			tbManpowerTrainResearchSetMapper.updateByPrimaryKeySelective(tbResearchSet);
		}

		if (!StringUtils.isBlank(researchSet.getEmailList()) && !StringUtils.isBlank(researchSet.getEmailSubject())
				&& !StringUtils.isBlank(researchSet.getEmailContent())) {
			String emailList = researchSet.getEmailList();
			String[] emails = emailList.split(",");
			for (String email : emails) {
				if (!ValidateUtil.isEmail(email)) {
					logger.warn("发放调研失败,输入邮箱格式错误:{}", email);
					throw new JnSpringCloudException(TrainExceptionEnums.SEND_ERROR, "发放调研失败,输入邮箱格式错误");
				}
			}
			EmailVo emailVo = new EmailVo();
			emailVo.setEmail(emailList);
			emailVo.setEmailSubject(researchSet.getEmailSubject());
			emailVo.setEmailContent(researchSet.getEmailContent());
			sendEmailMsg(emailVo);
		}
		// 邮件发送成功，更新调研状态
		TbManpowerTrainInvestiga tbHrinvestiage = new TbManpowerTrainInvestiga();
		BeanUtils.copyProperties(researchSet, tbHrinvestiage);
		tbHrinvestiage.setModifierAccount(user.getAccount());
		tbHrinvestiage.setModifiedTime(new Date());
		tbHrinvestiage.setStatus(Byte.parseByte(InvestigateStatusEnums.UNDER_WAY.getCode()));
		tbManpowerTrainInvestigaMapper.updateByPrimaryKeySelective(tbHrinvestiage);
		logger.info("[调研分析] 发放调研成功,projectId:{}", researchSet.getProjectId());
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
			throw new JnSpringCloudException(TrainExceptionEnums.SEND_ERROR, "发送邮件通知失败");
		}
	}

	/**
	 * 调研页面展示
	 * 
	 * @param researchSet
	 *            调研设置实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "调研页面展示功能")
	public ResearchSet loginInvestiage(String projectId) {
		ResearchSet researchSet = new ResearchSet();
		TbManpowerTrainInvestiga tbHrinvestiage = selectQuestInvestigate(projectId);
		BeanUtils.copyProperties(tbHrinvestiage, researchSet);
		if (null != tbHrinvestiage.getProjectNote()) {
			researchSet.setProjectNote(new String(tbHrinvestiage.getProjectNote()));
		}
		TbManpowerTrainResearchSet tbResearchSet = tbManpowerTrainResearchSetMapper.selectByPrimaryKey(projectId);
		if (null == tbResearchSet) {
			logger.warn("[调研分析] 登陆调研失败，当前调研任务不存在,projectId:{}", researchSet.getProjectId());
			throw new JnSpringCloudException(TrainExceptionEnums.RESEARCH_SET_NOT_EXIST, "登陆调研失败，当前调研未发放");
		}
		BeanUtils.copyProperties(tbResearchSet, researchSet);

		logger.info("调研页面信息查询成功,projectId:{}", researchSet.getProjectId());
		return researchSet;
	}

	/**
	 * 调研结果-汇总统计
	 * 
	 * @param investigaAdd
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "汇总统计功能")
	public List<AnswerVo> questionAnswerList(String projectId) {
		List<AnswerVo> answerVos = questAnswerList(projectId);
		return answerVos;
	}

	/**
	 * 分页查询调研结果
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "单人统计功能")
	public PaginationData<List<SurveyResultVo>> surveyResultList(SurveyResultPage surveyResultPage) {
		// 查询当前项目设置详情
		TbManpowerTrainResearchSet tbManpowerTrainQuestResearchSet = tbManpowerTrainResearchSetMapper
				.selectByPrimaryKey(surveyResultPage.getProjectId());
		if (null != tbManpowerTrainQuestResearchSet && InvestigateStatusEnums.HIDE_NAME.getCode()
				.equals(tbManpowerTrainQuestResearchSet.getResearchMethod().toString())) {
			logger.warn("[调研分析] 查看单人统计页面失败,当前项目为匿名统计项目,projectId:{}", surveyResultPage.getProjectId());
			throw new JnSpringCloudException(TrainExceptionEnums.INTERFACE_NOT_EXIT, "匿名统计项目无单人统计界面");
		}
		Page<Object> objects = PageHelper.startPage(surveyResultPage.getPage(), surveyResultPage.getRows());
		List<SurveyResultVo> noticeList = surveyResultMapper.list(surveyResultPage);
		for (SurveyResultVo notice : noticeList) {
			notice.setSubmitTimeStr(DateUtils.formatDate(notice.getSubmitTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		PaginationData<List<SurveyResultVo>> data = new PaginationData(noticeList, objects.getTotal());
		return data;
	}

	/**
	 * 查询单人调研结果
	 * 
	 * @param investigatePage
	 * @return
	 */
	@Override
	@ServiceLog(doAction = "查询单人调研结果")
	public SurveyResultVo selectSurveyResult(SurveyResultPage surveyResult) {
		// 查询用户调研结果
		SurveyResultVo tbSurveyResult = surveyResultMapper.selectSurveyResult(surveyResult);

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
	 * 新建答题信息
	 * 
	 * @param investigaAdd
	 *            调研实体
	 * @param user
	 *            当前登陆用户
	 */
	@Override
	@ServiceLog(doAction = "新建答题信息")
	@Transactional(rollbackFor = Exception.class)
	public void addAnswerInfo(ResultAnswerAdd resultAnswerAdd) {
		TbManpowerTrainSurveyResult tbResult = new TbManpowerTrainSurveyResult();
		BeanUtils.copyProperties(resultAnswerAdd, tbResult);
		if (null == tbResult.getSubmitTime()) {
			tbResult.setSubmitTime(new Date());
		}
		if (null == tbResult.getIsEffective()) {
			tbResult.setIsEffective(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
		}
		tbManpowerTrainSurveyResultMapper.insertSelective(tbResult);

		List<InvestigateQuestion> answerInfoList = resultAnswerAdd.getAnswerInfoList();
		for (InvestigateQuestion answer : answerInfoList) {
			TbManpowerTrainAnswerInfo tbAnswerInfo = new TbManpowerTrainAnswerInfo();

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
			if (!StringUtils.isBlank(tbAnswerInfo.getOptionAnswer())) {
				tbAnswerInfo.setOptionAnswer(tbAnswerInfo.getOptionAnswer().toUpperCase());
			}
			tbManpowerTrainAnswerInfoMapper.insertSelective(tbAnswerInfo);
		}

		logger.info("[调研分析] 答题成功,projectId:{},name:{}", resultAnswerAdd.getProjectId(), resultAnswerAdd.getName());

	}

	/**
	 * TODO 跟据项目id，查询项目详情
	 * 
	 * @param productId
	 * @return
	 */
	private TbManpowerTrainInvestiga selectQuestInvestigate(String projectId) {
		TbManpowerTrainInvestiga investigate = tbManpowerTrainInvestigaMapper.selectByPrimaryKey(projectId);
		if (investigate == null
				|| StringUtils.equals(HrStatusEnums.DELETED.getCode(), investigate.getRecordStatus().toString())) {
			logger.warn("[调研分析] 查询调研项目详情信息失败,当前调研项目不存在,projectId:{}", projectId);
			throw new JnSpringCloudException(TrainExceptionEnums.MANAGEMENT_NOT_EXIST, "当前调研项目不存在");
		}

		return investigate;
	}

	/**
	 * TODO 更新调研问题
	 * 
	 * @param questionUpd
	 *            问题实体
	 */
	private void updateQuestion(InvestigateQuestion questionUpd) {
		String titleId = questionUpd.getTitleId();
		TbManpowerTrainQuestionnaireQuese question = tbManpowerTrainQuestionnaireQueseMapper
				.selectByPrimaryKey(titleId);
		if (null == question) {
			logger.warn("当前调研问题不存在,projectId:{},titleID:{}", questionUpd.getProjectId(), questionUpd.getTitleId());
			throw new JnSpringCloudException(TrainExceptionEnums.QUESTION_NOT_EXIST, "当前调研问题不存在");
		}
		TbManpowerTrainQuestionnaireQuese tbQuestion = new TbManpowerTrainQuestionnaireQuese();
		BeanUtils.copyProperties(questionUpd, tbQuestion);
		tbManpowerTrainQuestionnaireQueseMapper.updateByPrimaryKeySelective(tbQuestion);
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
					TbManpowerTrainTitleOption tbOption = new TbManpowerTrainTitleOption();
					BeanUtils.copyProperties(titleOption, tbOption);
					if (StringUtils.isBlank(tbOption.getId())) {
						tbOption.setId(UUID.randomUUID().toString());
					}
					if (!StringUtils.isBlank(tbOption.getOptionId())) {
						tbOption.setOptionId(tbOption.getOptionId().toUpperCase());
					}
					tbManpowerTrainTitleOptionMapper.insertSelective(tbOption);
				} else {
					TbManpowerTrainTitleOption tbOption = new TbManpowerTrainTitleOption();
					BeanUtils.copyProperties(titleOption, tbOption);
					if (!StringUtils.isBlank(tbOption.getOptionId())) {
						tbOption.setOptionId(tbOption.getOptionId().toUpperCase());
					}
					tbManpowerTrainTitleOptionMapper.updateByPrimaryKeySelective(tbOption);
				}
			}
		}

		List<InvestigateTitleOption> deltitleOptionList = questionUpd.getDeltitleOptionList();
		if (null != deltitleOptionList && deltitleOptionList.size() > 0) {
			for (InvestigateTitleOption deltitleOption : deltitleOptionList) {
				tbManpowerTrainTitleOptionMapper.deleteByPrimaryKey(deltitleOption.getId());
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
		List<TbManpowerTrainQuestionnaireQuese> tbQuestionList = questionMapper.list(projectId);
		for (TbManpowerTrainQuestionnaireQuese tbQuestion : tbQuestionList) {
			// 填充返回的题目名称/类型
			InvestigateQuestionAdd question = new InvestigateQuestionAdd();
			BeanUtils.copyProperties(tbQuestion, question);

			// 填充题目对应的选项
			List<InvestigateTitleOptionAdd> titleOptionList = new ArrayList<InvestigateTitleOptionAdd>();
			List<TbManpowerTrainTitleOption> tbTitleOptionList = titleOptionMapper.list(tbQuestion.getTitleId());
			for (TbManpowerTrainTitleOption tbTitleOption : tbTitleOptionList) {
				InvestigateTitleOptionAdd titleOption = new InvestigateTitleOptionAdd();
				BeanUtils.copyProperties(tbTitleOption, titleOption);
				titleOptionList.add(titleOption);
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
		List<TbManpowerTrainQuestionnaireQuese> tbQuestionList = questionMapper.list(projectId);
		for (TbManpowerTrainQuestionnaireQuese tbQuestion : tbQuestionList) {

			AnswerVo questionAnswer = new AnswerVo();
			// 题目信息
			BeanUtils.copyProperties(tbQuestion, questionAnswer);
			// 查询题目所有选项
			List<TbManpowerTrainTitleOption> tbTitleOptionList = titleOptionMapper.list(tbQuestion.getTitleId());

			List<InvestigateTitleOptionAdd> titleOptionList = BeanCopyUtil.copyList(tbTitleOptionList,
					InvestigateTitleOptionAdd.class);
			questionAnswer.setTitleOptionList(titleOptionList);

			// 查询所有答案
			List<TbManpowerTrainAnswerInfo> tbAnswerInfos = answerInfoMapper.list(tbQuestion.getTitleId());
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
					for (TbManpowerTrainAnswerInfo tbAnswerInfo : tbAnswerInfos) {
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
		List<TbManpowerTrainQuestionnaireQuese> tbQuestionList = questionMapper.list(projectId);
		for (TbManpowerTrainQuestionnaireQuese tbQuestion : tbQuestionList) {
			// 查询题目所有选项
			List<TbManpowerTrainTitleOption> tbTitleOptionList = titleOptionMapper.list(tbQuestion.getTitleId());
			List<InvestigateTitleOptionAdd> titleOptionList = new ArrayList<InvestigateTitleOptionAdd>();
			for (TbManpowerTrainTitleOption tbTitleOption : tbTitleOptionList) {
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
		List<TbManpowerTrainAnswerInfo> userAnswerList = answerInfoMapper.listById(surveyResult);
		for (AnswerVo question : questionAnswers) {
			for (TbManpowerTrainAnswerInfo userAnswer : userAnswerList) {
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

}
