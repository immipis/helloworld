package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정화면에서 submit 이벤트가 발생하면 데이터 베이스의 정보를 수정\
		// 수정후 목록으로 이동
		// 수정에러가 발생하면 수정화면으로
		BoardDAO bdao = new BoardDAO();
		
		int bno =  Integer.parseInt(req.getParameter("boardNum"));
		String btle = req.getParameter("boardTitle");
		String bcon = req.getParameter("boardContent");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardVO bvo = new BoardVO();
		
		bvo.setBoardNo(bno);
		bvo.setTitle(btle);
		bvo.setContent(bcon);
		
		if(bdao.updateBoard(bvo)) {
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
		}else {
			req.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(req, resp);
		}

	}

}
