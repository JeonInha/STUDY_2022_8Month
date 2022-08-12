<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러를 보여줄 페이지</title>
</head>
<body>
	<p>
		요청 처리 중 에러가 발생하였습니당! 다시 시도해주세용!~ 
		<br /> 해당에러가 계속된다면 담당자에게 문의해주세용~~~~ 
		<br /> 담당자는 연락처같은거 없지만~~~~~~~~~~
	</p>

	<%= exception.getClass() %>
	<!-- 이렇게 익셉션 개체로도 확인가능함. -->
	
</body>
</html>