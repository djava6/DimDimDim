package br.com.useinet.listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import br.com.useinet.ui.DespesaRelatorioUI;
import br.com.useinet.ui.DespesaUI;
import br.com.useinet.ui.RendaDespesaRelatorioUI;
import br.com.useinet.ui.RendaRelatorioUI;
import br.com.useinet.ui.RendaUI;
import br.com.useinet.ui.TipoUI;
import br.com.useinet.ui.UsuarioUI;

public class DimDimAction implements ActionListener {

	private JDesktopPane desktopPane = null;

	public DimDimAction(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Rendas")) {
			RendaUI rendaUI = new RendaUI();
			desktopPane.add(rendaUI);
			rendaUI.setVisible(true);
		} else if (e.getActionCommand().equals("Tipos")) {
			TipoUI tipoUI = new TipoUI();
			desktopPane.add(tipoUI);
			tipoUI.setVisible(true);
		} else if (e.getActionCommand().equals("Despesas")) {
			DespesaUI despesaUI = new DespesaUI();
			desktopPane.add(despesaUI);
			despesaUI.setVisible(true);
		} else if (e.getActionCommand().equals("Usuários")) {
			UsuarioUI usuarioUI = new UsuarioUI();
			desktopPane.add(usuarioUI);
			usuarioUI.setVisible(true);
		} else if (e.getActionCommand().equals("Renda")) {
			RendaRelatorioUI rendaRelatorioUI = new RendaRelatorioUI();
			desktopPane.add(rendaRelatorioUI);
			rendaRelatorioUI.setVisible(true);
		} else if (e.getActionCommand().equals("Despesa")) {
			DespesaRelatorioUI despesaRelatorioUI = new DespesaRelatorioUI();
			desktopPane.add(despesaRelatorioUI);
			despesaRelatorioUI.setVisible(true);
		} else if (e.getActionCommand().equals("Renda X Despesa")) {
			RendaDespesaRelatorioUI rendaDespesaRelatorioUI = new RendaDespesaRelatorioUI();
			desktopPane.add(rendaDespesaRelatorioUI);
			rendaDespesaRelatorioUI.setVisible(true);
		} else if (e.getActionCommand().equals("Sair")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Sobre o DimDimDim")) {
			JOptionPane.showMessageDialog(desktopPane, "DimDimDim 1.1\n" + "Sistema para Controle Financeiro Pessoal\n"
					+ "Todas as vossas coisas sejam feitas com amor.\n" + "1 Coríntios 16:14", "Sobre o DimDimDim",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Toolkit.getDefaultToolkit().getImage(
							getClass().getResource("/br/com/useinet/ui/dim.png"))));
		}
	}
}
