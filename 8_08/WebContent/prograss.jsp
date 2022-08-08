<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<p>로그인 처리 요청이 전달되었습니다.</p>

<%String id = request.getParameter("userId");

// 해당 파라미터가 전달되었으나 입력값이 없으면 "".
// 없는 파라미터 값을 요청하면 null 나옴.
if (id.equals("")) {
	out.println("<p>로그인 실패. 로그인 정보를 입력하세요.</p>");
	response.sendRedirect("./login.jsp");
	// 무조건 루트 주소 써야 함.
} else {
	out.println("<p>"+id+"님, 반갑습니다. </p>");
}
%>

</body>
</html>