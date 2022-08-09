<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "signUp.*"%>
<%@ page import = "DB.*"%>
<%@ page import = "de.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AccManagerDaoImpl ad = new AccManagerDaoImpl();
Account ac = ad.readAccount("inha123");
out.println(ac);

%>
</body>
</html>