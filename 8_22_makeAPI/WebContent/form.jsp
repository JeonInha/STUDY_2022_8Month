<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="text" name="id" id="textID" />
		<button id="CheckIDbtn">아이디 중복 확인</button>
		<br />
		<!-- ajax 라는 기술 사용하기:: 비동기, 사용자 화면에 보이지 않게 요청 보내기 -->
		<input type="submit" />
	</form>
</body>

<script>
	let elem = document.getElementById("CheckIDbtn");
	elem.addEventListener("click", function(e) {
		e.preventDefault();
		e.stopPropagation();
		let inputId = document.getElementById("textID").value;
		
		if (!inputId) {
			return;
		}
		// fatchAPI 사용해보장
		fetch("http://localhost:8080/api/idcheck?id=" + inputId)
		.then((resp) => resp.text())
		.then((json) => {
			let result = JSON.parse(json);
			if (result.duplicate) {
				window.alert("중복");
			} else {
				window.alert("사용가능");
			}
		})
		.catch((e) => console.log(e));
	});
</script>
</html>