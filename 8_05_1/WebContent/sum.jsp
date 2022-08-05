<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%!
	// 여기는 메소드 정의표현만 가능함
	public int getSum(int lastNumber) {
		int sum = 0;
		for (int i = 0; i<= lastNumber; i++) {
			sum +=i;
		}
		return sum;
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p>jsp 페이지에서 java scriptLet을 활용한 합계 구하기</p>

	<%
	//	int sum = 0;
	// for (int i = 0; i <= 10; i++) {
	//	sum += i;}
	// 
	%>
	<p>
		0부터 100까지의 합계:
		<%=getSum(100)%></p>

</body>
</html>