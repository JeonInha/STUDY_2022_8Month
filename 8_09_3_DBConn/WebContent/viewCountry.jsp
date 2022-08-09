<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> list = (List<String>) request.getAttribute("world_list");

	out.println("<ul>");
	
		for (int i=0; i<list.size(); i++) {
			out.println("<li>"+list.get(i)+"</li>");
		}
	out.println("</ul>");



%>

</body>
</html>