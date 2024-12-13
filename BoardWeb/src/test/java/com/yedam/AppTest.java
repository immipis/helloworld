package com.yedam;

import java.util.Iterator;

import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyVO rv = new ReplyVO();
		rv.setBoardNo(1492);
		rv.setReply("테스트 123");
		rv.setReplyer("124124");
		
		ReplyDAO rDao = new ReplyDAO();
		
		
		if (rDao.insertReply(rv)) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
		
		
		
		
		for(ReplyVO rVo : rDao.selectList(224)) {
			System.out.println(rVo.toString());
		}
	}
}
