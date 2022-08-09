<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여길 봐조요!</title>
</head>
<body>
<p>정보</p>
<p>연산의 결과</p>
<%-- <%= request.getParameter("result") %> --%>
<%= application.getAttribute("result") %>
<%= request.getAttribute("result") %>

</body>
</html>