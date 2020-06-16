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

import br.com.useinet.listener.TipoAction;

public class TipoUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private TipoAction tipoAction = null;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton3 = null;
	private JButton jButton2 = null;

	public TipoUI() throws HeadlessException {
		super();
		initialize();
	}

	private void initialize() {
		this.setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/br/com/useinet/ui/dim.png"))));
		this.setContentPane(getJContentPane());
		this.setTitle("Tipos");
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(new Rectangle(20, 20, 378, 400));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(15, 15, 42, 15));
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jLabel.setText("Tipo *");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField(), null);
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
			jTextField.setBounds(new Rectangle(15, 35, 204, 20));
			jTextField.setToolTipText("Digite o tipo de despesa");
			jTextField.setColumns(40);
		}
		return jTextField;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new java.awt.Rectangle(15, 340, 70, 20));
			jButton.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jButton.setText("Incluir");
			jButton.addActionListener(getTipoAction());
		}
		return jButton;
	}

	private TipoAction getTipoAction() {

		if (tipoAction == null) {
			tipoAction = new TipoAction(this);
		}

		return tipoAction;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(96, 340, 75, 20));
			jButton1.setText("Alterar");
			jButton1.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton1.addActionListener(getTipoAction());
		}
		return jButton1;
	}

	public JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(15, 60, 339, 270));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	public JTable getJTable() {
		if (jTable == null) {
			jTable = new TipoJTable(jTextField);
		}
		return jTable;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(269, 340, 85, 20));
			jButton3.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jButton3.setText("Remover");
			jButton3.addActionListener(getTipoAction());
		}
		return jButton3;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(182, 340, 76, 20));
			jButton2.setText("Limpar");
			jButton2.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton2.addActionListener(getTipoAction());
		}
		return jButton2;
	}

} // @jve:decl-index=0:visual-constraint="25,18"
