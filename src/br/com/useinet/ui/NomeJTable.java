package br.com.useinet.ui;

import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.useinet.listener.ListenerMouse;

public abstract class NomeJTable extends JTable {

	private static final long serialVersionUID = 1L;

	public NomeJTable(JTextField textField) {
		setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);		
		addMouseListener(new ListenerMouse(textField, this));
	}

}
