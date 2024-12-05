package com.yedam.jdbc.student;

public class Student {
	private int engScore, mathScore; // employee_id => employeeId
	private String stdNo, stdName, stdPhone, creationDate;
	
	public Student() {

	}
	public Student(String no) {
		this.stdNo = no;
	}
	public Student(String no, String name, String phone) {
		this.stdNo = no;
		this.stdName = name;
		this.stdPhone = phone;
	}
	public Student(String no, int es, int ms) {
		this.stdNo = no;
		this.engScore = es;
		this.mathScore = ms;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String showInfo() {
		return " " + stdNo + " " + stdName + " " + stdPhone+ " " + engScore+ " " + mathScore;
	}
	
	public String showDetauill() {
		String result = "-----------------------------\n";
		result +="학생번호"+stdNo+"이름"+stdName+"\n";
		result +="휴대폰"+stdPhone+"\n";
		result +="영어"+engScore+"수학"+mathScore+"\n";
		result +="-----------------------------";
		return result;
	}

}
