<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="math.MyMath" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MyMath a = new MyMath();
	int b = a.sum(10, 20);
%>
<%= b %>
</body>
</html>