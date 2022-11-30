package aplication.natalia.aplication.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

//Indicar que essa classe será mapeada
//pelo Hibernate como uma tabela no banco de dados:
@Entity(name = "usuario") //coloco name = "usuario" caso o nome da classe seja diferente do nome da tabela
public class Usuario
{
	@NotNull(message = "O nome do usuário precisa ser preenchido!") //mensagem que aparece na tela
	private String nome;
	
	@NotNull(message = "A senha do usuário precisa ser preenchida!")
	@Size(min = 5, max = 20, message = "O tamanho da senha deve estar entre 5 e 20 caracteres!")
	private String senha;
	
	@NotNull(message = "O email do usuário precisa ser preenchido!")
	@Email(message = "E-email em formato inválido!")
	private String email;
	
	private String telefone;
	
	@NotNull(message = "O cpf do usuário precisa ser preenchido!")
	//posso criar uma anotação customizada que checa se cpf é válido (@Cpf)
	private String cpf;
	
	//pk já é automaticamente não nula
	@Id //indico que será a chave-primária da tabela
	@GeneratedValue //gerar o id automaticamente
	@Column(name = "id_usuario") //por ter nome diferente do da tabela, indico qual é respectivo
	private Integer id;
	
	@OneToMany(fetch = FetchType.LAZY) //indica relação e tals, tem explicacao melhor em Permissao.java
				//quando carregar o usuário, ele não carrega a lista, tenho que pedir para ele carregar
				//para melhor desempenho com muitos dados
				//o padrão é FetchType.EAGER
	private List<Permissao> listaPermissoes;
	
	//Se tiver atributos a menos, pode gerar uma exceção automaticamente ou gerar um warning caso for opcional
	//@Transient //(import -> javax.persistence) //se tiver atributos a mais, tem que indicar que não existe na tabela
	//private String aux;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
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
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Permissao> getListaPermissoes() {
		return listaPermissoes;
	}

	public void setListaPermissoes(List<Permissao> listaPermissoes) {
		this.listaPermissoes = listaPermissoes;
	}
}

