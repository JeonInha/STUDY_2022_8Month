<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 리퀘스트 객체는 사용자의 한번의 요청에 대해서만 유지됨. 한번 셋하고 두번 겟 할 수 없음.... -->
<%
	request.setAttribute("reqAttr", "요청 객체에 존재하는 값");
	request.setAttribute("reqInt", 22);

%>

<%= request.getAttribute("reqAttr") %>
<%= request.getAttribute("reqInt") %>

</body>
</html>