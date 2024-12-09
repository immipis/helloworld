package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//HttpServlet 상속
//생성자ㅣ 정의
//init 메소드 실행.
//service 메서드 실행
//


//@WebServlet("/second") //방법 1
//방법 2 web.xml로
public class SecondServlet extends HttpServlet{
	public SecondServlet() {
		System.out.println("SecondServlet 생성자 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 메소드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service 호출");
		resp.setContentType("text/html;char=utf-8");
		PrintWriter out = resp.getWriter();
		
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.boardList();
		
		out.print("<h3>게시글 목록<h3>");
		out.print("<table border='2'>");
		out.print("<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr></thead>");
		out.print("<tbody>");
		for (BoardVO brd : list) {
			out.print("<tr><td><a href='First?board_no="+brd.getBoardNo()+"'>"+brd.getBoardNo()+"<a></td><td>"
								+brd.getTitle()+"</td><td>"
								+brd.getWriter()+"</td><td>"
								+brd.getViewCnt()+"</td></tr>");
		} 
		out.print("</tbody>");
		out.print("</table>");
	}
}
