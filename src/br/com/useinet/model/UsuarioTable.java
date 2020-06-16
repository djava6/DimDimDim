package br.com.useinet.model;

import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.useinet.db.UsuarioDb;
import br.com.useinet.vo.Usuario;

public class UsuarioTable extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<?> usuarios = new UsuarioDb().listaObjetosOrdenados();
	private String[] titulos = { "Nome", "Login", "Senha" };
	private Object[][] dados = new Object[getRowCount()][getColumnCount()];

	public UsuarioTable() {

		Usuario usuario = new Usuario();
		Iterator<?> iterator = usuarios.iterator();

		for (int i = 0; i < getRowCount(); i++) {
			usuario = (Usuario) iterator.next();
			for (int j = 0; j < getColumnCount(); j++) {

				switch (j) {
				case 0:
					setValueAt(usuario.getNome(), i, j);
					break;

				case 1:
					setValueAt(usuario.getLogin(), i, j);
					break;

				case 2:
					setValueAt(usuario.getSenha(), i, j);
					break;

				default:
					break;
				}

			}
		}
	}

	public int getRowCount() {
		return usuarios.size();
	}

	public int getColumnCount() {
		return titulos.length;
	}

	public String getColumnName(int col) {
		return titulos[col];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return dados[rowIndex][columnIndex];
	}

	public void setValueAt(Object value, int row, int col) {
		dados[row][col] = value;
	}

}
