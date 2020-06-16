package br.com.useinet.ui;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.useinet.listener.UsuarioAction;

public class UsuarioUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private UsuarioAction usuarioAction = null;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;

	public UsuarioUI() throws HeadlessException {
		super();
		initialize();
	}

	private void initialize() {
		this.setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/useinet/ui/dim.png"))));
		this.setContentPane(getJContentPane());
		this.setTitle("Usuários");
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(new Rectangle(60, 60, 393, 463));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(15, 61, 54, 15));
			jLabel2.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jLabel2.setText("Senha *");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(270, 15, 54, 15));
			jLabel1.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jLabel1.setText("Login *");
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(15, 15, 61, 15));
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jLabel.setText("Usuário *");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
		}
		return jContentPane;
	}

	public JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(15, 35, 241, 20));
			jTextField.setToolTipText("Digite o nome do usuário");
			jTextField.setColumns(40);
		}
		return jTextField;
	}

	public JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(270, 35, 97, 20));
			jTextField1.setColumns(10);
			jTextField1.setToolTipText("Digite o login do usuário");
		}
		return jTextField1;
	}

	public JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(15, 81, 97, 20));
			jTextField2.setColumns(10);
			jTextField2.setToolTipText("Digite a senha do usuário");
		}
		return jTextField2;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(15, 401, 70, 20));
			jButton.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jButton.setText("Incluir");
			jButton.addActionListener(getUsuarioAction());
		}
		return jButton;
	}

	private UsuarioAction getUsuarioAction() {

		if (usuarioAction == null) {
			usuarioAction = new UsuarioAction(this);
		}

		return usuarioAction;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(101, 401, 75, 20));
			jButton1.setText("Alterar");
			jButton1.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton1.addActionListener(getUsuarioAction());
		}
		return jButton1;
	}

	public JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(15, 106, 352, 285));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	public JTable getJTable() {
		if (jTable == null) {
			jTable = new UsuarioJTable(jTextField, jTextField1, jTextField2);
		}
		return jTable;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(191, 401, 77, 20));
			jButton2.setText("Limpar");
			jButton2.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton2.addActionListener(getUsuarioAction());
		}
		return jButton2;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(282, 401, 85, 20));
			jButton3.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jButton3.setText("Remover");
			jButton3.addActionListener(getUsuarioAction());
		}
		return jButton3;
	}

} // @jve:decl-index=0:visual-constraint="15,13"
