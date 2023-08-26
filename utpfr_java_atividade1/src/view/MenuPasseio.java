package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPasseio extends JFrame {

	private JPanel contentPane;
	
	static MenuPasseio menuPasseioSingle;
	
	public static MenuPasseio getMenuPasseioSingle() {
		if (menuPasseioSingle == null) {
			menuPasseioSingle = new MenuPasseio();
		}
		return menuPasseioSingle;
	}

	/**
	 * Launch the application.
	 */
	private static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPasseio frame = new MenuPasseio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPasseio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
