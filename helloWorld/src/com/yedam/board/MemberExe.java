package com.yedam.board;

//회원 가입, 회원정보 수정, 목록

public class MemberExe {
	//인스턴스 vs 정적(static)필드,정적메소드 선언
	private static Member[] storege; // 필드

	public MemberExe() {
		storege = new Member[10];
		storege[0] = new Member("user01","1111","홍길동","010-1111-1111");
		storege[1] = new Member("user02","2222","박민석","010-2222-2222");
		storege[2] = new Member("user03","3333","최주찬","010-3333-3333");
	}

	// 1. 등록
	public static boolean addMember(Member member) {
		for (int i = 0; i < storege.length; i++) {
			if (storege[i] == null) {
				storege[i] = member;
				return true; // 등록 오케이
			}
		}
		return false; // 등록안댐
	}

	// 2. 목록
	public static Member[] memberList() {
		return storege;
	}

	// 3. 로그인

	public static boolean login(String id, String pw) {
		for (int i = 0; i < storege.length; i++) {
			if (storege[i] != null) {
				if (storege[i].getMemberId().equals(id)&& 
						storege[i].getPassword().equals(pw)){
					return true;
				}
			}
		}
		return false;
	}
	public static String getLoginName(String id) {
		String logName = " ";
		for (int i = 0; i < storege.length; i++) {
			if(storege[i] != null) {
				if(storege[i].getMemberId().equals(id)){
					logName = storege[i].getMemberName();
				}
			}
		}
		return logName;
		
	}
}
