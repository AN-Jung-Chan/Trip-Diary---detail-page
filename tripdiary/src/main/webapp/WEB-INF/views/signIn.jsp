<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="root">
		<h2>로그인 페이지</h2>
		
		<form name='homeForm' method="post" action="/signIn">
			<div>
				<label for="id"></label> 
				<input type="text" id="id" name="id">
			</div>
			<div>
				<label for="password"></label> 
				<input type="password" id="password" name="password">
			</div>
			<br>
			<div>
				<input type="submit" value="Sing In">
			</div>
		</form>
	</div>




</body>
</html>