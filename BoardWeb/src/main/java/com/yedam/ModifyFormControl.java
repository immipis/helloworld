package com.yedam;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		String bno = req.getParameter("boardNum");
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno));
		req.setAttribute("modboard", bvo);
		req.getRequestDispatcher("html/modifyForm.jsp").forward(req, resp);
		
	}

}
