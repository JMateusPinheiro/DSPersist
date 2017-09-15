/**
 * 
 */
package l03.classes;

import java.io.Serializable;

/**
 * @author J.Mateus
 *
 */
public class Deputado implements Serializable{
	String id;
	String uri;
	String nome;
	String siglaPartido;
	String uriPartido;
	String siglaUf;
	String idLegislatura;
	String urlFoto;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSiglaPartido() {
		return siglaPartido;
	}
	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}
	public String getUriPartido() {
		return uriPartido;
	}
	public void setUriPartido(String uriPartido) {
		this.uriPartido = uriPartido;
	}
	public String getSiglaUf() {
		return siglaUf;
	}
	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}
	public String getIdLegislatura() {
		return idLegislatura;
	}
	public void setIdLegislatura(String idLegislatura) {
		this.idLegislatura = idLegislatura;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
}
