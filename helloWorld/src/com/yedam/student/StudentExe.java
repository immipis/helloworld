package com.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(20191855);// 인스턴스 생성
//		s1.studentCode = 20191855;
		s1.studentName = "조성민";
		s1.e_Score = 100;
		s1.m_Score = 95;
		System.out.println(s1.studentCode+"asd"+s1.sumScore()+"asd"+s1.avgScore());
		
		Student s2 = new Student(20191855,"조성민");// 인스턴스 생성
//		s2.studentCode = 20191855;
//		s2.studentName = "조성민";
		System.out.println(s2.studentCode + s2.studentName);
		
		Student s3 = new Student(20191855,"조성민",100,100);
		System.out.println(s3.studentCode + s3.studentName+
				s3.m_Score+ s3.e_Score);
		
		
		System.out.println(s1==s2);
	}
}
