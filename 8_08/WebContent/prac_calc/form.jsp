<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산을 해보자 짠짠짠</title>
</head>
<body>
	<form action = "./calc.jsp">
		<label>숫자 1  <input type = "number" name="num1"/></label><br>
		<label>숫자 2  <input type = "number" name="num2"/></label><br>
		<label>더하기<input type = "radio" value="plus" name = "radioBtn"/></label><br>
		<label>빼기<input type = "radio" value="minus" name = "radioBtn"/></label><br>
		<label>곱하기<input type = "radio" value="mul" name = "radioBtn"/></label><br>
		<label>나누기<input type = "radio" value="div" name = "radioBtn"/></label><br>
		<input type = "submit"/>
	</form>
</body>
</html>