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

import br.com.useinet.listener.RendaAction;

public class RendaRelatorioUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTextPane jTextPane = null;
	private JLabel jLabel = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private RendaAction rendaAction;

	public RendaRelatorioUI() throws HeadlessException {
		super();
		initialize();
	}

	private void initialize() {
		this.setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/br/com/useinet/ui/dim.png"))));
		this.setContentPane(getJContentPane());
		this.setTitle("Renda");
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(new Rectangle(400, 0, 393, 400));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(15, 14, 38, 16));
			jLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
			jLabel.setText("Renda");
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
			jTextPane = new RendaJTextPane(this);
		}
		return jTextPane;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(180, 340, 99, 20));
			jButton.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton.setText("Recarregar");
			jButton.addActionListener(getRendaAction());
		}
		return jButton;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(291, 340, 75, 20));
			jButton1.setText("Fechar");
			jButton1.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton1.addActionListener(getRendaAction());
		}
		return jButton1;
	}

	private RendaAction getRendaAction() {

		if (rendaAction == null) {
			rendaAction = new RendaAction(this);
		}

		return rendaAction;
	}

} // @jve:decl-index=0:visual-constraint="15,13"
