<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="world.WorldDaoImpl"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대륙을 선택해주세용</title>
</head>
<body>
	<p>대륙 선택하기</p>
	<form action="viewWorldCon_useEL.jsp">
		<select name="cont" class="Continent">
			<%
			List<String> list= new WorldDaoImpl().getCont();
			
			for (int i = 0; i < list.size(); i++) {
				out.println(String.format("<option value=\"%s\">%s</option>", list.get(i), list.get(i)));
			}
			%>
			
		</select> <input type="submit" />
	</form>

</body>
</html>