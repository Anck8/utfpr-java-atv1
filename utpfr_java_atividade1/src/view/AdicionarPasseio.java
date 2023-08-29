package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.VeicExistException;
import model.BDVeiculos;
import model.Passeio;

public class AdicionarPasseio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPlaca;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldCor;
	private JComboBox comboBoxQtdRodas;
	private JTextField textFieldVelocMax;
	private JTextField textFieldQtdPistoes;
	private JTextField textFieldPotencia;
	private JTextField textFieldQtdPassageiros;
	private JButton btnNovo;
	
	static AdicionarPasseio adicionarPasseioSingle;
	
	public static AdicionarPasseio getAdicionarPasseioSingle() {
		if (adicionarPasseioSingle == null) {
			adicionarPasseioSingle = new AdicionarPasseio();
		}
		return adicionarPasseioSingle;
	}

	/**
	 * Launch the application.
	 */
	private static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarPasseio frame = new AdicionarPasseio();
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
	public AdicionarPasseio() {
		setResizable(false);
		setTitle("Gestão de Veículos - [Passeio] Adicionar Veículo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(12, 30, 110, 15);
		contentPane.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 57, 110, 15);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(12, 84, 110, 15);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(12, 111, 110, 15);
		contentPane.add(lblCor);
		
		JLabel lblQtdRodas = new JLabel("Qtd. Rodas:");
		lblQtdRodas.setBounds(12, 138, 110, 15);
		contentPane.add(lblQtdRodas);
		
		JLabel lblVelMax = new JLabel("Velocidade Máx.:");
		lblVelMax.setBounds(12, 165, 110, 15);
		contentPane.add(lblVelMax);
		
		JLabel lblQtdPistes = new JLabel("Qtd. Pistões:");
		lblQtdPistes.setBounds(12, 191, 110, 15);
		contentPane.add(lblQtdPistes);
		
		JLabel lblPotncia = new JLabel("Potência:");
		lblPotncia.setBounds(12, 218, 110, 15);
		contentPane.add(lblPotncia);
		
		JLabel lblQtdPassageiros = new JLabel("Qtd. Passageiros:");
		lblQtdPassageiros.setBounds(12, 3, 110, 15);
		contentPane.add(lblQtdPassageiros);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setToolTipText("");
		textFieldPlaca.setBounds(140, 28, 298, 18);
		contentPane.add(textFieldPlaca);
		textFieldPlaca.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(140, 55, 298, 18);
		contentPane.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(140, 82, 298, 18);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		textFieldCor = new JTextField();
		textFieldCor.setBounds(140, 109, 298, 18);
		contentPane.add(textFieldCor);
		textFieldCor.setColumns(10);
		
		comboBoxQtdRodas = new JComboBox();
		comboBoxQtdRodas.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "6", "8", "12"}));
		comboBoxQtdRodas.setSelectedIndex(2);
		comboBoxQtdRodas.setBounds(140, 138, 298, 15);
		contentPane.add(comboBoxQtdRodas);
		
		textFieldVelocMax = new JTextField();
		textFieldVelocMax.setBounds(140, 163, 298, 18);
		contentPane.add(textFieldVelocMax);
		textFieldVelocMax.setColumns(10);
		
		textFieldQtdPistoes = new JTextField();
		textFieldQtdPistoes.setBounds(140, 189, 298, 18);
		contentPane.add(textFieldQtdPistoes);
		textFieldQtdPistoes.setColumns(10);
		
		textFieldPotencia = new JTextField();
		textFieldPotencia.setBounds(140, 216, 298, 18);
		contentPane.add(textFieldPotencia);
		textFieldPotencia.setColumns(10);
		
		textFieldQtdPassageiros = new JTextField();
		textFieldQtdPassageiros.setBounds(140, 1, 298, 18);
		contentPane.add(textFieldQtdPassageiros);
		textFieldQtdPassageiros.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				btnNovo.setEnabled(false);
				dispose();
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
				limpar();
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
		
		setLocationRelativeTo(null);
	}
	
	public void limpar() {
		textFieldPlaca.setText("");
		textFieldMarca.setText("");
		textFieldModelo.setText("");
		textFieldCor.setText("");
		comboBoxQtdRodas.setSelectedIndex(-1);
		textFieldVelocMax.setText("");
		textFieldQtdPistoes.setText("");
		textFieldPotencia.setText("");
		textFieldQtdPassageiros.setText("");
		btnNovo.setEnabled(false);
	}
	
	public void btnCadastrarAction(ActionEvent e) throws VeicExistException{
		try {
			Passeio passeio = new Passeio(
					textFieldPlaca.getText(), 
					textFieldMarca.getText(), 
					textFieldModelo.getText(),
					textFieldCor.getText(),
					Float.parseFloat(textFieldVelocMax.getText()),
					Integer.parseInt(comboBoxQtdRodas.getSelectedItem().toString()),
					Integer.parseInt(textFieldQtdPistoes.getText()),
					Integer.parseInt(textFieldPotencia.getText()),
					Integer.parseInt(textFieldQtdPassageiros.getText())
					);
			BDVeiculos.addPasseio(passeio);
			Mensagem.sucesso("Veículo cadastrado com sucesso!");
			btnNovo.setEnabled(true);
		} 
		catch (VeicExistException ve) {
			Mensagem.excecao("Veículo já cadastrado no sistema.");
		} 
		catch (NumberFormatException ne) {
			Mensagem.excecao("Campo(s) preenchido(s) incorretamente.");
		}
	}
	
	public void btnNovoAction(ActionEvent e) {
		limpar();
		btnNovo.setEnabled(false);
	}

}
