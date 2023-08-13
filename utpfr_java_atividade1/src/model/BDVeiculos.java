package model;

public class BDVeiculos {
	
	private Passeio[] listaPasseio; 
	private Carga[] listaCarga;
	
	public Passeio[] getListaPasseio() {
		return listaPasseio;
	}
	public void setListaPasseio(Passeio[] listaPasseio) {
		this.listaPasseio = listaPasseio;
	}
	public Carga[] getListaCarga() {
		return listaCarga;
	}
	public void setListaCarga(Carga[] listaCarga) {
		this.listaCarga = listaCarga;
	}
}
