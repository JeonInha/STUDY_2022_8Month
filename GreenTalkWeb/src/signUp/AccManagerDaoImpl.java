package signUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import de.Static;
import DB.DBUtil;

public class AccManagerDaoImpl implements AccManagerDao {

	private String makeListToString(List<String> list) {
		String a = list.get(0);
		for (String ac : list) {
			a = a.concat("/" + ac);
		}
		return a;
	}

	private List<String> makefollowList(String st) {
		String[] arr = st.split("/");
		List<String> list = new ArrayList<>();
		for (String s : arr) {
			list.add(s);
		}
		return list;
	}

	private Account resultMaping(ResultSet rs) throws SQLException {
		int num = rs.getInt("user_num");
		String name = rs.getString("user_name");
		String pw = rs.getString("user_pw");
		String follower = rs.getString("user_followerList");
		String folloing = rs.getString("user_followingList");

		Account ac = new Account(num, name, pw);
		if (follower != null) {
			List<String> followerList = makefollowList(follower);
			ac.setUser_followerList(followerList);
		}
		if (folloing != null) {
			List<String> folloingList = makefollowList(folloing);
			ac.setUser_followingList(folloingList);
		}
		return ac;
	}

	// C
	@Override
	public int createNewAccount(Account user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String quary = "insert into user_account(user_name, user_pw) values(?, ?);";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(quary);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_pw());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return Static.ERROR;
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return Static.SUCESS;
	}

	// R
	@Override
	public Account readAccount(int name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String quary = "select * from user_account where user_num = ?;";
		Account ac = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(quary);
			pstmt.setInt(1, name);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ac = resultMaping(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				DBUtil.closeRs(rs);
				DBUtil.closeStmt(pstmt);
				DBUtil.closeConn(conn);
			}
		}
		return ac;
	}

	@Override
	public Account readAccount(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String quary = "select * from user_account where user_name = ?;";
		Account ac = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(quary);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ac = resultMaping(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				DBUtil.closeRs(rs);
				DBUtil.closeStmt(pstmt);
				DBUtil.closeConn(conn);
			}
		}
		return ac;
	}

	@Override
	public List<Account> readAllAccount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String quary = "select * from user_account;";
		List<Account> arr = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(quary);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Account a = resultMaping(rs);
				arr.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return arr;
	}

	public List<Account> getFollowingList(Account ac) {
		List<String> following = ac.getUser_followingList();
		List<Account> list = new ArrayList<>();
		for (String a : following) {
			int num = Integer.valueOf(a);
			list.add(readAccount(num));
		}
		return list;
	}

	public List<Account> getFollowerList(Account ac) {
		List<String> follower = ac.getUser_followerList();
		List<Account> list = new ArrayList<>();
		for (String a : follower) {
			int num = Integer.valueOf(a);
			list.add(readAccount(num));
		}
		return list;
	}

	// U
	@Override
	public int updateFollowing(Account user) {
		String st = makeListToString(user.getUser_followingList());
		Connection conn = null;
		PreparedStatement pstmt = null;
		String quary = "update user_account set user_followingList = ? where user_num = ?;";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(quary);
			pstmt.setString(1, st);
			pstmt.setInt(2, user.getUser_num());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return Static.ERROR;
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return Static.SUCESS;
	}

	@Override
	public int updateFollower(Account user) {
		String st = makeListToString(user.getUser_followerList());
		Connection conn = null;
		PreparedStatement pstmt = null;
		String quary = "update user_account set user_followerList = ? where user_num = ?;";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(quary);
			pstmt.setString(1, st);
			pstmt.setInt(2, user.getUser_num());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return Static.ERROR;
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return Static.SUCESS;
	}

	// D
	@Override
	public int deleteAccount(Account user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String quary = "delete from user_account where user_name = ?;";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(quary);
			pstmt.setString(1, user.getUser_name());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return Static.ERROR;
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return Static.SUCESS;
	}

	/////////////////////////////////////////////////////////////

	public boolean getIdCheck(String inputId) {
		Account ac = readAccount(inputId);
		if (ac == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean getLogin(String inputId, String inputPw) {
		Account ac = readAccount(inputId);
		if (ac != null) {
			if (ac.getUser_pw().equals(inputPw)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean makeNewUser(String inputId, String inputPw) {
		Account ac = new Account(inputId, inputPw);
		int check = createNewAccount(ac);
		if (check == de.Static.SUCESS) {
			return true;
		} else {
			return false;
		}
	}
}
