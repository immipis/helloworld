package com.yedam.variable;

public class IntExe4 {

	public static void main(String[] args) {
		String msg = new String("Hello, World"); //msg 주소값에 문자 객체의 주소.
		int age = 10;// age 주소값에 10의 값.
		
		int myAge = age;
		myAge = 20;

		
		System.out.println(age+","+myAge);
		System.out.println(msg.equals("Hello, World"));//equals 주소의 문자 값을 비교
		System.out.println(msg == "Hello, World");
		
	}
}
