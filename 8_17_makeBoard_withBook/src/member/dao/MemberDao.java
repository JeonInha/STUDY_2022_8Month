package member.dao;

import java.sql.*;

import jdbc.DBCPInitLitener;
import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {

	public Member resultMapping(ResultSet rs) throws SQLException {
		String id = rs.getString("memberid");
		String name = rs.getString("name");
		String password = rs.getString("password");
		Date regDate = toDate(rs.getTimestamp("regdate"));

		return new Member(id, name, password, regDate);
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	////////////////////////////////////////////////////

	public Member selectById(Connection conn, String id) throws SQLException {
		String sql = "select * from board.member where memberid = ?";
		Member member = null;
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = resultMapping(rs);
			}
		} finally {
			JdbcUtil.closeRS(rs);
		}
		return member;
	}
	
	public void insert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into board.member(memberid, name, password, regdate) values( ?, ?, ?, ? )")) {
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setTimestamp(4, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}
	
	public void update(Connection conn, Member member) throws SQLException {
		String sql = "update board.member set name = ?, password = ? where memberid = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setNString(1, member.getName());
			pstmt.setNString(2, member.getPassword());
			pstmt.setNString(3, member.getId());
			
			pstmt.executeUpdate();
		}
	}
}
