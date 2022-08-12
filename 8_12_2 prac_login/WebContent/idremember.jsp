<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
<%
	Cookie[] c = request.getCookies();
	for (Cookie ck : c) {
		
		if (ck.getName().equals("rememberme")) {
			request.setAttribute("idvalue", URLDecoder.decode(ck.getValue(), "utf-8"));
		}
	}
%>
	<form action="./login" method = "post">
		<input type="text" name="id" value = ${ idvalue } />
		<input type="password" name="password"/>
		<input type="checkbox" name="rememberme"/>
		<input type="submit"/>
	</form>
</body>
</html>