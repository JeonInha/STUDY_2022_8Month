<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	out.println("<!DOCTYPE html>");
%>
<html>
<head>
<meta charset="UTF-8">
<title>out 기본 객체</title>
</head>
<body>
	<h1>정적 텍스트</h1>
	<%=1 + 2 + 3%><br />
	<%-- 표현식: 동적 텍스트 --%>
	<%-- 표현식: 동적 텍스트 --%>
	<%
		out.println(1 + 2 + 3);
	out.println("<br />");
	out.println("으아아아아앙");
	// html 형식으로 출력할 수 있는 객체.
	// 보통 특정 조건 아래에서  무언가 출력을 하려고 할 때 사용.
	// 표현식을 쓰지 않아도 괜찮게 동작함.그런 간편함이 있음.
	%>

	<%
		boolean a = true;
	if (a) {
		out.println("<strong><br>참일때 이거 출력</strong>");
	} else {
		out.println("<strong>거짓일 때 이거 출력</strong>");
	}
	%>
	<p>모든 문서 아웃 객체가 출력됩니다.</p>
</body>
</html>