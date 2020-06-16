package br.com.useinet.ui;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import br.com.useinet.db.DespesaDb;
import br.com.useinet.util.Decimal;
import br.com.useinet.util.LogUtil;
import br.com.useinet.vo.Despesa;

public class DespesaJTextPane extends JTextPane {

	private static final long serialVersionUID = 1L;

	public DespesaJTextPane(DespesaRelatorioUI relatorioUI) {
		setEditable(false);
		setToolTipText("Despesa Total");

		Despesa despesa = new Despesa();

		try {
			despesa = (Despesa) new DespesaDb().listaObjetos().get(0);
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(relatorioUI, "Despesa n�o encontrada.", "Registro inexistente", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String[] initString = { "\n", "    Total:\t\t\t", "R$ " + new Decimal(Double.parseDouble(despesa.getTotal())).getValor() };

		String[] initStyles = { "regular", "large", "bold" };

		StyledDocument doc = getStyledDocument();
		addStylesToDocument(doc);

		try {
			for (int i = 0; i < initString.length; i++) {
				doc.insertString(doc.getLength(), initString[i], doc.getStyle(initStyles[i]));
			}
		} catch (BadLocationException ble) {
			LogUtil.getLogger().warn("N�o foi poss�vel inserir o texto no painel.");
		}
	}

	protected void addStylesToDocument(StyledDocument doc) {
		Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

		Style regular = doc.addStyle("regular", def);
		StyleConstants.setFontFamily(def, "Arial");
		StyleConstants.setFontSize(def, 14);

		Style s = doc.addStyle("italic", regular);
		StyleConstants.setItalic(s, true);

		s = doc.addStyle("bold", regular);
		StyleConstants.setBold(s, true);

		s = doc.addStyle("small", regular);
		StyleConstants.setFontSize(s, 12);

		s = doc.addStyle("large", regular);
		StyleConstants.setFontSize(s, 16);
	}

}
