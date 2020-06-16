package br.com.useinet.ui;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import br.com.useinet.listener.UsuarioMouse;
import br.com.useinet.model.UsuarioTable;

public class UsuarioJTable extends JTable {

	private static final long serialVersionUID = 1L;

	public UsuarioJTable(JTextField textField, JTextField textField1, JTextField textField2) {
		setModel(new UsuarioTable());
		setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		setToolTipText("Selecione um usuário");

		TableColumn colunaUsuario = getColumnModel().getColumn(0);
		colunaUsuario.setPreferredWidth(60);

		TableColumn colunaLogin = getColumnModel().getColumn(1);
		colunaLogin.setPreferredWidth(20);

		TableColumn colunaSenha = getColumnModel().getColumn(2);
		colunaSenha.setPreferredWidth(20);

		addMouseListener(new UsuarioMouse(textField, textField1, textField2, this));
	}

}
