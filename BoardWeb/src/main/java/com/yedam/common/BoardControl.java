package com.yedam.common;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
			String savePath = req.getServletContext().getRealPath("images");
			int maxSize = 1024 * 1024 * 5;
			
			MultipartRequest mr = new MultipartRequest(
					req//요정정보
					,savePath //저장경로
					,maxSize //최대크기
					,"utf-8" //인코딩 방식
					, new DefaultFileRenamePolicy()//리네임정책
					);
			
			req.setCharacterEncoding("utf-8");		
			
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			String writer = mr.getParameter("writer");
			String img = mr.getFilesystemName("img");//리네임 정책에 의해 생성된 파일명
			
			BoardVO bvo = new BoardVO();
			
			bvo.setTitle(title);
			bvo.setContent(content);
			bvo.setWriter(writer);
			bvo.setImg(img);
			
			if(bdao.insertBoard(bvo)) {
				resp.sendRedirect("boardList.do");
			}else {
				//등록화면으로 이동
				req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);
			}
		}

	}

}
