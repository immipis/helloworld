package com.yedam;

//대소문자 구분
// 객체지향언어 (object oriented language)
public class Hello {
	// 메소드를 여러개 선언 start(),main();
	public static void start() {
		System.out.println("시작합니다");
	}

	// 메인 메소드. 함수(function)
	public static void main(String[] args) {
		System.out.println("Hello, World");
		start();
		OperationExe exe = new OperationExe();
		exe.sum(10, 200);
		// 컴파일 저장하면 이클립스가 컴파일 만들어주
	}
}
