package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class FrameMenu extends JFrame {

	private JPanel contentPane;
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
					FrameMenu frame = new FrameMenu();
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
	public FrameMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCarga.setBounds(12, 82, 210, 51);
		
		btnPasseio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPasseio.setBounds(12, 145, 210, 51);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		
		btnSair.setBounds(12, 208, 210, 51);
		contentPane.add(btnCarga);
		contentPane.add(btnPasseio);
		contentPane.add(btnSair);
		
		JLabel lblGestoDeVeculos = new JLabel("Gestão de Veículos");
		lblGestoDeVeculos.setBounds(12, 12, 210, 42);
		contentPane.add(lblGestoDeVeculos);
	}
}
