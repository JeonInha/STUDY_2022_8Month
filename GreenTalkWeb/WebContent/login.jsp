<%@page import="de.Static"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
<title>그린그린톡.com</title>
</head>

<%
	Object prograss = request.getAttribute("progress");
if (prograss != null) {
	if (prograss.equals("None")) {
		out.println("<script> alert('값을 입력하세요') </script>");
	} else if (prograss.equals("Fail")) {
		out.println("<script> alert('로그인 실패. 잘못된 정보 입력.') </script>");
	}
}
%>

<body>
	<div class=container>
		<header>
			<a href="/"><img src="./img/logo1.png" alt="그린그린톡 메인로고"></a>
		</header>
		<main>
			<form class="login_box" action="./home" method="post">
				<div class="input_box">
					<i class="xi-profile-o"></i> <label for="id"> <input
						type="text" name="input_id" placeholder="ID 입력" />
					</label>
				</div>
				<div class="input_box">
					<i class="xi-lock-o"></i> <label for="pw"> <input
						type="password" name="input_pw" placeholder="패스워드 입력" />
					</label>
				</div>
				<button>LOGIN</button>
			</form>
			<div class="signUp_box">
				<p>
					회원이 아니신가요?<a href="signUp.jsp">회원가입</a>
				</p>
			</div>

		</main>
		<footer>
			<!-- <p>푸터에 들어가야 할 여러가지가 들어갈 예정</p> -->
		</footer>
	</div>
</body>

</html>