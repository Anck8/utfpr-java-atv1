package model;

import java.util.ArrayList;
import java.util.List;

import controller.Impressao;
import controller.VeicExistException;

public final class BDVeiculos {

	static final String VEICULO_CADASTRADO = "\nJá existe um veículo com esta placa!\n";
	private List<Passeio> listaPasseio = new ArrayList<Passeio>();
	private List<Carga> listaCarga = new ArrayList<Carga>();
	static BDVeiculos BDVeiculosSingle;

	public static BDVeiculos getBDVeiculosSingle() {
		if (BDVeiculosSingle == null) {
			BDVeiculosSingle = new BDVeiculos();
		}
		return BDVeiculosSingle;
	}

	private static void BDVeiculos() {
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
	
	public void addPasseio(Passeio veiculo) throws VeicExistException {
		validaVeiculoCadastrado(veiculo);
		BDVeiculosSingle.listaPasseio.add(veiculo);
	}
	
	public void addCarga(Carga veiculo) throws VeicExistException {
		validaVeiculoCadastrado(veiculo);
		BDVeiculosSingle.listaCarga.add(veiculo);
	}
	
	public static void removeCarga(Carga veiculo) {
		if (BDVeiculosSingle.listaCarga != null) {
			BDVeiculosSingle.listaCarga.remove(veiculo);
		}
	}
	
	public static void removePasseio(Passeio veiculo) {
		if(BDVeiculosSingle.listaPasseio != null) {
			BDVeiculosSingle.listaPasseio.remove(veiculo);
		}
	}

	public static void validaVeiculoCadastrado(Veiculo carro) throws VeicExistException {
		if (carro instanceof Passeio && !BDVeiculosSingle.listaPasseio.isEmpty()) {
			Veiculo carroCad = BDVeiculosSingle.listaPasseio.stream()
					.filter(cp -> cp.getPlaca().equals(carro.getPlaca())).findAny().orElse(null);
			if (carroCad != null) {
				Impressao.imprimeCarroPasseioPorPlaca(BDVeiculosSingle.listaPasseio, carro.getPlaca());
				throw new VeicExistException(VEICULO_CADASTRADO);
			}
		} else if (!BDVeiculosSingle.listaCarga.isEmpty()) {
			Veiculo carroCad = BDVeiculosSingle.listaCarga.stream().filter(cp -> cp.getPlaca().equals(carro.getPlaca()))
					.findAny().orElse(null);
			if (carroCad != null) {
				Impressao.imprimeCarroCargaPorPlaca(BDVeiculosSingle.listaCarga, carro.getPlaca());
				throw new VeicExistException(VEICULO_CADASTRADO);
			}
		}
	}

}
