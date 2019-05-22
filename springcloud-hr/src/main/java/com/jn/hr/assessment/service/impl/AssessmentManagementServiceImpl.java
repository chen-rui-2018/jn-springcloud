package com.jn.hr.assessment.service.impl;

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
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.Assert;
import com.jn.hr.assessment.dao.AssessManageMapper;
import com.jn.hr.assessment.dao.AssessmentInfoFillMapper;
import com.jn.hr.assessment.dao.AssessmentSubsidiaryMapper;
import com.jn.hr.assessment.dao.AssessmentTemplateDetailMapper;
import com.jn.hr.assessment.dao.AssessmentTemplateMapper;
import com.jn.hr.assessment.dao.TbManpowerAssessmentInfoFillMapper;
import com.jn.hr.assessment.dao.TbManpowerAssessmentManageMapper;
import com.jn.hr.assessment.dao.TbManpowerAssessmentTemplateMapper;
import com.jn.hr.assessment.entity.TbManpowerAssessmentInfoFill;
import com.jn.hr.assessment.entity.TbManpowerAssessmentManage;
import com.jn.hr.assessment.entity.TbManpowerAssessmentSubsidiary;
import com.jn.hr.assessment.entity.TbManpowerAssessmentTemplate;
import com.jn.hr.assessment.enums.AssessmentManageStatusEnums;
import com.jn.hr.assessment.model.AssessmentManageAdd;
import com.jn.hr.assessment.model.AssessmentManagePage;
import com.jn.hr.assessment.model.AssessmentManageVo;
import com.jn.hr.assessment.model.AssessmentSubsidiaryAdd;
import com.jn.hr.assessment.model.AssessmentSubsidiaryVo;
import com.jn.hr.assessment.model.AssessmentTemplateDetailAdd;
import com.jn.hr.assessment.model.AssessmentTemplateDetailVo;
import com.jn.hr.assessment.model.AssessmentTemplatePage;
import com.jn.hr.assessment.model.AssessmentTemplateVo;
import com.jn.hr.assessment.model.DepartmentTree;
import com.jn.hr.assessment.service.AssessmentManagementService;
import com.jn.hr.attendance.enums.attendanceManageStatusEnums;
import com.jn.hr.common.enums.HrStatusEnums;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.TbManpowerDepartmentMapper;
import com.jn.hr.employee.entity.TbManpowerDepartment;
import com.jn.hr.employee.entity.TbManpowerDepartmentCriteria;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

@Service
public class AssessmentManagementServiceImpl implements AssessmentManagementService {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentManagementServiceImpl.class);
	@Autowired
	AssessManageMapper assessManageMapper;
	@Autowired
	AssessmentSubsidiaryMapper assessmentSubsidiaryMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	AssessmentTemplateDetailMapper assessmentTemplateDetailMapper;
	@Autowired
	TbManpowerAssessmentInfoFillMapper tbManpowerAssessmentInfoFillMapper;
	@Autowired
	AssessmentInfoFillMapper assessmentInfoFillMapper;
	@Autowired
	TbManpowerAssessmentManageMapper tbManpowerAssessmentManageMapper;
	@Autowired
	AssessmentTemplateMapper assessmentTemplateMapper;
	@Autowired
	TbManpowerAssessmentTemplateMapper tbManpowerAssessmentTemplateMapper;
	@Autowired
	TbManpowerDepartmentMapper tbManpowerDepartmentMapper;
	
	@Override
	@ServiceLog(doAction = "考核管理页面查询")
	public PaginationData<List<AssessmentManageVo>> inquireAssessManagePage(AssessmentManagePage assessmentManagePage) {
		Page<Object> objects = PageHelper.startPage(assessmentManagePage.getPage(),assessmentManagePage.getRows());
		//List<AssessmentManageVo> assessList = assessManageMapper.list(assessmentManagePage);
		List<AssessmentManageVo> assessmentNameList = assessManageMapper.selectGroupByAssessmentName(assessmentManagePage);
		for(AssessmentManageVo assessName : assessmentNameList){
			List<AssessmentManageVo> assessList = assessManageMapper.selectByAssessmentName(assessName.getAssessmentId());
			StringBuffer str = new StringBuffer();
			StringBuffer strNumber = new StringBuffer();
			for(AssessmentManageVo manage : assessList){
				str.append(manage.getAssessmentObject()).append(",");
				strNumber.append(manage.getAssessmentJobNumber()).append(",");
			}
			assessName.setAssessmentObject(str.toString());
			assessName.setAssessmentObjectJobNumber(strNumber.toString());
			Integer number = assessManageMapper.selectCountNumber(assessName.getAssessmentId());
			
			assessName.setArchiveNumber(number);
		}
		
		PaginationData<List<AssessmentManageVo>> pageList = new PaginationData(assessmentNameList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "发起考核")
	public void initiateAssess(AssessmentManageAdd assessmentManageAdd, User user) {
		List<AssessmentManageAdd> assessList = new ArrayList<AssessmentManageAdd>();
		List<AssessmentSubsidiaryAdd> subsidiaryList = new ArrayList<AssessmentSubsidiaryAdd>();
		String[] str = assessmentManageAdd.getAssessmentObjectJobNumber().split(",");
		TbManpowerEmployeeBasicInfo info = employeeBasicInfoMapper.selectByJobNumber(assessmentManageAdd.getAssessmentJobNumber());
		TbManpowerAssessmentTemplate template = tbManpowerAssessmentTemplateMapper.selectByPrimaryKey(assessmentManageAdd.getTemplateId());
		String assessmentId = UUID.randomUUID().toString();
		for(String str1 : str){
			TbManpowerEmployeeBasicInfo basicInfo = employeeBasicInfoMapper.selectByJobNumber(str1);
			AssessmentManageAdd assess = new AssessmentManageAdd();
			AssessmentSubsidiaryAdd subsidiary = new AssessmentSubsidiaryAdd();
			subsidiary.setAssessmentName(assessmentManageAdd.getAssessmentName());
			subsidiary.setId(UUID.randomUUID().toString());
			subsidiary.setAssessmentId(assessmentId);
			subsidiary.setTemplateId(assessmentManageAdd.getTemplateId());
			subsidiary.setName(basicInfo.getName());
			subsidiary.setAssessmentStatus(Byte.parseByte(AssessmentManageStatusEnums.NOT_BEGIN.getCode()));
			subsidiary.setAssessmentJobNumber(str1);
			subsidiary.setAssessmentDepartment(basicInfo.getDepartmentName());
			subsidiaryList.add(subsidiary);
			
			BeanUtils.copyProperties(assessmentManageAdd,assess);
			assess.setId(UUID.randomUUID().toString());
			assess.setAssessmentId(assessmentId);
			assess.setStatus(Byte.parseByte(AssessmentManageStatusEnums.NOT_ASSESSMENT.getCode()));
			assess.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
			assess.setCreatedTime(new Date());
			assess.setCreatorAccount(user.getAccount());
			assess.setModifiedTime(new Date());
			assess.setModifierAccount(user.getAccount());
			assess.setAssessmentObject(basicInfo.getName());
			assess.setAssessmentPeople(info.getName());
			assess.setTemplateName(template.getTemplateName());
			assess.setAssessmentJobNumber(str1);
			//assess.setAssessmentObjectJobNumber(str1);
			assessList.add(assess);	
			logger.info("[发起考核]发起考核成功！考核id:"+assess.getId());
		}
		assessmentSubsidiaryMapper.insertBatch(subsidiaryList);
		assessManageMapper.insertBatch(assessList);
		
        
	}

	@Override
	@ServiceLog(doAction = "考核延期")
	public void assessmentExtension(AssessmentManageAdd assessmentManageAdd, User user) {
		// TODO Auto-generated method stub
		Assert.notNull(assessmentManageAdd.getAssessmentId(),"AssessmentId不能为空");
		List<AssessmentManageVo> assessList =  assessManageMapper.selectByAssessmentName(assessmentManageAdd.getAssessmentId());
		//List<AssessmentManageVo> assessList = new ArrayList<>();
		if(assessList == null || assessList.size() == 0){
			logger.info("[考核管理]该考核项目不存在，不能延期,考核名称：",assessmentManageAdd.getAssessmentName());
			return;
		}
			
		assessmentManageAdd.setModifiedTime(new Date());
		assessmentManageAdd.setModifierAccount(user.getAccount());
		assessManageMapper.updateBatch(assessmentManageAdd);
		//assessManageMapper.updateBatch(assessList);
		logger.info("[考核管理]该考核项目延期成功!");
	}

	@Override
	@ServiceLog(doAction = "删除考核记录")
	public void deleteAssessmentRecord(AssessmentManagePage assessmentManagePage) {
		// TODO Auto-generated method stub
		assessManageMapper.updateByAssessmentName(assessmentManagePage.getAssessmentId());
	}

	@Override
	@ServiceLog(doAction = "导出考核信息")
	public PaginationData<List<AssessmentManageVo>> exportAssessment(AssessmentManagePage assessmentManagePage) {
		Page<Object> objects = PageHelper.startPage(assessmentManagePage.getPage(),assessmentManagePage.getRows());
		List<AssessmentManageVo> assessList =  assessManageMapper.selectByAssessmentName(assessmentManagePage.getAssessmentName());
		//List<AssessmentManageVo> assessList = new ArrayList<>();
		TbManpowerEmployeeBasicInfo employeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		Map<String,TbManpowerEmployeeBasicInfo> basicMap = employeeBasicInfoMapper.map(employeeBasicInfo);
		//Map<String,TbManpowerEmployeeBasicInfo> basicMap = new HashMap<>();
		TbManpowerAssessmentSubsidiary assessmentSubsidiaryVo = new TbManpowerAssessmentSubsidiary();
		Map<String,AssessmentSubsidiaryVo> subsidiaryMap = assessmentSubsidiaryMapper.map(assessmentSubsidiaryVo);
		//Map<String,AssessmentSubsidiaryVo> subsidiaryMap = new HashMap<>();
		
		for(AssessmentManageVo assess:assessList){
			TbManpowerEmployeeBasicInfo basicInfo = new TbManpowerEmployeeBasicInfo();
			AssessmentSubsidiaryVo subsidiary = new AssessmentSubsidiaryVo();
			basicInfo = basicMap.get(assess.getAssessmentJobNumber());
			subsidiary = subsidiaryMap.get(assess.getAssessmentJobNumber());
			assess.setName(basicInfo.getName());
			assess.setStatus(subsidiary.getAssessmentStatus());
			assess.setDepartmentName(basicInfo.getDepartmentName());	
		}
		
		PaginationData<List<AssessmentManageVo>> pageList = new PaginationData(assessList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "查看页面信息")
	public PaginationData<List<AssessmentManageVo>> viewPageInfo(AssessmentManagePage assessmentManagePage) {
		Page<Object> objects = PageHelper.startPage(assessmentManagePage.getPage(),assessmentManagePage.getRows());
		List<AssessmentManageVo> assessList =  assessManageMapper.selectByAssessmentName(assessmentManagePage.getAssessmentId());
		//List<AssessmentManageVo> assessList = new ArrayList<>();
		TbManpowerEmployeeBasicInfo employeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		Map<String,TbManpowerEmployeeBasicInfo> basicMap = employeeBasicInfoMapper.map(employeeBasicInfo);
		//Map<String,TbManpowerEmployeeBasicInfo> basicMap = new HashMap<>();
		TbManpowerAssessmentSubsidiary assessmentSubsidiaryVo = new TbManpowerAssessmentSubsidiary();
		Map<String,AssessmentSubsidiaryVo> subsidiaryMap = assessmentSubsidiaryMapper.map(assessmentSubsidiaryVo);
		//Map<String,AssessmentSubsidiaryVo> subsidiaryMap = new HashMap<>();
		
		for(AssessmentManageVo assess:assessList){
			TbManpowerEmployeeBasicInfo basicInfo = new TbManpowerEmployeeBasicInfo();
			AssessmentSubsidiaryVo subsidiary = new AssessmentSubsidiaryVo();
			basicInfo = basicMap.get(assess.getAssessmentJobNumber());
			if(basicInfo == null){
				continue;
			}
			subsidiary = subsidiaryMap.get(assess.getAssessmentJobNumber());
			assess.setName(basicInfo.getName());
			//assess.setStatus(subsidiary.getAssessmentStatus());
			assess.setDepartmentName(basicInfo.getDepartmentName());
			assess.setAssessmentObjectJobNumber(assess.getAssessmentJobNumber());
		}
		
		PaginationData<List<AssessmentManageVo>> pageList = new PaginationData(assessList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "开始考核-保存")
	public void saveStartAssessmentPage(AssessmentManageAdd assessmentManageAdd) {
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentManageAdd.getTemplateDetailList();
		for(AssessmentTemplateDetailVo templateDetail : templateDetailList){
			TbManpowerAssessmentInfoFill assessmentInfoFill = assessmentInfoFillMapper.selectByJobNumber(assessmentManageAdd.getAssessmentObjectJobNumber(),templateDetail.getId(),templateDetail.getTemplateId());
			if(assessmentInfoFill == null){
				TbManpowerAssessmentInfoFill record = new TbManpowerAssessmentInfoFill();
				record.setJobNumber(assessmentManageAdd.getAssessmentObjectJobNumber());
				record.setAssessmentScore(templateDetail.getAssessmentScore());
				record.setCauseDeduction(templateDetail.getCauseDeduction());
				record.setTemplateDetailId(templateDetail.getId());
				record.setTemplateId(templateDetail.getTemplateId());
				record.setId(UUID.randomUUID().toString());
				tbManpowerAssessmentInfoFillMapper.insert(record);
				logger.info("[评估信息]评估信息不存在，添加成功！jobNumber[]",record.getJobNumber());
			}else{
				assessmentInfoFill.setAssessmentScore(templateDetail.getAssessmentScore());
				assessmentInfoFill.setCauseDeduction(templateDetail.getCauseDeduction());
				tbManpowerAssessmentInfoFillMapper.updateByPrimaryKey(assessmentInfoFill);
				logger.info("[评估信息]评估信息更新成功！jobNumber[]",assessmentInfoFill.getJobNumber());
			}
			
		}
		//更改考核状态为待归档
		assessmentSubsidiaryMapper.updateByStatus(assessmentManageAdd.getAssessmentJobNumber(),assessmentManageAdd.getAssessmentId());
	}

	@Override
	@ServiceLog(doAction = "归档生效")
	public String updateAssessment(AssessmentManageAdd assessmentManageAdd) {
		// TODO Auto-generated method stub
		//根据模板Id  查询模板明细表
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentManageAdd.getTemplateId());
		for(AssessmentTemplateDetailVo templateDetail : templateDetailList){
			TbManpowerAssessmentInfoFill assessmentInfoFill = assessmentInfoFillMapper.selectByJobNumber(assessmentManageAdd.getAssessmentObjectJobNumber(),templateDetail.getId(),templateDetail.getTemplateId());
			if(assessmentInfoFill == null){
				return "还有考核项未结束";
			}
		}

		assessmentSubsidiaryMapper.updateByAssessmentStatus(assessmentManageAdd.getAssessmentObjectJobNumber(),assessmentManageAdd.getAssessmentId());
		logger.info("[考核管理]考核项目归档成功！");
		return "归档成功";
	}

	@Override
	@ServiceLog(doAction = "结束并归档")
	public String finishAndArchive(AssessmentManageAdd assessmentManageAdd) {
		int number = assessmentSubsidiaryMapper.selectByAssessmentId(assessmentManageAdd.getAssessmentId());
		if(number == 0){
			AssessmentManagePage assessmentManagePage = new AssessmentManagePage();
			assessmentManagePage.setAssessmentObjectJobNumber(assessmentManageAdd.getAssessmentObjectJobNumber());
			assessmentManagePage.setAssessmentId(assessmentManageAdd.getAssessmentId());
			assessManageMapper.updateByStatus(assessmentManagePage);
		}
		
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentManageAdd.getTemplateId());
		for(AssessmentTemplateDetailVo templateDetail : templateDetailList){
			TbManpowerAssessmentInfoFill assessmentInfoFill = assessmentInfoFillMapper.selectByJobNumber(assessmentManageAdd.getAssessmentObjectJobNumber(),templateDetail.getId(),templateDetail.getTemplateId());
			if(assessmentInfoFill == null){
				return "还有考核项未结束";
			}
		}
		assessmentSubsidiaryMapper.updateByAssessmentStatus(assessmentManageAdd.getAssessmentObjectJobNumber(),assessmentManageAdd.getAssessmentId());
				
		return "归档成功";
	}
	@Override
	@ServiceLog(doAction = "删除被考核人记录")
	public void deleteAppraisedPersonRecord(AssessmentManagePage assessmentManagePage) {
		assessManageMapper.updateByRecordStatus(assessmentManagePage);
		//查询记录是否存在
		//assessmentSubsidiaryMapper.deleteByJobNumber(assessmentManagePage.getAssessmentObjectJobNumber());
		logger.info("[考核记录]删除考核记录成功");
	}


	@Override
	@ServiceLog(doAction = "开始考核详细页面显示")
	public List<AssessmentTemplateDetailVo> viewAssessmentDetails(AssessmentManageAdd assessmentManageAdd) {
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentManageAdd.getTemplateId());
		Map<String,TbManpowerAssessmentInfoFill> fillMap = assessmentInfoFillMapper.selectByTemplateDetailId(assessmentManageAdd.getAssessmentObjectJobNumber(),assessmentManageAdd.getTemplateId());
		for(AssessmentTemplateDetailVo detailVo : templateDetailList){
			TbManpowerAssessmentInfoFill fill = fillMap.get(detailVo.getId());
			detailVo.setAssessmentScore(fill.getAssessmentScore());
			detailVo.setCauseDeduction(fill.getCauseDeduction());
		}
		logger.info("[考核详情]详情页面查询成功！");
		return templateDetailList;
	}

	@Override
	@ServiceLog(doAction = "开始考核页面明细")
	public List<AssessmentTemplateDetailVo> startAssessmentPageDetails(AssessmentManageAdd assessmentManageAdd) {
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentManageAdd.getTemplateId());
		logger.info("[开始考核]考核明细查询成功！");
		return templateDetailList;
	}
	
	@Override
	@ServiceLog(doAction = "考核模板页面显示")
	public PaginationData<List<AssessmentTemplateVo>> assessmentTemplatePaginationDisplay(AssessmentTemplatePage assessmentTemplatePage) {
		Page<Object> objects = PageHelper.startPage(assessmentTemplatePage.getPage(),assessmentTemplatePage.getRows());
		List<AssessmentTemplateVo> templateList = assessmentTemplateMapper.list(assessmentTemplatePage);
		PaginationData<List<AssessmentTemplateVo>> pageList = new PaginationData(templateList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "添加模板页面")
	public String addAssessmentTemplate(AssessmentTemplatePage assessmentTemplatePage) {
		// TODO Auto-generated method stub
		TbManpowerAssessmentTemplate tbManpowerAssessmentTemplate = new TbManpowerAssessmentTemplate();
		tbManpowerAssessmentTemplate.setTemplateId(UUID.randomUUID().toString());
		tbManpowerAssessmentTemplate.setTemplateName(assessmentTemplatePage.getTemplateName());
		tbManpowerAssessmentTemplate.setRecordStatus(Byte.parseByte(attendanceManageStatusEnums.SIGN_NORMAL.getCode()));
		tbManpowerAssessmentTemplateMapper.insert(tbManpowerAssessmentTemplate);
		logger.info("[考核模板]新增模板成功！");
		List<AssessmentTemplateDetailAdd> recordList = assessmentTemplatePage.getRecordList();
		for(AssessmentTemplateDetailAdd assessmentTemplateDetailAdd : recordList){
			assessmentTemplateDetailAdd.setTemplateId(tbManpowerAssessmentTemplate.getTemplateId());
			assessmentTemplateDetailAdd.setId(UUID.randomUUID().toString());
		}
		assessmentTemplateDetailMapper.insertBatch(recordList);
		logger.info("[考核模板明细]考核模板添加成功！");
		return "";
	}

	@Override
	@ServiceLog(doAction = "获取部门树")
	public List<DepartmentTree> ObtainDepartmentTree(EmployeeBasicInfoPage employeeBasicInfoPage) {		
		TbManpowerDepartmentCriteria tbManpowerDepartmentCriteria = new TbManpowerDepartmentCriteria();
		List<TbManpowerDepartment> departmentList = tbManpowerDepartmentMapper.selectByExample(tbManpowerDepartmentCriteria);
		
		List<DepartmentTree> parentList = new ArrayList<DepartmentTree>();
		for(TbManpowerDepartment department : departmentList){
			List<DepartmentTree> childrenList = new ArrayList<DepartmentTree>();
			List<TbManpowerEmployeeBasicInfo> basicInfoList = employeeBasicInfoMapper.selectByDepartment(department.getDepartmentId());
			for(TbManpowerEmployeeBasicInfo basicInfo : basicInfoList){
				DepartmentTree children = new DepartmentTree();
				children.setValue(basicInfo.getJobNumber());
				children.setLabel(basicInfo.getName());
				children.setParent("1");
				childrenList.add(children);
			}
			DepartmentTree departmentTree = new DepartmentTree();
			departmentTree.setValue(department.getDepartmentId());
			departmentTree.setLabel(department.getDepartmentName());
			departmentTree.setParent("-1");
			departmentTree.setChildren(childrenList);
			parentList.add(departmentTree);
		}
		logger.info("[考核列表] 获取各部门成员成功");
		
		return parentList;
	}

	@Override
	@ServiceLog(doAction = "删除考核模板")
	public void deleteAssessmentTemplate(AssessmentTemplatePage assessmentTemplatePage) {
		// TODO Auto-generated method stub
		assessmentTemplateMapper.updateByTemplateId(assessmentTemplatePage);
		logger.info("删除模板成功");
	}

	@Override
	@ServiceLog(doAction = "考核模板详情")
	public AssessmentTemplateVo assessmentTemplateDetails(
			AssessmentTemplatePage assessmentTemplatePage) {
		// TODO Auto-generated method stub
		AssessmentTemplateVo assessmentTemplateVo = new AssessmentTemplateVo();
		TbManpowerAssessmentTemplate tbManpowerAssessmentTemplate = tbManpowerAssessmentTemplateMapper.selectByPrimaryKey(assessmentTemplatePage.getTemplateId());
		assessmentTemplateVo.setTemplateId(tbManpowerAssessmentTemplate.getTemplateId());
		assessmentTemplateVo.setTemplateName(tbManpowerAssessmentTemplate.getTemplateName());
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentTemplatePage.getTemplateId());
		assessmentTemplateVo.setRecordList(templateDetailList);
		return assessmentTemplateVo;
	}

}
