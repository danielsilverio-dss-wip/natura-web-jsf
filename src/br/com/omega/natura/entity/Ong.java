package br.com.omega.natura.entity;

public class Ong {

	private long id;

	private String nome;

	private String email;

	private String telefone;

	private String cnpj;

	private byte[] logo;

	// private List<Projeto> projetos;

	public Ong() {
	}

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
