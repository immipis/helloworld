<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>수정화면</h3>
<%BoardVO bvo = (BoardVO) request.getAttribute("modboard");%>
<form action="modifyBoard.do" method="post">

	<input type="hidden" name="boardNum" value="<%=bvo.getBoardNo()%>">
	<table class="table" >
		<tr>
			<th>글번호</th>
			<td><%=bvo.getBoardNo()%></td>

			<th>작성자</th>
			<td><%=bvo.getWriter()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input name="boardTitle" value="<%=bvo.getTitle()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td class="form-control"><input name="boardContent" value="<%=bvo.getContent()%>"></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><%=bvo.getCreatioDate()%></td>
			<th>조회수</th>
			<td><%=bvo.getViewCnt()%></td>
		</tr>
		<tr>
			<td colspan ="4" align ="center">
				<input type="submit" class="btn btn-warning" value="수정완료">
			</td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>