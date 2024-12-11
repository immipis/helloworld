package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	int startPage, endPage, currentPage; //현재 페이지를 기준으로 0~10
	boolean prev,next;
	
	public PageDTO(int page,int totalCnt){
		this.currentPage = page;
		this.endPage = (int) Math.ceil(page / 10.0)*10;
		this.startPage = this.endPage - 9;
		
		//실제 마지막 페이지 계산
		int realEnd =(int) Math.ceil(totalCnt /5.0);//87
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage>1;
		this.next = this.endPage < realEnd ? true : false;
	}
	
}
