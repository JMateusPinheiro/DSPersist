package br.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.model.Dependente;
import br.model.Funcionario;
import br.util.JPAUtil;

public class JpaDao implements DAO {
	EntityManager em;
	EntityTransaction tx;

	public JpaDao(){
		JPAUtil.init("h2-unit");
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
	}

	public void AddFunc(String cpf, String matricula, String nome, String email, String telefone) {
		Funcionario funcionario = new Funcionario(cpf, matricula, nome, email, telefone);
		em.merge(funcionario);
	}

	public void RmFunc(int id) {
		em.remove(em.merge(getFuncionario(id)));
	}

	public void AddDepen(int func_id, String cpf, String nome) {
		Dependente dependente = new Dependente(cpf, nome, getFuncionario(func_id));
		em.merge(dependente);
	}

	public void RmDepen(int id) {
		em.remove(em.merge(getDependente(id)));
	}

	public Funcionario getFuncionario(int id) {
		return em.find(Funcionario.class, id); 
	}

	public Dependente getDependente(int id) {
		return em.find(Dependente.class, id); 
	}

	public void beginTransaction() {
		JPAUtil.beginTransaction();
	}

	public void commit() {
		JPAUtil.commit();
	}

	public void rollback() {
		JPAUtil.rollback();
	}

	public void close() {
		JPAUtil.closeEntityManager();
	}
}