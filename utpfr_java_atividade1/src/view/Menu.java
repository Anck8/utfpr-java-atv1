package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JInternalFrame;

public class Menu extends JFrame {

	private static final long serialVersionUID = -7703754494214959683L;
	private JPanel contentPane = new JPanel();
	private final JButton btnCarga = new JButton("Carga");
	private final JButton btnPasseio = new JButton("Passeio");
	private final JButton btnSair = new JButton("Sair");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Menu(){
		setResizable(false);
		setTitle("Gestão de Veículos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnCarga.setBounds(226, 150, 212, 70);
		btnPasseio.setBounds(12, 150, 212, 70);
		btnSair.setBounds(381, 232, 57, 27);
		
		contentPane.setLayout(null);
		contentPane.add(btnCarga);
		contentPane.add(btnPasseio);
		contentPane.add(btnSair);
		
		JLabel lblIconeCarga = new JLabel("");
		try {
			lblIconeCarga.setBounds(226, 13, 212, 125);
			lblIconeCarga.setIcon(new ImageIcon(Menu.class.getResource("/resources/Carga.jpg")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		contentPane.add(lblIconeCarga);
		
		JLabel lblIconePasseio = new JLabel("");
		try {
			lblIconePasseio.setBounds(12, 13, 212, 125);
			lblIconePasseio.setIcon(new ImageIcon(Menu.class.getResource("/resources/Passeio.jpg")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		contentPane.add(lblIconePasseio);
		
		
		btnCarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAbreMenuCarga(arg0);
			}
		});
		btnPasseio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAbreMenuPasseio(arg0);
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSairAction(arg0);
			}
		});
		setLocationRelativeTo(null);
	}
	
	private void btnSairAction(ActionEvent e) {
		if (Mensagem.confirmaAcao("Deseja sair do programa?")) {
			dispose();
		}
	}
	
	private void btnAbreMenuCarga(ActionEvent e) {
		ImprimirCarga.getMenuCargaSingle().setVisible(true);
	}
	
	private void btnAbreMenuPasseio(ActionEvent e) {
		ImprimirPasseio.getMenuPasseioSingle().setVisible(true);
	}
}