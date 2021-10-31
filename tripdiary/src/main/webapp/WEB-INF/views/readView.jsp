<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip Diary</title>
</head>
<body>
	<div class="container">
		<a href="/list">목록으로</a>
		<hr />
		<form role="form" method="get">
			
			프로필사진 : <br>
			닉네임 : <c:out value="${read.nickname}" /><br><br>
			
			찜하기, 게시글 사진, 태그, 좋아요 들어와야함<br><br>
			
			작성일 : <fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd"/><br>
			여행일 : <fmt:formatDate value="${read.tripdate}" pattern="yyyy-MM-dd"/><br>
			게시글 내용 : <c:out value="${read.content}"></c:out><br><br>
			<hr />
			<br><br>
			사진 테스트 :<br> <img alt="" src="<spring:url value='/image/test.jpg'/>" style="width: 400px; height: 400px; ">
			
			
		<!-- 댓글 작성 -->
		</form>
		<form action="/replyWrite" method="post">
			<input type="hidden" name="boardNum" value="${read.boardNum }">
			<input type="hidden" name="memberNum" value="${memberVo.memberNum }">
			
			<input type="text" id="content" name="content"><br>
			<button type="submit">댓글 작성</button>
		</form>
		
		<form action="/replyUpdate" method="get">
		
		</form>
		
		<!-- 댓글 -->
			<div id="reply">
				<ol class="replyList">
					<c:forEach items="${replyList}" var="replyList" varStatus="loop">
					<p>
					작성자 : ${replyList.nickname}<br />
					작성 날짜 :  <fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
					</p>
				
					<p>${replyList.content}</p>
						<button onclick='location.href="/replyUpdateView?replyNum=${replyList.replyNum}"'>수정</button>
						<input type="button" onclick='location.href="/replyDeleteView?replyNum=${replyList.replyNum}"' value="삭제">
					</c:forEach>   
				</ol>
			</div>
	</div>
</body>
</html>