package com.tasks.courseregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DbConnections {
	
	static Connection conn ;
	static Statement st;
	static ResultSet result ;

	public static void getConnection() throws ClassNotFoundException, SQLException {
		String url ="jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password="Login@123";
		Class.forName("org.postgresql.Driver");
		conn =  DriverManager.getConnection(url, username,password);
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
	
	public static ResultSet ExecuteQuery(String query) throws ClassNotFoundException, SQLException {
		//System.out.println(query);
		
		st = conn.createStatement();
		result = st.executeQuery(query);
		
		
		return result;
	}
	
	
}
