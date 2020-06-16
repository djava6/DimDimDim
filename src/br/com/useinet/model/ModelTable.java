package br.com.useinet.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.useinet.vo.VoClass;

public abstract class ModelTable extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	protected List<?> objetos;			
	protected String[] titulos = {"Nome"};
	protected Object[][] dados;
	protected VoClass voClass = new VoClass();

	public int getRowCount() {
		return objetos.size();
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
