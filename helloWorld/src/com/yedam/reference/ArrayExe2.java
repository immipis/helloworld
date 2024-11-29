package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe2 {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		int asd = 0;
		int asdf = 0;
		int max = 100000;
		Scanner scn = new Scanner(System.in);
		while(run) {
			System.out.println("----------------------");
			System.out.println("1.예금|2.출금|3.잔고|4.종료");
			System.out.println("----------------------");
			System.out.print("선택 > ");
			int menu =Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1: {
				System.out.print("예금액> ");
				asd = Integer.parseInt(scn.nextLine());
				if (balance + asd >max) {
					System.out.println("10만넘음");
				}
				else {
					balance += asd;
				}
				break;
			}
			case 2: {	
				System.out.print("출금> ");
				asd = Integer.parseInt(scn.nextLine());
				if (balance - asd <0) {
					System.out.println("돈없음");
					break;
				}
				balance -= asdf;
				break;
			}
			case 3: {	
				System.out.printf("잔고> %d\n",balance);
				break;
			}
			case 4: {		
				System.out.println("프로그램 종료");
				run = false;
			}

			}
		}
	}
}
