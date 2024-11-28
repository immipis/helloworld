package com.yedam.variable;

public class IntExe3 {

	public static void main(String[] args) {
		boolean b1 = true;
		b1 = 10 > 20;
		System.out.println(b1);
		
//		char c1 = 0;//유니 코드매핑
//		c1 = 65;
//		for (int i = 0; i < 100; i++) {
//			System.out.println(c1++);
//		}
		String c2 = "hello";
		System.out.println(c2);
		
		int n1 = 1;
		int n2 = 2;
		
		double result = n1*1.0 / (double)n2;//자동형변환 프로모션
		System.out.println(result);
	}

}
