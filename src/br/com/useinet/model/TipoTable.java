package br.com.useinet.model;

import java.util.Iterator;

import br.com.useinet.db.TipoDb;
import br.com.useinet.vo.VoClass;

public class TipoTable extends ModelTable {

	private static final long serialVersionUID = 1L;

	public TipoTable() {
		super();
		objetos = new TipoDb().listaObjetosOrdenados();
		dados = new Object[getRowCount()][getColumnCount()];
		Iterator<?> iterator = objetos.iterator();
		
		for (int i = 0; i < getRowCount(); i++) {
			voClass = (VoClass)iterator.next();
			setValueAt(voClass.getNome(), i, 0);
		}

	}

}
