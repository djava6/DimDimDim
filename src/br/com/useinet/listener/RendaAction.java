package br.com.useinet.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.useinet.db.RendaDb;
import br.com.useinet.ui.RendaJTable;
import br.com.useinet.ui.RendaJTextPane;
import br.com.useinet.ui.RendaRelatorioUI;
import br.com.useinet.ui.RendaUI;
import br.com.useinet.util.Decimal;
import br.com.useinet.vo.Renda;

public class RendaAction implements ActionListener {

	private RendaUI rendaUI;
	private RendaRelatorioUI relatorioUI;
	private JTable table;
	private RendaDb rendaDb;
	private String rendaNome;
	private String valorRenda;
	private Double valor;

	public RendaAction(RendaUI rendaUI) {
		this.rendaUI = rendaUI;
		table = rendaUI.getJTable();
	}

	public RendaAction(RendaRelatorioUI relatorioUI) {
		this.relatorioUI = relatorioUI;
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getActionCommand().equals("Fechar")) {
			relatorioUI.dispose();
			return;
		}

		if (actionEvent.getActionCommand().equals("Recarregar")) {
			relatorioUI.getJScrollPane().setViewportView(new RendaJTextPane(relatorioUI));
			return;
		}

		if (actionEvent.getActionCommand().equals("Limpar")) {
			atualizaTela();
			return;
		}

		if (actionEvent.getActionCommand().equals("Incluir")) {

			if (!isCamposValidos()) {
				return;
			}

			rendaDb = new RendaDb();

			if (rendaDb.criaObjeto(rendaNome, valor.toString()) == null) {
				JOptionPane.showMessageDialog(rendaUI, "Renda já cadastrada.", "Registro existente",
						JOptionPane.WARNING_MESSAGE);
				rendaDb.descartaObjeto();
				return;
			}

			rendaDb.salvaObjeto();
			atualizaTela();
			return;
		}

		int linhaSelecionada = table.getSelectedRow();

		if (linhaSelecionada == -1) {
			JOptionPane.showMessageDialog(rendaUI, "Selecione uma renda.", "Selecionar registro",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String nome = (String) table.getValueAt(linhaSelecionada, 0);
		rendaDb = new RendaDb();
		Renda renda;

		try {
			renda = (Renda) rendaDb.listaObjetos("nome", nome).get(0);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(rendaUI, "Renda não encontrada.", "Registro inexistente",
					JOptionPane.WARNING_MESSAGE);
			table = new RendaJTable(rendaUI.getJTextField(), rendaUI.getJTextField1());
			rendaUI.getJScrollPane().setViewportView(table);
			rendaDb.descartaObjeto();
			return;
		}

		if (actionEvent.getActionCommand().equals("Remover") && rendaDb.removeObjeto(renda.getId())) {
			if (!rendaDb.salvaObjeto()) {
				JOptionPane.showMessageDialog(rendaUI, "Não foi possível remover a renda.", "Remover registro",
						JOptionPane.WARNING_MESSAGE);
				rendaDb.descartaObjeto();
				return;
			}
			atualizaTela();
			return;
		}

		if (actionEvent.getActionCommand().equals("Alterar") && isCamposValidos()) {
			if (!rendaDb.atualizaObjeto(renda.getId(), rendaNome, valor.toString())) {
				JOptionPane.showMessageDialog(rendaUI, "Não foi possível atualizar a renda.", "Atualizar registro",
						JOptionPane.WARNING_MESSAGE);
				rendaDb.descartaObjeto();
				return;
			}
			rendaDb.salvaObjeto();
			atualizaTela();
		}

	}

	private boolean isCamposValidos() {
		rendaNome = rendaUI.getJTextField().getText().trim();
		valorRenda = rendaUI.getJTextField1().getText().trim();

		if (rendaNome.equals("")) {
			JOptionPane.showMessageDialog(rendaUI, "Preencha o campo renda.", "Campo obrigatório",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		if (valorRenda.equals("")) {
			JOptionPane.showMessageDialog(rendaUI, "Preencha o campo valor.", "Campo obrigatório",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			try {
				valor = new Decimal(valorRenda).getDecimal();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(rendaUI, "O campo valor deve conter apenas números.", "Campo inválido",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}

		return true;
	}

	private void atualizaTela() {
		table = new RendaJTable(rendaUI.getJTextField(), rendaUI.getJTextField1());
		rendaUI.getJTextField().setText("");
		rendaUI.getJTextField1().setText("");
		rendaUI.getJScrollPane().setViewportView(table);
	}

}
