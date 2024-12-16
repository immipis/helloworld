<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>상세보기</h3>

<form action="modifyForm.do">
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
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><img src="images/${board.img }" width="100px"></td>
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

<!-- 댓글시작 -->
<style>
div.reply .content ul {
	list-style-type: none;
}

div.reply .content span {
	display: inline-block;
}
</style>


<div class="reply">
	<div class="header">
		댓글내용 : <input type="text" id="reply" class="col-sm-8">
		<button id="addBtn" class="col-sm-2 btn btn-primary">댓글 등록</button>
	</div>
	<div class="content">
		<ul class="title">
			<li><span class="col-sm-2">글번호</span> <span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span> <span class="col-sm-2">삭제</span></li>

		</ul>
		<ul class="list"></ul>
	</div>
	<div class="footer">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
</div>
<script>
	let bno = "${board.boardNo}"//원본글 본호
	let logId = "${logId }"
</script>
<script src="js/board.js"></script>


<jsp:include page="../includes/footer.jsp"></jsp:include>