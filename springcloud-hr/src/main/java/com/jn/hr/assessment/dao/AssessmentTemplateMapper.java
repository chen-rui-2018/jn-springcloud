package com.jn.hr.assessment.dao;

import java.util.List;

import com.jn.hr.assessment.model.AssessmentTemplatePage;
import com.jn.hr.assessment.model.AssessmentTemplateVo;

public interface AssessmentTemplateMapper {

	List<AssessmentTemplateVo> list(AssessmentTemplatePage assessmentTemplatePage);
	
	void updateByTemplateId(AssessmentTemplatePage assessmentTemplatePage);
}
