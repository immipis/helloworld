package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.valves.JsonAccessLogValve;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.multipart.LimitedServletInputStream;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		// 댓글 -> 자바스크립트 오브젝트 -> 문자열 : json

//		let obj = {name:"홍길동",age:20}
//		JSON.stringfy()
//		{"name":"홍길동","age":"20"}
		ReplyDAO rdao = new ReplyDAO();
		List<ReplyVO> list = rdao.selectList(Integer.parseInt(bno),Integer.parseInt(page));
//		String json = "[";
//		for (int i = 0; i < list.size(); i++) {
//			json += "{\"replyNo\": " + list.get(i).getReplyNo() + ""//
//					+ ", \"reply\":\"" + list.get(i).getReply() + "\""//
//					+ ", \"replyer\":\"" + list.get(i).getReplyer() + "\""//
//					+ ", \"replyDate\":\"" + list.get(i).getReplyDate() + "\"}";
//			if (i + 1 != list.size()) {
//				json += ",";
//			}
//		}
//
//		json += "]";
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		
		resp.getWriter().print(json);
	}

}
