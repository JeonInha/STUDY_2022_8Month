package MemberDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	
	private Member resultMapping(ResultSet rs) throws SQLException {
		Member mem;
		
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int age = rs.getInt("age");
		
		mem = new Member(id, name, age);
		return mem;
	}
	
	// c
	public boolean insertNewMember(Member member) {
		boolean insertCheck = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into my_db.member (name, age) value (?, ?);";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getAge());
			pstmt.executeUpdate();
			
			insertCheck = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return insertCheck;
	}
	
	// r
	public List<Member> readAllMember() {
		List<Member> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from my_db.member";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Member a = resultMapping(rs);
				list.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
		
		return list;
	}
}
