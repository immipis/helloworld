package com.yedam.common;

import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data //get set
@AllArgsConstructor //생성자
public class SearchDTO {
	private int page;
	private String searchCondition,keyword;
	
}
