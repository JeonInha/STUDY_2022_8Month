<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 드라이버의 패키지와 클래스이름을 집어넣어주기
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
//	List<String> worldList = new ArrayList<>();
	String a;

	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT Name FROM world.country");
		out.println("<ui>");
		while (rs.next()) {
			a = rs.getString("Name");
			a = a.replace(" ", "_");
//			worldList.add(a);
			out.println("<li>" + a + "</li>");
		}
		out.println("</ui>");

	} finally {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	%>

</body>
</html>