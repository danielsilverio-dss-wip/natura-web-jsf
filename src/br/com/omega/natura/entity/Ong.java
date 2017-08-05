package br.com.omega.natura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="TB_ONG")
public class Ong {
	@Id
	@Column(name="id_ong")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="nm_nome")
	private String nome;
	
	@Column(name="nm_email")
	private String email;
	
	@Column(name="nr_telefone")
	private String telefone;
	
	@Column(name="nr_cnpj")
	private String cnpj;
	
	@Lob
	private byte[] logo;
	
//  private List<Projeto> projetos;
	
	public Ong(){}
	
	public Ong(String nome, String email, String telefone, String cnpj, byte[] logo) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.logo = logo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	
	
	

}
