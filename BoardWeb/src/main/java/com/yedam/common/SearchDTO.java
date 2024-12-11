package com.yedam.common;

import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SearchDTO {
	private int page;
	private String searchCondition,keyword;
	

}
