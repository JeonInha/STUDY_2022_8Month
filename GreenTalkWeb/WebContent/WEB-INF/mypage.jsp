<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="signUp.*"%>
<%@ page import="java.util.*"%>
<%@ page import="post.*"%>
<%@ page import="signUp.AccManagerDaoImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
<title>그린그린톡.com</title>
</head>
<%
	Account user = (Account) session.getAttribute("user");
%>
<body>
	<div class="container">
		<header>
			<a href="/"><img src="./img/logo1.png" alt="그린그린톡 메인로고"></a>
		</header>
		<nav>
			<ul>
				<li><a href="#!">톡톡하기</a></li>
				<li><a href="#!">탐색하기</a></li>
				<li><a href="#!">검색하기</a></li>
				<li><a href="#!">알림창</a></li>
				<li><a href="#!">마이페이지</a></li>
			</ul>
		</nav>
		<main>
			<div class="mypage_wrap">
				<c:set var="user" value=user />
				<div class="flexBox">
					<h2>이름:</h2>
					<p>${ user.user_name }</p>
				</div>
				<div class="flexBox">
					<h2>아이디:</h2>
					<p>${ user.user_id }</p>
				</div>
			</div>
		</main>
		<footer> </footer>
	</div>
</body>

</html>