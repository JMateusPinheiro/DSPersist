package br.DAO;

import java.util.List;

import br.model.Dependente;
import br.model.Funcionario;

public interface DAO {
	
	public void AddFunc(String cpf, String matricula, String nome, String email, String telefone);
	
	public void RmFunc(int id);
	
	public void AddDepen(int func_id, String cpf, String nome);
	
	public void RmDepen(int id);
	
	public Funcionario getFuncionario(int id);
	
	public Dependente getDependente(int id);
	
	public List<Dependente> getDepenWithLetter(String a);
	
	public void getAllInfoAboutFuncs();
	
	public void beginTransaction();

	public void commit();

	public void rollback();

	public void close();
}
