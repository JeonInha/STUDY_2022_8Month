package loginpracServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.BoardArticle;
import board.BoardDAO;
import board.BoardService;

/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/board")
public class boardServlet extends HttpServlet {
	private final static Logger logger = LoggerFactory.getLogger(boardServlet.class);
	// 로거 객체를 만들어주는 동작. 파라미터로 해당 클래스를 객체로 받음.
	
	private BoardService service;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new BoardService(new BoardDAO());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			logger.info("logger를 통해 메시지를 남깁니다.");
			logger.info("사용자가 Get 요청함. (게시판 목록)");
			
			// slf4j - FATAL / ERROR / WARN /INFO / DEBUG /
			// 중요도. 왼쪽으로 갈수록 높은 레벨. 이걸 등급에 따라 나눠 요청할 수 있음.
			// 이걸 설정파일을 만들어서 기록할 수 있음 !  !  !
		
			List<BoardArticle> articles = service.readArticle();

			request.setAttribute("articles", articles);
			request.getRequestDispatcher("/WEB-INF/articles.jsp").forward(request, response);

	}
}
