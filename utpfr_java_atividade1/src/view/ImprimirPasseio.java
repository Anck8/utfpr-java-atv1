package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.BDVeiculos;

public class ImprimirPasseio extends JFrame {

	private JPanel contentPane;
	private String[] colunas = {"Qtd. Passageiros", "Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Máx.", "Qtd. Pistões", "Potência"};
	private DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
	private JTable tabelaPasseio = new JTable() {
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };
	
	static ImprimirPasseio menuPasseioSingle;
	
	public static ImprimirPasseio getMenuPasseioSingle() {
		if (menuPasseioSingle == null) {
			menuPasseioSingle = new ImprimirPasseio();
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
					ImprimirPasseio frame = new ImprimirPasseio();
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
	public ImprimirPasseio() {
		setResizable(false);
		setTitle("Gestão de Veículos - [Passeio]");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);

		tabelaPasseio.setBounds(13, 0, 675, 278);
		montarTabelaPasseio();
		
		JScrollPane scrollPane = new JScrollPane(tabelaPasseio);
		scrollPane.setSize(775, 257);
		scrollPane.setLocation(13, 12);
		contentPane.add(scrollPane);
		
		JButton btnExcluirTodos = new JButton("Excluir Todos");
		btnExcluirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnExcluirTodos(arg0);
			}
		});
		btnExcluirTodos.setBounds(650, 281, 138, 27);
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
		btnConsultarexcluirPlaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConsultarAction(arg0);
			}
		});
		btnConsultarexcluirPlaca.setBounds(130, 332, 173, 27);
		contentPane.add(btnConsultarexcluirPlaca);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(683, 332, 105, 27);
		contentPane.add(btnSair);
		
		JButton btnListar = new JButton();
		try {
			btnListar.setBounds(13, 267, 30, 30);
		    btnListar.setIcon(new ImageIcon(ImprimirPasseio.class.getResource("/resources/refresh.png")));
		  } catch (Exception ex) {
		    btnListar.setText("Listar");
		    btnListar.setBounds(13, 281, 105, 27);
		    ex.printStackTrace();
		  }
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnListarAction(arg0);
			}
		});
		contentPane.add(btnListar);
		
		setLocationRelativeTo(null);
	}
	
	public void montarTabelaPasseio () {
		if (!BDVeiculos.getBDVeiculosSingle().getListaPasseio().isEmpty()) {
			modelo = new DefaultTableModel(colunas, 0);
			BDVeiculos.getBDVeiculosSingle().getListaPasseio().forEach(v -> {
				String[] dados = { String.valueOf(v.getQtdPassageiros()), v.getPlaca(), v.getMarca(), v.getModelo(), v.getCor(), String.valueOf(v.getQtdRodas()),
						String.valueOf(v.getVelMaxima()), String.valueOf(v.getMotor().getQtdPist()),
						String.valueOf(v.getMotor().getPotencia())};
				modelo.addRow(dados);
			});
		} else {
			modelo.setRowCount(0);
		}
		modelo.setColumnIdentifiers(colunas);
		tabelaPasseio.setModel(modelo);
		tabelaPasseio.getColumnModel().getColumn(0).setPreferredWidth(100);
	}
	
	public void btnExcluirTodos(ActionEvent e) {
		if (!BDVeiculos.getBDVeiculosSingle().getListaPasseio().isEmpty() 
				&& Mensagem.confirmaAcao("Excluir todos os registros?")) {
			BDVeiculos.getBDVeiculosSingle().getListaPasseio().clear();
			montarTabelaPasseio();
		}
	}
	
	public void btnCadastrar(ActionEvent e) {
		AdicionarPasseio.getAdicionarPasseioSingle().setVisible(true);
	}
	
	public void btnListarAction(ActionEvent e){
		montarTabelaPasseio();
	}
	
	public void btnConsultarAction(ActionEvent e) {
		BuscarPasseio.getBuscarPasseioSingle().setVisible(true);
	}

}
