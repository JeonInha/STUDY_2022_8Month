package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.DBCPInitLitener;
import jdbc.JdbcUtil;

public class WriteArticleService {
	
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public Integer write(WriteRequest req) {
		
		Connection conn = null;
		
		try {
			conn = DBCPInitLitener.getConnection();
			conn.setAutoCommit(false);
			
			Article article = toArticle(req);
			Article saveArticle = articleDao.insert(conn, article);
			
			if (saveArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			ArticleContent content = new ArticleContent(
					saveArticle.getNumber(), req.getContent());
			ArticleContent saveContent = contentDao.insert(conn, content);
			
			if (saveContent==null) {
				throw new RuntimeException("fail to insert article_content");
			}
					
			conn.commit();
			
			return saveArticle.getNumber();
			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			System.out.println("익셉션 출력해랑");
			e.printStackTrace();
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.closeConn(conn);
		}
		return null;
		
	}
	
	private Article toArticle(WriteRequest req) {
		Date now = new Date();
		return new Article(null, req.getWriter(), req.getTitle(), now, now, 0);
	}
	
}
