package com.yedam.variable;

import java.util.Iterator;
import java.util.Scanner;

public class TodoExe4 {

	public static void main(String[] args) {

//		Scanner scn = new Scanner(System.in);
//		System.out.print("몇단 까지 >>>>>>>>>>>>>> \n");
//		int dan = scn.nextInt();
//
//		for (int j = 0; j <= 9 ; j++) {
//			for (int i = 2; i <=dan; i++) {
//				if(j==0) {
//					System.out.printf(" 현재 %d 단     ",i);
//				}
//				else {
//					System.out.printf("%2d * %d = %3d ",i,j,i*j);
//				}
//			}
//			System.out.println();
//		}
//
//		System.out.println("end of prog.");

		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}

}
