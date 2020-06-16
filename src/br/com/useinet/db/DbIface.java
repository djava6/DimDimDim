package br.com.useinet.db;

import java.util.List;

public interface DbIface {

	public List<?> listaObjetos();

	public Object listaObjeto(Long objetoId);

	public boolean removeObjeto(Long objetoId);

	public boolean salvaObjeto();

}