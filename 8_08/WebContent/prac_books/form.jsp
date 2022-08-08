<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책을 입력하자 짠짠짠</title>
</head>
<body>
	<form action = "./books.jsp">
		<label>몇페이지를 볼까?  <input type = "number" name="page"/></label><br>
		<label>몇페이지씩 볼까?  <input type = "number" name="pageper"/></label><br>
		<input type = "submit"/>
	</form>
</body>
</html>