package com.yedam.api;

import java.awt.geom.FlatteningPathIterator;

public class Student {
	private int sno;
	private String sname;
	private int score;
	
	public Student(int sno, String sname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.score = score;
	}
	
	//hashCode() & equals() => 학번이 같으면 논리적으로 동등한 객체.
	@Override
	public int hashCode() {
		return sno;//학생번호를 hashCoder값으로 사용
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(sno == std.sno){
				return true;
			}
		}
		return false;
	}

	public int getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "학번 : " + sno + " 이름 : "+sname+ " 점수 : "+score;
	}
	
}
