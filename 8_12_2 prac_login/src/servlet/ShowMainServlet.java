package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCheck")
public class ShowMainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {		
			if (! (c.getName().equals("login"))) {
				resp.sendRedirect("./idremember.jsp");
			} else {
				resp.sendRedirect("./ok.jsp");
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {		
			if (! (c.getName().equals("login"))) {
				resp.sendRedirect("./idremember.jsp");
			} else {
				resp.sendRedirect("./ok.jsp");
			}
		}
		
		
	}
}
