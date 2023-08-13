package model;

import java.util.ArrayList;
import java.util.List;

import controller.VeicExistException;

public class BDVeiculos {
	
	private List<Passeio> listaPasseio = new ArrayList<>(5); 
	private List<Carga> listaCarga = new ArrayList<>(5);
	
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
