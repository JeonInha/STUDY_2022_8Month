package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signUp.AccManagerDaoImpl;

public class login extends HttpServlet {
		@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AccManagerDaoImpl acdi = new AccManagerDaoImpl();

			String inputId = request.getParameter("input_id");
			inputId.trim();
			// 공백제거
			String inputPw = request.getParameter("input_pw");
			inputPw.trim();
			
			boolean loginCheck = acdi.getIdCheck(inputId);
			boolean getloginCheck = acdi.getLogin(inputId, inputPw);
			
			if (inputId == null || inputId.length() == 0 || inputPw == null || inputPw.length() == 0) {
				// http 프로토콜::
				// 입력이 잘못되었을때  response 클래스에 정의된 static 상수를 사용해 코드에러를 전달할 수 있음.
				request.setAttribute("progress", "None");
				request.getRequestDispatcher("./login.jsp").forward(request, response);
				
			} else if (!loginCheck || !getloginCheck) {
				request.setAttribute("progress", "Fail");
				request.getRequestDispatcher("./login.jsp").forward(request, response);
				
			} else {
				response.sendRedirect("./home.jsp");
			}
	}
}
