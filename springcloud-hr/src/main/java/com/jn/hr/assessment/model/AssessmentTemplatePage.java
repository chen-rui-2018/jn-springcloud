package com.jn.hr.assessment.model;

import java.io.Serializable;
import java.util.List;

import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssessmentTemplatePage", description = "考核模板分页实体")
public class AssessmentTemplatePage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7661869923657076766L;

	@ApiModelProperty(value = "模板ID")
	private String templateId;

	@ApiModelProperty(value = "模板名称")
    private String templateName;
	
	@ApiModelProperty(value = "考核模板明细对象")
	private List<AssessmentTemplateDetailAdd> recordList;

	
	public List<AssessmentTemplateDetailAdd> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<AssessmentTemplateDetailAdd> recordList) {
		this.recordList = recordList;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
    
}
