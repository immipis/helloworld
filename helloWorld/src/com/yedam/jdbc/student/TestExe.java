package com.yedam.jdbc.student;

import java.util.ArrayList;

public class TestExe {
	public static void main(String[] args) {
		Search search = new Search();
		search.setName("민");
		search.setPhone("6");
		search.setEngScore(20);
		search.setOrderBy("std_no");
		
		StudentDAO sdao = new StudentDAO();
		
		ArrayList<Student> list = sdao.studentList(search);

		for (Student std : list) {
			System.out.println(std.showInfo());
		}
	}
}
