<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "showError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러를 발생시킬 페이지</title>
</head>
<body>
	<%
		String name = null;
		System.out.println(name.toString());
	%>
	<!-- 톰캣의 에러메시지는 사용자에게 보여주기 적합하지 않으니까 우리가 새로 만들장! -->

</body>
</html>