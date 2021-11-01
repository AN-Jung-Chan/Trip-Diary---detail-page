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

 <!-- 제이쿼리 -->
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

</head>



<body>
	<div class="container">
		<form role="form" method="post">
	    
			<input type="hidden" id="replyNum" name="replyNum" value="${selectReply.replyNum}" readonly="readonly" /> 
			<input type="hidden" id="boardNum" name="boardNum" value="${read.boardNum}" readonly="readonly" />
			<input type="hidden" id="memberNum" name="memberNum" value="${memberVo.memberNum }" readonly="readonly">
		   
		  
		   <br><br>
		   
		   <input type="submit" value="삭제">
		   
		   
		   
		   <!--  
		   <p>
		    <button type="submit">삭제</button>
		    <button type="button" id="cancel_btn">취소</button>
		    
		    <script>
		    // 폼을 변수에 저장
		    var formObj = $("form[role='form']"); 
		    
		    // 취소 버튼 클릭
	    	$("#cancel_btn").click(function(){   
	    		 self.location = "/readView?boardNum=${selectReply.boardNum}"
	    	});
		    </script>
			</p> 
		    -->
		</form>
	</div>	
</body>
</html>