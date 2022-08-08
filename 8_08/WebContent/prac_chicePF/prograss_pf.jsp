<%
	String input = request.getParameter("radioBtn");
if (input == null || input.length()==0) {
	response.sendRedirect("./want_p_f.jsp?prograss=failed");
}else if (input.equals("person")) {
	response.sendRedirect("./persons.jsp");
} else if (input.equals("fruit")) {
	response.sendRedirect("./fruit.jsp");
} else {
	response.sendRedirect("./want_p_f.jsp");
}
%>