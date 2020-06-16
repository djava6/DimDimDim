package br.com.useinet.ui;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.sourceforge.jcalendarbutton.JCalendarButton;

import br.com.useinet.listener.DespesaAction;
import br.com.useinet.util.Data;

public class DespesaUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private DespesaAction despesaAction = null;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JLabel jLabel2 = null;
	private JButton jButton = null;
	private JButton jButton2 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JCalendarButton jCalendarButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel1 = null;
	private JComboBox jComboBox = null;
	private JLabel jLabel3 = null;

	public DespesaUI() throws HeadlessException {
		super();
		initialize();
	}

	private void initialize() {
		this.setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/useinet/ui/dim.png"))));
		this.setContentPane(getJContentPane());
		this.setTitle("Despesas");
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(new Rectangle(40, 40, 480, 537));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(182, 60, 36, 16));
			jLabel3.setText("Data *");
			jLabel3.setFont(new Font("Dialog", Font.PLAIN, 12));
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(269, 15, 42, 15));
			jLabel1.setText("Tipo *");
			jLabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(15, 60, 54, 15));
			jLabel2.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jLabel2.setText("Valor *");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(15, 15, 68, 15));
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jLabel.setText("Despesa *");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJComboBox(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJCalendarButton(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
			jContentPane.add(jLabel3, null);
		}
		return jContentPane;
	}

	public JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(15, 35, 241, 20));
			jTextField.setToolTipText("Digite o nome da despesa");
			jTextField.setColumns(40);
		}
		return jTextField;
	}

	public JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(15, 79, 97, 20));
			jTextField1.setColumns(10);
			jTextField1.setToolTipText("Digite o valor da despesa");
		}
		return jTextField1;
	}

	public JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(182, 79, 147, 20));
			jTextField2.setColumns(10);
			jTextField2.setToolTipText("Digite a data da despesa");
		}
		return jTextField2;
	}

	public JCalendarButton getJCalendarButton() {
		if (jCalendarButton == null) {
			jCalendarButton = new JCalendarButton();
			jCalendarButton.setBounds(new Rectangle(331, 79, 30, 20));
			jCalendarButton.setToolTipText("Selecione a data da despesa");
			jCalendarButton.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					dateOnlyPopupChanged(evt);
				}
			});
		}
		return jCalendarButton;
	}

	private void dateOnlyPopupChanged(PropertyChangeEvent evt) {
		if (evt.getNewValue() instanceof Date) {
			setDate((Date) evt.getNewValue());
		}
	}

	public void setDate(Date date) {
		String dateString = "";
		if (date != null) {
			dateString = new Data(date).getValor();
		}
		jTextField2.setText(dateString);
		jCalendarButton.setTargetDate(date);
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(15, 476, 70, 20));
			jButton.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jButton.setText("Incluir");
			jButton.addActionListener(getDespesaAction());
		}
		return jButton;
	}

	private DespesaAction getDespesaAction() {

		if (despesaAction == null) {
			despesaAction = new DespesaAction(this);
		}

		return despesaAction;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(198, 476, 78, 20));
			jButton2.setText("Alterar");
			jButton2.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton2.addActionListener(getDespesaAction());
		}
		return jButton2;
	}

	public JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(15, 105, 441, 361));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	public JTable getJTable() {
		if (jTable == null) {
			jTable = new DespesaJTable(jTextField, jComboBox, jTextField1, jTextField2);
		}
		return jTable;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(285, 476, 77, 20));
			jButton3.setText("Limpar");
			jButton3.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton3.addActionListener(getDespesaAction());
		}
		return jButton3;
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(371, 476, 85, 20));
			jButton4.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			jButton4.setText("Remover");
			jButton4.addActionListener(getDespesaAction());
		}
		return jButton4;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(95, 476, 93, 20));
			jButton1.setText("Atualizar");
			jButton1.setFont(new Font("Dialog", Font.PLAIN, 12));
			jButton1.addActionListener(getDespesaAction());
		}
		return jButton1;
	}

	public JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new TipoJComboBox();
			jComboBox.setBounds(new Rectangle(269, 35, 185, 20));
		}
		return jComboBox;
	}

} // @jve:decl-index=0:visual-constraint="-31,-11"
