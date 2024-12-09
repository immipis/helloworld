package com.yedam;

import java.sql.SQLException;
import java.util.ArrayList;


public class EmpDAO extends DAO {
	public ArrayList<Employees> selected() {
		getConnet();
		
		ArrayList<Employees> empList = new ArrayList<Employees>();
		
		String sql = "select employee_id 사원번호,first_name ||' '|| last_name 이름, email 이메일, salary 급여"
				+ " from employees"
				+ " where salary > 5000"
				+ " order by salary desc";
		

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Employees emp = new Employees();
				emp.setEmployeeId(rs.getString("사원번호"));
				emp.setEmployeeName(rs.getString("이름"));
				emp.setEmployeeEmail(rs.getString("이메일"));
				emp.setSalay(rs.getInt("급여"));;
				empList.add(emp);// 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return empList;
	
	}

}
