package com.yedam.api;

public class Exe {
	public static void main(String[] args) {
		String snn = "123456-14567892";
		char sex = snn.charAt(7);
		switch (sex) {
		case '1':
		case '3':
			System.out.println("남");
			break;
		case '2':
		case '4':
			System.out.println("여");
			break;

		}
	}
}
