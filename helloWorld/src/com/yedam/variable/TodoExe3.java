package com.yedam.variable;

import java.util.Scanner;

public class TodoExe3 {
	public static void main(String[] args) {
		String[] names= {"박창석","홍영민","김익수","이화영"};
		boolean isOk = false;
		
		Scanner scn = new Scanner(System.in);
		System.out.print("친구이름을 입력하세요>>>>>");
		String searchString =scn.nextLine();
		for (int i = 0; i < names.length; i++) {
			if(names[i].equals(searchString)) {
				isOk = true;
			}
		}
		if (isOk) {
			System.out.printf("입력한 이름 %s 이(가) 있씀 %10d\n \t",searchString,10);
		}
		else {
			System.out.printf("입력한 이름 %s 이(가) 없씀 %d",searchString,20);
		}
		System.out.println("end of prog.");
 	}
}
