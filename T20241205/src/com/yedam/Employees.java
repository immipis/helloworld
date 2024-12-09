package com.yedam;

import java.text.SimpleDateFormat;

public class Employees {
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private int salay;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public int getSalay() {
		return salay;
	}
	public void setSalay(int salay) {
		this.salay = salay;
	}
	public String showInfo() {
		return " " + employeeId + "|" + employeeName + " " + employeeEmail+ " " + salay;
	}
}
