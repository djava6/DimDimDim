package br.com.useinet.ui;

import javax.swing.JTextField;

import br.com.useinet.model.TipoTable;

public class TipoJTable extends NomeJTable {

	private static final long serialVersionUID = 1L;

	public TipoJTable(JTextField textField) {
		super(textField);
		setToolTipText("Selecione um tipo");		
		setModel(new TipoTable());
	}

}
