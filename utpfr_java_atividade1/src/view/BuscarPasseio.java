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
import model.Passeio;

public class BuscarPasseio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPlaca;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldCor;
	private JTextField textFieldQtdRodas;
	private JTextField textFieldVelocMax;
	private JTextField textFieldQtdPistoes;
	private JTextField textFieldPotencia;
	private JTextField textFieldQtdPassageiros;
	private JButton btnExcluir;
	
	static BuscarPasseio buscarPasseioSingle;
	
	public static BuscarPasseio getBuscarPasseioSingle() {
		if (buscarPasseioSingle == null) {
			buscarPasseioSingle = new BuscarPasseio();
		}
		return buscarPasseioSingle;
	}

	/**
	 * Launch the application.
	 */
	private static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarPasseio frame = new BuscarPasseio();
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
	public BuscarPasseio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gestão de Veículos - [Passeio] Buscar Veículo");
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(12, 3, 110, 15);
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
		lblQtdPistes.setBounds(12, 192, 110, 15);
		contentPane.add(lblQtdPistes);
		
		JLabel lblPotncia = new JLabel("Potência:");
		lblPotncia.setBounds(12, 219, 110, 15);
		contentPane.add(lblPotncia);
		
		JLabel lblQtdPassageiros = new JLabel("Qtd. Passageiros:");
		lblQtdPassageiros.setBounds(12, 30, 110, 15);
		contentPane.add(lblQtdPassageiros);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setToolTipText("Digite a Placa do veículo que deseja listar");
		textFieldPlaca.setBounds(140, 1, 298, 18);
		contentPane.add(textFieldPlaca);
		textFieldPlaca.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setEnabled(false);
		textFieldMarca.setBounds(140, 55, 298, 18);
		contentPane.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setEnabled(false);
		textFieldModelo.setBounds(140, 82, 298, 18);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		textFieldCor = new JTextField();
		textFieldCor.setEnabled(false);
		textFieldCor.setBounds(140, 109, 298, 18);
		contentPane.add(textFieldCor);
		textFieldCor.setColumns(10);
		
		textFieldQtdRodas = new JTextField();
		textFieldQtdRodas.setEnabled(false);
		textFieldQtdRodas.setBounds(140, 136, 298, 18);
		contentPane.add(textFieldQtdRodas);
		textFieldQtdRodas.setColumns(10);
		
		textFieldVelocMax = new JTextField();
		textFieldVelocMax.setEnabled(false);
		textFieldVelocMax.setBounds(140, 163, 298, 18);
		contentPane.add(textFieldVelocMax);
		textFieldVelocMax.setColumns(10);
		
		textFieldQtdPistoes = new JTextField();
		textFieldQtdPistoes.setEnabled(false);
		textFieldQtdPistoes.setBounds(140, 190, 298, 18);
		contentPane.add(textFieldQtdPistoes);
		textFieldQtdPistoes.setColumns(10);
		
		textFieldPotencia = new JTextField();
		textFieldPotencia.setEnabled(false);
		textFieldPotencia.setBounds(140, 217, 298, 18);
		contentPane.add(textFieldPotencia);
		textFieldPotencia.setColumns(10);
		
		textFieldQtdPassageiros = new JTextField();
		textFieldQtdPassageiros.setEnabled(false);
		textFieldQtdPassageiros.setBounds(140, 28, 298, 18);
		contentPane.add(textFieldQtdPassageiros);
		textFieldQtdPassageiros.setColumns(10);
		
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
		
		setLocationRelativeTo(null);
	}
	
	public void btnConsultarAction() {
		try {
			if (!BDVeiculos.getBDVeiculosSingle().getListaPasseio().isEmpty()) {
				Passeio passeio = consultarPasseio(textFieldPlaca.getText());
				if (passeio != null) {
					preencherConsulta(passeio);
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
	
	public void preencherConsulta(Passeio passeio) {
		textFieldPlaca.setText(passeio.getPlaca());
		textFieldQtdPassageiros.setText(String.valueOf(passeio.getQtdPassageiros()));
		textFieldMarca.setText(passeio.getMarca());
		textFieldModelo.setText(passeio.getModelo());
		textFieldCor.setText(passeio.getCor());
		textFieldQtdRodas.setText(String.valueOf(passeio.getQtdRodas()));
		textFieldVelocMax.setText(String.valueOf(passeio.getVelMaxima()));
		if (passeio.getMotor() != null) {
			textFieldQtdPistoes.setText(String.valueOf(passeio.getMotor().getQtdPist()));
			textFieldPotencia.setText(String.valueOf(passeio.getMotor().getPotencia()));
		}
	}
	
	public void btnExcluirAction(ActionEvent e) {
		BDVeiculos.getBDVeiculosSingle().getListaPasseio().remove(consultarPasseio(textFieldPlaca.getText()));
		Mensagem.sucesso("Veículo excluído com sucesso!");
		btnExcluir.setEnabled(false);
		habilitarCampos(false);
		limpar();
	}
	
	public void limpar() {
		textFieldPlaca.setText("");
		textFieldMarca.setText("");
		textFieldModelo.setText("");
		textFieldCor.setText("");
		textFieldQtdRodas.setText("");
		textFieldVelocMax.setText("");
		textFieldQtdPistoes.setText("");
		textFieldPotencia.setText("");
		textFieldQtdPassageiros.setText("");
	}
	
	public void habilitarCampos(boolean habilitar) {
		textFieldPlaca.setEnabled(!habilitar);
		textFieldQtdPassageiros.setEnabled(habilitar);
		textFieldMarca.setEnabled(habilitar);
		textFieldModelo.setEnabled(habilitar);
		textFieldCor.setEnabled(habilitar);
		textFieldQtdRodas.setEnabled(habilitar);
		textFieldVelocMax.setEnabled(habilitar);
		textFieldQtdPistoes.setEnabled(habilitar);
		textFieldPotencia.setEnabled(habilitar);
	}
	
	public Passeio consultarPasseio(String placa) {
		return BDVeiculos.getBDVeiculosSingle().getListaPasseio().stream()
				.filter(v -> v.getPlaca().equalsIgnoreCase(placa)).findAny().orElse(null);
	}

}
