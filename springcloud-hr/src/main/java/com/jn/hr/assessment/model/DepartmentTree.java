package com.jn.hr.assessment.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DepartmentTree", description = "部门树实体")
public class DepartmentTree implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8162738961710016899L;
	@ApiModelProperty(value = "部门ID/工号")
	private String value;
	@ApiModelProperty(value = "部门名称/姓名")
	private String label;
	@ApiModelProperty(value = "父节点")
	private String parent;
	@ApiModelProperty(value = "员工信息")
	private List<DepartmentTree> children;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public List<DepartmentTree> getChildren() {
		return children;
	}
	public void setChildren(List<DepartmentTree> children) {
		this.children = children;
	}
}
