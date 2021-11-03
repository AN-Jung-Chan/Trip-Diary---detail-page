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
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Neucha' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/resources/css/style.css" 
	rel="stylesheet"/>

<!-- 보드 이미지 슬라이드 -->
<!-- 제이쿼리 -->
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

	
<title>Trip Diary</title>
<link href="${pageContext.request.contextPath}/resources/css/slide.css" rel="stylesheet"/>

 	
</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />
	<jsp:include page="common/sidebar.jsp" flush="false" />
    
	<div class="container">
		<a href="/list">목록으로</a>
		<hr />
		<form role="form"  name="readForm" method="get">
			<div>
				<img alt="" src="<spring:url value='/image/profile_64.png'/>" style="width: 40px; height: 40px; ">  
				<c:out value="${read.nickname}" />
				
				<div> 보드 이미지 : 
					<c:forEach items="${boardImgList }" var="boardImgList" varStatus="loop">
					<c:out value="${boardImgList.storeFileName}.${boardImgList.fileType}" />
					</c:forEach>
				</div>
			</div>
			
			<div id="wrapper">
		      <div id="slider-wrap">
		          <ul id="slider"  style="padding-left: 0;">
		             <li>           
						<img alt="" src="<spring:url value='/image/test1.png'/>" style="object-fit : cover">
		             </li>
		             
		             <li>
						<img alt="" src="<spring:url value='/image/test2.png'/>" style="object-fit : cover">
				     </li>
		             
		             <li>
						<img alt="" src="<spring:url value='/image/test3.jpg'/>" style="object-fit : cover">
		             </li>
		             
		             <li>
						<img alt="" src="<spring:url value='/image/test4.jpg'/>" style="object-fit : cover">
		             </li>
		          </ul>
		          
		           <!--controls-->
		          <div class="btns" id="next"><i class="fa fa-arrow-right"></i></div>
		          <div class="btns" id="previous"><i class="fa fa-arrow-left"></i></div>
		          
		          <div id="pagination-wrap">
		            <ul>
		            </ul>
		          </div>
		          <!--controls-->  
		      </div>
		   </div>
			
			
			<!-- 찜하기 -->
			<div>
				<c:choose>
					<c:when test="${selectPick.memberNum eq memberVo.memberNum && selectPick.boardNum eq read.boardNum}">
						<a href="/readView?pickNum=${insertPick.pickNum}&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >없음</a>
					</c:when>
					<c:otherwise>
						<a href="/readView?pickNum=${deletePick.pickNum}&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >있음</a>
					</c:otherwise>
				</c:choose>
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
		
			<div>
				
				
				
			</div>
			
			<!-- 댓글 작성 -->
			<div>
				<form action="/replyWrite" method="post">
					<input type="hidden" name="boardNum" value="${read.boardNum }">
					<input type="hidden" name="memberNum" value="${memberVo.memberNum }">
					
					<input type="text" id="content" name="content">  
					<button type="submit">작성</button>
				</form>
			</div>
			
		<!-- 댓글 목록 -->
			<div >
			<ol class="replyList">
				<c:forEach items="${replyList}" var="replyList" varStatus="loop">
				
				${replyList.nickname}  
				<fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd HH:mm" />   
               <a href="/replyUpdate?replyNum=${replyList.replyNum}&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >수정</a>  
               
               <!-- c:choose 예시  -->
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
	
	
	<script type="text/javascript">
	//current position
	var pos = 0;
	//number of slides
	var totalSlides = $('#slider-wrap ul li').length;
	//get the slide width
	var sliderWidth = $('#slider-wrap').width();


	$(document).ready(function(){
	  
	  
	  /*****************
	   BUILD THE SLIDER
	  *****************/
	  //set width to be 'x' times the number of slides
	  $('#slider-wrap ul#slider').width(sliderWidth*totalSlides);
	  
	    //next slide  
	  $('#next').click(function(){
	    slideRight();
	  });
	  
	  //previous slide
	  $('#previous').click(function(){
	    slideLeft();
	  });
	  
	  
	  
	  /*************************
	   //*> OPTIONAL SETTINGS
	  ************************/
	  //automatic slider
	  //var autoSlider = setInterval(slideRight, 3000);
	  
	  //for each slide 
	  $.each($('#slider-wrap ul li'), function() { 

	     //create a pagination
	     var li = document.createElement('li');
	     $('#pagination-wrap ul').append(li);    
	  });
	  
	  //counter
	  countSlides();
	  
	  //pagination
	  pagination();
	  
	  //hide/show controls/btns when hover
	  //pause automatic slide when hover
	  $('#slider-wrap').hover(
	    function(){ $(this).addClass('active'); clearInterval(autoSlider); }, 
	    function(){ $(this).removeClass('active'); autoSlider = setInterval(slideRight, 3000); }
	  );
	  
	  

	});//DOCUMENT READY
	  


	/***********
	 SLIDE LEFT
	************/
	function slideLeft(){
	  pos--;
	  if(pos==-1){ pos = totalSlides-1; }
	  $('#slider-wrap ul#slider').css('left', -(sliderWidth*pos));  
	  
	  //*> optional
	  countSlides();
	  pagination();
	}


	/************
	 SLIDE RIGHT
	*************/
	function slideRight(){
	  pos++;
	  if(pos==totalSlides){ pos = 0; }
	  $('#slider-wrap ul#slider').css('left', -(sliderWidth*pos)); 
	  
	  //*> optional 
	  countSlides();
	  pagination();
	}



	  
	/************************
	 //*> OPTIONAL SETTINGS
	************************/
	function countSlides(){
	  $('#counter').html(pos+1 + ' / ' + totalSlides);
	}

	function pagination(){
	  $('#pagination-wrap ul li').removeClass('active');
	  $('#pagination-wrap ul li:eq('+pos+')').addClass('active');
	}
	    
	
	</script>
</body>
</html>