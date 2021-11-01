<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

<title>메인</title>
</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />
    <jsp:include page="common/sidebar.jsp" flush="false" />
	<div class="container">
		<div>
			<%@include file="nav.jsp"%>
		</div>
		<hr />

		<section id="boardList">
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
							<td><c:out value="${list.nickname}" /></td>
							<td><fmt:formatDate value="${list.tripdate}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach> 
				</table>
			</form>
		</section>
		<hr />
	</div>
</body>
</html>