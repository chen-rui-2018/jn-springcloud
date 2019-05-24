package com.jn.hr.attendance.model;

import java.io.Serializable;

public class AttendanceKeyValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5919119516196607175L;

	private String timeKey;
	
	private String value;

	public String getTimeKey() {
		return timeKey;
	}

	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
