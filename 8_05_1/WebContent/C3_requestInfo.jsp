<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.Map.Entry"%>
        <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>클라이언트 및 서버 정보</title>
</head>
<body>
클라이언트 IP = <%= request.getRemoteAddr() %><br/>
요청정보길이 = <%= request.getContentLength() %><br/>
요청정보 인코딩 = <%= request.getCharacterEncoding() %><br/>
요청정보 컨텐츠타입= <%= request.getContentType() %><br/>
요청정보 프로토콜=<%= request.getProtocol() %><br/>
요청정보 전송방식 = <%= request.getMethod() %><br/>
요청 URI = <%= request.getRequestURI() %><br/>
컨텍스트 경로 = <%= request.getContextPath() %><br/>
서버 이름 = <%= request.getServerName() %><br/>
서버 포트 = <%= request.getServerPort() %><br/>
---------------------------------<br/>
<%=request.getRequestURI() %><br/>
<%= request.getQueryString() %><br/>
이름: <%= URLDecoder.decode(request.getParameter("inputName"), "UTF-8")   %><br/>
나이: <%= request.getParameter("inputAge") %><br/>
성별: <%= request.getParameter("inputGender") %><br/>


사용자의 값 맵으로 주세요: <%= request.getParameterMap().toString() %><br/>

// 자바 사용식과 자바 표현식을 중첩해서 사용할 수 없기 때문에 닫았다 열었다 귀찮아두 해야함...
// 
<%
Map<String, String[]> map = request.getParameterMap();
// String[] 으로 밸류를 받는 이유: 체크박스 등 한 이름으로 여러개의 값을 넘겨줄 수 있기 때문
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