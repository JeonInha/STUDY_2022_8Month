package board;

import java.sql.SQLException;
import java.util.List;

public class BoardService {
	BoardDAO dao;
	
	public BoardService(BoardDAO boardDAO) {
		this.dao = boardDAO;
	}
	
	
	public List<BoardArticle> readArticle() {
		try {
			return dao.readArticleList();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터를 읽을 수 없습니다.");
		}
	}

	
	// 필요한 로직을 포함하는 문장들 ~~~~~~
	
	// 게시글 적기 서비스
	
	// 게시글 수정하기 서비스
	
	// 게시글 하나 내용 보기 서비스
}
