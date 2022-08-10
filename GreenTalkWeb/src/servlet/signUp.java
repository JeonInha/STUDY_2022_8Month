package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signUp.AccManagerDaoImpl;

public class signUp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputId = request.getParameter("input_id");
		String inputPw = request.getParameter("input_pw");
		String checkPw = request.getParameter("check_pw");

		AccManagerDaoImpl acdi = new AccManagerDaoImpl();


		boolean idCheck = acdi.getIdCheck(inputId);


		// TODO 해당 내용 alert로 띄우게 하기
		if (inputId == null || inputPw == null || checkPw==null) {
			
			request.setAttribute("progress", "NoneValue");
			request.getRequestDispatcher("./signUp.jsp").forward(request, response);
			
			
		} else if (idCheck) {
			
			request.setAttribute("progress", "ID_exist");
			request.getRequestDispatcher("./signUp.jsp").forward(request, response);
			
		} else if (!(inputPw.equals(checkPw))) {
			
			request.setAttribute("progress", "checkPw_error");
			request.getRequestDispatcher("./signUp.jsp").forward(request, response);
			
		} else {
			boolean check = acdi.makeNewUser(inputId, inputPw);
			if (check) {
				response.sendRedirect("login.jsp");
			} else {
				request.setAttribute("progress", "signUp_error");
				request.getRequestDispatcher("./signUp.jsp").forward(request, response);
			}
		}
	}

}
