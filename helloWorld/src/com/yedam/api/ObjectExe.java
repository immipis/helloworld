package com.yedam.api;

class Member {
	String id;
	int age;

	@Override
	public boolean equals(Object obj) {
//		return super.equals(obj);//Object.equals() 두 객체의 주소값을 비교
		// id 속성의 값이 동일하면 논리적으로는 동등하다라고 판단하겟습니다
		if(obj instanceof Member) {
			Member m2 = (Member) obj;
			if(id.equals(m2.id) && age == m2.age){
				return true;
			}
		}
		return false;
	}
}

public class ObjectExe {
	public static void main(String[] args) {
		Member m1 = new Member();//m1은 Member 인스턴스의 주소 값을 가지고 있다.
		m1.id = "user01";
		m1.age = 11;
		Member m2 = new Member();
		m2.id = "user01";
		m2.age = 11;

		System.out.println(m1==m2);
		System.out.println(m1.equals(m2));

	}
}
