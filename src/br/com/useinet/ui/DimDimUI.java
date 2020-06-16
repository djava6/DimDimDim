package br.com.useinet.ui;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.useinet.listener.DimDimAction;

public class DimDimUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JMenu jMenu2 = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;
	private JMenuItem jMenuItem4 = null;
	private JMenuItem jMenuItem5 = null;
	private JMenuItem jMenuItem6 = null;
	private JMenuItem jMenuItem7 = null;
	private JMenuItem jMenuItem8 = null;
	private JDesktopPane jDesktopPane = null;
	private DimDimAction dimDimAction;

	public DimDimUI() throws HeadlessException {
		super();
		initialize();
	}

	private void initialize() {
		this.setResizable(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/useinet/ui/dim.png")));
		this.setContentPane(getJDesktopPane());
		this.setJMenuBar(getJJMenuBar());
		this.setBounds(new java.awt.Rectangle(0, 0, 1024, 740));
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setTitle("DimDimDim");
	}

	public DimDimAction getDimDimAction() {
		if (dimDimAction == null) {
			dimDimAction = new DimDimAction(jDesktopPane);
		}
		return dimDimAction;
	}

	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu2());
		}
		return jJMenuBar;
	}

	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Cadastros");
			jMenu.setMnemonic(java.awt.event.KeyEvent.VK_C);
			jMenu.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
			jMenu.add(getJMenuItem2());
			jMenu.add(getJMenuItem8());
			jMenu.addSeparator();
			jMenu.add(getJMenuItem3());
		}
		return jMenu;
	}

	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Rendas");
			jMenuItem.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_R);
			jMenuItem.addActionListener(getDimDimAction());
		}
		return jMenuItem;
	}

	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Tipos");
			jMenuItem1.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jMenuItem1.setMnemonic(java.awt.event.KeyEvent.VK_T);
			jMenuItem1.addActionListener(getDimDimAction());
		}
		return jMenuItem1;
	}

	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Despesas");
			jMenuItem2.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jMenuItem2.setMnemonic(java.awt.event.KeyEvent.VK_D);
			jMenuItem2.addActionListener(getDimDimAction());
		}
		return jMenuItem2;
	}

	private JMenuItem getJMenuItem8() {
		if (jMenuItem8 == null) {
			jMenuItem8 = new JMenuItem();
			jMenuItem8.setText("Usuários");
			jMenuItem8.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jMenuItem8.setMnemonic(java.awt.event.KeyEvent.VK_U);
			jMenuItem8.addActionListener(getDimDimAction());
		}
		return jMenuItem8;
	}

	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Sair");
			jMenuItem3.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jMenuItem3.setMnemonic(java.awt.event.KeyEvent.VK_S);
			jMenuItem3.addActionListener(getDimDimAction());
		}
		return jMenuItem3;
	}

	private JDesktopPane getJDesktopPane() {
		if (jDesktopPane == null) {
			jDesktopPane = new JDesktopPane();
			jDesktopPane.setBackground(java.awt.SystemColor.controlHighlight);
		}
		return jDesktopPane;
	}

	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Relatórios");
			jMenu1.setMnemonic(KeyEvent.VK_R);
			jMenu1.setFont(new Font("Dialog", Font.PLAIN, 12));
			jMenu1.add(getJMenuItem4());
			jMenu1.add(getJMenuItem5());
			jMenu1.add(getJMenuItem6());
		}
		return jMenu1;
	}

	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Ajuda");
			jMenu2.setMnemonic(KeyEvent.VK_A);
			jMenu2.setFont(new Font("Dialog", Font.PLAIN, 12));
			jMenu2.add(getJMenuItem7());
		}
		return jMenu2;
	}

	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem();
			jMenuItem4.setText("Renda");
			jMenuItem4.setMnemonic(KeyEvent.VK_E);
			jMenuItem4.setFont(new Font("Dialog", Font.PLAIN, 12));
			jMenuItem4.addActionListener(getDimDimAction());
		}
		return jMenuItem4;
	}

	private JMenuItem getJMenuItem5() {
		if (jMenuItem5 == null) {
			jMenuItem5 = new JMenuItem();
			jMenuItem5.setText("Despesa");
			jMenuItem5.setMnemonic(KeyEvent.VK_D);
			jMenuItem5.setFont(new Font("Dialog", Font.PLAIN, 12));
			jMenuItem5.addActionListener(getDimDimAction());
		}
		return jMenuItem5;
	}

	private JMenuItem getJMenuItem6() {
		if (jMenuItem6 == null) {
			jMenuItem6 = new JMenuItem();
			jMenuItem6.setText("Renda X Despesa");
			jMenuItem6.setMnemonic(KeyEvent.VK_X);
			jMenuItem6.setFont(new Font("Dialog", Font.PLAIN, 12));
			jMenuItem6.addActionListener(getDimDimAction());
		}
		return jMenuItem6;
	}

	private JMenuItem getJMenuItem7() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new JMenuItem();
			jMenuItem7.setText("Sobre o DimDimDim");
			jMenuItem7.setMnemonic(KeyEvent.VK_S);
			jMenuItem7.setFont(new Font("Dialog", Font.PLAIN, 12));
			jMenuItem7.addActionListener(getDimDimAction());
		}
		return jMenuItem7;
	}

} // @jve:decl-index=0:visual-constraint="5,5"
