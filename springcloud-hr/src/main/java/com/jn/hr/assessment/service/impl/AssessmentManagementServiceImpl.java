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
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.hr.assessment.dao.AssessManageMapper;
import com.jn.hr.assessment.dao.AssessmentInfoFillMapper;
import com.jn.hr.assessment.dao.AssessmentSubsidiaryMapper;
import com.jn.hr.assessment.dao.AssessmentTemplateDetailMapper;
import com.jn.hr.assessment.dao.AssessmentTemplateMapper;
import com.jn.hr.assessment.dao.TbManpowerAssessmentInfoFillMapper;
import com.jn.hr.assessment.dao.TbManpowerAssessmentManageMapper;
import com.jn.hr.assessment.dao.TbManpowerAssessmentTemplateMapper;
import com.jn.hr.assessment.entity.TbManpowerAssessmentInfoFill;
import com.jn.hr.assessment.entity.TbManpowerAssessmentSubsidiary;
import com.jn.hr.assessment.entity.TbManpowerAssessmentTemplate;
import com.jn.hr.assessment.enums.AssessmentManageExceptionEnums;
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
import com.jn.hr.attendance.enums.AttendanceManageStatusEnums;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.common.enums.HrStatusEnums;
import com.jn.hr.common.util.DepartMentUtil;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.TbManpowerDepartmentMapper;
import com.jn.hr.employee.entity.TbManpowerDepartment;
import com.jn.hr.employee.entity.TbManpowerDepartmentCriteria;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

@Service
public class AssessmentManagementServiceImpl implements AssessmentManagementService {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentManagementServiceImpl.class);
	@Autowired
	SystemClient systemClient;
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
	@ServiceLog(doAction = "????????????????????????")
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
			Integer number = assessmentSubsidiaryMapper.selectByAssessmentId(assessName.getAssessmentId());
			assessName.setArchiveNumber(number);
		}
		
		PaginationData<List<AssessmentManageVo>> pageList = new PaginationData(assessmentNameList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "????????????")
	@Transactional(rollbackFor = Exception.class)
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
			assess.setStatus(Byte.parseByte(AssessmentManageStatusEnums.ASSESSMENT_ING.getCode()));
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
			logger.info("[????????????]???????????????????????????id:"+assess.getId());
		}
		assessmentSubsidiaryMapper.insertBatch(subsidiaryList);
		assessManageMapper.insertBatch(assessList);
		
        
	}

	@Override
	@ServiceLog(doAction = "????????????")
	@Transactional(rollbackFor = Exception.class)
	public String assessmentExtension(AssessmentManageAdd assessmentManageAdd, User user) {
		List<AssessmentManageVo> assessList =  assessManageMapper.selectByAssessmentName(assessmentManageAdd.getAssessmentId());
		if(assessList == null || assessList.size() == 0){
			logger.info("[????????????]???????????????????????????????????????,???????????????",assessmentManageAdd.getAssessmentName());
			throw new JnSpringCloudException(AssessmentManageExceptionEnums.ASSESSMENT_PROJECT);
		}
			
		assessmentManageAdd.setModifiedTime(new Date());
		assessmentManageAdd.setModifierAccount(user.getAccount());
		assessManageMapper.updateBatch(assessmentManageAdd);
		logger.info("[????????????]???????????????????????????!");
		return "????????????";
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String deleteAssessmentRecord(AssessmentManagePage assessmentManagePage) {
		// TODO Auto-generated method stub
		assessManageMapper.updateByAssessmentName(assessmentManagePage.getAssessmentId());
		return "????????????";
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	public PaginationData<List<AssessmentManageVo>> exportAssessment(AssessmentManagePage assessmentManagePage) {
		Page<Object> objects = PageHelper.startPage(assessmentManagePage.getPage(),assessmentManagePage.getRows());
		List<AssessmentManageVo> assessList =  assessManageMapper.selectByAssessmentName(assessmentManagePage.getAssessmentName());
		TbManpowerAssessmentSubsidiary assessmentSubsidiaryVo = new TbManpowerAssessmentSubsidiary();
		List<AssessmentSubsidiaryVo> subsidiaryList = assessmentSubsidiaryMapper.map(assessmentSubsidiaryVo);
		
		for(AssessmentManageVo assess:assessList){
			for(AssessmentSubsidiaryVo subsidiary : subsidiaryList){
				if(assess.getAssessmentJobNumber().equals(subsidiary.getAssessmentJobNumber()) && assess.getAssessmentName().equals(subsidiary.getAssessmentName())){
					assess.setName(subsidiary.getName());
					assess.setStatus(subsidiary.getAssessmentStatus());
					assess.setDepartmentName(subsidiary.getAssessmentDepartment());
					assess.setAssessmentObjectJobNumber(assess.getAssessmentJobNumber());
				}
				break;
			}
		}
		
		PaginationData<List<AssessmentManageVo>> pageList = new PaginationData(assessList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	public PaginationData<List<AssessmentManageVo>> viewPageInfo(AssessmentManagePage assessmentManagePage) {
		Page<Object> objects = PageHelper.startPage(assessmentManagePage.getPage(),assessmentManagePage.getRows());
		List<AssessmentManageVo> assessList =  assessManageMapper.selectByAssessmentName(assessmentManagePage.getAssessmentId());
		TbManpowerAssessmentSubsidiary assessmentSubsidiaryVo = new TbManpowerAssessmentSubsidiary();
		List<AssessmentSubsidiaryVo> subsidiaryList = assessmentSubsidiaryMapper.map(assessmentSubsidiaryVo);
		
		for(AssessmentManageVo assess:assessList){
			for(AssessmentSubsidiaryVo subsidiary : subsidiaryList){
				if(assess.getAssessmentJobNumber().equals(subsidiary.getAssessmentJobNumber()) && assess.getAssessmentName().equals(subsidiary.getAssessmentName())){
					assess.setName(subsidiary.getName());
					assess.setStatus(subsidiary.getAssessmentStatus());
					assess.setDepartmentName(subsidiary.getAssessmentDepartment());
					assess.setAssessmentObjectJobNumber(assess.getAssessmentJobNumber());
					break;
				}
			}	
		}
		
		PaginationData<List<AssessmentManageVo>> pageList = new PaginationData(assessList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "????????????-??????")
	@Transactional(rollbackFor = Exception.class)
	public String saveStartAssessmentPage(AssessmentManageAdd assessmentManageAdd) {
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
				logger.info("[????????????]???????????????????????????????????????jobNumber[]",record.getJobNumber());
			}else{
				assessmentInfoFill.setAssessmentScore(templateDetail.getAssessmentScore());
				assessmentInfoFill.setCauseDeduction(templateDetail.getCauseDeduction());
				tbManpowerAssessmentInfoFillMapper.updateByPrimaryKey(assessmentInfoFill);
				logger.info("[????????????]???????????????????????????jobNumber[]",assessmentInfoFill.getJobNumber());
			}
			
		}
		//??????????????????????????????
		assessmentSubsidiaryMapper.updateByStatus(assessmentManageAdd.getAssessmentJobNumber(),assessmentManageAdd.getAssessmentId());
		return "????????????";
	}

	@Override
	@ServiceLog(doAction = "????????????")
	@Transactional(rollbackFor = Exception.class)
	public String updateAssessment(AssessmentManageAdd assessmentManageAdd) {
		// TODO Auto-generated method stub
		//????????????Id  ?????????????????????
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentManageAdd.getTemplateId());
		for(AssessmentTemplateDetailVo templateDetail : templateDetailList){
			TbManpowerAssessmentInfoFill assessmentInfoFill = assessmentInfoFillMapper.selectByJobNumber(assessmentManageAdd.getAssessmentObjectJobNumber(),templateDetail.getId(),templateDetail.getTemplateId());
			if(assessmentInfoFill == null){
				logger.info("????????????????????????");
				throw new JnSpringCloudException(AssessmentManageExceptionEnums.ASSESSMENT_NOT_FINISHED);
			}
		}

		assessmentSubsidiaryMapper.updateByAssessmentStatus(assessmentManageAdd.getAssessmentObjectJobNumber(),assessmentManageAdd.getAssessmentId());
		logger.info("[????????????]???????????????????????????");
		return "????????????";
	}

	@Override
	@ServiceLog(doAction = "???????????????")
	@Transactional(rollbackFor = Exception.class)
	public String finishAndArchive(AssessmentManageAdd assessmentManageAdd) {
		
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentManageAdd.getTemplateId());
		for(AssessmentTemplateDetailVo templateDetail : templateDetailList){
			TbManpowerAssessmentInfoFill assessmentInfoFill = assessmentInfoFillMapper.selectByJobNumber(assessmentManageAdd.getAssessmentObjectJobNumber(),templateDetail.getId(),templateDetail.getTemplateId());
			if(assessmentInfoFill == null){
				logger.info("????????????????????????");
				throw new JnSpringCloudException(AssessmentManageExceptionEnums.ASSESSMENT_NOT_FINISHED);
			}
		}
		assessmentSubsidiaryMapper.updateByAssessmentStatus(assessmentManageAdd.getAssessmentObjectJobNumber(),assessmentManageAdd.getAssessmentId());
				
		return "????????????";
	}
	
	@Override
	@ServiceLog(doAction = "????????????")
	@Transactional(rollbackFor = Exception.class)
	public String assessmentEnd(AssessmentManageAdd assessmentManageAdd) {
		assessmentSubsidiaryMapper.updateByAssessmentStatus(null,assessmentManageAdd.getAssessmentId());
		AssessmentManagePage assessmentManagePage = new AssessmentManagePage();
		assessmentManagePage.setAssessmentId(assessmentManageAdd.getAssessmentId());
		assessManageMapper.updateByStatus(assessmentManagePage);
		return "????????????";
	}
	
	@Override
	@ServiceLog(doAction = "????????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String deleteAppraisedPersonRecord(AssessmentManagePage assessmentManagePage) {
		assessManageMapper.updateByRecordStatus(assessmentManagePage);
		//????????????????????????
		assessmentSubsidiaryMapper.updateByAssessmentStatus(assessmentManagePage.getAssessmentObjectJobNumber(),assessmentManagePage.getAssessmentId());
		logger.info("[????????????]????????????????????????");
		return "????????????";
	}


	@Override
	@ServiceLog(doAction = "??????????????????????????????")
	public List<AssessmentTemplateDetailVo> viewAssessmentDetails(AssessmentManageAdd assessmentManageAdd) {
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentManageAdd.getTemplateId());
		Map<String,TbManpowerAssessmentInfoFill> fillMap = assessmentInfoFillMapper.selectByTemplateDetailId(assessmentManageAdd.getAssessmentObjectJobNumber(),assessmentManageAdd.getTemplateId());
		if(fillMap == null){
			fillMap = new HashMap<String,TbManpowerAssessmentInfoFill>();
		}
		for(AssessmentTemplateDetailVo detailVo : templateDetailList){
			TbManpowerAssessmentInfoFill fill = fillMap.get(detailVo.getId());
			if(fill != null){
				detailVo.setAssessmentScore(fill.getAssessmentScore());
				detailVo.setCauseDeduction(fill.getCauseDeduction());
			}
			Result result = systemClient.selectDeptByParentId(detailVo.getLeadAssessmentDepartment(), false);
			if(result==null || !"0000".equals(result.getCode()) || result.getData()==null){
	            throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
	        }
	        Map<String,String>  departMap= (HashMap<String, String>)result.getData();
	        detailVo.setLeadAssessmentDepartment(departMap.get("departmentName"));
		}
		logger.info("[????????????]???????????????????????????");
		return templateDetailList;
	}

	@Override
	@ServiceLog(doAction = "????????????????????????")
	public List<AssessmentTemplateDetailVo> startAssessmentPageDetails(AssessmentManageAdd assessmentManageAdd) {
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentManageAdd.getTemplateId());
		for(AssessmentTemplateDetailVo detail : templateDetailList){
			Result result = systemClient.selectDeptByParentId(detail.getLeadAssessmentDepartment(), false);
			if(result==null || !"0000".equals(result.getCode()) || result.getData()==null){
	            throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
	        }
	        Map<String,String>  departMap= (HashMap<String, String>)result.getData();
			detail.setLeadAssessmentDepartment(departMap.get("departmentName"));
		}
		logger.info("[????????????]???????????????????????????");
		return templateDetailList;
	}
	
	@Override
	@ServiceLog(doAction = "????????????????????????")
	public PaginationData<List<AssessmentTemplateVo>> assessmentTemplatePaginationDisplay(AssessmentTemplatePage assessmentTemplatePage) {
		Page<Object> objects = PageHelper.startPage(assessmentTemplatePage.getPage(),assessmentTemplatePage.getRows());
		List<AssessmentTemplateVo> templateList = assessmentTemplateMapper.list(assessmentTemplatePage);
		PaginationData<List<AssessmentTemplateVo>> pageList = new PaginationData(templateList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String addAssessmentTemplate(AssessmentTemplatePage assessmentTemplatePage) {
		// TODO Auto-generated method stub
		AssessmentTemplateVo assessmentTemplateVo = assessmentTemplateMapper.selectByTemplateName(assessmentTemplatePage);
		if(assessmentTemplateVo != null){
			logger.info("[????????????]?????????????????????");
			throw new JnSpringCloudException(AssessmentManageExceptionEnums.ASSESSMENT_TEMPLATE_EXIST);
		}
		
		TbManpowerAssessmentTemplate tbManpowerAssessmentTemplate = new TbManpowerAssessmentTemplate();
		tbManpowerAssessmentTemplate.setTemplateId(UUID.randomUUID().toString());
		tbManpowerAssessmentTemplate.setTemplateName(assessmentTemplatePage.getTemplateName());
		tbManpowerAssessmentTemplate.setRecordStatus(Byte.parseByte(AttendanceManageStatusEnums.SIGN_NORMAL.getCode()));
		tbManpowerAssessmentTemplateMapper.insert(tbManpowerAssessmentTemplate);
		logger.info("[????????????]?????????????????????");
		List<AssessmentTemplateDetailAdd> recordList = assessmentTemplatePage.getRecordList();
		for(AssessmentTemplateDetailAdd assessmentTemplateDetailAdd : recordList){
			assessmentTemplateDetailAdd.setTemplateId(tbManpowerAssessmentTemplate.getTemplateId());
			assessmentTemplateDetailAdd.setId(UUID.randomUUID().toString());
		}
		assessmentTemplateDetailMapper.insertBatch(recordList);
		logger.info("[??????????????????]???????????????????????????");
		return "??????????????????";
	}

	@Override
	@ServiceLog(doAction = "???????????????")
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
		logger.info("[????????????] ???????????????????????????");
		
		return parentList;
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String deleteAssessmentTemplate(AssessmentTemplatePage assessmentTemplatePage) {
		// TODO Auto-generated method stub
		assessmentTemplateMapper.updateByTemplateId(assessmentTemplatePage);
		logger.info("??????????????????");
		return "??????????????????";
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	public AssessmentTemplateVo assessmentTemplateDetails(
			AssessmentTemplatePage assessmentTemplatePage) {
		// TODO Auto-generated method stub
		AssessmentTemplateVo assessmentTemplateVo = new AssessmentTemplateVo();
		TbManpowerAssessmentTemplate tbManpowerAssessmentTemplate = tbManpowerAssessmentTemplateMapper.selectByPrimaryKey(assessmentTemplatePage.getTemplateId());
		assessmentTemplateVo.setTemplateId(tbManpowerAssessmentTemplate.getTemplateId());
		assessmentTemplateVo.setTemplateName(tbManpowerAssessmentTemplate.getTemplateName());
		List<AssessmentTemplateDetailVo> templateDetailList = assessmentTemplateDetailMapper.selectByTemplateId(assessmentTemplatePage.getTemplateId());
		for(AssessmentTemplateDetailVo detail : templateDetailList){
			Result result = systemClient.selectDeptByParentId(detail.getLeadAssessmentDepartment(), false);
			if(result==null || !"0000".equals(result.getCode()) || result.getData()==null){
	            throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
	        }
	        Map<String,String>  departMap= (HashMap<String, String>)result.getData();
			detail.setLeadAssessmentDepartment(departMap.get("departmentName"));
		}
		assessmentTemplateVo.setRecordList(templateDetailList);
		return assessmentTemplateVo;
	}

}
