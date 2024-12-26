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
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.CalendarDataControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartDataControl;
import com.yedam.control.DelEventControl;
import com.yedam.control.GetReplyCountControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.FullCalendarControl;

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
		
		map.put("/replyList.do", new ReplyListControl()); //댓목
		map.put("/removeReply.do", new RemoveReplyControl()); // 댓삭
		map.put("/addReply.do", new AddReplyControl()); // 댓등
		map.put("/getCount.do", new GetReplyCountControl());
		
		//구글 차트
		map.put("/chart.do", new ChartControl());
		map.put("/chartData.do", new ChartDataControl());
		
		//풀캘린더
		map.put("/full.do", new FullCalendarControl());
		map.put("/fullData.do", new CalendarDataControl());
		map.put("/AddEvent.do", new AddEventControl());
		map.put("/DelEvent.do", new DelEventControl());
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
