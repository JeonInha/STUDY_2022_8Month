<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.Map.Entry"%>
        <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ŭ���̾�Ʈ �� ���� ����</title>
</head>
<body>
Ŭ���̾�Ʈ IP = <%= request.getRemoteAddr() %><br/>
��û�������� = <%= request.getContentLength() %><br/>
��û���� ���ڵ� = <%= request.getCharacterEncoding() %><br/>
��û���� ������Ÿ��= <%= request.getContentType() %><br/>
��û���� ��������=<%= request.getProtocol() %><br/>
��û���� ���۹�� = <%= request.getMethod() %><br/>
��û URI = <%= request.getRequestURI() %><br/>
���ؽ�Ʈ ��� = <%= request.getContextPath() %><br/>
���� �̸� = <%= request.getServerName() %><br/>
���� ��Ʈ = <%= request.getServerPort() %><br/>
---------------------------------<br/>
<%=request.getRequestURI() %><br/>
<%= request.getQueryString() %><br/>
�̸�: <%= URLDecoder.decode(request.getParameter("inputName"), "UTF-8")   %><br/>
����: <%= request.getParameter("inputAge") %><br/>
����: <%= request.getParameter("inputGender") %><br/>


������� �� ������ �ּ���: <%= request.getParameterMap().toString() %><br/>

// �ڹ� ���İ� �ڹ� ǥ������ ��ø�ؼ� ����� �� ���� ������ �ݾҴ� ������ �����Ƶ� �ؾ���...
// 
<%
Map<String, String[]> map = request.getParameterMap();
// String[] ���� ����� �޴� ����: üũ�ڽ� �� �� �̸����� �������� ���� �Ѱ��� �� �ֱ� ����
for (Entry<String, String[]> e : map.entrySet()) {
	String key = e.getKey();
	String[] value = e.getValue();
	%>
	<%= key%><%=Arrays.toString(value) %><br/>
<%
}
%>


</body>
</html>