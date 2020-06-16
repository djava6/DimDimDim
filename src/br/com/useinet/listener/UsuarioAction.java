package br.com.useinet.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.useinet.db.UsuarioDb;
import br.com.useinet.ui.UsuarioJTable;
import br.com.useinet.ui.UsuarioUI;
import br.com.useinet.vo.Usuario;

public class UsuarioAction implements ActionListener {

	private UsuarioUI usuarioUI;
	private JTable table;
	private UsuarioDb usuarioDb;
	private String usuarioNome;
	private String login;
	private String senha;

	public UsuarioAction(UsuarioUI usuarioUI) {
		this.usuarioUI = usuarioUI;
		table = usuarioUI.getJTable();
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

			usuarioDb = new UsuarioDb();

			if (usuarioDb.criaObjeto(usuarioNome, login, senha) == null) {
				JOptionPane.showMessageDialog(usuarioUI, "Usuário já cadastrado.", "Registro existente", JOptionPane.WARNING_MESSAGE);
				usuarioDb.descartaObjeto();
				return;
			}

			usuarioDb.salvaObjeto();
			atualizaTela();
			return;
		}

		int linhaSelecionada = table.getSelectedRow();

		if (linhaSelecionada == -1) {
			JOptionPane.showMessageDialog(usuarioUI, "Selecione um usuário.", "Selecionar registro", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String nome = (String) table.getValueAt(linhaSelecionada, 0);
		usuarioDb = new UsuarioDb();
		Usuario usuario;

		try {
			usuario = (Usuario) usuarioDb.listaObjetos("nome", nome).get(0);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(usuarioUI, "Usuário não encontrado.", "Registro inexistente", JOptionPane.WARNING_MESSAGE);
			table = new UsuarioJTable(usuarioUI.getJTextField(), usuarioUI.getJTextField1(), usuarioUI.getJTextField2());
			usuarioUI.getJScrollPane().setViewportView(table);
			usuarioDb.descartaObjeto();
			return;
		}

		if (actionEvent.getActionCommand().equals("Remover") && usuarioDb.removeObjeto(usuario.getId())) {
			if (!usuarioDb.salvaObjeto()) {
				JOptionPane.showMessageDialog(usuarioUI, "Não foi possível remover o usuário.", "Remover registro",
						JOptionPane.WARNING_MESSAGE);
				usuarioDb.descartaObjeto();
				return;
			}
			atualizaTela();
			return;
		}

		if (actionEvent.getActionCommand().equals("Alterar") && isCamposValidos()) {
			if (!usuarioDb.atualizaObjeto(usuario.getId(), usuarioNome, login, senha)) {
				JOptionPane.showMessageDialog(usuarioUI, "Não foi possível atualizar o usuário.", "Atualizar registro",
						JOptionPane.WARNING_MESSAGE);
				usuarioDb.descartaObjeto();
				return;
			}
			usuarioDb.salvaObjeto();
			atualizaTela();
		}

	}

	private boolean isCamposValidos() {
		usuarioNome = usuarioUI.getJTextField().getText().trim();
		login = usuarioUI.getJTextField1().getText().trim();
		senha = usuarioUI.getJTextField2().getText().trim();

		if (usuarioNome.equals("")) {
			JOptionPane.showMessageDialog(usuarioUI, "Preencha o campo usuário.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		if (login.equals("")) {
			JOptionPane.showMessageDialog(usuarioUI, "Preencha o campo login.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		if (senha.equals("")) {
			JOptionPane.showMessageDialog(usuarioUI, "Preencha o campo senha.", "Campo obrigatório", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;
	}

	private void atualizaTela() {
		table = new UsuarioJTable(usuarioUI.getJTextField(), usuarioUI.getJTextField1(), usuarioUI.getJTextField2());
		usuarioUI.getJTextField().setText("");
		usuarioUI.getJTextField1().setText("");
		usuarioUI.getJTextField2().setText("");
		usuarioUI.getJScrollPane().setViewportView(table);
	}

}
