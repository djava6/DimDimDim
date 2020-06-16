package br.com.useinet.db;

import org.hibernate.HibernateException;

import br.com.useinet.vo.Usuario;

public class UsuarioDb extends DbClass {

	private Usuario usuario;

	public Long criaObjeto(String nome, String login, String senha) {

		usuario = new Usuario();

		setObjeto(nome, login, senha);

		try {
			return (Long) sessao.save(usuario);
		} catch (HibernateException e) {
			return null;
		}
	}

	public boolean atualizaObjeto(Long usuarioId, String nome, String login, String senha) {

		usuario = (Usuario) listaObjeto(usuarioId);

		if (usuario == null) {
			return false;
		}

		setObjeto(nome, login, senha);

		try {
			sessao.flush();
		} catch (HibernateException e) {
			return false;
		}

		return true;
	}

	private void setObjeto(String nome, String login, String senha) {
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
	}

}
