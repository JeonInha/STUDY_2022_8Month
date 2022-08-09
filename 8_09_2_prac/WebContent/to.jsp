<%@page import="java.util.Random"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>



<%
	String alphabet = request.getParameter("choose");
if (alphabet != null) {

	if (alphabet.equals("A")) {
		// 서버 시간
		request.setAttribute("result", LocalTime.now());
		request.getRequestDispatcher("/WEB-INF/A.jsp").forward(request, response);
	} else if (alphabet.equals("B")) {
		// 서버 날짜
		request.setAttribute("result", LocalDate.now());
		request.getRequestDispatcher("/WEB-INF/B.jsp").forward(request, response);

	} else if (alphabet.equals("C")) {
		// 랜덤 정수
		Random random = new Random();
		request.setAttribute("result", random.nextInt(100));
		request.getRequestDispatcher("/WEB-INF/C.jsp").forward(request, response);
	}
} else {
	response.sendRedirect("from.jsp");
}
%>