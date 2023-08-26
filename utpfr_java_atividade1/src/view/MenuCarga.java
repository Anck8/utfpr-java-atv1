package view;

import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.AdicionarCarga;
import model.BDVeiculos;
import model.Carga;

public class MenuCarga extends JFrame {

	private JPanel contentPane;
	private List<Carga> veiculosCarga = BDVeiculos.getBDVeiculosSingle().getListaCarga();
	private String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Máx.", "Qtd. Pistões", "Potência", "Qtd. Passageiros"};
	private DefaultTableModel tabela = new DefaultTableModel(colunas, 0);
	private JTable tabelaCarga = new JTable(tabela);
//	private JScrollPane scrollPane = new JScrollPane(tabelaCarga);
	
	private final JMenuBar menuBarCarga = new JMenuBar();
	
	static MenuCarga menuCargaSingle;
	private final JButton btnAdicionarCarga = new JButton("Adicionar");
	
	public static MenuCarga getMenuCargaSingle() {
		if (menuCargaSingle == null) {
			menuCargaSingle = new MenuCarga();
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
					MenuCarga frame = new MenuCarga();
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
	private MenuCarga() {
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		setTitle("Gestão de Veículos - [Carga]");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		btnAdicionarCarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAdicionarCargaAction(arg0);
			}
		});

		montarTabelaCarga();
		tabelaCarga.setModel(tabela);
		
		menuBarCarga.setToolTipText("Menu");
		menuBarCarga.setComponentOrientation(getComponentOrientation());
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.add(menuBarCarga);
		
		menuBarCarga.add(btnAdicionarCarga);
		contentPane.add(tabelaCarga);
	}
	
	public void btnAdicionarCargaAction(ActionEvent e) {
		AdicionarCarga.getAdicionarCargaSingle().setVisible(true);
	}
	
	public void montarTabelaCarga () {
		tabela = new DefaultTableModel(colunas,0);
		veiculosCarga.forEach(v -> {
			String[] dados = {v.getPlaca(), 
							v.getMarca(), 
							v.getCor(), 
							String.valueOf(v.getQtdRodas()),
							String.valueOf(v.getVelMaxima()),
							String.valueOf(v.getMotor().getQtdPist()),
							String.valueOf(v.getMotor().getPotencia()),
							String.valueOf(v.getTara()),
							String.valueOf(v.getCargaMax())};
			tabela.addRow(dados);
		});
	}
}
