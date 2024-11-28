package com.yedam.variable;

import java.io.Console;
import java.util.Scanner;

public class TodoExe2 {
	public static void main(String[] args) {
		String name = "김길동";
		
		Scanner scn = new Scanner(System.in);
		System.out.println("이름을 입력");
		String inputValue = scn.nextLine();
		if(name.equals(inputValue)) {
			System.out.println("같은이름입니다");
		}
		else {
			System.out.println("이름 "+inputValue);
		}

		System.out.println("end of prog.");
	}


//		public static void main(String[] args) {
//			String name = "김길동";
//			System.out.println("이름을 입력");
//			String inputValue = new Scanner(System.in).nextLine();
//
//		}
	

}
