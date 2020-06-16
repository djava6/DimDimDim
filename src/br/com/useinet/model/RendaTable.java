package br.com.useinet.model;

import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.useinet.db.RendaDb;
import br.com.useinet.util.Decimal;
import br.com.useinet.util.LogUtil;
import br.com.useinet.vo.Renda;

public class RendaTable extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<?> rendas = new RendaDb().listaObjetosOrdenados();
	private String[] titulos = { "Renda", "Valor" };
	private Object[][] dados = new Object[getRowCount()][getColumnCount()];

	public RendaTable() {

		Renda renda = new Renda();
		Iterator<?> iterator = rendas.iterator();

		for (int i = 0; i < getRowCount(); i++) {
			renda = (Renda) iterator.next();
			for (int j = 0; j < getColumnCount(); j++) {
				setValueAt(j == 0 ? renda.getNome() : new Decimal(Double.parseDouble(renda.getValor())).getValor(), i,
						j);
				LogUtil.getLogger().info(new Decimal(Double.parseDouble(renda.getValor())));
			}
		}
	}

	public int getRowCount() {
		return rendas.size();
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
