package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO bdao = new BoardDAO();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if (bdao.loginBoard(id, pw) != null) {
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);//꼐속 서버에 존재 삭제하거나 시간이 오래 지나면 제거
			
			resp.sendRedirect("boardList.do");
			
		} else {
			resp.sendRedirect("loginForm.do");
		}

	}

}
