package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {
	// 상세정보

	public String loginBoard(String uid, String pw) {
		getConn();
		String sql = "select * from tbl_member where member_id = ? and password = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				return rs.getString("member_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	public int selectCount(SearchDTO search) {
		getConn();
		String sql = "select count(1) from tbl_board ";

		if (search.getSearchCondition() != null && search.getKeyword() != null) {
			if (search.getSearchCondition().equals("T")) {
				sql += " where title like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("W")) {
				sql += " where writer like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("TW")) {
				sql += " where title like '%'||?||'%' or writer like '%'||?||'%'";
			}
		}
		int cnt = 1;
		try {
			psmt = conn.prepareStatement(sql);
			if (search.getSearchCondition() != null && search.getKeyword() != null) {
				if (search.getSearchCondition().equals("T")) {
					psmt.setString(cnt++, search.getKeyword());
				} else if (search.getSearchCondition().equals("W")) {
					psmt.setString(cnt++, search.getKeyword());
				} else if (search.getSearchCondition().equals("TW")) {
					psmt.setString(cnt++, search.getKeyword());
					psmt.setString(cnt++, search.getKeyword());
				}

			}
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

	public BoardVO selectBoard(int boardNo) {
		getConn();
		String sql = "select * from tbl_board where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setBoardNo(rs.getInt("board_no"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setViewCnt(rs.getInt("view_cnt"));
				bVo.setCreatioDate(rs.getDate("creation_date"));
				bVo.setUpdateDate(rs.getDate("update_date"));

				return bVo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	public boolean insertBoard(BoardVO board) {
		getConn();
		String sql = "insert into tbl_board " + "(board_no, title, content, writer) "
				+ " values(board_seq2.nextval,?,?,?) ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate();
			while (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}
	
	//파라메터
	public List<BoardVO> boardList(SearchDTO search) {
		getConn();
		System.out.println("123123" + search);
		String sql = "select b.* "//
				+ "   from (select rownum rn, a.* "//
				+ "         from (select * "//
				+ "               from tbl_board ";//

		// title 검색조건 => title 검색조건에서 칼라
		if (search.getSearchCondition() != null && search.getKeyword() != null) {
			if (search.getSearchCondition().equals("T")) {
				sql += " where title like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("W")) {
				sql += " where writer like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("TW")) {
				sql += " where title like '%'||?||'%' or writer like '%'||?||'%'";
			}
		}
		sql += "   order by board_no desc) a) b "//
				+ "   where b.rn >  (? -1) * 5 "//
				+ "   and   b.rn <= ? * 5";

		List<BoardVO> result = new ArrayList<>();
		int cnt = 1;
		try {
			psmt = conn.prepareStatement(sql);
			if (search.getSearchCondition() != null && search.getKeyword() != null) {
				if (search.getSearchCondition().equals("T")) {
					psmt.setString(cnt++, search.getKeyword());
				} else if (search.getSearchCondition().equals("W")) {
					psmt.setString(cnt++, search.getKeyword());
				} else if (search.getSearchCondition().equals("TW")) {
					psmt.setString(cnt++, search.getKeyword());
					psmt.setString(cnt++, search.getKeyword());
				}

			}

			psmt.setInt(cnt++, search.getPage());
			psmt.setInt(cnt++, search.getPage());

			System.out.println(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreatioDate(rs.getDate("creation_date"));
				brd.setUpdateDate(rs.getDate("update_date"));

				result.add(brd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}

	public boolean updateBoard(BoardVO board) {
		getConn();
		String sql = "update tbl_board set title = ?, content = ? where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			int r = psmt.executeUpdate();
			while (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

}
