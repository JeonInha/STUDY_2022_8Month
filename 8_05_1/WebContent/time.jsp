<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
// directive
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// �ڹ��ڵ带 ���� �� �ִ� ������ �� �ȿ� ��
	// scriptlet�̶�� �θ�
	// �̰ɷ� ���� �� ������ �ҽ������ �� �� ����!
	// �⺻�����δ� ��������
	System.out.println("����ڰ� jsp �������� ��û�Ͽ����ϴ�.");
	int a = 10;
	%>
	
	<%-- �ǳʶٴ°��� �̷��� --%>

	<strong><%=java.time.LocalTime.now()%></strong>
	<p>
		jsp �������Դϴ� <br>a�� ����
		<%=a%>�Դϴ�.
	</p>
</body>
</html>