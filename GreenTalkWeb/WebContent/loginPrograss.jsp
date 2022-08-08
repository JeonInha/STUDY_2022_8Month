<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="signUp.AccManagerDaoImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		AccManagerDaoImpl acdi = new AccManagerDaoImpl();

	String inputId = request.getParameter("input_id");
	String inputPw = request.getParameter("input_pw");

	boolean loginCheck = acdi.getIdCheck(inputId);
	boolean getloginYN = acdi.getLogin(inputId, inputPw);

	if (inputId == null || inputId.length() == 0 || inputPw == null || inputPw.length() == 0) {
		response.sendRedirect("./login.jsp?prograss=none");
	} else if (!loginCheck || !getloginYN) {
		response.sendRedirect("./login.jsp?prograss=fail");
	} else {
		response.sendRedirect("./main.jsp");
	}
	%>

</body>
</html>