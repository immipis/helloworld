package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.BoardControl;
import com.yedam.common.Control;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;

//url 패턴에서 ~~~~*.do로 끝나는 건 전부 frontcontrol실행 

public class FrontControl extends HttpServlet{
	
	Map<String, Control> map;
	
	public FrontControl() {
		map = new HashMap<>();//필드의 값으 ㄹ초기화
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do",new BoardListControl()); //목록
		map.put("/board.do",new BoardControl()); //상세
		
		map.put("/board.do",new BoardControl()); 
		
		map.put("/modifyForm.do",new ModifyFormControl()); //등록
		map.put("/modifyBoard.do",new ModifyBoardControl()); 
		
		map.put("/loginForm.do",new LoginFormControl()); //등록
		map.put("/login.do",new LoginControl()); //등록
		
		map.put("/boardForm.do",new BoardFormControl()); //등록
		map.put("/logout.do",new LogoutControl());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);// 공통부분을 제외한 나머지 부분
		
		Control control = map.get(path);
		control.exec(req,resp);
	}
}
