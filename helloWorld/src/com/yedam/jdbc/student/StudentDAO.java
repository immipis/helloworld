package com.yedam.jdbc.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.util.ArrayList;

//dao 입력 수정 삭제 조회(목록,단건)

public class StudentDAO extends DAO {

	public boolean deleteStudent(Student std) {
		getConn();
		String sql = "delete tbl_student where std_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			int r = psmt.executeUpdate(); // 쿼리실행
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	public boolean updateStudent(Student std) {
		getConn();
		String sql = "update tbl_student set eng_score =?, math_score =? where std_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, std.getEngScore());
			psmt.setInt(2, std.getMathScore());
			psmt.setString(3, std.getStdNo());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	// 등록. 반환값은 불린,매게 student, 메소드 insertStudent
	public boolean insertStudent(Student std) {
		getConn();
		String sql = "insert into tbl_student(std_no, std_name, std_phone)" + "values (?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getStdPhone());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	public ArrayList<Student> studentList() {
		getConn();
		// 조회결과를 반환
		ArrayList<Student> studList = new ArrayList<Student>();

		String sql = "select * from tbl_student";
		try {
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환
			rs = psmt.executeQuery();

			while (rs.next()) {
				Student stud = new Student(rs.getString("std_no"), rs.getString("std_name"), rs.getString("std_phone"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setMathScore(rs.getInt("math_score"));

				studList.add(stud);// 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// 트라이 캐치 둘중 하나가 끝나면 실행
			disConnect();// 연결해제
		}

		return studList;
	}

	public Student selecStudent(String std) {
		getConn();
		// 조회결과를 반환
		String sql = "select * from tbl_student where std_no=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student std1 = new Student();
				std1.setStdNo(rs.getString("std_no"));
				std1.setStdName(rs.getString("std_name"));
				std1.setStdPhone(rs.getString("std_phone"));
				std1.setEngScore(rs.getInt("eng_score"));
				std1.setMathScore(rs.getInt("math_score"));
				return std1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return null;
	}

}
