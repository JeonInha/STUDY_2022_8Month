<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
</head>
<body>
	<form action = "/8_05_1/C3_requestInfo.jsp" method = "post">
	<!-- get: 주소의 표현이 됨. 입력한 값이 사용자에게 노출됨. 디폴트값 -->
	<!-- get: 주소의 표현이 되지 않음.  입력값이 상대에게 노출되지 않음.-->
		<!-- 한글: 인코딩 디코딩 해야함 ....-->
		이름: <input type=text name="inputName" /> 나이: <input type=number
			name="inputAge" /> 성별: <input type=text name="inputGender" /> 제출: <input
			type=submit value = "입력완료"/>
	</form>

</body>
</html>