package br.com.useinet.vo;

public class Usuario extends VoClass {

	private String login;
	private String senha;

	public Usuario() {

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

}
