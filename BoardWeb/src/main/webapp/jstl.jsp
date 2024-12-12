<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL ㅕㅂ습</title>
</head>
<body>
	<!-- 1. jstl 라이브러리가 있어야 함 -->
	<!-- 2. jstl 태그 지시자 선언 -->
	<c:set var="myName" value="홍길동"></c:set>
	<c:out value="${myName}"></c:out>

	<c:set var="myAge" value="10"></c:set>
	<h3>
		<c:out value="${myAge}"></c:out>
	</h3>

	<c:if test="${myAge>=20}">
		<p>성인입니다</p>
	</c:if>

	<c:choose>
		<c:when test="${myAge>=20}">
			<p>성인입니다</p>
		</c:when>
		<c:otherwise>
			<p>미성년입니다</p>
		</c:otherwise>
	</c:choose>

	<!-- score = 85 저장 -->
	<!-- score가 90이상이면 a 80이상이면 b 70이상이면c 그외 d -->
	<c:set var="score" value="90"></c:set>
	<c:choose>
		<c:when test="${score>=90}">
			<p>A</p>
		</c:when>
		<c:when test="${score>=80}">
			<p>B</p>
		</c:when>
		<c:when test="${score>=70}">
			<p>C</p>
		</c:when>
		<c:otherwise>
			<p>D</p>
		</c:otherwise>
	</c:choose>
	
	<!-- 반복문 for(int i = 0 i<10 i++)-->
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:if test="${i%2 == 0}">
			<p><c:out value="8 * ${i } = ${8*i }"/></p>
		</c:if>
	</c:forEach>
</body>
</html>