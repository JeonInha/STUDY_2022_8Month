<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<%
	// 여기선 db 연결과 select만 할것임!!

Class.forName("com.mysql.cj.jdbc.Driver");

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
List<String> list = new ArrayList<>();

try {
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select name from world.country");
	
	while (rs.next()) {
		String name = rs.getString("name");
		list.add(name);
	}

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

request.setAttribute("world_list", list);
request.getRequestDispatcher("viewCountry.jsp").forward(request, response);

%>