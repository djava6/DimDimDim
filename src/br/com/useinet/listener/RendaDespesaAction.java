package br.com.useinet.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.useinet.ui.RendaDespesaJTextPane;
import br.com.useinet.ui.RendaDespesaRelatorioUI;

public class RendaDespesaAction implements ActionListener {

	private RendaDespesaRelatorioUI rendaDespesaRelatorioUI;

	public RendaDespesaAction(RendaDespesaRelatorioUI rendaDespesaRelatorioUI) {
		this.rendaDespesaRelatorioUI = rendaDespesaRelatorioUI;
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getActionCommand().equals("Fechar")) {
			rendaDespesaRelatorioUI.dispose();
			return;
		}

		if (actionEvent.getActionCommand().equals("Recarregar")) {
			rendaDespesaRelatorioUI.getJScrollPane()
					.setViewportView(new RendaDespesaJTextPane(rendaDespesaRelatorioUI));
			return;
		}
	}
}
