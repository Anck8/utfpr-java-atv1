package main;

import controller.VeicExistException;
import model.BDVeiculos;
import model.Carga;
import model.Passeio;
import view.Menu;

public class Main {
	
	static BDVeiculos carros = BDVeiculos.getBDVeiculosSingle();
	
    public static void main(String[] args) throws VeicExistException {
        Menu menu = new Menu();
        //populaTabelasTeste();
        menu.setVisible(true);
    }

	private static void populaTabelasTeste() throws VeicExistException {
		try {
			carros.addPasseio(new Passeio("BCD 234", "Ford", "Transit", "Branca", 190.00F, 4, 6, 127, 1000));
			carros.addPasseio(new Passeio("CDT 246", "Ford", "Transit", "Preta", 210.00F, 4, 8, 152, 1150));
			carros.addPasseio(new Passeio("CFT 910", "Ford", "Ranger", "Amarela", 200.00F, 4, 12, 230, 800));
			carros.addPasseio(new Passeio("BGA 398", "Fiat", "Doblo", "Azul", 210.00F, 4, 5, 183, 1100));
			carros.addPasseio(new Passeio("HAY 099", "RAPsev", "L2e-U", "Branca", 90.00F, 3, 0, 97, 400));
			carros.addPasseio(new Passeio("BCF 234", "Ford", "Transit", "Branca", 190.00F, 4, 6, 127, 1000));
			carros.addPasseio(new Passeio("CRT 246", "Ford", "Transit", "Preta", 210.00F, 4, 8, 152, 1150));
			carros.addPasseio(new Passeio("GET 910", "Ford", "Ranger", "Amarela", 200.00F, 4, 12, 230, 800));
			carros.addCarga(new Carga("OAP 398", "Fiat", "Doblo", "Azul", 210.00F, 4, 5, 183, 1100, 550));
			carros.addCarga(new Carga("HFF 982", "RAPsev", "L2e-U", "Branca", 90.00F, 3, 0, 97, 400, 110));
			carros.addCarga(new Carga("GER 099", "RAPsev", "L2e-U", "Branca", 90.00F, 3, 0, 97, 400, 110));
			carros.addCarga(new Carga("KAO 234", "Ford", "Transit", "Branca", 190.00F, 4, 6, 127, 1000, 500));
			carros.addCarga(new Carga("LPS 246", "Ford", "Transit", "Preta", 210.00F, 4, 8, 152, 1150, 510));
			carros.addCarga(new Carga("NCB 099", "RAPsev", "L2e-U", "Branca", 90.00F, 3, 0, 97, 400, 110));
			carros.addCarga(new Carga("BSA 234", "Ford", "Transit", "Branca", 190.00F, 4, 6, 127, 1000, 500));
			carros.addCarga(new Carga("MGH 246", "Ford", "Transit", "Preta", 210.00F, 4, 8, 152, 1150, 510));
		} catch (VeicExistException e) {
			e.printStackTrace();
		}
	}
}
