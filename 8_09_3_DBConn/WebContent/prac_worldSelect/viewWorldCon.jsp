<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "world.Country" %>
<%@ page import = "world.WorldDaoImpl" %>
<%@ page import = "java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택한 대륙 보여줄게용</title>
</head>
<body>
<% 
	String cont = request.getParameter("cont");
	List<Country> list = new WorldDaoImpl().getInfo(cont);
	
	out.println(String.format("<p>선택한 대륙: %s</p>", cont));
	
	out.println("<ul>");
		for (int i=0; i<list.size(); i++) {
			out.println("<li>"+list.get(i)+"</li>");
		}
	out.println("</ul>");
	
%>

</body>
</html>