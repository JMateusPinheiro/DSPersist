package br.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDao implements DAO{

	private Connection connection;

	public JdbcDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void AddFunc(String cpf, String matricula, String nome, String email, String telefone) {
		String sql = "insert into funcionario " + "(id,cpf,matricula,nome,email,telefone)" + " values (?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, );
			stmt.setString(2, cpf);
			stmt.setString(3, matricula);
			stmt.setString(4, nome);
			stmt.setString(5, email);
			stmt.setString(6, telefone);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		
	}

	public void RmFunc(int id) {
		// TODO Auto-generated method stub
		
	}

	public void AddDepen(int id_func, String cpf, String nome) {
		// TODO Auto-generated method stub
		
	}

	public void RmDepen(int id) {
		// TODO Auto-generated method stub
		
	}
}