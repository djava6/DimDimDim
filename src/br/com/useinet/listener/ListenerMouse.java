package br.com.useinet.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextField;

public class ListenerMouse implements MouseListener {
	
	private JTextField textField = null;
	private JTable table = null;

	public ListenerMouse(JTextField textField, JTable table) {
		this.textField = textField;
		this.table = table;
	}

	public void mouseClicked(MouseEvent e) {
		
		int linhaSelecionada = table.getSelectedRow();		
		String nome = (String)table.getValueAt(linhaSelecionada, 0);
		
		textField.setText(nome);
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
