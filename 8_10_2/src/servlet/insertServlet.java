package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDB.Member;
import MemberDB.MemberDao;

public class insertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));

		Member mem = new Member(name, age);
		MemberDao md = new MemberDao();
		boolean check = md.insertNewMember(mem);

		if (check) {
			String a = request.getContextPath();
			// URL, 주소를 요청함.
			response.sendRedirect(a + "/prac_personManager/readMemberList.jsp");
		}
	}
}
