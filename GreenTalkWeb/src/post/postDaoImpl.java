package post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import DB.DBUtil;
import de.Static;
import signUp.Account;

public class postDaoImpl implements PostDao{
	
	public Post resultMap(ResultSet rs) throws SQLException {
		int post_id = rs.getInt("post_id");
		int post_user_id = rs.getInt("post_user_id");
		LocalDateTime post_dateTime = StringtoLDT(rs.getString("post_dateTime"));
		String post_content = rs.getString("post_content");
		int post_isComment = rs.getInt("post_isComment");
		
		if (post_isComment == 1) {
			int post_Comment_postid = rs.getInt("post_Comment_postid");
			int post_Comment_userid = rs.getInt("post_Comment_userid");
			
			return new Post(post_id, post_user_id, post_dateTime, post_content, true, post_Comment_postid, post_Comment_userid);
		} else {
			return new Post(post_id, post_user_id, post_dateTime, post_content, false);	
		}
	}
	
	public LocalDateTime StringtoLDT(String dateTime) {
		
		dateTime= dateTime.replace("-", ":");
		dateTime= dateTime.replace(" ", ":");
		String[] dateString = dateTime.split(":");
		int[] date = new int[6];
		
		LocalDateTime ldt = LocalDateTime.of(LocalDate.of(date[0], date[1], date[2]), LocalTime.of(date[3], date[4], date[5]));
		return ldt;
	}

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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from FROM green_talk.post where post_user_id = ?";
		List<Post> post = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_num());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				post.add(resultMap(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return post;
	}

	@Override
	public Post readPostbyID(int postid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from FROM green_talk.post where post_id = ?";
		Post post = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postid);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				post = resultMap(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return post;
	}

	@Override
	public List<Post> readPostbySearch(String s) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from FROM green_talk.post where post_content Like ?";
		List<Post> post = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				post.add(resultMap(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return post;
	}
	
	@Override
	public List<Post> readPostbyFollower(Account user) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * FROM green_talk.post where post_user_id in (";
		List<Post> post = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			
			List<String> followerList = user.getUser_followerList();
			
			for (String a : followerList) {
				sql = sql.concat(a+", ");
			}
			
			sql = sql.concat("0);");
			System.out.println(sql);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				post.add(resultMap(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
		return post;
	}

	@Override
	public int deletePost(int postid) {
		int check = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from green_Talk.post where post_id = ?;";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postid);
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
	
	//////////////////////////////////////////////////////
}
