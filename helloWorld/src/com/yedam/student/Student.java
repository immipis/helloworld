package com.yedam.student;

// 학생 관리 프로그램
public class Student {
	public int studentCode; // 필드(속성)
	public String studentName;
	public int m_Score;
	public int e_Score;

	// 컴파일러가 기본 생성자를 만들어 준다.
	public Student() {}

	public Student(int studentCode) {
		this.studentCode = studentCode;
	}
	
	public Student(int studentCode, String studentName) {
		this.studentCode = studentCode;
		this.studentName = studentName;
	}
	public Student(int studentCode, String studentName ,int m_Score,int e_Score) {
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.m_Score = m_Score;
		this.e_Score = e_Score;
	}
	public void smile() {
		System.out.println("학생이 웃습니다");
	}

	public void introduce() {
		System.out.println("이름은" + studentName + "이고 학번은" + studentCode);
	}
	public int sumScore() {
		return m_Score+e_Score;
	}
	public double avgScore() {
		return (m_Score+e_Score)/2.0;
	}
	

	
}
