<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	 	<title>게시판</title>
	</head>
	<body>
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<div>
				<%@include file="nav.jsp" %>
			</div>
			<hr />
			
			<section id="container">
				<form role="form" method="get" action="/board/list">
					<table>
						<tr>
							<th>번호</th><th>작성자</th><th>여행일</th><th>등록일</th>
						</tr>
						
						<c:forEach items="${list}" var = "list">
							<tr>
								<td>
									<a href="/readView?boardNum=${list.boardNum}"><c:out value="${list.boardNum}" /></a>
								</td>
								<td><c:out value="${list.memberNum}" /></td>
								<td><fmt:formatDate value="${list.tripdate}" pattern="yyyy-MM-dd"/></td>
								<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
						
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>