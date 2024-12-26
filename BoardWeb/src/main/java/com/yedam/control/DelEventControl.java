package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class DelEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/json;charset=utf-8");
		
		String title = req.getParameter("a");

		ReplyDAO rdao = new ReplyDAO();
		if (rdao.deleteEvent(title)) {
			//{"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}
		else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}

	}

}
