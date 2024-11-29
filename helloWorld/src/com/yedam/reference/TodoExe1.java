package com.yedam.reference;

public class TodoExe1 {
	public static void main(String[] args) {
		//정수를 담는 배열 크기는 5개
		int[] intAry = new int[5];
		for (int i = 0; i < intAry.length;) {
			int a = (int)(Math.random()*5)+50;
			boolean exists = false;
			for (int j = 0; j <= i-1; j++) {
				if(intAry[j]==a) {
					exists = true;
				}
			}
			if(exists){
				continue;
			}
			intAry[i] = a;
			i++;
		}
		for (int i : intAry) {
			System.out.println(i);
		}
		
	}
}
