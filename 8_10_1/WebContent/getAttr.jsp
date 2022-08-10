<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language: EL</title>
</head>
<body>
	<p>${requestScope.name1 }</p>
	<p>${requestScope.name2 }</p>
	<p>${applicationScope.name3 }</p>
	<p>${requestScope.name4 }</p>
	<p>${applicationScope.name1 }</p>
	<!-- 값 설정하는 곳 -->
	<hr/>
	<p>${name1 }</p>
	<p>${name2 }</p>
	<p>${name3 }</p>
	<p>${name4 }</p>
	<!-- 값 출력하는 곳. 영역 신경쓸필요없이 이름만으로도! (지정된 순서대로(더 좁은 범위) 알아서 값을 찾아줌) -->
	<p>${name5 }</p>
	<!-- 없으면 아예 공백 출력 -->
</body>
