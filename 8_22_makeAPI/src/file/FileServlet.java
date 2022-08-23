package file;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/fileupload")
@MultipartConfig(location = "d:\\temp", fileSizeThreshold = 10 * 1024 * 1024, maxFileSize = 50 * 1024 * 1024)
// 해당 용량(fileSizeThreshold=10*1024*1024)을 넘어가면 임시폴더에서 사용될것이라 설정
// 이 용량보다 작으면 인메모리(메모리상)에서 처리
// 이렇게 설정하면 서블릿에서 멀티파트를 다룰 수 있음.
public class FileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part p = request.getPart("fileupload");
		System.out.println(p.getName());
		System.out.println(p.getSubmittedFileName());
		for (String header : p.getHeaderNames()) {
			System.out.println(header + ":" + p.getHeader(header));
		}
		String contextPath = getServletContext().getRealPath("");
		// 여기서 빈문자열: 웹컨텐츠폴더(그자리에 바로);
		Path directory = Paths.get(contextPath);
		// 해당경로를 가리킬 때 Path 객체가 됨.
		Files.copy(p.getInputStream(), directory.resolve(p.getSubmittedFileName()), StandardCopyOption.REPLACE_EXISTING);

		response.sendRedirect("/"+URLEncoder.encode(p.getSubmittedFileName(), "UTF-8"));
	}

}
