package com.yedam.variable;

import java.util.Iterator;

public class TodoExe5 {
	public static void main(String[] args) {
		int sum=0;
		for (int i = 1; i <= 100; i++) {
			if(i%3==0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		for(int i=1;i<=5;i++) {
			for (int j = 5; j >= 1; j--) {
				if(i>=j) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
