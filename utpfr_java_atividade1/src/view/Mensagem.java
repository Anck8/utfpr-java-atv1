package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mensagem extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public Mensagem() {
	}
	
	public static boolean confirmaAcao(String mensagem) {
		return JOptionPane.showConfirmDialog(null, mensagem, null, JOptionPane.YES_NO_OPTION) == 0;
	}
	
	public static void excecao(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, null, JOptionPane.WARNING_MESSAGE);
	}
	
	public static void sucesso(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, null, JOptionPane.INFORMATION_MESSAGE);
	}

}
