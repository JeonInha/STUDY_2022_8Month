package jdbc;

import java.sql.Connection;
import java.sql.SQLException;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


@WebListener
public class DBCPInitLitener implements ServletContextListener {
     	private static DataSource dataSource;
    	
    	@Override
    	public void contextInitialized(ServletContextEvent sce) {
    		
    		// 웹 어플리케이션 첫 구동 시 필요한 설정을 할 수 있음.
    		ServletContext context = sce.getServletContext();
    		
    		String driver = context.getInitParameter("driver");
    		String DBurl = context.getInitParameter("DBurl");
    		String DBid = context.getInitParameter("DBid");
    		String DBpw = context.getInitParameter("DBpw");	
    		
    		BasicDataSource ds = new BasicDataSource();
    		ds.setDriverClassName(driver);
    		ds.setUrl(DBurl);
    		ds.setUsername(DBid);
    		ds.setPassword(DBpw);
    		
    		dataSource = ds;
    	}
    	
    	public static Connection getConnection() throws SQLException {
    		return dataSource.getConnection();
    		// 이렇게 쓰는 이유: 다쓰면 자동으로 반환함!!!
    	}
}
