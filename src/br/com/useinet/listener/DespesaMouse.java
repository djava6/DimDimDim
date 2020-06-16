package br.com.useinet.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class DespesaMouse implements MouseListener {

	private JTextField textField = null;
	private JComboBox comboBox = null;
	private JTextField textField1 = null;
	private JTextField textField2 = null;
	private JTable table = null;

	public DespesaMouse(JTextField textField, JComboBox comboBox, JTextField textField1, JTextField textField2, JTable table) {
		this.textField = textField;
		this.comboBox = comboBox;
		this.textField1 = textField1;
		this.textField2 = textField2;
		this.table = table;
	}

	public void mouseClicked(MouseEvent e) {
		int linhaSelecionada = table.getSelectedRow();
		String nome = (String) table.getValueAt(linhaSelecionada, 0);
		String tipo = (String) table.getValueAt(linhaSelecionada, 1);
		String valor = (String) table.getValueAt(linhaSelecionada, 2);
		String data = table.getValueAt(linhaSelecionada, 3).toString();
		textField.setText(nome);
		comboBox.setSelectedItem(tipo);
		textField1.setText(valor);
		textField2.setText(data);
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
