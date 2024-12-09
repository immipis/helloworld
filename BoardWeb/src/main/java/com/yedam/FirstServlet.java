package com.yedam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/First") // http://localhost/BoardWeb/First
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("겟방식");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 출력스트림(자바에서는 데이터의 이동 스트림 (데이터의 흐름))

		String boardNo = request.getParameter("board_no");
		BoardDAO bdao = new BoardDAO();
		BoardVO board = null;
		try {
			board = bdao.selectBoard(Integer.parseInt(boardNo));
		} catch (Exception e) {
			out.print("게시글 번호를 확인 하세요");
			return;
		}

		out.print("<h3>상세페이지</h3>");
		if (board == null) {
			out.print("<p>조회된 값이 없음</p>");
		} else {
			String html = "<table border ='1'>";
			html += "  <tr>";
			html += "  <th>글번호</th> <td>" + board.getBoardNo() + "</td>";
			html += "  <th>제목</th> <td>" + board.getTitle() + "</td>";
			html += "  </tr>";
			html += "  <tr>";
			html += "  <th>글내용</th> <td colspan ='3'>" + board.getContent() + "</td>";
			html += "  </tr>";
			html += "  </table>";
			out.print(html);
		}

		// boardDAO에 기능추가
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("포스트 방식");
		request.setCharacterEncoding("uth-8");// post 요청일 경우 바디에 담아 주기에 인코딩 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 출력스트림(자바에서는 데이터의 이동 스트림 (데이터의 흐름))
//		out.print("Hello, World");
//		out.print("<h3>안녕하세요</h3>");
//		out.print("<a href ='index.html'>인덱스로</a>");
//		out.print("<a href ='html/intro.html'>인트로로</a>");
		// First?title=테스&content=테스트&writer=123123123

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);

		BoardDAO bdao = new BoardDAO();
		bdao.selectBoard(1);
//		if (bdao.insertBoard(board)) {
//			out.print("<p>등록됨</p>");
//			out.print("<a href='second'>목록이동</a>");
//		}else {
//			out.print("<p>등록안됨</p>");
//		}
//		doGet(request, response);
	}

}
