package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe3 {
	public static void main(String[] args) {
		boolean run = true;
		String name = "";
		Scanner scn = new Scanner(System.in);
		String[] names = { "홍길동", "김민수", "최두식" };
		int[] scores = { 80, 90, 70 };

//		for (int i = 0; i < names.length; i++) {
//			System.out.println(names[i]+"의 점수는 "+scores[i]+"입니다");
//		}
		while (run) {
			boolean inName = false;
			System.out.println("이름 >>> ");
			name = scn.nextLine();
			
			if (name.equals("quit")) {
				System.out.println("종료");
				run = false;
			}
			for (int i = 0; i < names.length; i++) {
				if (names[i].equals(name)) {
					System.out.println(names[i] + "의 점수는 " + scores[i] + "입니다");
					inName = true;
				}
			}
			if (!inName) {
				System.out.println("그런 이름 없음");
			}

		}

	}
}
