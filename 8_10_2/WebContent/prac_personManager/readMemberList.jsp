<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.container {
	margin: 30px
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>멤버 목록</h2>
		<ul>
			<c:forEach var="member" items = "${ memberList }">
				<li>${member}</li>
				
			</c:forEach>
		</ul>
		<a href="./index.jsp">목록으로 가기</a>
	</div>

</body>
</html>