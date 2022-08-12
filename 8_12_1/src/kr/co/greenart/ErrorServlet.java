package kr.co.greenart;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/errorhandle" )
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> e = request.getAttributeNames();
		// 얘는 이터레이터랑 비스무리함!
		
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + ": ");
			System.out.println(request.getAttribute(e.nextElement()));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
