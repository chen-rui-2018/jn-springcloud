package com.jn.hr.assessment.dao;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.jn.hr.assessment.entity.TbManpowerAssessmentInfoFill;

public interface AssessmentInfoFillMapper {

	TbManpowerAssessmentInfoFill selectByJobNumber(@Param("jobNumber") String jobNumber , @Param("templateDetailId") String templateDetailId,@Param("templateId") String templateId);
	@MapKey("templateDetailId")
	Map<String,TbManpowerAssessmentInfoFill> selectByTemplateDetailId(@Param("jobNumber") String jobNumber,@Param("templateId") String templateId);
	void updateByJobNumber(TbManpowerAssessmentInfoFill record);
}
