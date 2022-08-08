<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		String int1 = request.getParameter("num1");
		String int2 = request.getParameter("num2");
		int num1 = Integer.valueOf(int1);
		int num2 = Integer.valueOf(int2);
		double calc = 0;
		String input = request.getParameter("radioBtn");
		
		if (input.equals("plus")){
			calc = num1 + num2;
		} else if (input.equals("minus")) {
			calc = num1 - num2;
		} else if (input.equals("mul")) {
			calc = num1 * num2;
		} else if (input.equals("div")) {
			Double num11 = Double.valueOf(num1);
			Double num22 = Double.valueOf(num2);
			calc = num11 / num22;
		}
		
		String printCalc = String.format("%.2f", calc);
		out.println("<p>계산한 값은 <strong>"+printCalc+"</strong>입니다.</p>");

	} catch (Exception e) {
		out.println("잘못된 시도");
	}
	%>
	<p><a href = "./form.jsp">뒤로가기</a></p>
</body>
</html>