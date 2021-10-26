<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip Diary</title>
</head>
<body>
	<form role="form" method="post" autocomplete="off">
		<p>
			<label for="id">아이디</label> 
			<input type="text" id="id" name="id" />
		</p>
		<p>
			<label for="password">패스워드</label> 
			<input type="password" id="password" name="password" />
		</p>
		<p>
			<label for="nickname">닉네임</label> 
			<input type="text" id="nickname" name="nickname" />
		</p>
		
		<p>
			<label for="email">email</label> 
			<input type="text" id="email" name="email" />
		</p>
		
		<p>
			<label for="birthYear">출생년도</label> 
			<input type="text" id="birthYear" name="birthYear" />
		</p>
		
		<p>
			<label for="birth">생일</label> 
			<input type="text" id="birth" name="birth" />
		</p>
		
		<p>
			<label for="gender">성별</label> 
			<input type="checkbox" id="gender" name="gender" value="남">남 
			<input type="checkbox" id="gender" name="gender" value="여">여
		</p>
		
		<p>
			<button type="submit" id="submit">가입</button>
		</p>
		
		<p>
			<a href="/">처음으로</a>
		</p>

	</form>
</body>
</html>