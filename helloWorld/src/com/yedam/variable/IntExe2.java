package com.yedam.variable;

import java.util.Iterator;
import java.util.function.BiConsumer;

public class IntExe2 {
	public static void main(String[] args) {
		byte b1 = 100;
		byte b2 = 100;
		int result = (int)b1 + (int)b2;
		byte result2 = (byte)(b1+b2);
		System.out.println(result2);
		
		for (int i = 0; i < 100; i++) {
			System.out.println(++b1);

		}
		System.out.println(Integer.MAX_VALUE);
		long l1 =1100000000000000000L;
		

		double d1 = 0.1;
		double d2 = 0.2;
		double result3 = d1 + d2;
		double sum = 0;
		result3 = 0.3456789;
		//round/ceil/floor/abs (반올림/올림/내림/절대값)
		System.out.println(Math.floor(result3*1000)/1000);
		
		double[] doubleAry = {10,23.4,11.7,34.5};
		for (int i = 0; i < doubleAry.length; i++) {
			  sum += doubleAry[i];
		}
		System.out.println(sum);
		
	}
}
