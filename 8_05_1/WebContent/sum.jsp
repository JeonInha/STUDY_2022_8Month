<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%!
	// ����� �޼ҵ� ����ǥ���� ������
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
	<p>jsp ���������� java scriptLet�� Ȱ���� �հ� ���ϱ�</p>

	<%
	//	int sum = 0;
	// for (int i = 0; i <= 10; i++) {
	//	sum += i;}
	// 
	%>
	<p>
		0���� 100������ �հ�:
		<%=getSum(100)%></p>

</body>
</html>