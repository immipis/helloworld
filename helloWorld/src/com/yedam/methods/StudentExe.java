package com.yedam.methods;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setStudentCode("1000");
		System.out.println(s1.getStudentCode());
		s1.setE_Score(1000);
		System.out.println(s1.getE_Score());
		
		s1.setStudentName("홍길동");
		s1.setE_Score(700);
		s1.setM_Score(1000);
		
		System.out.println(s1.showInfo());
	}
}
