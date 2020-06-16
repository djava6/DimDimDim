package br.com.useinet.db;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.useinet.util.HibernateUtil;

public class DbClass implements DbIface {

	protected Session sessao;
	private String nomeClasseDb = this.getClass().getSimpleName();
	private String nomeClasseVo = nomeClasseDb.substring(0, nomeClasseDb.length() - 2);
	private String nomeCompletoClasseVo = "br.com.useinet.vo." + nomeClasseVo;

	public DbClass() throws HibernateException {
		sessao = HibernateUtil.getSessaoFactory().getCurrentSession();
		sessao.beginTransaction();
	}

	public List<?> listaObjetos() {
		try {
			return sessao.createCriteria(nomeCompletoClasseVo).list();
		} catch (HibernateException e) {
			return null;
		}
	}

	public List<?> listaObjetos(String campo, Object valor) {
		try {
			return sessao.createCriteria(nomeCompletoClasseVo).add(Restrictions.eq(campo, valor)).list();
		} catch (HibernateException e) {
			return null;
		}
	}

	public List<?> listaObjetos(String campo, Object valor, String campo1, Object valor1) {
		try {
			return sessao.createCriteria(nomeCompletoClasseVo).add(Restrictions.eq(campo, valor)).add(Restrictions.eq(campo1, valor1))
					.list();
		} catch (HibernateException e) {
			return null;
		}
	}

	public Object listaObjeto(Long objetoId) {
		try {
			return sessao.get(nomeCompletoClasseVo, objetoId);
		} catch (HibernateException e) {
			return null;
		}
	}

	public List<?> listaObjetosOrdenados() {
		try {
			return sessao.createCriteria(nomeCompletoClasseVo).addOrder(Order.asc("nome")).list();
		} catch (HibernateException e) {
			return null;
		}
	}

	public boolean removeObjeto(Long objetoId) {
		Object objeto = listaObjeto(objetoId);

		if (objeto == null) {
			return false;
		}

		sessao.delete(objeto);
		return true;
	}

	public boolean salvaObjeto() {
		try {
			sessao.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean descartaObjeto() {
		try {
			sessao.getTransaction().rollback();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

}
