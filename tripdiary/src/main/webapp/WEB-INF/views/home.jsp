<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Trip Diary</title>
</head>
<body>
	<c:if test="${loginMember == null }">
	<form role="form" method="post" autocomplete="off" action="/login">
		<p>
			<label for="id">아이디</label> 
			<input type="text" id="id" name="id" />
		</p>
		<p>
			<button type="submit">로그인</button>
		</p>
	</form>
	</c:if>
	
	<c:if test="${msg == false }">
		<p style = "color:#f00;">로그인에 실패했습니다. 아이디를 다시 입력해주십시오.</p>
	</c:if>
	
	<c:if test="${loginMember != null }">
	<p>${loginMember.id }님 환영합니다.</p>
		<a href="<c:url value='/list'/>">[게시글 목록]</a>
		<a href="<c:url value='/logout'/>">[로그아웃]</a>
		
	</c:if>
</body>
</html>