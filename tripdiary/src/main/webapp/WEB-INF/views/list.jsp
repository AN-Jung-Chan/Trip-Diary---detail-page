<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta charset="UTF-8">

<title>메인</title>
</head>
<body>
	<div id="root">
		<div>
			<%@include file="nav.jsp"%>
		</div>
		<hr />

		<section id="container">
			<form role="form" method="get" action="/list">
				<table>
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>여행일</th>
						<th>등록일</th>
					</tr>

					<c:forEach items="${list}" var="list">
						<tr>
							<td><a href="/readView?boardNum=${list.boardNum}">
							<c:out value="${list.boardNum}" /></a></td>
							<td><c:out value="${list.memberNum}" /></td>
							<td><fmt:formatDate value="${list.tripdate}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach> 
				</table>
			</form>
		</section>
		<hr />
	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/popper.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>