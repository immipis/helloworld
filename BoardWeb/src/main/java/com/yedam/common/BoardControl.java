package com.yedam.common;

import java.io.IOException;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		if (req.getMethod().equals("GET")) {
			String bno = req.getParameter("board_No");
			
			BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno));
			req.setAttribute("board", bvo);
			req.getRequestDispatcher("html/board.jsp").forward(req, resp);
		}
		else if(req.getMethod().equals("POST")){
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			
			BoardVO bvo = new BoardVO();
			
			bvo.setTitle(title);
			bvo.setContent(content);
			bvo.setWriter(writer);
			
			if(bdao.insertBoard(bvo)) {
				resp.sendRedirect("boardList.do");
			}else {
				//등록화면으로 이동
				req.getRequestDispatcher("html/boardForm.jsp").forward(req, resp);
			}
		}

	}

}
