package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.ConnectionEventListener;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.DBCPInitLitener;

public class ReadArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public ArticleData getArticle(int articlenum, boolean increseReadCount) {

		try (Connection conn = DBCPInitLitener.getConnection()) {
			
			Article article = articleDao.selectById(conn, articlenum);
			if (article==null) {
				throw new ArticleNotFoundException();
			}
			ArticleContent content = contentDao.selectById(conn, articlenum);
			if (content==null) {
				throw new ArticleContentnotFoundException();
			}
			if (increseReadCount) {
				articleDao.increaseReadCount(conn, articlenum);
			}
			return new ArticleData(article, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
		
	}
	
}
