<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글목록 (boardList.jsp)</h3>

<p>${searchCondition}</p>
<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option value="">선택하세요</option>
				<option value="T"
					${!empty searchCondition and searchCondition eq 'T' ? 'selected' : '' }>제목</option>
				<option value="W"
					${searchCondition ne null && searchCondition == 'W' ? 'selected' : '' }>작성자</option>
				<option value="TW"
					${not empty searchCondition && searchCondition == 'TW' ? 'selected' : '' }>제목&
					작성자</option>
			</select>
		</div>
		<div class="col-sm-6">

			<input type="text" name="keyword"
				value="${!empty keyword ? keyword : '' }" class="form-control">
		</div>
		<div class="col">
			<input type="submit" value="검색" class="form-control">
		</div>
	</div>
</form>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="bvo" items="${list }">
			<tr>
				<th><a
					href="board.do?keyword=${empty keyword ? '' :keyword }&searchCondition=${empty searchCondition ? '' :searchCondition }&page=${paging.currentPage }&board_No=${bvo.boardNo} ">${bvo.boardNo }</a></th>
				<td>${bvo.title }</td>
				<td>${bvo.writer }</td>
				<td>${bvo.creatioDate }</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
<!-- 번호 -->

<nav aria-label="...">
	<ul class="pagination">
		<c:choose>
			<c:when test="${paging.prev }">
				<li class="page-item">
				<a class="page-link"
					href="boardList.do?keyword=${empty keyword ? '' :keyword }&searchCondition=${empty searchCondition ? '' :searchCondition }&page=${paging.startPage -1}">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">Previous</span>
				</li>
			</c:otherwise>
		</c:choose>

		<c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }"
			step="1">
			<c:choose>
				<c:when test="${paging.currentPage == p }">
					<li class="page-item active" aria-current="page">
						<a class="page-link" href="boardList.do?keyword=${empty keyword ? '' :keyword }&searchCondition=${empty searchCondition ? '' :searchCondition }&page=${p}">${p}</a>
					</li>
				</c:when>

				<c:otherwise>
					<li class="page-item">
						<a class="page-link"href="boardList.do?keyword=${empty keyword ? '' :keyword }&searchCondition=${empty searchCondition ? '' :searchCondition }&page=${p}">${p}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${paging.next }">
				<li class="page-item"><a class="page-link"
					href="boardList.do?keyword=${empty keyword ? '' :keyword }&searchCondition=${empty searchCondition ? '' :searchCondition }&page=${paging.endPage +1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">Next</span>
			</c:otherwise>
		</c:choose>

	</ul>
</nav>
<jsp:include page="../includes/footer.jsp"></jsp:include>