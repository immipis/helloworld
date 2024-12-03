package com.yedam.board;

import java.util.Date;

//게시글 번호, 제목 , 내용, 작성자, 등록일시


public class Board {
	private int boardNo;//게시글 번호
	private String title;//제목
	private String content;// 네영
	private String writer;//회원 아이디
	private Date writerDate;//등록일시
	
	public Board() {
		
	}
	public Board(int boardNo,String title,String content,String writer,Date writerDate){
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writerDate = writerDate;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriterDate(Date writerDate) {
		this.writerDate = writerDate;
	}
	public Date getWriterDate() {
		return writerDate;
	}
	
	public String showInfo() {
		String yyyymmdd = writerDate.getYear()+1900 +"년 "+ (writerDate.getMonth()+1)+"월 "+writerDate.getDate()+"일 "
				+writerDate.getHours()+"시 "+writerDate.getMinutes() +"분 "+writerDate.getSeconds()+"초 ";
		return "  "+boardNo+"  "+title+"  "+writer+"  "+ yyyymmdd;
	}
	public String showInfo2() {
		String yyyymmdd = writerDate.getYear()+1900 +"년 "+ (writerDate.getMonth()+1)+"월 "+writerDate.getDate()+"일 "
				+writerDate.getHours()+"시 "+writerDate.getMinutes() +"분 "+writerDate.getSeconds()+"초 ";
		return yyyymmdd;
	}
}
