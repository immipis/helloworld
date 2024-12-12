package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		if (req.getMethod().equals("GET")) {
			
			String bno = req.getParameter("board_No");
			String page = req.getParameter("page");
			String sc = req.getParameter("searchCondition");
			String kw = req.getParameter("keyword");
			
			BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno));
			req.setAttribute("board", bvo);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			req.setAttribute("page", page);
			req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, resp);
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
				req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);
			}
		}

	}

}
