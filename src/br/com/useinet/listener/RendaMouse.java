package br.com.useinet.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextField;

public class RendaMouse implements MouseListener {

	private JTextField textField = null;
	private JTextField textField1 = null;
	private JTable table = null;

	public RendaMouse(JTextField textField, JTextField textField1, JTable table) {
		this.textField = textField;
		this.textField1 = textField1;
		this.table = table;
	}

	public void mouseClicked(MouseEvent e) {

		int linhaSelecionada = table.getSelectedRow();
		String nome = (String) table.getValueAt(linhaSelecionada, 0);
		String valor = (String) table.getValueAt(linhaSelecionada, 1);

		textField.setText(nome);
		textField1.setText(valor);
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

}
