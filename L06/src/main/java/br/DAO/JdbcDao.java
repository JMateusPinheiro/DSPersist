package br.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.model.Dependente;
import br.model.Funcionario;

public class JdbcDao implements DAO{

	private Connection connection;

	public JdbcDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void AddFunc(String cpf, String matricula, String nome, String email, String telefone) {
		String sql = "insert into funcionario " + "(cpf,matricula,nome,email,telefone)" + " values (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cpf);
			stmt.setString(2, matricula);
			stmt.setString(3, nome);
			stmt.setString(4, email);
			stmt.setString(5, telefone);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}

	public void RmFunc(int id) {
		String sql = "delete from funcionario where id = ?";
		try {
			RmAllDepenFromFunc(id);
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void RmAllDepenFromFunc(int id) {
		String sql = "delete from dependente where func_id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void AddDepen(int func_id, String cpf, String nome) {
		String sql = "insert into dependente " + "(cpf,nome,func_id)" + " values (?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cpf);
			stmt.setString(2, nome);
			stmt.setInt(3, func_id);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public void RmDepen(int id) {
		String sql = "delete from dependente where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Funcionario getFuncionario(int id) {
		try {
			Funcionario funcioario = new Funcionario();
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionario where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Funcionario
				funcioario.setId(rs.getInt("id"));
				funcioario.setNome(rs.getString("nome"));
				funcioario.setCpf(rs.getString("cpf"));
				funcioario.setEmail(rs.getString("email"));
				funcioario.setTelefone(rs.getString("telefone"));
				funcioario.setMatricula(rs.getString("matricula"));
			}
			rs.close();
			stmt.close();
			return funcioario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Dependente getDependente(int id) {
		try {
			Dependente dependente = new Dependente();
			PreparedStatement stmt = this.connection.prepareStatement("select * from dependente where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Funcionario
				dependente.setId(rs.getInt("id"));
				dependente.setNome(rs.getString("nome"));
				dependente.setCpf(rs.getString("cpf"));
				rs.close();
				stmt.close();
			}
			return dependente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
