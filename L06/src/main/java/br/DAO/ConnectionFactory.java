package br.DAO;
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	public Connection getConnection() {
		try{
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			cpds.setDriverClass("org.postgresql.Driver");
			cpds.setJdbcUrl("jdbc:postgresql://localhost/DSPersis_L06");
			cpds.setUser("postgres");
			cpds.setPassword("postgres");
			cpds.setMinPoolSize(3);
			cpds.setMaxPoolSize(10);

			return 	cpds.getConnection();

			/*
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql://localhost/teste","postgres","postgres");
			 */
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}