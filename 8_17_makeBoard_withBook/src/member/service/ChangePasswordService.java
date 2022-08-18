package member.service;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

import jdbc.DBCPInitLitener;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePasswordService {
	private MemberDao md = new MemberDao();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = DBCPInitLitener.getConnection();
			conn.setAutoCommit(false);
			
			Member member = md.selectById(conn, userId);
			
			if (member==null) {
				throw new MemberNotFoundException();
			}
			if (!member.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			member.changePassword(newPwd);
			md.update(conn, member);
			conn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			System.out.println("스택트레이스 출력하세요");
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.closeConn(conn);
		}
	}
}