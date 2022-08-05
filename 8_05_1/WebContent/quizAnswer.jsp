<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		boolean answer = false;
	String inputAS = request.getParameter("answer");
	String printAS = "";

	if (inputAS.equals("apple")) {
		answer = true;
	}

	if (answer) {
		//	printAS = printAS.concat("정답~~~~");
		printAS = "정답~~~~~~~";
	} else {
		//	printAS = printAS.concat("오답~~~~");
		printAS = "오답~~~~~~~";
	}
	%>


	<h1>
		<strong><%=printAS%></strong>
	</h1>
	<a href="/8_05_1/quiz.jsp">뒤로가기</a>

</body>
</html>