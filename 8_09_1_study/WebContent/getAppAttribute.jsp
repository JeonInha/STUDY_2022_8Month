<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>어플리케이션 기본객체에 설정된 값 확인 페이지</p>
<!-- 값을 설정하는 페이지를 서버 구동할 때 먼저 열어야 함. -->


<%
out.println(application.getAttribute("myStr"));
out.println(application.getAttribute("myInt"));
%>

</body>
</html>