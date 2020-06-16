package br.com.useinet.db;

import org.hibernate.HibernateException;

import br.com.useinet.vo.Tipo;

public class TipoDb extends DbClass {
	
	private Tipo tipo;
	
	public Long criaObjeto(String nome) {
		
		tipo = new Tipo();
		
		setObjeto(nome);
		
		try {
			return (Long)sessao.save(tipo);
		} catch (HibernateException e) {
			return null;
		}
	}
	
	public boolean atualizaObjeto(Long tipoId, String nome) {
		
		tipo = (Tipo)listaObjeto(tipoId);
		
		if (tipo == null) {
			return false;
		}
		
		setObjeto(nome);
		
		try {
			sessao.flush();
		} catch (HibernateException e) {
			return false;
		}
		
		return true;
	}
	
	private void setObjeto(String nome) {
		tipo.setNome(nome);
	}
	
}
