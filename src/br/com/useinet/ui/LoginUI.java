package br.com.useinet.ui;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.useinet.listener.LoginAction;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private LoginAction rendaAction = null;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JLabel jLabel1 = null;
	private JButton jButton = null;
	private JButton jButton2 = null;
	private JPasswordField jPasswordField = null;

	public LoginUI() throws HeadlessException {
		super();
		initialize();
	}

	private void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/useinet/ui/dim.png")));
		this.setContentPane(getJContentPane());
		this.setTitle("Login");
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(new Rectangle(400, 300, 187, 194));
		this.setResizable(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(15, 68, 54, 15));
			jLabel1.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jLabel1.setText("Senha *");
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(15, 15, 61, 15));
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jLabel.setText("Usuário *");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJPasswordField(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton2(), null);
		}
		return jContentPane;
	}

	public JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(15, 35, 151, 20));
			jTextField.setToolTipText("Digite o usuário");
			jTextField.setColumns(40);
		}
		return jTextField;
	}

	public JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
			jPasswordField.setBounds(new Rectangle(15, 90, 151, 20));
			jPasswordField.setColumns(10);
			jPasswordField.setToolTipText("Digite a senha");
		}
		return jPasswordField;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(15, 120, 70, 20));
			jButton.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jButton.setText("OK");
			jButton.addActionListener(getRendaAction());
		}
		return jButton;
	}

	private LoginAction getRendaAction() {

		if (rendaAction == null) {
			rendaAction = new LoginAction(this);
		}

		return rendaAction;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(90, 120, 77, 20));
			jButton2.setText("Limpar");
			jButton2.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton2.addActionListener(getRendaAction());
		}
		return jButton2;
	}

} // @jve:decl-index=0:visual-constraint="5,6"
