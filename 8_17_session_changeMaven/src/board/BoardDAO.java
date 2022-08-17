package board;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import listener.MyContextListener;

public class BoardDAO {
	// 데이터메이스에 대해 입출력
	
	public List<BoardArticle> readArticleList() throws SQLException {
		
		String query = "SELECT * FROM boardarticle";
		List<BoardArticle> list = new ArrayList<>();
		
		try (Connection conn = MyContextListener.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			
			while (rs.next()) {
				int id = rs.getInt("ba_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				
				list.add(new BoardArticle(id, title, content));
			}
		}
		return list;
	}
}
