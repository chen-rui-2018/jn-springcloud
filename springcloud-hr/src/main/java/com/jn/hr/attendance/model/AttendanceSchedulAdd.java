package com.jn.hr.attendance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AttendanceSchedulAdd", description = "排班管理添加实体")
public class AttendanceSchedulAdd extends BaseRowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4565314688284582290L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "排班月份")
	@ExcelProperty(value = "排班月份", index = 0)
    private String schedulMonth;

	@ApiModelProperty(value = "部门Id")
    private String departmentId;

	@ApiModelProperty(value = "部门")
	@ExcelProperty(value = "部门", index = 1)
    private String departmentName;

	@ApiModelProperty(value = "工号")
	@ExcelProperty(value = "工号", index = 2)
    private String jobNumber;

	@ApiModelProperty(value = "姓名")
	@ExcelProperty(value = "姓名", index = 3)
    private String name;

	@ApiModelProperty(value = "1号")
	@ExcelProperty(value = "1号", index = 4)
    private Integer number1;

	@ApiModelProperty(value = "2号")
	@ExcelProperty(value = "2号", index = 5)
    private Integer number2;

	@ApiModelProperty(value = "3号")
	@ExcelProperty(value = "3号", index = 6)
    private Integer number3;

	@ApiModelProperty(value = "4号")
	@ExcelProperty(value = "4号", index = 7)
    private Integer number4;

	@ApiModelProperty(value = "5号")
	@ExcelProperty(value = "5号", index = 8)
    private Integer number5;

	@ApiModelProperty(value = "6号")
	@ExcelProperty(value = "6号", index = 9)
    private Integer number6;

	@ApiModelProperty(value = "7号")
	@ExcelProperty(value = "7号", index = 10)
    private Integer number7;

	@ApiModelProperty(value = "8号")
	@ExcelProperty(value = "8号", index = 11)
    private Integer number8;

	@ApiModelProperty(value = "9号")
	@ExcelProperty(value = "9号", index = 12)
    private Integer number9;

	@ApiModelProperty(value = "10号")
	@ExcelProperty(value = "10号", index = 13)
    private Integer number10;

	@ApiModelProperty(value = "11号")
	@ExcelProperty(value = "11号", index = 14)
    private Integer number11;

	@ApiModelProperty(value = "12号")
	@ExcelProperty(value = "12号", index = 15)
    private Integer number12;

	@ApiModelProperty(value = "13号")
	@ExcelProperty(value = "13号", index = 16)
    private Integer number13;

	@ApiModelProperty(value = "14号")
	@ExcelProperty(value = "14号", index = 17)
    private Integer number14;

	@ApiModelProperty(value = "15号")
	@ExcelProperty(value = "15号", index = 18)
    private Integer number15;

	@ApiModelProperty(value = "16号")
	@ExcelProperty(value = "16号", index = 19)
    private Integer number16;

	@ApiModelProperty(value = "17号")
	@ExcelProperty(value = "17号", index = 20)
    private Integer number17;

	@ApiModelProperty(value = "18号")
	@ExcelProperty(value = "18号", index = 21)
    private Integer number18;

	@ApiModelProperty(value = "19号")
	@ExcelProperty(value = "19号", index = 22)
    private Integer number19;

	@ApiModelProperty(value = "20号")
	@ExcelProperty(value = "20号", index = 23)
    private Integer number20;

	@ApiModelProperty(value = "21号")
	@ExcelProperty(value = "21号", index = 24)
    private Integer number21;

	@ApiModelProperty(value = "22号")
	@ExcelProperty(value = "22号", index = 25)
    private Integer number22;

	@ApiModelProperty(value = "23号")
	@ExcelProperty(value = "23号", index = 26)
    private Integer number23;

	@ApiModelProperty(value = "24号")
	@ExcelProperty(value = "24号", index = 27)
    private Integer number24;

	@ApiModelProperty(value = "25号")
	@ExcelProperty(value = "25号", index = 28)
    private Integer number25;

	@ApiModelProperty(value = "26号")
	@ExcelProperty(value = "26号", index = 29)
    private Integer number26;

	@ApiModelProperty(value = "27号")
	@ExcelProperty(value = "27号", index = 30)
    private Integer number27;

	@ApiModelProperty(value = "28号")
	@ExcelProperty(value = "28号", index = 31)
    private Integer number28;

	@ApiModelProperty(value = "29号")
	@ExcelProperty(value = "29号", index = 32)
    private Integer number29;

	@ApiModelProperty(value = "30号")
	@ExcelProperty(value = "30号", index = 33)
    private Integer number30;

	@ApiModelProperty(value = "31号")
	@ExcelProperty(value = "31号", index = 34)
    private Integer number31;

	@ApiModelProperty(value = "status")
    private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

	@ApiModelProperty(value = "创建时间")
    private Date createdTime;

	@ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;

	@ApiModelProperty(value = "最新的更新时间")
    private Date modifiedTime;
	
	@ApiModelProperty(value = "排班明细")
	private List<AttendanceSchedulPage> attendanceSchedulList;

	public List<AttendanceSchedulPage> getAttendanceSchedulList() {
		return attendanceSchedulList;
	}

	public void setAttendanceSchedulList(List<AttendanceSchedulPage> attendanceSchedulList) {
		this.attendanceSchedulList = attendanceSchedulList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchedulMonth() {
		return schedulMonth;
	}

	public void setSchedulMonth(String schedulMonth) {
		this.schedulMonth = schedulMonth;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	public Integer getNumber3() {
		return number3;
	}

	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}

	public Integer getNumber4() {
		return number4;
	}

	public void setNumber4(Integer number4) {
		this.number4 = number4;
	}

	public Integer getNumber5() {
		return number5;
	}

	public void setNumber5(Integer number5) {
		this.number5 = number5;
	}

	public Integer getNumber6() {
		return number6;
	}

	public void setNumber6(Integer number6) {
		this.number6 = number6;
	}

	public Integer getNumber7() {
		return number7;
	}

	public void setNumber7(Integer number7) {
		this.number7 = number7;
	}

	public Integer getNumber8() {
		return number8;
	}

	public void setNumber8(Integer number8) {
		this.number8 = number8;
	}

	public Integer getNumber9() {
		return number9;
	}

	public void setNumber9(Integer number9) {
		this.number9 = number9;
	}

	public Integer getNumber10() {
		return number10;
	}

	public void setNumber10(Integer number10) {
		this.number10 = number10;
	}

	public Integer getNumber11() {
		return number11;
	}

	public void setNumber11(Integer number11) {
		this.number11 = number11;
	}

	public Integer getNumber12() {
		return number12;
	}

	public void setNumber12(Integer number12) {
		this.number12 = number12;
	}

	public Integer getNumber13() {
		return number13;
	}

	public void setNumber13(Integer number13) {
		this.number13 = number13;
	}

	public Integer getNumber14() {
		return number14;
	}

	public void setNumber14(Integer number14) {
		this.number14 = number14;
	}

	public Integer getNumber15() {
		return number15;
	}

	public void setNumber15(Integer number15) {
		this.number15 = number15;
	}

	public Integer getNumber16() {
		return number16;
	}

	public void setNumber16(Integer number16) {
		this.number16 = number16;
	}

	public Integer getNumber17() {
		return number17;
	}

	public void setNumber17(Integer number17) {
		this.number17 = number17;
	}

	public Integer getNumber18() {
		return number18;
	}

	public void setNumber18(Integer number18) {
		this.number18 = number18;
	}

	public Integer getNumber19() {
		return number19;
	}

	public void setNumber19(Integer number19) {
		this.number19 = number19;
	}

	public Integer getNumber20() {
		return number20;
	}

	public void setNumber20(Integer number20) {
		this.number20 = number20;
	}

	public Integer getNumber21() {
		return number21;
	}

	public void setNumber21(Integer number21) {
		this.number21 = number21;
	}

	public Integer getNumber22() {
		return number22;
	}

	public void setNumber22(Integer number22) {
		this.number22 = number22;
	}

	public Integer getNumber23() {
		return number23;
	}

	public void setNumber23(Integer number23) {
		this.number23 = number23;
	}

	public Integer getNumber24() {
		return number24;
	}

	public void setNumber24(Integer number24) {
		this.number24 = number24;
	}

	public Integer getNumber25() {
		return number25;
	}

	public void setNumber25(Integer number25) {
		this.number25 = number25;
	}

	public Integer getNumber26() {
		return number26;
	}

	public void setNumber26(Integer number26) {
		this.number26 = number26;
	}

	public Integer getNumber27() {
		return number27;
	}

	public void setNumber27(Integer number27) {
		this.number27 = number27;
	}

	public Integer getNumber28() {
		return number28;
	}

	public void setNumber28(Integer number28) {
		this.number28 = number28;
	}

	public Integer getNumber29() {
		return number29;
	}

	public void setNumber29(Integer number29) {
		this.number29 = number29;
	}

	public Integer getNumber30() {
		return number30;
	}

	public void setNumber30(Integer number30) {
		this.number30 = number30;
	}

	public Integer getNumber31() {
		return number31;
	}

	public void setNumber31(Integer number31) {
		this.number31 = number31;
	}

	public Byte getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Byte recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getCreatorAccount() {
		return creatorAccount;
	}

	public void setCreatorAccount(String creatorAccount) {
		this.creatorAccount = creatorAccount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifierAccount() {
		return modifierAccount;
	}

	public void setModifierAccount(String modifierAccount) {
		this.modifierAccount = modifierAccount;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
}
