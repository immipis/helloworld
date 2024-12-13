package com.yedam.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// vo = 밸류 오브젝트
// lombok 사용 1. Lombok 설치
			//2. Lombok 라이브러리 다운
			//3. 이클립스 재실행
			//4. 어노ㅔ이션
@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private Date creatioDate;
	private Date updateDate;
	private String img;
}
