package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		
		if (session==null || session.getAttribute("authUser")==null) {
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendRedirect(request.getContextPath() + "/login.do");
		} else {
			chain.doFilter(req, resp);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void destroy() {
	}

}
