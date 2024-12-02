package com.yedam.methods;

// 학생 관리 프로그램
public class Student {
	private String studentCode; // 필드(속성)
	private String studentName;
	private int m_Score;
	private int e_Score;
	
	public Student() {
	}
	public Student(String studentCode, String studentName, int m_Score, int e_Score) {
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.m_Score = m_Score;
		this.e_Score = e_Score;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getM_Score() {
		return m_Score;
	}

	public void setM_Score(int m_Score) {
		this.m_Score = m_Score;
	}

	public int getE_Score() {
		return e_Score;
	}

	public void setE_Score(int e_Score) {
		this.e_Score = e_Score;
	}
	
	public String showInfo() {
		return "학번: " + studentCode + ", 이름: " +studentName + ", 영어점수: " + e_Score + ", 수학점수: " + m_Score;
	}

	// 생성자 최소 1개
	
}
