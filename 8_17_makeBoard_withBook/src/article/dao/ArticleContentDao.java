package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {
	
	
	public ArticleContent insert(Connection conn, ArticleContent content) throws SQLException {
		
		PreparedStatement pstmt = null;
		String sql = "insert into article_content(article_no, content) values(?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, content.getNumber());
			pstmt.setNString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}
			
		} finally {
			JdbcUtil.closeStmt(pstmt);
		}
	}
	
	public ArticleContent selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from article_content where article_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ArticleContent content = null;
			if (rs.next()) {
				content = new ArticleContent(
						rs.getInt("article_no"), rs.getString("content"));
			}
			return content;
		} finally {
			JdbcUtil.closeRS(rs);
			JdbcUtil.closeStmt(pstmt);
		}
	}
}
