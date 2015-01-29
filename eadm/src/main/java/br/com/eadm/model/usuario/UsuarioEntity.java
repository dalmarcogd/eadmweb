package br.com.eadm.model.usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.eadm.model.BasicEntity;

@Entity
@Table(name="usuario")
public class UsuarioEntity extends BasicEntity {

	private static final long serialVersionUID = -4578758892593140847L;
	
	@NotNull
	@Column(name="cd_usuario",updatable=false)
	private Long codigo;
	
	@NotNull
	@Column(name="nm_usuario")
	private String nome;
	
	@Column(name="dt_usuario")
	@Temporal(value=TemporalType.DATE)
	private Date data;
	
	@NotNull
	@Column(name="em_usuario")
	private String email;
	
	@NotNull
	@Column(name="lg_usuario")
	private String login;
	
	@NotNull
	@Column(name="ps_usuario")
	private String password;

	public UsuarioEntity() {
	
	}
	
	public UsuarioEntity(Long codigo, String nome, Date data, String email,
			String login, String password) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
