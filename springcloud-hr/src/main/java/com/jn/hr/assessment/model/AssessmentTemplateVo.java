package com.jn.hr.assessment.model;

import java.io.Serializable;
import java.util.List;

import com.alibaba.excel.metadata.BaseRowModel;

import io.swagger.annotations.ApiModelProperty;

public class AssessmentTemplateVo extends BaseRowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 967104402523863506L;

	@ApiModelProperty(value = "模板ID")
	private String templateId;

	@ApiModelProperty(value = "模板名称")
    private String templateName;
	
	@ApiModelProperty(value = "考核模板明细对象")
	private List<AssessmentTemplateDetailVo> recordList;


	public List<AssessmentTemplateDetailVo> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<AssessmentTemplateDetailVo> recordList) {
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
