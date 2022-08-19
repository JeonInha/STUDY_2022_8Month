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

@WebServlet("/letslogin")
public class login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("loginid");
		
		if (id==null) {
			resp.sendError(401);
		} else {

		AccManagerDaoImpl adi = new AccManagerDaoImpl();
		postDaoImpl pd = new postDaoImpl();
		String userID = (String) session.getAttribute("loginid");
		Account user = adi.readAccountById(userID);
		List<Post> timeLine = pd.readPostbyFollower(user);

		req.setAttribute("timeline", timeLine);
		req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccManagerDaoImpl acdi = new AccManagerDaoImpl();

		String inputId = req.getParameter("input_id");
		inputId.trim();
		// 공백제거
		String inputPw = req.getParameter("input_pw");
		inputPw.trim();

		boolean loginCheck = acdi.getIdCheck(inputId);
		boolean getloginCheck = acdi.getLogin(inputId, inputPw);

		if (inputId == null || inputId.length() == 0 || inputPw == null || inputPw.length() == 0) {
			// http 프로토콜::
			// 입력이 잘못되었을때 response 클래스에 정의된 static 상수를 사용해 코드에러를 전달할 수 있음.
			req.setAttribute("progress", "None");
			req.getRequestDispatcher("./login.jsp").forward(req, resp);

		} else if (!loginCheck || !getloginCheck) {
			req.setAttribute("progress", "Fail");
			req.getRequestDispatcher("./login.jsp").forward(req, resp);

		} else {
			HttpSession session = req.getSession();
			session.setAttribute("loginid", inputId);

			AccManagerDaoImpl adi = new AccManagerDaoImpl();
			postDaoImpl pd = new postDaoImpl();
			String userID = (String) session.getAttribute("loginid");
			Account user = adi.readAccountById(userID);
			List<Post> timeLine = pd.readPostbyFollower(user);

			req.setAttribute("timeline", timeLine);
			req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
		}
	}
}
