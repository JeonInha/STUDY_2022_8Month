package servlet;

import java.io.IOException;
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


@WebServlet("/gomypage")
public class mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginid = (String) session.getAttribute("loginid");
		System.out.println();
		
		if (loginid != null) {
			AccManagerDaoImpl adi = new AccManagerDaoImpl();
			request.setAttribute("user", adi.readAccountById(loginid));

			postDaoImpl pd = new postDaoImpl();
			String userID = (String) session.getAttribute("loginid");
			Account user = adi.readAccountById(userID);
			List<Post> timeLine = pd.readPostbyUser(user);

			request.setAttribute("timeline", timeLine);
			
			request.getRequestDispatcher("/WEB-INF/mypage.jsp").forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
}
