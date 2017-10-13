package br.ui;

import java.util.List;

import br.DAO.DAO;
import br.DAO.JpaDao;
import br.model.Dependente;

public class TesteClass {
	
	public static void main(String[] args) {
		
		DAO jpa = new JpaDao();
//		DAO jdbc = new JdbcDao();
		try {
//			jdbc.beginTransaction();
			jpa.beginTransaction();
			
//			jpa.AddFunc("123", "123", "João", "joao@email.com", "999999989");
//			jpa.AddFunc("223", "223", "Jose", "jose@email.com", "899999989");
//			jpa.AddFunc("213", "213", "Joaquim", "joaquim@email.com", "899979989");
//			jpa.AddFunc("221", "221", "Jorge", "jorge@email.com", "899949989");
//			jpa.AddFunc("243", "243", "Joselito", "joselito@email.com", "899699989");
//			jpa.AddFunc("523", "523", "Jonata", "jonata@email.com", "899899989");
//			jpa.AddDepen(1, "776", "Maria");
//			jpa.AddDepen(2, "176", "Carla");
//			jpa.AddDepen(2, "756", "Marlucia");
//			jpa.AddDepen(3, "746", "Mariana");
//			jpa.AddDepen(4, "786", "Marivalda");
			
//			jpa.AddDepen(3, "736", "Marta");
//			jpa.RmFunc(1);
			
//			jdbc.AddDepen(1, "111", "Bruna");
//			jdbc.RmFunc(1);
			
			List<Dependente> depts = jpa.getDepenWithLetter("M");
			for(Dependente dept : depts){
				System.out.println("Dependente: " + dept.getNome().toString() + " --- Funcionario: " + (dept.getFunc().getNome().toString()));
			}
			
//			jpa.getAllInfoAboutFuncs();
			
//			jdbc.commit();
			jpa.commit();
		} catch (Exception e) {
//			jdbc.rollback();
			jpa.rollback();
			e.printStackTrace();
		} finally {
//			jdbc.close();
			jpa.close();
		}
	}
}
