package Metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/tp8", "root", "");
			System.out.println("Création d'une connexion");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
