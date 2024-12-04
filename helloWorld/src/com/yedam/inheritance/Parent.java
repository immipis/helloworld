package com.yedam.inheritance;

// 부모

public class Parent extends Object/*모든 클래스에 생략되있음*/{
	String filed1; // 필드
//1번방법
	public Parent(){
		
	}

	// 생성자
	// 개발자가 생성자에 대한 정의가 없으면 컴파일러가 기본생성자 생성
	// 개발자가 생성자를 정의하면 기본 생성자는 없음.

	public Parent(String filed1) {
		super();// super는 부모를 가리킴. 
		this.filed1 = filed1;
	}

	void method1() {
		System.out.println("mothod1 호출");
	}
	
	@Override
	public String toString() {
		return "filed1값은"+filed1;
	}
}
