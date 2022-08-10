<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager</title>
</head>
<body>

<!-- 페이지 이동을 제공하는 index.html 작성

a. 사람등록페이지(입력양식제공)
->action = mapping 된 servlet
->service 메소드 {
db행을 추가
redirect 응답 (사람 목록 페이지)
}

b.사람 목록페이지
->mapping된 servlet
->service 메소드 {
db 목록 읽기
forward 사람 목록을 보여주는(view) jsp페이지 !
} -->

	<ul>
		<li><a href="insertMemberForm.jsp">회원 등록하기</a></li>
		<li><a href="./read_member">회원 목록 보기</a></li>
	</ul>
</body>
</html>