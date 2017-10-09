package br.DAO;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");

			return DriverManager.getConnection(
					"jdbc:h2:~/DSPesis_L06", 
					"", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}