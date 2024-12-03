package com.yedam.board;

import java.util.Date;

import javax.swing.border.Border;

// 등록, 목록

public class BoardExe {
	private Board[] storege;

	public BoardExe() { // 초기화.
		storege = new Board[10];
		storege[0] = new Board(1, "자바는 재밌어", "열심히 합시다", "user01", new Date());
		storege[1] = new Board(2, "아직 화요일이네", "3일 남았네", "user02", new Date());
		storege[2] = new Board(3, "살고싶다고 말해!!!!!", "살고싶어!!!!", "user03", new Date());
	}

	public boolean insertBoard(Board board) { // 등록
		for (int i = 0; i < storege.length; i++) {
			if (storege[i] == null) {
				storege[i] = board;
				return true;
			}
		}
		return false;
	}

	public Board[] boardList() {
		for (int i = 0; i < storege.length-1; i++) {

			for (int j = 0; j < storege.length-1; j++) {
				if(storege[j+1]==null) {
					continue;
				}

				if (storege[j]==null||
						storege[j].getBoardNo()>storege[j+1].getBoardNo()) {
					Board temp = storege[j];
					storege[j] = storege[j+1];
					storege[j+1] = temp;
				}
			}
		}
		return storege;
	}

	// 글번호 가져오는 메소드
	// null이 아닌 카운트에 +1 한값을 반환
	public int getNextNo() {
		int max = 0;
		for (int i = 0; i < storege.length; i++) {
			if (storege[i] != null) {
				if(max<storege[i].getBoardNo()) {
					max = storege[i].getBoardNo();
				}
			}
		}
		return max+1;
	}

	// 삭제
	public boolean deleteBoard(int dleNo) {
		for (int i = 0; i < storege.length; i++) {
			if (storege[i] != null && storege[i].getBoardNo() == dleNo) {
				storege[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean checkResponsibility(int bno,String id) {
		for (int i = 0; i < storege.length; i++) {
			if (storege[i] != null) {
				if (storege[i].getBoardNo() == bno && storege[i].getWriter().equals(id)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean moBoard(int bno,String title,String content) {
		for (int i = 0; i < storege.length; i++) {
			if (storege[i] != null && storege[i].getBoardNo() == bno) {
				storege[i].setTitle(title);
				storege[i].setContent(content);
				return true;
			}
		}
		return false;
	}
	public void sangSeBoGi(int bno) {
		for (int i = 0; i < storege.length; i++) {
			if (storege[i] != null) {
				if(storege[i].getBoardNo() == bno) {
					System.out.println("-------------");
					System.out.println("글번호"+storege[i].getBoardNo()+"작성자"+storege[i].getWriter());
					System.out.println("제목:"+storege[i].getTitle());
					System.out.println("내용:"+storege[i].getContent());
					System.out.println("작성일시:"+storege[i].showInfo2());
				
				}
			}
		}
	}

}
