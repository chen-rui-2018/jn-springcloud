package com.jn.hr.train.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 培训记录
 * @author： wangtt
 * @date：Created on  2019/04/28 02:57 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ManagementTrainRecord", description = "培训记录实体 ")
public class ManagementTrainRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5294186177477611678L;

	@ApiModelProperty(value = "培训记录编号", required = true, example = "\"Q1\"")
	private String id;

	@ApiModelProperty(value = "课程编号ID", required = true, example = "\"Q1\"")
	private String managementId;

	@ApiModelProperty(value = "培训人部门", required = true, example = "\"Q1\"")
	private String trainerDepartment;

	@ApiModelProperty(value = "培训人工号", required = true, example = "\"Q1\"")
	private String trainerJobNumber;

	@ApiModelProperty(value = "培训人姓名", required = true, example = "\"Q1\"")
	private String trainerName;

	public ManagementTrainRecord() {
		super();
	}

	public ManagementTrainRecord(String id, String managementId, String trainerDepartment, String trainerJobNumber,
			String trainerName) {
		super();
		this.id = id;
		this.managementId = managementId;
		this.trainerDepartment = trainerDepartment;
		this.trainerJobNumber = trainerJobNumber;
		this.trainerName = trainerName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getManagementId() {
		return managementId;
	}

	public void setManagementId(String managementId) {
		this.managementId = managementId;
	}

	public String getTrainerDepartment() {
		return trainerDepartment;
	}

	public void setTrainerDepartment(String trainerDepartment) {
		this.trainerDepartment = trainerDepartment;
	}

	public String getTrainerJobNumber() {
		return trainerJobNumber;
	}

	public void setTrainerJobNumber(String trainerJobNumber) {
		this.trainerJobNumber = trainerJobNumber;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public String toString() {
		return "ManagementTrainRecord {id='" + id + "', managementId='" + managementId + "', trainerDepartment='"
				+ trainerDepartment + "', trainerJobNumber='" + trainerJobNumber + "', trainerName='" + trainerName
				+ "'}";
	}

}
