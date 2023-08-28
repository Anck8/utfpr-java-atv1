package main;

import controller.Impressao;
import controller.Leitura;
import controller.VeicExistException;
import controller.VelocException;
import model.BDVeiculos;
import model.Carga;
import model.Passeio;
import view.Menu;

public class Teste {

	static BDVeiculos carros = BDVeiculos.getBDVeiculosSingle();
    static Leitura leitura = new Leitura();
    static String placa;

    public static void main(String[] args) throws VeicExistException {
        Menu menu = new Menu();
        menu.setVisible(true);
        carros.addCarga(new Carga("BCD 234", "Ford", "Transit", "Branca", 190.00F, 4, 6, 127, 1000, 500));
        carros.addCarga(new Carga("CDT 246", "Ford", "Transit", "Preta", 210.00F, 4, 8, 152, 1150, 510));
        carros.addCarga(new Carga("CFT 910", "Ford", "Ranger", "Amarela", 200.00F, 4, 12, 230, 800, 300));
        carros.addCarga(new Carga("BGA 398", "Fiat", "Doblo", "Azul", 210.00F, 4, 5, 183, 1100, 550));
        carros.addCarga(new Carga("HAY 099", "RAPsev", "L2e-U", "Branca", 90.00F, 3, 0, 97, 400, 110));
        
    }

    public static void controlaMenu() throws VeicExistException {
        String seletor = leitura.entDados("");
        while (!seletor.equals("9")) {
            switch (seletor) {
                case "1":
                    cadastrarPasseio();
                    break;
                case "2":
                    cadastrarCarga();
                    break;
                case "3":
                    Impressao.imprimeCarrosPasseio(carros.getListaPasseio());
                    break;
                case "4":
                    Impressao.imprimeCarrosCarga(carros.getListaCarga());
                    break;
                case "5":
                    placa = leitura.entDados("Digite a placa: ");
                    Impressao.imprimeCarroPasseioPorPlaca(carros.getListaPasseio(), placa);
                    break;
                case "6":
                    placa = leitura.entDados("Digite a placa: ");
                    Impressao.imprimeCarroCargaPorPlaca(carros.getListaCarga(), placa);
                    break;
                case "7":
                	placa = leitura.entDados("Digite a placa: ");
                	excluirPasseio(placa);
                	break;
                case "8":
                	placa = leitura.entDados("Digite a placa: ");
                	excluirCarga(placa);
                	break;
                default:
                    break;
            }
            Impressao.imprimeMenu();
            seletor = leitura.entDados("");
        }
    }

	public static void cadastrarPasseio() throws VeicExistException {
		System.out.println("[Cadastro>Passeio]");
		Passeio carro = new Passeio();
		try {
			carro.setPlaca(leitura.entDados("    Placa: "));
			BDVeiculos.validaVeiculoCadastrado(carro);
			carro.setMarca(leitura.entDados("    Marca: "));
			carro.setModelo(leitura.entDados("    Modelo: "));
			carro.setCor(leitura.entDados("    Cor: "));
			carro.setVelMaxima(Float.parseFloat(leitura.entDados("    Vel. Maxima: ").replaceAll("\\D+", "")));
			
		} catch (VelocException vel) {
			VelocException.setVelocMaxima(carro);
			System.out.println(vel.getMessage());
		} catch (VeicExistException vei) {
			System.out.println(vei.getMessage());
		} finally {
			carro.setQtdRodas(Integer.parseInt(leitura.entDados("    Qtd. Rodas: ").replaceAll("\\D+", "")));
			carro.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("    [Motor] Qtd. Pist: ").replaceAll("\\D+", "")));
			carro.getMotor().setPotencia(Integer.parseInt(leitura.entDados("    [Motor] Potência: ").replaceAll("\\D+", "")));
			carro.setQtdPassageiros(Integer.parseInt(leitura.entDados("    Qtd. Passageiros: ").replaceAll("\\D+", "")));
			carros.addPasseio(carro);
		}
		
		String novoCadastro = leitura.entDados("    Deseja cadastrar mais um veículo [Passeio]?: ");
		switch (novoCadastro.toUpperCase()) {
		case "NAO":
	        System.out.println("\n==========================================\n");
			break;
		case "SIM":
			cadastrarPasseio();
			break;
		default:
	        System.out.println("\n==========================================\n");
			break;
		}
	}
    
	public static void cadastrarCarga() throws VeicExistException {
		System.out.println("[Cadastro>Carga]");
		Carga carro = new Carga();
		try {
			carro.setPlaca(leitura.entDados("    Placa: "));
			BDVeiculos.validaVeiculoCadastrado(carro);
			carro.setMarca(leitura.entDados("    Marca: "));
			carro.setModelo(leitura.entDados("    Modelo: "));
			carro.setCor(leitura.entDados("    Cor: "));
			carro.setVelMaxima(Float.parseFloat(leitura.entDados("    Vel. Maxima: ").replaceAll("\\D+", "")));
		} catch (VelocException vel) {
			VelocException.setVelocMaxima(carro);
			System.out.println(vel.getMessage());
		} catch (VeicExistException vei) {
			System.out.println(vei.getMessage());
		} finally {
			carro.setQtdRodas(Integer.parseInt(leitura.entDados("    Qtd. Rodas: ").replaceAll("\\D+", "")));
			carro.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("    [Motor] Qtd. Pist: ").replaceAll("\\D+", "")));
			carro.getMotor().setPotencia(Integer.parseInt(leitura.entDados("    [Motor] Potência: ").replaceAll("\\D+", "")));
			carro.setCargaMax(Integer.parseInt(leitura.entDados("    Carga Máxima: ").replaceAll("\\D+", "")));
			carro.setTara(Integer.parseInt(leitura.entDados("    Tara: ").replaceAll("\\D+", "")));
			carros.addCarga(carro);
		}
		
		String novoCadastro = leitura.entDados("    Deseja cadastrar mais um veículo [Carga]?: ");
		switch (novoCadastro.toUpperCase()) {
		case "NAO":
	        System.out.println("\n==========================================\n");
			break;
		case "SIM":
			cadastrarCarga();
			break;
		default:
	        System.out.println("\n==========================================\n");
			break;
		}
	}
	
	public static void excluirPasseio(String placa) {
		if (carros.getListaPasseio().isEmpty()) {
			System.out.println("\n==========[Veículo inexistente]==========\n");
		} else {
			carros.getListaPasseio().removeIf(v -> v.getPlaca().equals(placa));
			System.out.println("\n============[Veículo removido]============\n");
		}
	}
	
	public static void excluirCarga(String placa) {
		if (carros.getListaCarga().isEmpty()) {
			System.out.println("\n==========[Veículo inexistente]==========\n");
		} else {
			carros.getListaCarga().removeIf(v -> v.getPlaca().equals(placa));			
			System.out.println("\n============[Veículo removido]============\n");
		}
	}

}
