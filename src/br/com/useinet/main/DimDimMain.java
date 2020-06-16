package br.com.useinet.main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.hibernate.HibernateException;

import br.com.useinet.db.DbClass;
import br.com.useinet.ui.LoginUI;
import br.com.useinet.ui.TelaAberturaJWindow;
import br.com.useinet.util.LogUtil;

public class DimDimMain {

	private static TelaAberturaJWindow sp;
	private static DbClass dbClass;

	public static void criarExibirInterface() {

		LoginUI loginUI = new LoginUI();
		loginUI.setVisible(true);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			LogUtil.getLogger().warn("Não foi possível interromper a thread\n" + e);
		}

		sp.hideSplash();
	}

	public static void main(String[] args) {

		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();

		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			LogUtil.getLogger().warn("Não foi possível setar o LookAndFeel\n" + e);
		}

		sp = new TelaAberturaJWindow("/br/com/useinet/ui/dimdimdim.png");
		sp.showSplash();
		sp.setProgressMaxMin(0, 100);
		sp.setDisplayString(50, "Conectando ao banco de dados...");

		try {
			dbClass = new DbClass();
		} catch (HibernateException e) {
			LogUtil.getLogger().error("Não foi possível conectar ao banco de dados\n" + e);
			JFrame frame = new JFrame();
			sp.hideSplash();
			JOptionPane.showMessageDialog(frame, "Não foi possível conectar ao banco de dados.", "Erro na conexão",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		dbClass.descartaObjeto();

		sp.setDisplayString(100, "Carregando interface...");

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				criarExibirInterface();
			}
		});
	}
}
