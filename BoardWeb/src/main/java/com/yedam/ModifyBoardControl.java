package com.yedam;

import java.io.IOException;

import com.yedam.common.Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정화면에서 submit 이벤트가 발생하면 데이터 베이스의 정보를 수정\
		// 수정후 목록으로 이동
		// 수정에러가 발생하면 수정화면으로


	}

}
