package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.VeicNaoExistException;
import model.BDVeiculos;
import model.Carga;

public class BuscarCarga extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPlaca;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldCor;
	private JTextField textFieldQtdRodas;
	private JTextField textFieldVelocMax;
	private JTextField textFieldQtdPistoes;
	private JTextField textFieldPotencia;
	private JTextField textFieldTara;
	private JTextField textFieldCargaMax;
	private JButton btnExcluir;
	
	static BuscarCarga buscarCargaSingle;
	
	public static BuscarCarga getBuscarCargaSingle() {
		if (buscarCargaSingle == null) {
			buscarCargaSingle = new BuscarCarga();
		}
		return buscarCargaSingle;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCarga frame = new BuscarCarga();
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
	public BuscarCarga() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gestão de Veículos - [Carga] Buscar Veículo");
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(12, 3, 110, 15);
		contentPane.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 86, 110, 15);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(12, 113, 110, 15);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(12, 140, 110, 15);
		contentPane.add(lblCor);
		
		JLabel lblQtdRodas = new JLabel("Qtd. Rodas:");
		lblQtdRodas.setBounds(12, 167, 110, 15);
		contentPane.add(lblQtdRodas);
		
		JLabel lblVelMax = new JLabel("Velocidade Máx.:");
		lblVelMax.setBounds(12, 194, 110, 15);
		contentPane.add(lblVelMax);
		
		JLabel lblQtdPistes = new JLabel("Qtd. Pistões:");
		lblQtdPistes.setBounds(12, 221, 110, 15);
		contentPane.add(lblQtdPistes);
		
		JLabel lblPotncia = new JLabel("Potência:");
		lblPotncia.setBounds(12, 248, 110, 15);
		contentPane.add(lblPotncia);
		
		JLabel lblTara = new JLabel("Tara:");
		lblTara.setBounds(12, 30, 110, 15);
		contentPane.add(lblTara);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setToolTipText("Digite a Placa do veículo que deseja listar");
		textFieldPlaca.setBounds(140, 1, 298, 18);
		contentPane.add(textFieldPlaca);
		textFieldPlaca.setColumns(10);
		
		textFieldCargaMax = new JTextField();
		textFieldCargaMax.setEnabled(false);
		textFieldCargaMax.setBounds(140, 55, 298, 18);
		contentPane.add(textFieldCargaMax);
		textFieldCargaMax.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setEnabled(false);
		textFieldMarca.setBounds(140, 84, 298, 18);
		contentPane.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setEnabled(false);
		textFieldModelo.setBounds(140, 111, 298, 18);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		textFieldCor = new JTextField();
		textFieldCor.setEnabled(false);
		textFieldCor.setBounds(140, 138, 298, 18);
		contentPane.add(textFieldCor);
		textFieldCor.setColumns(10);
		
		textFieldQtdRodas = new JTextField();
		textFieldQtdRodas.setEnabled(false);
		textFieldQtdRodas.setBounds(140, 165, 298, 18);
		contentPane.add(textFieldQtdRodas);
		textFieldQtdRodas.setColumns(10);
		
		textFieldVelocMax = new JTextField();
		textFieldVelocMax.setEnabled(false);
		textFieldVelocMax.setBounds(140, 192, 298, 18);
		contentPane.add(textFieldVelocMax);
		textFieldVelocMax.setColumns(10);
		
		textFieldQtdPistoes = new JTextField();
		textFieldQtdPistoes.setEnabled(false);
		textFieldQtdPistoes.setBounds(140, 219, 298, 18);
		contentPane.add(textFieldQtdPistoes);
		textFieldQtdPistoes.setColumns(10);
		
		textFieldPotencia = new JTextField();
		textFieldPotencia.setEnabled(false);
		textFieldPotencia.setBounds(140, 246, 298, 18);
		contentPane.add(textFieldPotencia);
		textFieldPotencia.setColumns(10);
		
		textFieldTara = new JTextField();
		textFieldTara.setEnabled(false);
		textFieldTara.setBounds(140, 28, 298, 18);
		contentPane.add(textFieldTara);
		textFieldTara.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				btnExcluir.setEnabled(false);
				dispose();
			}
		});
		btnSair.setBounds(348, 282, 90, 27);
		contentPane.add(btnSair);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConsultarAction();
			}
		});
		btnConsultar.setBounds(12, 282, 105, 27);
		contentPane.add(btnConsultar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnExcluirAction(arg0);
			}
		});
		btnExcluir.setBounds(129, 282, 105, 27);
		contentPane.add(btnExcluir);
		
		JLabel lblCargaMx = new JLabel("Carga Máx:");
		lblCargaMx.setBounds(12, 57, 110, 17);
		contentPane.add(lblCargaMx);
		setLocationRelativeTo(null);
	}
	
	public void btnConsultarAction() {
		try {
			if (!BDVeiculos.getBDVeiculosSingle().getListaCarga().isEmpty()) {
				Carga carga = consultarCarga(textFieldPlaca.getText());
				if (carga != null) {
					preencherConsulta(carga);
					btnExcluir.setEnabled(true);
				}
				else {
					throw new VeicNaoExistException();
				}
			}
		} catch (VeicNaoExistException vn) {
			Mensagem.excecao("Veículo não existe no sistema.");
		}
	}
	
	public void preencherConsulta(Carga carga) {
		textFieldPlaca.setText(carga.getPlaca());
		textFieldTara.setText(String.valueOf(carga.getTara()));
		textFieldCargaMax.setText(String.valueOf(carga.getCargaMax()));
		textFieldMarca.setText(carga.getMarca());
		textFieldModelo.setText(carga.getModelo());
		textFieldCor.setText(carga.getCor());
		textFieldQtdRodas.setText(String.valueOf(carga.getQtdRodas()));
		textFieldVelocMax.setText(String.valueOf(carga.getVelMaxima()));
		
		if (carga.getMotor() != null) {
			textFieldQtdPistoes.setText(String.valueOf(carga.getMotor().getQtdPist()));
			textFieldPotencia.setText(String.valueOf(carga.getMotor().getPotencia()));
		}
	}
	
	public void btnExcluirAction(ActionEvent e) {
		BDVeiculos.getBDVeiculosSingle().getListaCarga().remove(consultarCarga(textFieldPlaca.getText()));
		Mensagem.sucesso("Veículo excluído com sucesso!");
		btnExcluir.setEnabled(false);
		habilitarCampos(false);
		limpar();
	}
	
	public void limpar() {
		textFieldPlaca.setText("");
		textFieldCargaMax.setText("");
		textFieldMarca.setText("");
		textFieldModelo.setText("");
		textFieldCor.setText("");
		textFieldQtdRodas.setText("");
		textFieldVelocMax.setText("");
		textFieldQtdPistoes.setText("");
		textFieldPotencia.setText("");
		textFieldTara.setText("");
	}
	
	public void habilitarCampos(boolean habilitar) {
		textFieldPlaca.setEnabled(!habilitar);
		textFieldTara.setEnabled(habilitar);
		textFieldCargaMax.setEnabled(habilitar);
		textFieldMarca.setEnabled(habilitar);
		textFieldModelo.setEnabled(habilitar);
		textFieldCor.setEnabled(habilitar);
		textFieldQtdRodas.setEnabled(habilitar);
		textFieldVelocMax.setEnabled(habilitar);
		textFieldQtdPistoes.setEnabled(habilitar);
		textFieldPotencia.setEnabled(habilitar);
	}
	
	public Carga consultarCarga(String placa) {
		return BDVeiculos.getBDVeiculosSingle().getListaCarga().stream()
				.filter(v -> v.getPlaca().equalsIgnoreCase(placa)).findAny().orElse(null);
	}
}
