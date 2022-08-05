<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
// directive
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// 자바코드를 적을 수 있는 영역이 이 안에 들어감
	// scriptlet이라고 부름
	// 이걸로 적은 건 페이지 소스보기로 볼 수 없음!
	// 기본적으로는 순차진행
	System.out.println("사용자가 jsp 페이지를 요청하였습니다.");
	int a = 10;
	%>
	
	<%-- 건너뛰는곳은 이렇게 --%>

	<strong><%=java.time.LocalTime.now()%></strong>
	<p>
		jsp 페이지입니다 <br>a의 값은
		<%=a%>입니다.
	</p>
</body>
</html>