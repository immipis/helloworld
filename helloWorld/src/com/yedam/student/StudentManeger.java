package com.yedam.student;

import java.util.Scanner;

//1추가 2목록 3수정(영어,수학) 4삭제(학생번호)

public class StudentManeger {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		Student[] storage = new Student[10];

		while (true) {
			System.out.println("1추가 2목록 3수정(영어,수학) 4삭제(학생번호) 5상세조회(합,평) 6합계점수기준정렬 7 9종료");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: {
				boolean isOk = true;
				System.out.print("학생번호>>");
				int s_Code = Integer.parseInt(scn.nextLine());
				System.out.print("학생이름>>");
				String studentName = scn.nextLine();
				System.out.print("수학점수>>");
				int m_Score = Integer.parseInt(scn.nextLine());
				System.out.print("영어점수>>");
				int e_Score = Integer.parseInt(scn.nextLine());

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null && storage[i].studentCode == s_Code) {
						isOk = false;
					}
					;
					if (!isOk) {
						System.out.println("학생코드 중첩 오류");
						break;
					}
					if (storage[i] == null) {
						storage[i] = new Student(s_Code,studentName,m_Score,e_Score);
						break;
					}
				}
				break;
			}
			case 2: {
				System.out.println("------------목록------------");
				System.out.println("학생코드  이름    수학점수  영어점수");
//				for (Student student : storage) {
//					if (student != null) {
////						System.out.printf("%6d %3s %8d %7d \n", student.studentCode, student.studentName,
////								student.m_Score, student.e_Score);
//						student.introduce();
//					}
//
//				}
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						storage[i].introduce();
					}
				}
				break;
			}
			case 3: {
				System.out.print("학생번호>>");
				int s_Code = Integer.parseInt(scn.nextLine());
				System.out.println("1수학 2영어 9취소");
				System.out.print("선택>>");
				int num = Integer.parseInt(scn.nextLine());
				switch (num) {
				case 1: {
					for (int i = 0; i < storage.length; i++) {
						if (storage[i] != null && storage[i].studentCode == s_Code) 
						{						
							System.out.println("얼마로");
							int m_Code2 = Integer.parseInt(scn.nextLine());
							storage[i].m_Score = m_Code2;
						}
					}
					break;
				}
				case 2: {
					for (int i = 0; i < storage.length; i++) {
						if (storage[i] != null && storage[i].studentCode == s_Code) {						
							System.out.println("얼마로");
							int m_Code2 = Integer.parseInt(scn.nextLine());
							storage[i].e_Score = m_Code2;
						}
					}
					break;
				}
				case 9: {
					break;
				}
				}

			}
			case 4: {
				System.out.print("학생번호>>");
				int s_Code = Integer.parseInt(scn.nextLine());
				for (int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].studentCode == s_Code) {
						storage[i] = null;
					}
				}

			}
			case 5:{
				System.out.print("학생번호>>");
				int s_Code = Integer.parseInt(scn.nextLine());
				for (int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].studentCode == s_Code) {
						double a = storage[i].m_Score;
						double b = storage[i].e_Score;
						double avg = (a+b)/2;
						System.out.printf("%d 번학생의 이름 %s 수학점수와 영어점수는 각각 %d, %d 이며 합계는 %d, 평균은 %f 입니다 \n",storage[i].studentCode,storage[i].studentName,storage[i].m_Score,storage[i].e_Score,storage[i].m_Score+storage[i].e_Score,avg);
					}
				}
				break;
			}
			case 6:{
				for (int i = 0; i < storage.length-1; i++) {
					if(storage[i] == null) {
						break;
					}
					for (int j = 0; j < storage.length-i; j++) {
						if(storage[j+1] == null) {
							break;
						}
						int sum1 = storage[j].m_Score+storage[j].e_Score;
						int sum2 = storage[j+1].m_Score+storage[j+1].e_Score;
						if(sum1>sum2) {
							Student strings = storage[j];
							storage[j] = storage[j+1];
							storage[j+1] = strings;
						}
					}
				}
				break;
			}
			case 7:{
				
			}
			}
		}
	}
}
