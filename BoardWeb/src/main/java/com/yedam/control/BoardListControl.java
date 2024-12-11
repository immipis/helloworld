package com.yedam.control;

import java.io.IOException;
import java.util.List;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");

		page = page == null ? "1" : page;
		
		String sc = req.getParameter("searchCondition");
		String ky = req.getParameter("keyword");
		//@AllArgsConstructor
		SearchDTO search = new SearchDTO(Integer.parseInt(page),sc,ky);
		
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.boardList(search);
		

		
		int totalCnt = bdao.selectCount(search);
		PageDTO pageDto = new PageDTO(Integer.parseInt(page),totalCnt);
		
		req.setAttribute("list", list);
		req.setAttribute("paging", pageDto);
		req.getRequestDispatcher("html/boardList.jsp").forward(req, resp);
		
		
	}


}
