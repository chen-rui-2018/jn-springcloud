package com.jn.hr.increase.model;

import java.io.Serializable;

public class SalaryKeyValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6075268263835441388L;
	private String name;
    private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
