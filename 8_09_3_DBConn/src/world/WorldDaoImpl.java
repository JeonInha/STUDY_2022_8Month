package world;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;	

public class WorldDaoImpl {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
	}

	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStmt(Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void closeRs(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public List<String> getCont() {
		List<String> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "Select distinct Continent From country";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				String a = rs.getString("Continent");
				a = a.replace(" ", "_");
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				closeRs(rs);
				closeStmt(stmt);
				closeConn(conn);
		}
		return list;
	}
	
	public List<Country> getInfo(String cont) {
		List<Country> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		cont = cont.replace("_", " ");
		
		String query = "Select name, Population from country where Continent = ? order by Population;";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cont);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				int pop = rs.getInt("Population");
				Country countryInfo = new Country(name, pop);
				list.add(countryInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeRs(rs);
			closeStmt(pstmt);
			closeConn(conn);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}