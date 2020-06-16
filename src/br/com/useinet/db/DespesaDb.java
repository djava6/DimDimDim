package br.com.useinet.db;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.useinet.vo.Despesa;
import br.com.useinet.vo.Tipo;

public class DespesaDb extends DbClass {

	private Despesa despesa;

	public Object listaObjeto(String nome, Tipo tipo) {
		try {
			return sessao.createCriteria(Despesa.class).add(Restrictions.eq("nome", nome)).add(Restrictions.eq("tipo", tipo))
					.uniqueResult();
		} catch (HibernateException e) {
			return null;
		}
	}

	public List<?> listaObjetosOrdenados() {
		try {
			return sessao.createCriteria(Despesa.class).addOrder(Order.asc("tipo")).addOrder(Order.asc("nome")).list();
		} catch (HibernateException e) {
			return null;
		}
	}

	public Long criaObjeto(String nome, Tipo tipo, String valor, Date data) {

		despesa = new Despesa();

		setObjeto(nome, tipo, valor, data);

		try {
			return (Long) sessao.save(despesa);
		} catch (HibernateException e) {
			return null;
		}
	}

	public boolean atualizaObjeto(Long despesaId, String nome, Tipo tipo, String valor, Date data) {

		despesa = (Despesa) listaObjeto(despesaId);

		if (despesa == null) {
			return false;
		}

		setObjeto(nome, tipo, valor, data);

		try {
			sessao.flush();
		} catch (HibernateException e) {
			return false;
		}

		return true;
	}

	private void setObjeto(String nome, Tipo tipo, String valor, Date data) {
		despesa.setNome(nome);
		despesa.setTipo(tipo);
		despesa.setValor(valor);
		despesa.setData(data);
	}

}
