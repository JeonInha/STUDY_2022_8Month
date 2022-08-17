package member.service;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

import jdbc.DBCPInitLitener;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	private MemberDao md = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = DBCPInitLitener.getConnection();
			conn.setAutoCommit(false);
			
			Member member = md.selectById(conn, joinReq.getId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			Member mem = new Member(joinReq.getId(), joinReq.getName(), joinReq.getConfirmPassword(), new Date());
			md.insert(conn, mem);
			
			conn.commit();
			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.closeConn(conn);
		}
	}
}
