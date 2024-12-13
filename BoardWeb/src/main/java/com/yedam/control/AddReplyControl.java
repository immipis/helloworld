package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno, replyer, reply
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		String replyer = req.getParameter("replyer");
		String reply = req.getParameter("reply");
		ReplyVO rvo = new ReplyVO();
		
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		ReplyDAO rdao = new ReplyDAO();
		
		//json 문자열을 생성
		Gson gson = new GsonBuilder().create();
		String json = "";
		
		Map<String, Object> resultMap = new HashMap<>();
		
		if (rdao.insertReply(rvo)) {
			//{"retCode":"OK"}
			resultMap.put("retCode", "OK");
			resultMap.put("retVal", rvo);
			json = gson.toJson(resultMap);
			resp.getWriter().print(json);
		}
		else {
			//{"retCode":"flase"}
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}

	}

}
