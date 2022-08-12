package kr.co.greenart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editcookie")
public class EditCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c = new Cookie("yourname", "edit");
		resp.addCookie(c);
		// 쿠키 더하기
		
		// 쿠키 삭제: 기간이 만료되었을 때 진행됨. :: 쿠키의 기간을 만료시켜보장
		Cookie c2 = new Cookie("yourname22", "");
		c2.setMaxAge(3600);	// 초 단위로 기간 설정할 수 있음! // 이건 1시간
		resp.addCookie(c2);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
