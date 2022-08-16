package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/after")
public class AfterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().contentEquals("login")) {
					loginCookie = c;
				}

			}
		}

		if (loginCookie != null) {
			request.getRequestDispatcher("/WEB-INF/ok.jsp");
		} else {
			response.sendRedirect("./idremember.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
