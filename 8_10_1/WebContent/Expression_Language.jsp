<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language: EL</title>
</head>
<body>
	<p>JSP Expression Language</p>
	<!-- jsp 페이지에서 출력을 도와줌. -->
	${"qwer"} ${123} ${11.22} ${true}
	<br/>
	${ 1+2 }
	${ true || false }
	<!-- 연산도 완전 가능. 관계연산도 오케이 -->
	<br/>
	
	${ pageContext.request.requestURI}
	<!-- 객체에도 접근 가능. 게터라면 get을 안적어도 된다고 함 ..... 근데 헷갈린당 -->


</body>
</html>