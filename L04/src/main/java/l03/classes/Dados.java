package l03.classes;

import java.io.Serializable;
import java.util.List;

public class Dados implements Serializable{
	
	private static final long serialVersionUID = 5740571625851096984L;
	
	List<Deputado> dados;
	List<Links> links;
	
	public List<Deputado> getDados() {
		return dados;
	}

	public void setDados(List<Deputado> dados) {
		this.dados = dados;
	}
	
	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}
	
}
