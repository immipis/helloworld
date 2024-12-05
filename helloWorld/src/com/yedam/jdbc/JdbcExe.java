package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExe {
	public static void main(String[] args) {
		insert("jo", "dhdh@never.com", "2024-12-11", "IT_PROG", 3000);
		update("성민","010-37496468","dhdhdh963@never.com",500000);
		select();
		delete("jo");
		select();
		System.out.println("프로그램 끝");
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			// connection객체 db,사용자,비번
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println("연결중 에러");
			e.printStackTrace();// 로그 출력
		}
		return conn;// connection객체 반환
	}

	public static void update(String firstName,String phoneNumber,String email,int salary) {
		Connection conn = getConn();
		String qurry = "update employees" //
				+ "         set first_name = '"+firstName+"'" //
				+ "            ,phone_number = '"+phoneNumber+"'" //
				+ "            ,email = '"+email+"'" //
				+ "            ,salary = "+salary+" "//
				+ "      where last_name = 'jo'";
		try {
			Statement stmt = conn.createStatement();
			// 테이블 반드시 들어가야 대는 칼럼 필수
			int r = stmt.executeUpdate(qurry);
			System.out.println(r + "건 처리됨");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(String name) {
		Connection conn = getConn();
		String qurry = "delete employees where LAST_NAME = '"+name+"'";
		try {
			Statement stmt = conn.createStatement();
			// 테이블 반드시 들어가야 대는 칼럼 필수
			int r = stmt.executeUpdate(qurry);
			System.out.println(r + "건 처리됨");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(String lastName, String email, String hireDate, String jobId, int salary) {
		Connection conn = getConn();
		String qurry = "insert into employees(employee_id, last_name, email, hire_date, job_id, salary) "
				+ "VALUES (employees_seq.nextval, '" + lastName + "', '" + email + "', '" + hireDate + "', '" + jobId
				+ "'," + salary + ")";
		try {
			Statement stmt = conn.createStatement();
			// 테이블 반드시 들어가야 대는 칼럼 필수
			int r = stmt.executeUpdate(qurry);
			System.out.println(r + "건 처리됨");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void select() {

		Connection conn = getConn();
		try {
			// sql 작성 Statement
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees where employee_id > 200 order by employee_id desc");// 조회
			while (rs.next()) {
				System.out.println(rs.getString("LAST_NAME") + ", " //
						+ rs.getString("FIRST_NAME") + ", "//
						+ rs.getString("EMAIL") + ", "//
						+ rs.getString("JOB_ID") + ", "//
						+ rs.getString("PHONE_NUMBER") + ", "//
						+ rs.getString("SALARY"));
			}
			conn.close();// 연결해제
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("데이터 끝");

	}
}
