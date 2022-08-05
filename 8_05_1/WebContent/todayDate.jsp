<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	// 임포트 여기서 이렇게
	<%@ page import = "java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p>
		오늘의 날짜는
		<%=LocalDate.now()%>
		입니다.
	</p>
</body>
</html>