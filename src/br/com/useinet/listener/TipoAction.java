package br.com.useinet.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.useinet.db.TipoDb;
import br.com.useinet.ui.TipoJTable;
import br.com.useinet.ui.TipoUI;
import br.com.useinet.vo.Tipo;

public class TipoAction implements ActionListener {

	private TipoUI tipoUI;
	private JTable table;
	private TipoDb tipoDb;
	private String tipo;

	public TipoAction(TipoUI tipoUI) {
		this.tipoUI = tipoUI;
		table = tipoUI.getJTable();
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getActionCommand().equals("Limpar")) {
			atualizaTela();
			return;
		}

		if (actionEvent.getActionCommand().equals("Incluir")) {

			if (!isCamposValidos()) {
				return;
			}

			tipoDb = new TipoDb();

			if (tipoDb.criaObjeto(tipo) == null) {
				JOptionPane.showMessageDialog(tipoUI, "Tipo já cadastrado.", "Registro existente",
						JOptionPane.WARNING_MESSAGE);
				tipoDb.descartaObjeto();
				return;
			}

			tipoDb.salvaObjeto();
			atualizaTela();
			return;
		}

		int linhaSelecionada = table.getSelectedRow();

		if (linhaSelecionada == -1) {
			JOptionPane.showMessageDialog(tipoUI, "Selecione um tipo.", "Selecionar registro",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String nome = (String) table.getValueAt(linhaSelecionada, 0);
		tipoDb = new TipoDb();
		Tipo tipo;

		try {
			tipo = (Tipo) tipoDb.listaObjetos("nome", nome).get(0);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(tipoUI, "Tipo não encontrado.", "Registro inexistente",
					JOptionPane.WARNING_MESSAGE);
			table = new TipoJTable(tipoUI.getJTextField());
			tipoUI.getJScrollPane().setViewportView(table);
			tipoDb.descartaObjeto();
			return;
		}

		if (actionEvent.getActionCommand().equals("Remover") && tipoDb.removeObjeto(tipo.getId())) {
			if (!tipoDb.salvaObjeto()) {
				JOptionPane.showMessageDialog(tipoUI, "Não foi possível remover o tipo.", "Remover registro",
						JOptionPane.WARNING_MESSAGE);
				tipoDb.descartaObjeto();
				return;
			}
			atualizaTela();
			return;
		}

		if (actionEvent.getActionCommand().equals("Alterar") && isCamposValidos()) {
			if (!tipoDb.atualizaObjeto(tipo.getId(), tipoUI.getJTextField().getText())) {
				JOptionPane.showMessageDialog(tipoUI, "Não foi possível atualizar o tipo.", "Atualizar registro",
						JOptionPane.WARNING_MESSAGE);
				tipoDb.descartaObjeto();
				return;
			}
			tipoDb.salvaObjeto();
			atualizaTela();
		}

	}

	private boolean isCamposValidos() {
		tipo = tipoUI.getJTextField().getText().trim();

		if (tipo.equals("")) {
			JOptionPane.showMessageDialog(tipoUI, "Preencha o campo tipo.", "Campo obrigatório",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;
	}

	private void atualizaTela() {
		table = new TipoJTable(tipoUI.getJTextField());
		tipoUI.getJTextField().setText("");
		tipoUI.getJScrollPane().setViewportView(table);
	}

}
