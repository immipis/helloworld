package com.yedam;

import java.util.ArrayList;



public class MainExe {
	static EmpDAO dao = new EmpDAO();
	public static void main(String[] args) {
		ArrayList<Employees> list = dao.selected();
		System.out.println("사원번호  이름               이메일     급여");
		for (Employees emps : list) { 
			System.out.printf("%5s| %-17s %-8s %d\n",emps.getEmployeeId(),emps.getEmployeeName(),emps.getEmployeeEmail(),emps.getSalay());
		}
	}

}
