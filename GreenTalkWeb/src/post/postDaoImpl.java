package post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import DB.DBUtil;
import de.Static;
import signUp.Account;

public class postDaoImpl implements PostDao{

	@Override
	public int uploadPost(Post post) {
		int check = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into green_talk.post "
				+ "(post_user_id, post_dateTime, post_content, post_isComment) "
				+ "value (?, now(), ?, 0)";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, post.getPost_user_id());
			pstmt.setNString(2, post.getPost_content());
			
			pstmt.executeUpdate();
			check = Static.SUCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			check = Static.ERROR;
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return check;
	}
	
	@Override
	public int uploadCommentPost(Post post) {
		int check = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into green_talk.post "
				+ "(post_user_id, post_dateTime, post_content, post_isComment, post_Comment_postid, post_Comment_userid) "
				+ "value (?, now(), ?, 1, ?, ?)";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, post.getPost_user_id());
			pstmt.setNString(2, post.getPost_content());
			pstmt.setInt(3, post.getPost_Comment_postid());
			pstmt.setInt(4, post.getPost_Comment_userid());
			
			pstmt.executeUpdate();
			check = Static.SUCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			check = Static.ERROR;
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return check;
	}

	@Override
	public List<Post> readPostbyUser(Account user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post readPostbyID(int postid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> readPostbySearch(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePost(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePost(int postid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
