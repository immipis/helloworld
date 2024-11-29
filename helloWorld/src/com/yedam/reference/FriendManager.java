package com.yedam.reference;

import java.util.Scanner;

// 친구 관리 
// 1추가 2목록 9종료

public class FriendManager {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10];
		int i = 0;
		boolean run = true;
//		storage[0]= new Friend();
//		storage[0].friendName = "홍길동";
//		storage[0].friendPhone = "010-1111-1111";
//		storage[0].friendBirth = "2000-11-11";
//		System.out.println(storage[0].friendName);
		while (run) {
			System.out.println("1추가 2목록 3조회 4수정 5삭제 9종료");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
				case 1: {
					if(i<storage.length) {
						storage[i]= new Friend();
						System.out.print("이름>>");
						storage[i].friendName = scn.nextLine();
						System.out.print("번호>>");
						storage[i].friendPhone = scn.nextLine();
						System.out.print("생일>>");
						storage[i].friendBirth = scn.nextLine();
						i++;
					}
					else {
						System.out.println("친구가 넘마늠");
					}
					break;
				}
				case 2: {
					for (Friend friend : storage) {
						if(friend != null) {
							System.out.println(friend.friendName +" 폰 번호 "+ friend.friendPhone+" 생일 " + friend.friendBirth);
						}
					}
					break;
				}
				case 3: {
					System.out.print("이름>>");
					String a = scn.nextLine();
					for (Friend friend : storage) {
						if(friend!=null && friend.friendName.equals(a)) {
							System.out.println(friend.friendName +"의 폰 번호 "+ friend.friendPhone+" 생일 " + friend.friendBirth);
						}
					}
					break;
				}
				case 4: {
					System.out.print("수정할 이름>>");
					String a = scn.nextLine();
					for (Friend friend : storage) {
						if(friend!=null && friend.friendName.equals(a)) {
							System.out.print("이름을 뭘로>>");
							String b = scn.nextLine();
							System.out.print("번호를 뭘로>>");
							String c = scn.nextLine();
							System.out.print("생일을 뭘로>>");
							String d = scn.nextLine();
							friend.friendName = b;
							friend.friendPhone = c;
							friend.friendBirth = d;
						}
					}
					break;
				}
				case 5:{
					System.out.print("삭제할 이름>>");
					String delname = scn.nextLine();
					for (int j = 0; j<storage.length; j++ ) {
						if(storage[j] != null && storage[j].friendName.equals(delname)) {
							storage[j] = null;
							break;
						}
					}
					break;
				}
				case 6:{
					
				}
				case 9: {
					System.out.println("종료");
					run = false;
					break;
				}
				default: System.out.println("없는 메뉴");
			}

		}
	}
}
