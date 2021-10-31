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
		<hr />
		<section id="container">
			<form role="form" method="get">
				<table>
					<tbody>	
						<tr>
							<td>
								작성일 : 
								<fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd"/>					
							</td>
						</tr>		
					</tbody>			
				</table>
			</form>
		</section>
		<hr />
	</div>
</body>
</html>