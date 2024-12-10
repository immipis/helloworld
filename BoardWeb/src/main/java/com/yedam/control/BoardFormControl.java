package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardFormControl implements Control{
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("html/boardForm.jsp").forward(req, resp);
		
	}
}
