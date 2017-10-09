package br.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dependente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
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
	
	
}
