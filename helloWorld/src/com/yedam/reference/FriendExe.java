package com.yedam.reference;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		String name = new String("홍길동");
		int age = 20;
		
		Friend f1 = new Friend();
		f1.friendName = "홍길동";
		f1.friendPhone = "010-1111-1111";
		f1.friendBirth = "2000-11-11";
		
		Friend f2 = new Friend();
		f2.friendName = "김민수";
		f2.friendPhone = "010-2222-2222";
		f2.friendBirth = "2000-22-22";
		
		Friend f3 = new Friend();
		f3.friendName = "최두식";
		f3.friendPhone = "010-3333-3333";
		f3.friendBirth = "2000-33-33";
		
		Friend[] myFriends = {f1,f2,f3};
		
		System.out.println(myFriends[0].friendName);
		System.out.println(myFriends[0].friendPhone);
		System.out.println(myFriends[0].friendBirth);
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			boolean run1 = false;
			System.out.println("이름 >>> ");
			name = scn.nextLine();
			if (name.equals("quit")) {
				System.out.println("종료");
				break;
			}
			for (Friend friend : myFriends) {
				if(friend.friendName.equals(name)) {
					run1 = friend.friendName.equals(name);
					System.out.println(friend.friendName+' '+friend.friendPhone+' '+friend.friendBirth);
				};
			}

			if(!run1) {
				System.out.println("없다");
			}
		}
		

	}
}
