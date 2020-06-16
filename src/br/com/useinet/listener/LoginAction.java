package br.com.useinet.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.useinet.db.UsuarioDb;
import br.com.useinet.ui.DimDimUI;
import br.com.useinet.ui.LoginUI;

public class LoginAction implements ActionListener {

	private LoginUI rendaUI;
	private String login;
	private String senha;

	public LoginAction(LoginUI rendaUI) {
		this.rendaUI = rendaUI;
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getActionCommand().equals("Limpar")) {
			atualizaTela();
			return;
		}

		if (actionEvent.getActionCommand().equals("OK")) {

			if (!isCamposValidos()) {
				return;
			}

			rendaUI.setVisible(false);
			DimDimUI dimDimUI = new DimDimUI();
			dimDimUI.setVisible(true);
			return;
		}

	}

	private boolean isCamposValidos() {
		login = rendaUI.getJTextField().getText().trim();
		senha = "";
		for (char c : rendaUI.getJPasswordField().getPassword()) {
			senha += c;
		}
		senha = senha.trim();

		if (login.equals("")) {
			JOptionPane.showMessageDialog(rendaUI, "Preencha o campo usuário.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		if (senha.equals("")) {
			JOptionPane.showMessageDialog(rendaUI, "Preencha o campo senha.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		UsuarioDb usuarioDb = new UsuarioDb();
		List<?> usuarios = usuarioDb.listaObjetos("login", login, "senha", senha);

		if (usuarios.size() < 1) {
			JOptionPane.showMessageDialog(rendaUI, "Usuário ou senha incorretos.", "Login incorreto", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;
	}

	private void atualizaTela() {
		rendaUI.getJTextField().setText("");
		rendaUI.getJPasswordField().setText("");
	}

}
