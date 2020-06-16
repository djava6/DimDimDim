package br.com.useinet.ui;

import java.util.Iterator;

import javax.swing.JComboBox;

import br.com.useinet.db.TipoDb;
import br.com.useinet.vo.Tipo;

public class TipoJComboBox extends JComboBox {

	private static final long serialVersionUID = 1L;

	public TipoJComboBox() {
		super();
		setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		setToolTipText("Selecione um tipo de despesa");
		
		addItem("  ");
		
		Iterator<?> i = new TipoDb().listaObjetosOrdenados().iterator();
		
		while (i.hasNext()) {
			Tipo tipo = (Tipo)i.next();
			addItem(tipo.getNome());
		}
		
	}

}