package l03.classes;

public class Servico {
	String Id;
	String dbId;
	String Nome;
	String Sigla;
	String Descricao;
	String Contato;
	String Gratuito;
	String PorcentagemManual;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getDbId() {
		return dbId;
	}
	public void setDbId(String dbId) {
		this.dbId = dbId;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSigla() {
		return Sigla;
	}
	public void setSigla(String sigla) {
		Sigla = sigla;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public String getContato() {
		return Contato;
	}
	public void setContato(String contato) {
		Contato = contato;
	}
	public String getGratuito() {
		return Gratuito;
	}
	public void setGratuito(String gratuito) {
		Gratuito = gratuito;
	}
	public String getPorcentagemManual() {
		return PorcentagemManual;
	}
	public void setPorcentagemManual(String porcentagemManual) {
		PorcentagemManual = porcentagemManual;
	}


}
