package studentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URL  ="jdbc:mysql://127.0.0.1:3306/student_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "OllyDevil@1228";
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//System.out.println("Database Connection Successful.");
		}
		catch(SQLException e) {
			System.out.println("Database Connection Failed.");
			e.printStackTrace();
		}
		
		return connection;
	}
}
