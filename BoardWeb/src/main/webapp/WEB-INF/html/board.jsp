<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>상세보기</h3>

<form action="modifyForm.do">
	<input type="hidden" name="boardNum" value="${board.boardNo}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="page" value="${page}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo}</td>

			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td class="form-control">${board.content}</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>${board.creatioDate}</td>
			<th>조회수</th>
			<td>${board.viewCnt}</td>
		</tr>
		<tr>
			<td colspan="4" align="center"><c:choose>
					<c:when test="${!empty logId and logId eq board.writer }">
						<input type="submit" class="btn btn-warning" value="수정화면">
					</c:when>
					<c:otherwise>
						<input disabled type="submit" class="btn btn-danger" value="수정화면">
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>