package com.yedam.api;

import java.util.Calendar;

public class CalenderExe {
	public static void main(String[] args) {

		createCalendar(2024,7);
	}
	
	static void createCalendar(int year,int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, 1);
		
		int positionOfDay = cal.get(Calendar.DAY_OF_WEEK);
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		for (String day : days) {
			System.out.printf("%4s",day);
		}
		System.out.println();
		for (int i = 1; i < positionOfDay; i++) {
			System.out.printf("%4s", " ");
		}
		
		for (int d = 1; d <= lastDate; d++) {
			System.out.printf("%4d",d);
			if((d+positionOfDay-1)%7==0) {
				System.out.println();
			}
		}
	}
}
