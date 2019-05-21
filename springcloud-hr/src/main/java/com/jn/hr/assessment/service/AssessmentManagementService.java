package com.jn.hr.assessment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jn.common.model.PaginationData;
import com.jn.hr.assessment.model.AssessmentManageAdd;
import com.jn.hr.assessment.model.AssessmentManagePage;
import com.jn.hr.assessment.model.AssessmentManageVo;
import com.jn.hr.assessment.model.AssessmentTemplateDetailAdd;
import com.jn.hr.assessment.model.AssessmentTemplateDetailVo;
import com.jn.hr.assessment.model.AssessmentTemplatePage;
import com.jn.hr.assessment.model.AssessmentTemplateVo;
import com.jn.hr.assessment.model.DepartmentTree;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.system.model.User;

@Service
public interface AssessmentManagementService {
	//考核管理页面查询
    public PaginationData<List<AssessmentManageVo>> inquireAssessManagePage(AssessmentManagePage assessmentManagePage);
    //发起考核
    public void initiateAssess(AssessmentManageAdd assessmentManageAdd,User user);
    //获取部门树
    public List<DepartmentTree> ObtainDepartmentTree(EmployeeBasicInfoPage employeeBasicInfoPage);
    //考核延期
    public void assessmentExtension(AssessmentManageAdd assessmentManageAdd,User user);
    //删除考核记录
    public void deleteAssessmentRecord(AssessmentManagePage assessmentManagePage);
    //导出
    public PaginationData<List<AssessmentManageVo>> exportAssessment(AssessmentManagePage assessmentManagePage);
    
    //查看页面的分页
    public PaginationData<List<AssessmentManageVo>> viewPageInfo(AssessmentManagePage assessmentManagePage);
    //开始考核-保存
    public void saveStartAssessmentPage(AssessmentManageAdd assessmentManageAdd);
    //开始考核-界面显示
    public List<AssessmentTemplateDetailVo> startAssessmentPageDetails(AssessmentManageAdd assessmentManageAdd);
    //归档生效
    public String updateAssessment(AssessmentManageAdd assessmentManageAdd);
    //删除被考核人记录
    public void deleteAppraisedPersonRecord(AssessmentManagePage assessmentManagePage);
    //开始考核详细页面显示
    public List<AssessmentTemplateDetailVo> viewAssessmentDetails(AssessmentManageAdd assessmentManageAdd);
    //结束归档
    public String finishAndArchive(AssessmentManageAdd assessmentManageAdd);
    
    //考核模板分页显示
    public PaginationData<List<AssessmentTemplateVo>> assessmentTemplatePaginationDisplay(AssessmentTemplatePage assessmentTemplatePage);
    //删除考核模板
    public void deleteAssessmentTemplate(AssessmentTemplatePage assessmentTemplatePage);
    //考核模板详情
    public AssessmentTemplateVo assessmentTemplateDetails(AssessmentTemplatePage assessmentTemplatePage);
    //新增模板
    public String addAssessmentTemplate(AssessmentTemplatePage assessmentTemplatePage);
}
