package br.com.useinet.model;

import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.useinet.db.DespesaDb;
import br.com.useinet.util.Data;
import br.com.useinet.util.Decimal;
import br.com.useinet.vo.Despesa;

public class DespesaTable extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<?> despesas = new DespesaDb().listaObjetosOrdenados();
	private String[] titulos = { "Despesa", "Tipo", "Valor", "Data" };
	private Object[][] dados = new Object[getRowCount()][getColumnCount()];

	public DespesaTable() {

		Despesa despesa = new Despesa();
		Iterator<?> iterator = despesas.iterator();

		for (int i = 0; i < getRowCount(); i++) {
			despesa = (Despesa) iterator.next();
			for (int j = 0; j < getColumnCount(); j++) {
				switch (j) {
				case 0:
					setValueAt(despesa.getNome(), i, j);
					break;

				case 1:
					setValueAt(despesa.getTipo().getNome(), i, j);
					break;

				case 2:
					setValueAt(new Decimal(Double.parseDouble(despesa.getValor())).getValor(), i, j);
					break;

				case 3:
					setValueAt(new Data(despesa.getData()).getValor(), i, j);
					break;

				default:
					break;
				}
			}
		}
	}

	public int getRowCount() {
		return despesas.size();
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
