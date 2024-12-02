package com.yedam.classes;


import com.yedam.student.Student;

public class Calculator {
	
	// 기본생성자. public Calculator(){}
	// 반환값 + 메소드 이름 + 매개변수(...)
	int sum(int n1,int n2) {
		int result = n1 + n2;
		return result;
	}
	//메소드 오버로딩 == 중복적용 가능
	double sum(double n1,double n2) {
		return n1 + n2;
	}
	
	double max(double n1,double n2) {
		return n1 >= n2 ? n1 : n2;
	}
	
	double max(int[] num) {
		double result = 0;
		for (int i = 0; i < num.length; i++) {
			if (result<num[i]) {
				result = num[i];
			}
		}
		return result;
	}
	void printStar(int times) {
		for (int i = 0; i < times; i++) {
			System.out.print("★");
		}
	}
	int sumAry(int[] num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			 sum += num[i];
		}
		return sum;
	}
	
	double averageAry(int[] num) {
		return sumAry(num)*1.0/num.length;
	}
	Student getMaxScore(Student[] stdAry) {
		int max = 0;
		Student result = null;
		for (int i = 0; i < stdAry.length; i++) {
			if(max < stdAry[i].e_Score) {
				max = stdAry[i].e_Score;
				result = stdAry[i];
			}
		}
		return result;
	}
}
