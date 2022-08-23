package person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/person")
public class PersonServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("{}");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mime = request.getHeader("content-type");
		if (!mime.equals("appplecation/json")) {
			response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ( (line = br.readLine())!= null ) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
