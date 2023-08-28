package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.BDVeiculos;

public class ImprimirCarga extends JFrame {

	private JPanel contentPane;
	private String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Máx.", "Qtd. Pistões", "Potência", "Qtd. Passageiros"};
	private DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
	private JTable tabelaCarga = new JTable();
	
	static ImprimirCarga menuCargaSingle;
	
	public static ImprimirCarga getMenuCargaSingle() {
		if (menuCargaSingle == null) {
			menuCargaSingle = new ImprimirCarga();
		}
		return menuCargaSingle;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImprimirCarga frame = new ImprimirCarga();
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
	private ImprimirCarga() {
		setResizable(false);
		setTitle("Gestão de Veículos - [Carga]");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);

		montarTabelaCarga();
		contentPane.setLayout(null);
		tabelaCarga.setBounds(13, 0, 675, 278);
		contentPane.add(tabelaCarga);
		
		JButton btnExcluirTodos = new JButton("Excluir Todos");
		btnExcluirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnExcluirTodos(arg0);
			}
		});
		btnExcluirTodos.setBounds(550, 281, 138, 27);
		contentPane.add(btnExcluirTodos);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrar(arg0);
			}
		});
		btnCadastrar.setBounds(13, 332, 105, 27);
		contentPane.add(btnCadastrar);
		
		JButton btnConsultarexcluirPlaca = new JButton("Consultar/Excluir Placa");
		btnConsultarexcluirPlaca.setBounds(130, 332, 173, 27);
		contentPane.add(btnConsultarexcluirPlaca);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSairAction(arg0);
			}
		});
		btnSair.setBounds(582, 332, 105, 27);
		contentPane.add(btnSair);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnListarAction(arg0);
			}
		});
		btnListar.setBounds(433, 281, 105, 27);
		contentPane.add(btnListar);
		setLocationRelativeTo(null);
	}
	
	public void montarTabelaCarga () {
		if (!BDVeiculos.getBDVeiculosSingle().getListaCarga().isEmpty()) {
			modelo = new DefaultTableModel(colunas, 0);
			BDVeiculos.getBDVeiculosSingle().getListaCarga().forEach(v -> {
				String[] dados = { v.getPlaca(), v.getMarca(), v.getCor(), String.valueOf(v.getQtdRodas()),
						String.valueOf(v.getVelMaxima()), String.valueOf(v.getMotor().getQtdPist()),
						String.valueOf(v.getMotor().getPotencia()), String.valueOf(v.getTara()),
						String.valueOf(v.getCargaMax()) };
				modelo.addRow(dados);
			});
		} else {
			modelo.setRowCount(0);
		}
		modelo.setColumnIdentifiers(colunas);
		tabelaCarga.setModel(modelo);
	}
	
	public void btnExcluirTodos(ActionEvent e) {
		if (!BDVeiculos.getBDVeiculosSingle().getListaCarga().isEmpty() 
				&& Mensagem.confirmaAcao("Excluir todos os registros?")) {
			BDVeiculos.getBDVeiculosSingle().getListaCarga().clear();
			montarTabelaCarga();
		}
	}
	
	private void btnSairAction(ActionEvent e) {
		dispose();
	}
	
	public void btnCadastrar(ActionEvent e) {
		AdicionarCarga.getAdicionarCargaSingle().setVisible(true);
	}
	
	public void btnListarAction(ActionEvent e){
		montarTabelaCarga();
	}
	
}
