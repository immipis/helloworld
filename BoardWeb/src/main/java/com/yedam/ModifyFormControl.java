package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		String bno = req.getParameter("boardNum");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", bvo);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page);
		req.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(req, resp);
		
	}

}
