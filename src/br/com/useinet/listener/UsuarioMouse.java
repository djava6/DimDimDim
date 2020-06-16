package br.com.useinet.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextField;

public class UsuarioMouse implements MouseListener {

	private JTextField textField = null;
	private JTextField textField1 = null;
	private JTextField textField2 = null;
	private JTable table = null;

	public UsuarioMouse(JTextField textField, JTextField textField1, JTextField textField2, JTable table) {
		this.textField = textField;
		this.textField1 = textField1;
		this.textField2 = textField2;
		this.table = table;
	}

	public void mouseClicked(MouseEvent e) {

		int linhaSelecionada = table.getSelectedRow();
		String nome = (String) table.getValueAt(linhaSelecionada, 0);
		String login = (String) table.getValueAt(linhaSelecionada, 1);
		String senha = (String) table.getValueAt(linhaSelecionada, 2);

		textField.setText(nome);
		textField1.setText(login);
		textField2.setText(senha);
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
