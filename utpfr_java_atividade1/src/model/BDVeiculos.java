package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import controller.Impressao;
import controller.VeicExistException;

public final class BDVeiculos {
	
	static final String VEICULO_CADASTRADO = "\n===[Já existe um veículo com esta placa!]===\n";
	private static List<Passeio> listaPasseio = new ArrayList<>(5); 
	private static List<Carga> listaCarga = new ArrayList<>(5);
	
	public void addPasseio (Passeio veiculo) {
		if (listaPasseio.size() < 5) {
			listaPasseio.add(veiculo);
		} else {
			System.out.println("\n===[ATENCAO] Limite de veículos de Passeio atingido! [ATENCAO]===\n");
		}
	}
	
	public void addCarga (Carga veiculo) {
		if (listaCarga.size() < 5) {
			listaCarga.add(veiculo);
		} else {
			System.out.println("\n===[ATENCAO] Limite de veículos de Carga atingido! [ATENCAO]===\n");
		}
	}
	
	public void removeCarga(Carga veiculo) {
		listaCarga.remove(veiculo);
	}
	
	public void removePasseio(Passeio veiculo) {
		listaPasseio.remove(veiculo);
	}
	
	public static void validaVeiculoCadastrado(Veiculo carro) throws VeicExistException {
		if (carro instanceof Passeio) {
			Veiculo carroCad = listaPasseio.stream().filter(cp -> cp.getPlaca().equals(carro.getPlaca()))
					.findAny().orElse(null);
			if (carroCad != null) {
				Impressao.imprimeCarroPasseioPorPlaca(listaPasseio, carro.getPlaca());
				throw new VeicExistException(VEICULO_CADASTRADO);
			}
		} else {
			Veiculo carroCad = listaCarga.stream().filter(cp -> cp.getPlaca().equals(carro.getPlaca())).findAny()
					.orElse(null);
			if (carroCad != null) {
				Impressao.imprimeCarroCargaPorPlaca(listaCarga, carro.getPlaca());
				throw new VeicExistException(VEICULO_CADASTRADO);
			}
		}
	}
	
	public static void BDVeiculos() {
	}

	public List<Passeio> getListaPasseio() {
		return listaPasseio;
	}
	public void setListaPasseio(List<Passeio> listaPasseio) {
		this.listaPasseio = listaPasseio;
	}
	public List<Carga> getListaCarga() {
		return listaCarga;
	}
	public void setListaCarga(List<Carga> listaCarga) {
		this.listaCarga = listaCarga;
	}
}
