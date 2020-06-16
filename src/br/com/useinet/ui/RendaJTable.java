package br.com.useinet.ui;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import br.com.useinet.listener.RendaMouse;
import br.com.useinet.model.RendaTable;

public class RendaJTable extends JTable {

	private static final long serialVersionUID = 1L;

	public RendaJTable(JTextField textField, JTextField textField1) {
		setModel(new RendaTable());
		setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		setToolTipText("Selecione uma renda");

		TableColumn colunaRenda = getColumnModel().getColumn(0);
		colunaRenda.setPreferredWidth(80);

		TableColumn colunaValor = getColumnModel().getColumn(1);
		colunaValor.setPreferredWidth(20);

		addMouseListener(new RendaMouse(textField, textField1, this));
	}

}
