package br.com.useinet.db;

import org.hibernate.HibernateException;

import br.com.useinet.vo.Renda;

public class RendaDb extends DbClass {

	private Renda renda;

	public Long criaObjeto(String nome, String valor) {

		renda = new Renda();

		setObjeto(nome, valor);

		try {
			return (Long) sessao.save(renda);
		} catch (HibernateException e) {
			return null;
		}
	}

	public boolean atualizaObjeto(Long rendaId, String nome, String valor) {

		renda = (Renda) listaObjeto(rendaId);

		if (renda == null) {
			return false;
		}

		setObjeto(nome, valor);

		try {
			sessao.flush();
		} catch (HibernateException e) {
			return false;
		}

		return true;
	}

	private void setObjeto(String nome, String valor) {
		renda.setNome(nome);
		renda.setValor(valor);
	}

}
