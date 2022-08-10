<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "world.Country" %>
<%@ page import = "world.WorldDaoImpl" %>
<%@ page import = "java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	request.setAttribute("list", list);
	
%>

<c:if test="${not empty list }">
	<ul>
		<c:forEach var="contry" items="${list}">
			<li> ${Country.name } ${Country.population }</li>
		</c:forEach>
	</ul>

</c:if>

</body>
</html>