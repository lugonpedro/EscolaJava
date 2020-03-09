package model;

public class Usuario {
	private int nivel;
	private String nome;
	private String login;
	private String senha;
	private String tel;
	private String email;
	private String nasc;
	private String cpf;
	
	public Usuario(int nivel, String nome, String login, String senha, String cpf, String tel, String email, String nasc) {
		this.nivel = nivel;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tel = tel;
		this.email = email;
		this.nasc = nasc;
		this.cpf = cpf;
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return tel;
	}

	public void setTelefone(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNasc() {
		return nasc;
	}


	public void setNasc(String nasc) {
		this.nasc = nasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getNivel() {
		return nivel;
	}
	
}
