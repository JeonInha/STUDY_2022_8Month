<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
<title>그린그린톡.com</title>

<%
	// TODO 이거 동작안함 이유 몰겠ㅆ음..
Object error = request.getAttribute("error");
String st = "";
if (error instanceof HashMap) {
	Map<String, String> errorMap = (HashMap<String, String>) error;
	if (errorMap != null) {
		for (String key : errorMap.keySet()) {
			st = st.concat(errorMap.get(key));
			st = st.concat("<br/>");
		}
	}
}
%>



</head>
<body>
<c:if test="${not empty error}">
	<script>window.alert( st )</script>
</c:if>
	<div class=container>
		<header>
			<a href="./timeline"><img src="./img/logo1.png" alt="그린그린톡 메인로고"></a>
		</header>
		<main>
			<form class="signUp_box" action="./letsignup" method="post">
				<h4>• ID 입력</h4>
				<strong>• 영문자 혹은 숫자, 언더바(_)사용가능, 4~12글자 입력.</strong>
				<div class="input_box">
					<i class="xi-profile-o"></i><label for="id"> <input
						type="text" name="input_id" placeholder="ID 입력" required />
					</label>
				</div>
				<h4>• 닉네임 입력</h4>
				<strong>• 영문자 숫자 혹은 한글, 1~8글자 입력.</strong>
				<div class="input_box">
					<i class="xi-lock-o"></i> <label for="nickname"> <input
						type="text" name="input_nickname" placeholder="닉네임 입력" required />
					</label>
				</div>
				<h4>• PW 입력</h4>
				<strong>• 영소문자 혹은 숫자, 4~12글자 입력.</strong>
				<div class="input_box">
					<i class="xi-lock-o"></i> <label for="pw"> <input
						type="password" name="input_pw" placeholder="패스워드 입력" required />
					</label>
				</div>
				<h4>• PW 확인</h4>
				<strong>• pw를 똑같이 입력</strong>
				<div class="input_box">
					<i class="xi-lock-o"></i> <label for="pw"> <input
						type="password" name="check_pw" placeholder="패스워드 확인" required />
					</label>
				</div>
				<button>회원가입</button>
			</form>
		</main>
		<footer>
			<!-- <p>푸터에 들어가야 할 여러가지가 들어갈 예정</p> -->
		</footer>
	</div>
</body>

</html>