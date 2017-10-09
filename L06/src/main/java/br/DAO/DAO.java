package br.DAO;

public interface DAO {
	
	public void AddFunc(String cpf, String matricula, String nome, String email, String telefone);
	
	public void RmFunc(int id);
	
	public void AddDepen(int id_func, String cpf, String nome);
	
	public void RmDepen(int id);

}
