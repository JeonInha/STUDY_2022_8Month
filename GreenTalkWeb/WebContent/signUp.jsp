<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
<title>그린그린톡.com</title>


<%
	Object prograss = request.getAttribute("progress");
if (prograss != null) {
	if (prograss.equals("NoneValue")) {
		out.println("<script> alert('값을 입력하세요') </script>");
		
	} else if (prograss.equals("ID_exist")) {
		out.println("<script> alert('이미 존재하는 ID입니다.') </script>");
		
	} else if (prograss.equals("checkPw_error")) {
		out.println("<script> alert('pw와 pw확인 불일치.') </script>");
		
	} else if (prograss.equals("signUp_error")) {
		out.println("<script> alert('이유를 알수없는 에러. 다시 시도 바랍니다.') </script>");
	}
}
%>



</head>
<body>
	<div class=container>
		<header>
			<a href="/"><img src="./img/logo1.png" alt="그린그린톡 메인로고"></a>
		</header>
		<main>
			<form class="signUp_box" action="./login" method="post">
					<h4>• ID 입력</h4><strong>• 4~12자, 영소문자와 숫자만 가능</strong>
					<button type="button" class="dc">중복 확인</button>
				<div class="input_box">
					<i class="xi-profile-o"></i><label for="id"> <input
						type="text" name="input_id" placeholder="ID 입력" />
					</label>
				</div>
				<h4>• PW 입력 </h4><strong>• 4~12자, 영소문자와 숫자만 가능</strong>
				<div class="input_box">
					<i class="xi-lock-o"></i> <label for="pw"> <input
						type="password" name="input_pw" placeholder="패스워드 입력" />
					</label>
				</div>
				<h4>• PW 확인</h4>
				<div class="input_box">
					<i class="xi-lock-o"></i> <label for="pw"> <input
						type="password" name="check_pw" placeholder="패스워드 확인" />
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