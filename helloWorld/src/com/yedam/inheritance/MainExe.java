package com.yedam.inheritance;

public class MainExe {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.filed1 = "부모필드";
		p1.method1();
		//p1.method2(); 자시필드
		System.out.println(p1.toString());
		
		Child c1 = new Child();
		c1.filed1 = "자식필드";
		c1.method1();
		c1.filed2 = "자식필드";
		c1.method2();
		System.out.println(c1.toString());
				
	}
}
