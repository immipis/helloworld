package com.yedam.classes;

import com.yedam.student.Student;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal1 = new Calculator();// 인스턴스 생성.

		int sum = cal1.sum(10, 20);
		double sum2 = cal1.sum(11.2, 20.6);

		System.out.println("합계: " + sum + "\n합계: " + cal1.sum(11.2, 20.6));
		System.out.println(cal1.max(5, 5.1));
		cal1.printStar(3);

		int[] intAry = { 3, 6, 9, 12 };
		sum = cal1.sumAry(intAry);
		System.out.println(sum);
		
		double result = cal1.averageAry(intAry);
		System.out.println("평균은 "+result);
		
		double result2 = cal1.max(intAry);
		System.out.println("max = "+result2);
		
		Student s1 = new Student(1,"홍길동",83,44);
		Student s2 = new Student(2,"김길동",70,52);
		Student s3 = new Student(3,"나길동",60,11);
		
		Student[] stdAry= {s1,s2,s3};
		Student std = cal1.getMaxScore(stdAry);
		System.out.println("최고영어점수"+ std.e_Score);
	}
}
