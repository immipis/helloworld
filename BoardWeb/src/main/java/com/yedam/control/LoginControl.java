package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
