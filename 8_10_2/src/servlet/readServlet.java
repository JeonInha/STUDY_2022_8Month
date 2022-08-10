package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDB.Member;
import MemberDB.MemberDao;

public class readServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("skdhsk");
		MemberDao md = new MemberDao();
		List<Member> list = md.readAllMember();
		
		req.setAttribute("memberList", list);
		req.setAttribute("listSize", list.size());
		
		// requestDispatcher는 webContent root 경로에서 찾아가려고 함.
		req.getRequestDispatcher("/prac_personManager/readMemberList.jsp").forward(req, resp);
	}
}
