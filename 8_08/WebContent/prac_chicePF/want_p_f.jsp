<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뭐가 보고싶니</title>
</head>
<body>
<%
	String prograss = request.getParameter("prograss");
	if (prograss != null) {
		out.println("잘못 입력함");
	}
%>
	<form action = "./prograss_pf.jsp">
		<input type="radio" value="person" name = "radioBtn" /> 사람 <br/>
		<input type="radio" value="fruit" name = "radioBtn" /> 과일<br/>
			<input type = "submit">
	</form>

</body>
</html>