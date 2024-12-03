package com.yedam.board;

import java.util.Date;
import java.util.Scanner;

public class MainExe {
	static MemberExe mexe = new MemberExe(); // 인스턴스 생성해야댐
	static BoardExe bexe = new BoardExe();
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		boolean run = true;

		while (run) {
			System.out.println("1.회원등록 2.회원목록 3.게시글등록 9.종료");
			System.out.print("선택 >>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("회원 아이디>>");
				String id = scn.nextLine();
				System.out.print("회원 비밀번호>>");
				String pw = scn.nextLine();
				System.out.print("회원 이름>>");
				String name = scn.nextLine();
				System.out.print("회원 연락처>>");
				String phone = scn.nextLine();

				boolean result = mexe.addMember(new Member(id, pw, name, phone));

				if (result) {
					System.out.println("정상 등록되었습니다");
				} else {
					System.out.println("등록 처리되지 않았습니다");
				}
				break;
			case 2: {
				Member[] list = mexe.memberList();
				for (Member member : list) {
					if (member != null) {
						System.out.println(member.showInfo());
					}
				}
				break;
			}
			case 3: {
				System.out.print("로그인 아이디>>");
				id = scn.nextLine();
				System.out.print("로그인 비밀번호>>");
				pw = scn.nextLine();
				result = mexe.login(id, pw);

				if (result) {
					boardMethod(id);
				} else {
					System.out.println("아이디나 비번이 잘못됨");
				}
				break;
			}
			case 9: {
				run = false;
			}

			default:

			}

		}
		System.out.println("프로그램 끝.");
	}

	// 게시판 관련.
	public static void boardMethod(String id) {
		// 1추가 2목록 3수정 4삭제 9.상위 메뉴로
		boolean run = true;
		while (run) {
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 9.상위 메뉴로");
			System.out.print("선택 >>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				int bno = bexe.getNextNo();
				String writer = id;
				System.out.print("글 제목 >>");
				String title = scn.nextLine();
				System.out.print("글내용 >>");
				String content = scn.nextLine();
				Date wdate = new Date();

				Board board = new Board(bno, title, content, writer, wdate);

				if (bexe.insertBoard(board)) {
					System.out.println("정상등록됨");
				} else {
					System.out.println("자리없음");
				}
				break;

			case 2: {
				Board[] list = bexe.boardList();
				for (Board brd : list) {
					if (brd != null) {
						System.out.println(brd.showInfo());
					}
				}
				break;
			}
			case 3: {
				System.out.print("수정할 글 번호 >>");
				bno = Integer.parseInt(scn.nextLine());

				if (!bexe.checkResponsibility(bno, id)) {
					System.out.println("권한이 없");
					break;
				}

				System.out.print("수정할 제목 >>");
				title = scn.nextLine();
				System.out.print("수정할 내용 >>");
				content = scn.nextLine();
				if (bexe.moBoard(bno, title, content)) {
					System.out.println("수정댐");
				} else {
					System.out.println("삭제한 글번호를 확인하세요");
				}
				break;
			}
			case 4: {
				System.out.print("삭제할 글 번호 >>");
				bno = Integer.parseInt(scn.nextLine());
				if (!bexe.checkResponsibility(bno, id)) {
					System.out.println("권한이 없음");
					break;
				}

				if (bexe.deleteBoard(bno)) {
					System.out.println("삭제댐");
				} else {
					System.out.println("안댐");
				}
				break;
			}
			case 9: {
				return;
			}

			}
		}
	}
}
