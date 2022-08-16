package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import post.Post;
import post.postDaoImpl;
import signUp.AccManagerDaoImpl;
import signUp.Account;

@WebServlet("/timeline")
public class setTimeline extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccManagerDaoImpl ad = new AccManagerDaoImpl();
	postDaoImpl pd = new postDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object loginid = session.getAttribute("loginid");
		
		if (loginid != null) {
			response.sendRedirect("./WEB-INF/home.jsp");
			
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

}
