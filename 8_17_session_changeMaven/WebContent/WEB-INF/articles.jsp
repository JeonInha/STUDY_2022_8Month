<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<style>
	.box {
	display: flex;
	}
</style>
<title>게시글 목록</title>
</head>
<body>
	<c:if test="${ not empty articles }">
		<c:forEach var="a" items="${ articles }">
			<div class="box">
				<h2>${ a.title }</h2>
				<p>${ a.content }</p>
			</div>
		</c:forEach>
	</c:if>
</body>
</html>