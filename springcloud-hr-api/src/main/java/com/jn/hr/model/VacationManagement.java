package com.jn.hr.model;

public class VacationManagement {

	private String id;

    private String userId;
    
    private String jobNumber;

    private String vacationType;

    private String vacationTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

	public String getVacationTime() {
		return vacationTime;
	}

	public void setVacationTime(String vacationTime) {
		this.vacationTime = vacationTime;
	}
    
}
