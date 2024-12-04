package com.yedam.inheritance;

public class Child extends Parent {
	String filed2;
	
	//생성자: 기본생성자를 생성 Child() => super(); 
	//부모의 기본생성자를 호출하고 자기자신의 생성자 생성
	//2번방법
//	public Child() {
//		super(" ");
//	}
	@Override//어노테이션 부모의 메소드 정의 (반환값, 메소드이름, 매개값) 
	//부모가 가진 메소드르 제정의 하겠다 규칙을 지켜야한다.
	void method1() {
		//부모의 메소드를 자식이 제정의
		//메소드 오버라이드이라고 함
		System.out.println("자식 method1 호출");
	}
	
	void method2() {
		System.out.println("method2 호출");
	}

	@Override
	public String toString() {
		return "Child [filed2=" + filed2 + "]";
	}
	
}
