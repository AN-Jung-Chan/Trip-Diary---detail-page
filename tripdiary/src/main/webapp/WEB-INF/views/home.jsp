<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Trip Diary</title>
</head>
<body>
	<c:if test="${member == null }">
	<form role="form" method="post" autocomplete="off" action="/member/login">
		<p>
			<label for="id">아이디</label> 
			<input type="text" id="id" name="id" />
		</p>
		<p>
			<label for="password">비밀번호</label> 
			<input type="password" id="password" name="password" />
		</p>
		<p>
			<button type="submit">로그인</button>
		</p>
		<p>
			<a href="/member/register">회원가입</a>
		</p>
	</form>
	</c:if>
	
	<c:if test="${msg == false }">
		<p style = "color:#f00;">로그인에 실패했습니다. 아이디 또는 비밀번호를 다시 입력해주십시오.</p>
	</c:if>
	
	<c:if test="${member != null }">
	<p>${member.nickname }님 환영합니다.</p>
		<a href="<c:url value='/member/logout'/>">[로그아웃]</a>
		<a href="<c:url value='/board/writeView'/>">[게시글 작성]</a>
		<a href="<c:url value='/board/list'/>">[게시글 목록]</a>
		
	</c:if>
</body>
</html>