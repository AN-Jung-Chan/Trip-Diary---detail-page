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
	<div id="root">
		<header>
		</header>
			<a href="/board/list">목록</a>
			<hr/>
			<section id="container">
				<form role="form"  method="post">
				<table>
					<tbody>
						<tr>
							<td>
								<label for="content">작성자</label>
								<c:out value="${read.nickname}" />
							</td>
						</tr>
						<tr>
							<td>
								<c:out value="${read.content}" />
							</td>
						</tr>
						
						<tr>
							<td>
								<label for="regdate">작성날짜</label>
								<fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd"/>					
							</td>
						</tr>		
						
						<tr>
							<td>
								<label for="tripdate">여행날짜</label>
								<fmt:formatDate value="${read.tripdate}" pattern="yyyy-MM-dd"/>					
							</td>
						</tr>	
					</tbody>			
				</table>
				
			<!-- 댓글 목록 [순서 작성자, 작성시간  그 아래 작성내용] -->
			<div id="reply">
  				<ol class="replyList">
    				<c:forEach items="${replyList}" var="replyList">
        				<p>
        				작성자 : <c:out value="${replyList.nickname}" /><br/>
        				작성시간 : <fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd HH:mm:ss" /><br/>
        				</p>
        				<p>작성내용 : <c:out value= "${replyList.content}" /></p>
    					</c:forEach>   
  					</ol>
				</div>
			</form>
			
			<!-- 댓글 작성 [글만 받아오기] -->
			<form name="replyForm" action="/replyWrite" method="post">
			  <input type="hidden" id="replyNum" name="replyNum" value="${read.replyNum}" />
			  <input type="hidden" id="boardNum" name="boardNum" value="${read.boardNum}" />
			  <input type="hidden" id=memberNum name="memberNum" value="${read.memberNum}" />
			
			  <div>
			    <label for="content">댓글 내용</label>
			    <input type="text" id="content" name="content" />
			  </div>
			 	 <input type="submit" value="작성">
			</form>
		</section>
	</div>	
</body>
</html>