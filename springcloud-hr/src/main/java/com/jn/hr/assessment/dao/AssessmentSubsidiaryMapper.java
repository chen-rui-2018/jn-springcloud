package com.jn.hr.assessment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.jn.hr.assessment.entity.TbManpowerAssessmentSubsidiary;
import com.jn.hr.assessment.model.AssessmentSubsidiaryAdd;
import com.jn.hr.assessment.model.AssessmentSubsidiaryVo;

public interface AssessmentSubsidiaryMapper {

	@MapKey("assessmentJobNumber")
	Map<String,AssessmentSubsidiaryVo> map(TbManpowerAssessmentSubsidiary record);
	
	int selectNumber(@Param("assessmentName") String assessmentName);
	
	List<AssessmentSubsidiaryVo> list(@Param("assessmentName") String assessmentName);
	
	Integer selectByAssessmentId(@Param("assessmentId") String assessmentId);
	
	int deleteByJobNumber(@Param("assessmentJobNumber") String jobNumber);
	
	void insertBatch(List<AssessmentSubsidiaryAdd> records);
	
	void updateByAssessmentStatus(@Param("assessmentJobNumber") String assessmentJobNumber,@Param("assessmentId") String assessmentId);
	
	void updateByStatus(@Param("assessmentJobNumber") String assessmentJobNumber,@Param("assessmentId") String assessmentId);
	
}
