package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();
		
		while (run) {
			System.out.println("1목록 2등록 3학생수정 4삭제 5상세화면 9종료");
			System.out.print("선택>");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1://목록
				ArrayList<Student> list = dao.studentList();
				for (Student stud : list) { //학생번호, 이름, 연락처
					System.out.println(stud.showInfo());
				}
				break;
				
			case 2: //등록.
				System.out.println("학생 번호>>>");
				String no = scn.nextLine();
				System.out.println("학생 이름>>>");
				String name = scn.nextLine();
				System.out.println("학생 연락처>>>");
				String phone = scn.nextLine();
				
				Student std = new Student(no,name,phone);
				
//				std.setStdNo(no);
//				std.setStdName(name);
//				std.setStdPhone(phone);
				
				if (dao.insertStudent(std)) {
					System.out.println("정상등록");
				}
				else {
					System.out.println("싫패");
				}
				break;
			case 3:
				System.out.println("학생 번호>>>");
				no = scn.nextLine();
				System.out.println("영점>>>");
				int es =Integer.parseInt(scn.nextLine()) ;
				System.out.println("수점>>>");
				int ms =Integer.parseInt(scn.nextLine()) ;
				std = new Student(no,es,ms);
				
				if (dao.updateStudent(std)) {
					System.out.println("정상수정");
				}
				else {
					System.out.println("싫패");
				}
				break;
			case 4:
				System.out.println("학생 번호>>>");
				no = scn.nextLine();
				std = new Student(no);
				
				if (dao.deleteStudent(std)) {
					System.out.println("정상삭제");
				}
				else {
					System.out.println("싫패");
				}
				break;
			case 5:
				System.out.println("학생 번호>>>");
				no = scn.nextLine();
				std = dao.selecStudent(no);
				if(std == null) {
					System.out.println("조회된 결과가 없음");
				}
				System.out.println(std.showDetauill());
				selecStudent
			case 9:
				run = false;
			default:
				break;
			}
		}
		
		System.out.println("end of prog");
	}
}
