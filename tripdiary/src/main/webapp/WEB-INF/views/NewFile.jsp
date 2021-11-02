<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 슬라이드 -->
	<script src="/resources/js/slideShow.js"></script>
</head>
<body>
	<div id="slidShow">
		<ul class="slides"> 
			<li><img alt="" src="<spring:url value='/image/flower.jpg'/>"></li>
			<li><img alt="" src="<spring:url value='/image/fox.jpg'/>"></li>
			<li><img alt="" src="<spring:url value='/image/lightning.jpg'/>"></li>
			<li><img alt="" src="<spring:url value='/image/moon.jpg'/>"></li>
			<li><img alt="" src="<spring:url value='/image/nature.jpg'/>"></li>
			<li><img alt="" src="<spring:url value='/image/space.jpg'/>"></li>
		</ul> 
		<p class="controller"> 
			<!-- &lang: 왼쪽 방향 화살표 &rang: 오른쪽 방향 화살표 --> 
			<span class="prev">&lang;</span> <span class="next">&rang;</span> 
		</p> 
	</div> 
</body>
</html>