package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str ="Hello, World";
		
		str ="20000809 3000000";
		char c1 = str.charAt(9);
		
		switch (c1) {
		case '1': {
			System.out.println("남");
			break;
		}
		case '2': {
			System.out.println("여");
			break;
		}
		default:
			System.out.println("?");
		}
	}
}
