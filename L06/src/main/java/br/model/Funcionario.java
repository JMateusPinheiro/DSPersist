package br.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Funcionario.getAllInfoAboutFuncs",query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable{
	public Funcionario(String cpf, String matricula, String nome, String email, String telefone) {
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Funcionario(){}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(unique=true)
	String cpf;
	
	@Column(unique=true)
	String matricula;
	
	String nome;
	
	String email;
	
	String telefone;
	
	@OneToMany(mappedBy="func", targetEntity = Dependente.class, cascade = CascadeType.ALL)
	private List<Dependente> depts; 
		
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public List<Dependente> getDepts() {
		return depts;
	}


	public void setDepts(List<Dependente> depts) {
		this.depts = depts;
	}

}
