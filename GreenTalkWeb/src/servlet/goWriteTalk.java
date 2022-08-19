package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class writeTalk
 */
@WebServlet("/letsTalkTalk")
public class goWriteTalk extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginid = (String) session.getAttribute("loginid");
		System.out.println();

		if (loginid != null) {
			request.getRequestDispatcher("./WEB-INF/writeTalkTalk.jsp").forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
