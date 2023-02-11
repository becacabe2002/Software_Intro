package testLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
//	Connection con = null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testlogin", "root", "29123498");
			return con;
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("ConnectionUtil : "+e.getMessage());
			return null;
		}
		
	}
}
