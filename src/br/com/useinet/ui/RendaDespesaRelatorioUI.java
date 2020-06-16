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
import javax.swing.JTextPane;

import br.com.useinet.listener.RendaDespesaAction;

public class RendaDespesaRelatorioUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private RendaDespesaAction rendaDespesaAction;

	public RendaDespesaRelatorioUI() throws HeadlessException {
		super();
		initialize();
	}

	private void initialize() {
		this.setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/br/com/useinet/ui/dim.png"))));
		this.setContentPane(getJContentPane());
		this.setTitle("Renda X Despesa");
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(new Rectangle(440, 40, 393, 400));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(15, 14, 107, 16));
			jLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
			jLabel.setText("Renda X Despesa");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

	public JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(15, 35, 352, 296));
			jScrollPane.setViewportView(getJTextPane());
		}
		return jScrollPane;
	}

	public JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new RendaDespesaJTextPane(this);
		}
		return jTextPane;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(180, 340, 99, 20));
			jButton.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton.setText("Recarregar");
			jButton.addActionListener(getRendaDespesaAction());
		}
		return jButton;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(291, 340, 75, 20));
			jButton1.setText("Fechar");
			jButton1.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton1.addActionListener(getRendaDespesaAction());
		}
		return jButton1;
	}

	private RendaDespesaAction getRendaDespesaAction() {

		if (rendaDespesaAction == null) {
			rendaDespesaAction = new RendaDespesaAction(this);
		}

		return rendaDespesaAction;
	}

} // @jve:decl-index=0:visual-constraint="15,13"
