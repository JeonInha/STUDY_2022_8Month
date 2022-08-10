package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class ContryServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// request, response;
		// 요청 주소에 따른 요청 흐름 제어를 기능함.
//		PrintWriter pw = resp.getWriter();
//		pw.println("Hello Servlet");
//		pw.println("<! DOCTYPE html>");
//		pw.println("<html>");
//		pw.println("<head><meta charset='utf-8'/></head>");
//		pw.println("<body><h2>Hello World</h2></body>");
//		pw.println("</html>");
//		pw.flush();
		req.setAttribute("title", "서블릿에서 설정한 제목");
		req.setAttribute("message", "서블릿에서 설정한 메시지");
		req.getRequestDispatcher("messageoutput.jsp").forward(req, resp);
	}
}
