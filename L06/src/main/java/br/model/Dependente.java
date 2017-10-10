package br.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Dependente.getDepenWithLetter",query="SELECT d FROM Dependente d WHERE d.nome LIKE :letter")
public class Dependente implements Serializable{
	
	public Dependente(String cpf, String nome, Funcionario func) {
		this.cpf = cpf;
		this.nome = nome;
		this.func = func;
	}
	public Dependente(){	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(unique=true)
	String cpf;
	
	String nome;
	
	@ManyToOne
	@JoinColumn(name="func_id")
	private Funcionario func;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Funcionario getFunc() {
		return func;
	}
	public void setFunc(Funcionario func) {
		this.func = func;
	}
	
	
}
