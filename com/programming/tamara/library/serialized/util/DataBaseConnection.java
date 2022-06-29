package programming.tamara.library.serialized.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	public static Connection conn;
	
	public static void connectingWithBase() {
		
		try {
			conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","jo7l79o8");
			if(conn != null) {
				System.out.println("Database is connected.");
			}
		} catch (Exception e) {
			System.out.println("not connected.");
		}
	}

}
