package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.common.DAO;
import com.yedam.vo.ReplyVO;

// 댓글 목록 등록 삭제

public class ReplyDAO extends DAO {
	String query = "select a.* "
			+ "from(select /*+ INDEX(r PK_REPLY)*/ rownum rn, r.* "
			+ "     	from tbl_reply r "
			+ "     	where board_no = ?) a "
			+ "		where a.rn > (? -1) * 5 "
			+ "		and  a.rn <= ? * 5";
	

	String insertQuery = "insert into tbl_reply (reply_no,reply,replyer,board_no)"
			+ "values(?,? ,? ,? )";
	String deleteQuery = "delete from tbl_reply where reply_no = ?";

	//전채 댓글 건수
	String replyCount = "select count(1) from tbl_reply where board_no = ?";
	
	String chartQuery ="select board_no || '번 글' as boardNo, count(1) as cnt from tbl_reply group by board_no ";
	
	//플캘린더
	//일정삭제
	public boolean deleteEvent(String title) {
		getConn();
		System.out.println(title);
		String sql ="delete from tbl_events "
				+ " where title = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,title);

			int r =psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	
	
	//일정등록
	public boolean insertEvent(Map<String, String> map) {
		getConn();
		System.out.println(map);
		String sql ="insert into tbl_events (title, start_date, end_date)"
				  + " values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,(String) map.get("title"));
			psmt.setString(2, map.get("start"));
			psmt.setString(3, map.get("end"));
			
			int r =psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	
	public List<Map<String, Object>> calendarData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		getConn();
		
		try {
			psmt = conn.prepareStatement("select title ,start_date, end_date from tbl_events");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("title", rs.getString("title"));
				map.put("start", rs.getString("start_date"));
				map.put("end", rs.getString("end_date"));
				list.add(map);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return list;
	}
	
	// 차트 데이터
	public List<Map<String, Object>> chartData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		getConn();
		try {
			psmt = conn.prepareStatement(chartQuery);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("boardNo",rs.getString("boardNo"));
				map.put("cnt",rs.getInt("cnt"));
				
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	
	
	public int selectReplyCount(int boardNo) {
		
		getConn();
		try {
			psmt = conn.prepareStatement(replyCount);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	
	public boolean insertReply(ReplyVO rvo) {
		getConn();
		try {
			psmt = conn.prepareStatement("select reply_seq.nextval from dual");
			rs = psmt.executeQuery();
			int rno = 0; // 시퀀스를 먼저 생성 해서 rvo에 저장
			if (rs.next()) {
				rno = rs.getInt(1);
				System.out.println(rno);
				rvo.setReplyNo(rno);
			}
			psmt = conn.prepareStatement(insertQuery);
			psmt.setInt(1, rno);
			psmt.setString(2, rvo.getReply());
			psmt.setString(3, rvo.getReplyer());
			psmt.setInt(4, rvo.getBoardNo());
			int a = psmt.executeUpdate();
			System.out.println(a);
			if (a > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	public boolean deleteReply(int replyNo) {
		getConn();
		try {
			psmt = conn.prepareStatement(deleteQuery);
			psmt.setInt(1, replyNo);
			int a = psmt.executeUpdate();
			if (a > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	public List<ReplyVO> selectList(int boardNo, int page) {
		getConn();
		List<ReplyVO> rlist = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, boardNo);
			psmt.setInt(2, page);
			psmt.setInt(3, page);

			rs = psmt.executeQuery();

			while (rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setReplyNo(rs.getInt("reply_no"));
				rvo.setReply(rs.getString("reply"));
				rvo.setReplyer(rs.getString("replyer"));
				rvo.setReplyDate(rs.getDate("reply_date"));
				rvo.setBoardNo(rs.getInt("board_no"));

				rlist.add(rvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return rlist;
	}
}
