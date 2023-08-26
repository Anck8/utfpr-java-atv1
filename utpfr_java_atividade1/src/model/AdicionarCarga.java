package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdicionarCarga extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPlaca;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldCor;
	
	static AdicionarCarga adicionarCargaSingle;
	
	public static AdicionarCarga getAdicionarCargaSingle() {
		if (adicionarCargaSingle == null) {
			adicionarCargaSingle = new AdicionarCarga();
		}
		return adicionarCargaSingle;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarCarga frame = new AdicionarCarga();
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
	private AdicionarCarga() {
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(12, 12, 110, 15);
		contentPane.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 39, 110, 15);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(12, 66, 110, 15);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(12, 93, 110, 15);
		contentPane.add(lblCor);
		
		JLabel lblQtdRodas = new JLabel("Qtd. Rodas:");
		lblQtdRodas.setBounds(12, 120, 110, 15);
		contentPane.add(lblQtdRodas);
		
		JLabel lblVelMax = new JLabel("Velocidade Máx.:");
		lblVelMax.setBounds(12, 147, 110, 15);
		contentPane.add(lblVelMax);
		
		JLabel lblQtdPistes = new JLabel("Qtd. Pistões:");
		lblQtdPistes.setBounds(12, 174, 110, 15);
		contentPane.add(lblQtdPistes);
		
		JLabel lblPotncia = new JLabel("Potência:");
		lblPotncia.setBounds(12, 201, 110, 15);
		contentPane.add(lblPotncia);
		
		JLabel lblQtdPassageiros = new JLabel("Qtd. Passageiros:");
		lblQtdPassageiros.setBounds(12, 228, 110, 15);
		contentPane.add(lblQtdPassageiros);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setToolTipText("Placa:");
		textFieldPlaca.setBounds(140, 10, 298, 18);
		contentPane.add(textFieldPlaca);
		textFieldPlaca.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(140, 37, 298, 18);
		contentPane.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(140, 64, 298, 18);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		textFieldCor = new JTextField();
		textFieldCor.setBounds(140, 91, 298, 18);
		contentPane.add(textFieldCor);
		textFieldCor.setColumns(10);
		
		JComboBox comboBoxQtdRodas = new JComboBox();
		comboBoxQtdRodas.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "6", "8", "12"}));
		comboBoxQtdRodas.setSelectedIndex(2);
		comboBoxQtdRodas.setBounds(140, 120, 298, 15);
		contentPane.add(comboBoxQtdRodas);
		
		JSlider sliderVelocMax = new JSlider();
		sliderVelocMax.setValue(100);
		sliderVelocMax.setPaintTicks(true);
		sliderVelocMax.setSnapToTicks(true);
		sliderVelocMax.setMaximum(300);
		sliderVelocMax.setBounds(140, 147, 298, 16);
		contentPane.add(sliderVelocMax);
	}
}
