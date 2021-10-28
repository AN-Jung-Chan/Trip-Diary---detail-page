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
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<div>
				<%@include file="board/nav.jsp" %>
			</div>
			<hr />
			
			<section id="container">
				<form role="form"  method="post">
					<table>
						<tbody>
							<tr>
								<td>
									<label for=boardNum>글 번호</label>
									<input type="text" id="boardNum" name="boardNum" value="${read.boardNum}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="memberNum">회원번호</label>
									<input type="text" id="memberNum" name="memberNum" value="${read.memberNum}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label>
									<textarea id="content" name="content">
									<c:out value="${read.content}" /></textarea>
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
			</form>
		</section>
	</div>	
</body>
</html>