<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "signUp.AccManagerDaoImpl" %>


<%

String inputId = request.getParameter("input_id");
String inputPw = request.getParameter("input_pw");
String checkPw = request.getParameter("check_pw");

AccManagerDaoImpl acdi = new AccManagerDaoImpl();


boolean idCheck = acdi.getIdCheck(inputId);


// TODO 해당 내용 alert로 띄우게 하기
if (inputId == null || inputPw == null || checkPw==null) {
	out.println("<script> alert('값을 모두 입력하세요') </script>");
	response.sendRedirect("signUp.jsp");
	
} else if (idCheck) {
	out.println("<script> alert('이미 존재하는 ID입니다.') </script>");
	response.sendRedirect("signUp.jsp");
	
} else if (!(inputPw.equals(checkPw))) {
	out.println("<script> alert('pw와 pw확인 불일치.') </script>");
	response.sendRedirect("signUp.jsp");
	
} else {
	boolean check = acdi.makeNewUser(inputId, inputPw);
	if (check) {
		response.sendRedirect("login.jsp");
	} else {
		out.println("<script> alert('에러 발생으로 가입 실패. 다시 해주세요.') </script>");
		response.sendRedirect("signUp.jsp");
	}
}




%>