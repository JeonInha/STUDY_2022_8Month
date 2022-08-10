<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.form {
	margin: 30px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="form">
		<form action="../insert_Member">
			<label>이름: <input type="text" name="name" /></label><br /> <label>나이:
				<input type="number" name="age" />
			</label><br /> <input type="submit" class="submit" />
		</form>
		<a href="./index.jsp">index 페이지로 돌아가기</a>
	</div>
</body>
</html>