package view;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.VeicExistException;
import model.BDVeiculos;
import model.Carga;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarCarga extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPlaca;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldCor;
	private JComboBox comboBoxQtdRodas;
	private JTextField textFieldVelocMax;
	private JTextField textFieldQtdPistoes;
	private JTextField textFieldPotencia;
	private JTextField textFieldTara;
	private JButton btnNovo;
	
	static AdicionarCarga adicionarCargaSingle;
	private JTextField textFieldCargaMax;
	
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
		setTitle("Gestão de Veículos - [Carga] Adicionar Veículo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(12, 59, 110, 15);
		contentPane.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 87, 110, 15);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(12, 115, 110, 15);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(12, 143, 110, 15);
		contentPane.add(lblCor);
		
		JLabel lblQtdRodas = new JLabel("Qtd. Rodas:");
		lblQtdRodas.setBounds(12, 171, 110, 15);
		contentPane.add(lblQtdRodas);
		
		JLabel lblVelMax = new JLabel("Velocidade Máx.:");
		lblVelMax.setBounds(12, 198, 110, 15);
		contentPane.add(lblVelMax);
		
		JLabel lblQtdPistes = new JLabel("Qtd. Pistões:");
		lblQtdPistes.setBounds(12, 226, 110, 15);
		contentPane.add(lblQtdPistes);
		
		JLabel lblPotncia = new JLabel("Potência:");
		lblPotncia.setBounds(12, 254, 110, 15);
		contentPane.add(lblPotncia);
		
		JLabel lblTara = new JLabel("Tara:");
		lblTara.setBounds(12, 3, 110, 15);
		contentPane.add(lblTara);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setToolTipText("Placa:");
		textFieldPlaca.setBounds(140, 57, 298, 18);
		contentPane.add(textFieldPlaca);
		textFieldPlaca.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(140, 85, 298, 18);
		contentPane.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(140, 113, 298, 18);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		textFieldCor = new JTextField();
		textFieldCor.setBounds(140, 141, 298, 18);
		contentPane.add(textFieldCor);
		textFieldCor.setColumns(10);
		
		comboBoxQtdRodas = new JComboBox();
		comboBoxQtdRodas.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "6", "8", "12"}));
		comboBoxQtdRodas.setSelectedIndex(2);
		comboBoxQtdRodas.setBounds(140, 171, 298, 15);
		contentPane.add(comboBoxQtdRodas);
		
		textFieldVelocMax = new JTextField();
		textFieldVelocMax.setBounds(140, 196, 298, 18);
		contentPane.add(textFieldVelocMax);
		textFieldVelocMax.setColumns(10);
		
		textFieldQtdPistoes = new JTextField();
		textFieldQtdPistoes.setBounds(140, 224, 298, 18);
		contentPane.add(textFieldQtdPistoes);
		textFieldQtdPistoes.setColumns(10);
		
		textFieldPotencia = new JTextField();
		textFieldPotencia.setBounds(140, 252, 298, 18);
		contentPane.add(textFieldPotencia);
		textFieldPotencia.setColumns(10);
		
		textFieldTara = new JTextField();
		textFieldTara.setBounds(140, 1, 298, 18);
		contentPane.add(textFieldTara);
		textFieldTara.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSairAction(arg0);
			}
		});
		btnSair.setBounds(348, 282, 90, 27);
		contentPane.add(btnSair);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnCadastrarAction(arg0);
				} catch (VeicExistException e) {}
			}
		});
		btnCadastrar.setBounds(12, 282, 105, 27);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLimparAction(arg0);
			}
		});
		btnLimpar.setBounds(129, 282, 105, 27);
		contentPane.add(btnLimpar);
		
		btnNovo = new JButton("Novo");
		btnNovo.setEnabled(false);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNovoAction(arg0);
			}
		});
		btnNovo.setBounds(246, 282, 90, 27);
		contentPane.add(btnNovo);
		
		JLabel lblCargaMx = new JLabel("Carga Máx:");
		lblCargaMx.setBounds(12, 30, 110, 17);
		contentPane.add(lblCargaMx);
		
		textFieldCargaMax = new JTextField();
		textFieldCargaMax.setBounds(140, 28, 298, 21);
		contentPane.add(textFieldCargaMax);
		textFieldCargaMax.setColumns(10);
		
		setLocationRelativeTo(null);
	}
	
	private void btnSairAction(ActionEvent e) {
		dispose();
	}
	
	public void btnLimparAction(ActionEvent e) {
		textFieldPlaca.setText("");
		textFieldMarca.setText("");
		textFieldModelo.setText("");
		textFieldCor.setText("");
		comboBoxQtdRodas.setSelectedIndex(-1);
		textFieldVelocMax.setText("");
		textFieldQtdPistoes.setText("");
		textFieldPotencia.setText("");
		textFieldTara.setText("");
	}
	
	public void btnCadastrarAction(ActionEvent e) throws VeicExistException{
		try {
			Carga carga = new Carga(
					textFieldPlaca.getText(), 
					textFieldMarca.getText(), 
					textFieldModelo.getText(),
					textFieldCor.getText(),
					Float.parseFloat(textFieldVelocMax.getText()),
					Integer.parseInt(comboBoxQtdRodas.getSelectedItem().toString()),
					Integer.parseInt(textFieldQtdPistoes.getText()),
					Integer.parseInt(textFieldPotencia.getText()),
					Integer.parseInt(textFieldCargaMax.getText()),
					Integer.parseInt(textFieldTara.getText())
					);
			
			BDVeiculos.addCarga(carga);
			Mensagem.sucesso("Veículo cadastrado com sucesso!");
			btnNovo.setEnabled(true);
		} 
		catch (VeicExistException ve) {
			Mensagem.excecao("Veículo já cadastrado no sistema.");
		}
	}
	
	public void btnNovoAction(ActionEvent e) {
		btnLimparAction(e);
	}
}
