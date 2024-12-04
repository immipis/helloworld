package com.yedam.api;

public class Exe2 {
	public static void main(String[] args) {
		String strVal = new String("신민철");
		String strVal2 = "신민철";
		
		if (strVal==strVal2) {
			System.out.println("같은객체참조");
		}
		else {
			System.out.println("다른객체참조");
		}
		
		if (strVal.equals(strVal2)) {
			System.out.println("같은문자열");
		}
		else {
			System.out.println("같은문자열아님");
		}
	}
}
