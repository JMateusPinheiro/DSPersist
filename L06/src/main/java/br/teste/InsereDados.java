package br.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.DAO.DAO;
import br.DAO.JdbcDao;
import br.util.JPAUtil;


public class InsereDados {
	
	public static void main(String[] args) {
		/*Opções de BD disponiveis são:
		 * h2-unit
		 * postgres-unit 
		 * */
/*		JPAUtil.init("h2-unit");
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			JPAUtil.closeEntityManager();
		}
*/
		DAO jdbc = new JdbcDao();
		jdbc.AddFunc("7767", "7765", "José", "jose@gmail.com", "8898898989898");
		
	}
}
