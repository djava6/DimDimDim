package br.com.useinet.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.useinet.db.DespesaDb;
import br.com.useinet.db.TipoDb;
import br.com.useinet.ui.DespesaJTable;
import br.com.useinet.ui.DespesaJTextPane;
import br.com.useinet.ui.DespesaRelatorioUI;
import br.com.useinet.ui.DespesaUI;
import br.com.useinet.ui.TipoJComboBox;
import br.com.useinet.util.Data;
import br.com.useinet.util.Decimal;
import br.com.useinet.vo.Despesa;
import br.com.useinet.vo.Tipo;

public class DespesaAction implements ActionListener {

	private DespesaUI despesaUI;
	private JTable table;
	private DespesaDb despesaDb;
	private String nomeDespesa;
	private String valorDespesa;
	private String nomeTipo;
	private String dataDespesa;
	private Tipo tipo;
	private Double valor;
	private Date data;
	private DespesaRelatorioUI relatorioUI;

	public DespesaAction(DespesaUI despesaUI) {
		this.despesaUI = despesaUI;
		table = despesaUI.getJTable();
	}

	public DespesaAction(DespesaRelatorioUI relatorioUI) {
		this.relatorioUI = relatorioUI;
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getActionCommand().equals("Fechar")) {
			relatorioUI.dispose();
			return;
		}

		if (actionEvent.getActionCommand().equals("Recarregar")) {
			relatorioUI.getJScrollPane().setViewportView(new DespesaJTextPane(relatorioUI));
			return;
		}

		if (actionEvent.getActionCommand().equals("Limpar")) {
			atualizaTela();
			return;
		}

		if (actionEvent.getActionCommand().equals("Atualizar")) {
			despesaUI.getJComboBox().setModel(new TipoJComboBox().getModel());
			return;
		}

		if (actionEvent.getActionCommand().equals("Incluir")) {

			if (!isCamposValidos()) {
				return;
			}

			despesaDb = new DespesaDb();

			if (despesaDb.criaObjeto(nomeDespesa, tipo, valor.toString(), data) == null) {
				JOptionPane.showMessageDialog(despesaUI, "Despesa já cadastrada.", "Registro existente", JOptionPane.WARNING_MESSAGE);
				despesaDb.descartaObjeto();
				return;
			}

			despesaDb.salvaObjeto();
			atualizaTela();
			return;
		}

		int linhaSelecionada = table.getSelectedRow();

		if (linhaSelecionada == -1) {
			JOptionPane.showMessageDialog(despesaUI, "Selecione uma despesa.", "Selecionar registro", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String despesaNome = (String) table.getValueAt(linhaSelecionada, 0);
		String tipoNome = (String) table.getValueAt(linhaSelecionada, 1);

		Tipo tipoVo;

		try {
			tipoVo = (Tipo) new TipoDb().listaObjetos("nome", tipoNome).get(0);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(despesaUI, "Tipo não encontrado.", "Registro inexistente", JOptionPane.WARNING_MESSAGE);
			despesaUI.getJComboBox().setModel(new TipoJComboBox().getModel());
			return;
		}

		despesaDb = new DespesaDb();
		Despesa despesa;

		if ((despesa = (Despesa) despesaDb.listaObjeto(despesaNome, tipoVo)) == null) {
			JOptionPane.showMessageDialog(despesaUI, "Despesa não encontrada.", "Registro inexistente", JOptionPane.WARNING_MESSAGE);
			table = new DespesaJTable(despesaUI.getJTextField(), despesaUI.getJComboBox(), despesaUI.getJTextField1(), despesaUI
					.getJTextField2());
			despesaUI.getJScrollPane().setViewportView(table);
			despesaDb.descartaObjeto();
			return;
		}

		if (actionEvent.getActionCommand().equals("Remover") && despesaDb.removeObjeto(despesa.getId())) {
			if (!despesaDb.salvaObjeto()) {
				JOptionPane.showMessageDialog(despesaUI, "Não foi possível remover a despesa.", "Remover registro",
						JOptionPane.WARNING_MESSAGE);
				despesaDb.descartaObjeto();
				return;
			}
			atualizaTela();
			return;
		}

		if (actionEvent.getActionCommand().equals("Alterar") && isCamposValidos()) {
			if (!despesaDb.atualizaObjeto(despesa.getId(), nomeDespesa, tipo, valor.toString(), data)) {
				JOptionPane.showMessageDialog(despesaUI, "Não foi possível atualizar a despesa.", "Atualizar registro",
						JOptionPane.WARNING_MESSAGE);
				despesaDb.descartaObjeto();
				return;
			}
			despesaDb.salvaObjeto();
			atualizaTela();
		}

	}

	private boolean isCamposValidos() {
		nomeDespesa = despesaUI.getJTextField().getText().trim();
		nomeTipo = ((String) despesaUI.getJComboBox().getSelectedItem()).trim();
		valorDespesa = despesaUI.getJTextField1().getText().trim();
		dataDespesa = despesaUI.getJTextField2().getText().trim();

		if (nomeDespesa.equals("")) {
			JOptionPane
					.showMessageDialog(despesaUI, "Preencha o campo despesa.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		if (nomeTipo.equals("")) {
			JOptionPane.showMessageDialog(despesaUI, "Selecione um tipo.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			try {
				tipo = (Tipo) new TipoDb().listaObjetos("nome", nomeTipo).get(0);
			} catch (IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(despesaUI, "Tipo não encontrado.", "Registro inexistente", JOptionPane.WARNING_MESSAGE);
				despesaUI.getJComboBox().setModel(new TipoJComboBox().getModel());
				return false;
			}
		}

		if (valorDespesa.equals("")) {
			JOptionPane.showMessageDialog(despesaUI, "Preencha o campo valor.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			try {
				valor = new Decimal(valorDespesa).getDecimal();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(despesaUI, "O campo valor deve conter apenas números.", "Campo inválido",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}

		if (dataDespesa.equals("")) {
			JOptionPane.showMessageDialog(despesaUI, "Preencha o campo data.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			try {
				data = new Data(dataDespesa).getData();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(despesaUI, "O campo data deve ser no formato DD/MM/AA.", "Campo inválido",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}

		return true;
	}

	private void atualizaTela() {
		table = new DespesaJTable(despesaUI.getJTextField(), despesaUI.getJComboBox(), despesaUI.getJTextField1(), despesaUI
				.getJTextField2());
		despesaUI.getJTextField().setText("");
		despesaUI.getJComboBox().setModel(new TipoJComboBox().getModel());
		despesaUI.getJTextField1().setText("");
		despesaUI.getJTextField2().setText("");
		despesaUI.getJScrollPane().setViewportView(table);
	}

}
