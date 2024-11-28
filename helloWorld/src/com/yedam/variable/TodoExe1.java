package com.yedam.variable;

import javax.imageio.ImageTranscoder;

public class TodoExe1 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
		    int a =(int)(Math.random()*100)+1;
			System.out.println(a);
			sum += a;
		}
		System.out.println(sum);
	}
}
