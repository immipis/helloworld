package com.yedam.board;

//아이디, 비밀번호, 이름, 얀락처, 

public class Member {
	private String memberId;
	private String password;
	private String memberName;
	private String phoneNumber;
	
	public Member(String memberId, String password, String memberName, String phoneNumber) {
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;
	}
	
	
	
	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String showInfo() {
		return "  "+memberId+"  "+memberName+"  "+phoneNumber;
	}
}
