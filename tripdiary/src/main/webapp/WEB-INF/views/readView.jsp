<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link href="${pageContext.request.contextPath}/resources/css/style.css" 
	rel="stylesheet"/>
	
<title>Trip Diary</title>

 <!-- 제이쿼리 -->
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />
	<jsp:include page="common/sidebar.jsp" flush="false" />
    
	<div class="container">
		<a href="/list">목록으로</a>
		<hr />
		<form role="form"  name="readForm" method="get">
			
			<div>
				사진 테스트 : <img alt="" src="<spring:url value='/image/profile_64.png'/>" style="width: 40px; height: 40px; ">  
				<c:out value="${read.nickname}" />
			</div>
			
			<div>
				게시글 사진 - 페이징처리 해야함
			</div>
			
			<div>
				찜하기
			</div>
			
			<div>
				태그
			</div>
			
			<div>
				좋아요
			</div>
			
			<div>
				작성일 : <fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd"/><br>
				여행일 : <fmt:formatDate value="${read.tripdate}" pattern="yyyy-MM-dd"/><br>
				게시글 내용 : <c:out value="${read.content}"></c:out><br><br>
			</div>
			<hr />
			<br><br>
		</form>
			
			
			<!-- 댓글 작성 -->
			<div>
				<form action="/replyWrite" method="post">
					<input type="hidden" name="boardNum" value="${read.boardNum }">
					<input type="hidden" name="memberNum" value="${memberVo.memberNum }">
					
					<input type="text" id="content" name="content">  
					<button type="submit">댓글 작성</button>
				</form>
			</div>
			
		<!-- 댓글 목록 -->
			<div >
			<ol class="replyList">
				<c:forEach items="${replyList}" var="replyList" varStatus="loop">
				
				${replyList.nickname}  
				<fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />   
               <a href="/replyUpdate?replyNum=${replyList.replyNum}&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >수정</a>  
               <c:choose>
					<c:when test="${memberVo.memberNum eq replyList.memberNum }">
						<a href="/replyDelete?replyNum=${replyList.replyNum}&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" onclick="alert('삭제 완료')">삭제</a><br>
					</c:when>
					<c:otherwise>
						<a href="#" onclick="alert('회원 아님')">삭제</a><br>
					</c:otherwise>
				</c:choose>
				
               
		            
				<p>작성 내용 : ${replyList.content}</p>
				
				
				
				
				
				</c:forEach>   
				</ol>
			</div>
	</div>
</body>
</html>