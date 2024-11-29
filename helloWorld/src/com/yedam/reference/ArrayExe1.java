package com.yedam.reference;

public class ArrayExe1 {

	public static void main(String[] args) {
		int[] intAry = new int[5];
		// 위치 => 인덱스
		intAry[0]=10;
		intAry[1]=20;
		
		//크기(length)

		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("%d 번째 값은 %d \n",i,intAry[i]); 
		}
		
		double[] dblAry = {2.5,1.2,4,5.6,8}; //초기값 지정해서 선언
		double sum = 0;
		for (int i = 0; i < dblAry.length; i++) {
			sum += dblAry[i];
		}
		System.out.println(sum);
		dblAry = new double[]{1.05,2.6};//변수 선언후 값을 할당.
		for (int i = 0; i < dblAry.length; i++) {
			System.out.println(dblAry[i]);
		}
		//문자열 배열.
		String[] strAry = {"홍길동","김민섭","박창규"};
		//enhanced for.
		for (String str : strAry) {
			System.out.println(str);
		}
	}

}
