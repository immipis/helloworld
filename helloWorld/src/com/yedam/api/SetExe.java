package com.yedam.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


//hashCode() 메소드 오버라이딩.

public class SetExe {
	public static void main(String[] args) {
		
		HashMap<Integer,String>map = new HashMap<Integer,String>();
		map.put(100, "홍길동");
		map.put(200, "김길동");
		map.put(300, "나길동");
		
		map.keySet();// 키값만 뽑아서 set에 반환
		
		Set<Integer> kset = map.keySet();
		for (Integer key : kset) {
			System.out.printf("key : %d value : %s\n",key,map.get(key));
		}
		
		System.out.println("프로그램 끝");
	}
	public void set() {
		
		HashSet<Student> students = new HashSet<Student>();
		students.add(new Student(1001, "홍길동" , 90));
		students.add(new Student(1001, "김민동" , 70));
		students.add(new Student(1003, "심봉동" , 20));
		students.add(new Student(1004, "최동길" , 30));	
		students.add(new Student(1001, "홍길동" , 90));
		
		for (Student std : students) {
			System.out.println(std);
		}
		
		HashSet<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		set.add("Hello");
		//중복 값 저장 X
		for (String str : set) {
			System.out.println(str);
		}
		
	}
	public void arrayList() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		students.add(new Student(1001, "홍길동" , 90));
		students.add(new Student(1002, "김민동" , 70));
		students.add(new Student(1003, "심봉동" , 20));
		students.add(new Student(1004, "최동길" , 30));	
		students.add(new Student(1001, "홍길동" , 90));

		
		for (Student std : students) {
			if(std.getScore()>50) {
				System.out.println(std);
			}
		}
		ArrayList<String> strList = new ArrayList<String>();	
		strList.add("Hello");
		strList.add("World");
		strList.add(0,"Nice");
		
		strList.remove(2);
		
		System.out.println("strList의 크기는 "+ strList.size());
		
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		
	}
	public void list() {
		//Collection.size() -> List(인덱스 저장),Set(집합 중복값 안드감),Map(키, 값)
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("orenge");
//		list.add(10);
//		list.add(true);
		String v1 =(String) list.get(0);// object - >string
		Object v2 =list.get(1);
//		int v3 =(Integer) list.get(2);
		
		System.out.println(v1+' '+v2+' ');
		
		for (int i = 0; i < list.size(); i++) {
			String result = list.get(i);
		}
	}
}
