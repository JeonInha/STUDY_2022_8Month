package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import post.Post;
import post.postDaoImpl;
import signUp.Account;

/**
 * Servlet implementation class writeTalkTalk
 */
@WebServlet("/writeTalkTalk")
public class writeTalkTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = (String) request.getAttribute("content");
		HttpSession session = request.getSession();
		
		if (session==null || session.getAttribute("loginid")==null) {
			
		} else {
			postDaoImpl pd = new postDaoImpl();
			Account user = (Account) session.getAttribute("loginid");
			Post post = new Post(user.getUser_num(), content, false);
			
			int check = pd.uploadPost(post);
			
			if (check == 1) {
				response.sendError(401);
			} else {
				request.getRequestDispatcher("./mypage").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
