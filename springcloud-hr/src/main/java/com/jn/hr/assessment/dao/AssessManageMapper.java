package com.jn.hr.assessment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.assessment.model.AssessmentManageAdd;
import com.jn.hr.assessment.model.AssessmentManagePage;
import com.jn.hr.assessment.model.AssessmentManageVo;

public interface AssessManageMapper {

	List<AssessmentManageVo> list(AssessmentManagePage assessmentManagePage);
	List<AssessmentManageVo> selectGroupByAssessmentName(AssessmentManagePage assessmentManagePage);
	List<AssessmentManageVo> selectByAssessmentName(@Param("assessmentId") String assessmentId);
	Integer selectCountNumber(@Param("assessmentId") String assessmentId);
	void updateBatch(AssessmentManageAdd assessmentManageAdd);
	void updateByAssessmentName(@Param("assessmentId") String assessmentId);
	void insertBatch(List<AssessmentManageAdd> assessmentManageAdd);
	void updateByStatus(AssessmentManagePage assessmentManagePage);
	void updateByRecordStatus(AssessmentManagePage assessmentManagePage);
	List<AssessmentManageVo> selectByStatusAndRecordStatus(AssessmentManagePage assessmentManagePage);
}
