package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signUp.AccManagerDaoImpl;
import signUp.AccVailidator;

public class signUp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		String inputId = request.getParameter("input_id");
		String inputNic = request.getParameter("input_nickname");
		String inputPw = request.getParameter("input_pw");
		String checkPw = request.getParameter("check_pw");
		
		AccVailidator validator = new AccVailidator();
		
		Map<String, String> errors = new HashMap<String, String>();
		errors.putAll(validator.vaildID(inputId));
		errors.putAll(validator.vaildNic(inputNic));
		errors.putAll(validator.vaildPW(inputPw));
		
		if (!(inputPw.equals(checkPw))) {
			errors.put("pw_different", "패스워드와 패스워드 확인 입력값이 일치하지 않습니다.");
		}
		
		///////////////////////////////////////////
		
		if (errors.size()==0) {
			AccManagerDaoImpl acdi = new AccManagerDaoImpl();
			boolean check = acdi.makeNewUser(inputId, inputPw, checkPw);
			if (check) {
				response.sendRedirect("login.jsp");
				
			} else {
				errors.put("unknown_error", "에러 발생. 다시 시도해 주세요.");
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("./signUp.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("./signUp.jsp").forward(request, response);
		}

		
		////////////////////////////////
		
		
//		boolean idCheck = acdi.getIdCheck(inputId);
//
//
//		// TODO 배운 표현식 이용하여 갈아치우기 ..........
//		if (inputId == null || inputPw == null || checkPw==null) {
//			
//			request.setAttribute("progress", "NoneValue");
//			request.getRequestDispatcher("./signUp.jsp").forward(request, response);
//			
//		} else if (idCheck) {
//			
//			request.setAttribute("progress", "ID_exist");
//			request.getRequestDispatcher("./signUp.jsp").forward(request, response);
//			
//		} else if (!(inputPw.equals(checkPw))) {
//			
//			request.setAttribute("progress", "checkPw_error");
//			request.getRequestDispatcher("./signUp.jsp").forward(request, response);
//			
//		} else {
//			boolean check = acdi.makeNewUser(inputId, inputPw, checkPw);
//			if (check) {
//				response.sendRedirect("login.jsp");
//			} else {
//				request.setAttribute("progress", "signUp_error");
//				request.getRequestDispatcher("./signUp.jsp").forward(request, response);
//			}
//		}
	}

}
