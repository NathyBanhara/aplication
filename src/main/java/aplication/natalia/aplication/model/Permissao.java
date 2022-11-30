package aplication.natalia.aplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Permissao {
	@Id
	private Integer idPermissao;
	
	private String papel;
	
	@ManyToOne  //(não é obrigatório e pode ser menos eficiente, pois nem sempre quero saber todos os dados do usuario
				//quando chamar a tabela permissao) informar a cardinalidade da relação e
	            //indicar relacionamente -> preenchendo usuario automaticamente para mim
	private Usuario usuario; //tem os dados do usuario

	public Integer getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Integer idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
