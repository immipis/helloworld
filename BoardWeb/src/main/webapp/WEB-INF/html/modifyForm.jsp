<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>수정화면</h3>
<%
BoardVO bvo = (BoardVO) request.getAttribute("modboard");
//피라미터 추가 2024.12.12
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
String pg = (String) request.getAttribute("page");
%>

<form action="modifyBoard.do">

	<input type="hidden" name="boardNum" value="${board.boardNo}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}"> <input
		type="hidden" name="page" value="${page}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo}</td>

			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input name="boardTitle" value="${board.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td class="form-control"><input name="boardContent"
				value="${board.content}"></td>
		</tr>
		<tr>
			<th>작성일시</th>

			<td>${board.creatioDate}</td>
			<th>조회수</th>
			<td>${board.viewCnt}</td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit"
				class="btn btn-warning" value="수정완료"></td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>