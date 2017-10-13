package br.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import br.model.Dependente;
import br.model.Funcionario;
import br.util.JPAUtil;

public class JpaDao implements DAO {
	EntityManager em;
	EntityTransaction tx;

	public JpaDao(){
		JPAUtil.init("postgres-unit");
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

	public List<Dependente> getDepenWithLetter(String a){
		//JPQL
		List<Dependente> depts = em.createQuery("FROM Dependente WHERE nome LIKE :letter",Dependente.class)
				.setParameter("letter", a + "%")
				.getResultList();
		
		//Criteria
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Dependente> cq = cb.createQuery(Dependente.class);
//		Root<Dependente> r = cq.from(Dependente.class);
//		ParameterExpression<String> p = cb.parameter(String.class, "letter");
//		List<Dependente> depts = em.createQuery(cq.where(cb.like(r.get("nome").as(String.class), p)))
//				.setParameter("letter", a + "%")
//				.getResultList();

		//NamedQuery
//		List<Dependente> depts = em.createNamedQuery("Dependente.getDepenWithLetter",Dependente.class)
//				.setParameter("letter", a + "%")
//				.getResultList();
		
		//Native SQL
//		List<Dependente> depts = em.createNativeQuery("SELECT * FROM Dependente as d WHERE d.nome LIKE :letter", Dependente.class)
//				.setParameter("letter", a + "%")
//				.getResultList();
//		
		return depts;
	}

	public void getAllInfoAboutFuncs(){
		//JPQL
//		List<Funcionario> funcs = em.createQuery("FROM Funcionario", Funcionario.class)
//				.getResultList();

		
		//CRITERIA
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
//		cq.from(Funcionario.class);
//		List<Funcionario> funcs = em.createQuery(cq).getResultList();
		
		//NAMED QUERY
//		List<Funcionario> funcs = em.createNamedQuery("Funcionario.getAllInfoAboutFuncs",Funcionario.class).getResultList();
		
		//NATIVE QUERY
		List<Funcionario> funcs = em.createNativeQuery("SELECT * FROM Funcionario",Funcionario.class).getResultList();
		
		for(Funcionario func : funcs){
			System.out.println(func.getId() + "--"  
					+ func.getCpf() + "--"  
					+ func.getMatricula() + "--"  
					+ func.getNome() + "--"  
					+ func.getEmail() + "--"  
					+ func.getTelefone());
		}

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