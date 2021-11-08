<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="container">
		<form role="form" method="post" autocomplete="off">
			<input type="hidden" id="replyNum" name="replyNum" value="${selectReply.replyNum}" readonly="readonly" /> 
			<input type="hidden" id="boardNum" name="boardNum" value="${read.boardNum}" readonly="readonly" />
			<input type="hidden" id="memberNum" name="memberNum" value="${memberVo.memberNum }" readonly="readonly">
			
			<textarea name="content">${selectReply.content }</textarea><br><br>
			<input type="submit" value="작성" >
		</form>
	</div>	
</body>
</html>