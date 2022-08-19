<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/talktalk.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<header>
			<a href="./letslogin"><img src="./img/logo1.png" alt="그린그린톡 메인로고"></a>
		</header>
		<nav>
			<ul>
				<li><a href="./letslogin">톡톡하기</a></li>
				<li><a href="#!">탐색하기</a></li>
				<li><a href="#!">검색하기</a></li>
				<li><a href="#!">알림창</a></li>
				<li><a href="./gomypage">마이페이지</a></li>
			</ul>
		</nav>
		<main>
			<form action="./writeTalkTalk">
				<p>
					글쓰기:<br />
					<textarea name="content" rows="5" cols="30"> 무슨 일이 일어나고 있나요? </textarea>
				</p>
				<input type="submit" value="새 글 등록">
			</form>

		</main>
	</div>
</body>
</html>