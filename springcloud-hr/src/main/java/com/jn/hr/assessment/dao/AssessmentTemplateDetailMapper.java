package com.jn.hr.assessment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.assessment.model.AssessmentTemplateDetailAdd;
import com.jn.hr.assessment.model.AssessmentTemplateDetailVo;

public interface AssessmentTemplateDetailMapper {

	List<AssessmentTemplateDetailVo> selectByTemplateId(@Param("templateId") String templateId);
	
	int insertBatch(List<AssessmentTemplateDetailAdd> recordList);
}
