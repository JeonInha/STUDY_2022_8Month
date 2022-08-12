package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/idremember.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("rememberme");

		if (password.equals("123")) {
			// 로그인 성공
			// 쿠키(id) 넣은 메시지 응답
			if (rememberme != null && rememberme.equals("on")) {
				Cookie c = new Cookie("rememberme", URLEncoder.encode(id, "utf-8"));
				Cookie c2 = new Cookie("login", "ok");
				
				
				c.setMaxAge(60 * 60 * 24);
				c2.setMaxAge(60*60*2);
				
				response.addCookie(c);
				response.addCookie(c2);

			}
			request.getRequestDispatcher("/loginCheck").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/idremember.jsp");
		}
	}

}
