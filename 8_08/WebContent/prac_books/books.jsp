<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	List<String> list = new ArrayList<>();
for (int i = 1; i <= 100; i++) {
	list.add("book" + i);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책을 출력하자 짠짠짠</title>
</head>
<body>
	<%
	String iPage = request.getParameter("page");
	String iPagePer = request.getParameter("pageper");

	if (iPage == null || iPagePer == null || iPage.length()==0 || iPagePer.length()==0) {
		response.sendRedirect("./form.jsp");
	} else {

		int inputPage = Integer.valueOf(iPage);
		int inputPagePer = Integer.valueOf(iPagePer);

		out.println("<br/>");
		out.println("<ui>");

		for (int i = (inputPage - 1) * inputPagePer; i < inputPage * inputPagePer; i++) {
			out.println("<li>" + list.get(i) + "</li>");
		}
		out.println("</ui>");

		out.println("<p>페이지 번호: " + String.valueOf(inputPage) + "/" + 100 / inputPagePer + "  ::  " + inputPagePer
		+ "줄씩 출력</p>");
	}
	%>
	<p>
		<a href="./form.jsp">뒤로 돌아가기</a>
	</p>

</body>
</html>