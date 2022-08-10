package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	public HelloServlet() {
		super();
		System.out.println("헬로서블릿 여기서 만들어짐!!!!");
		System.out.println(LocalTime.now());
		// 해당 웹페이지를 호출할 때 한번 사용하고, 한 객체를 계속계속계속 사용함!
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println(request.getRequestURI());
	}

}
