package controller;

import model.Passeio;
import model.Veiculo;

public class VelocException extends Exception{
	
	public VelocException() {
	}
	
	public VelocException(String mensagem) {
		super(mensagem);
	}
	
	public static void setVelocMaxima (Veiculo veiculo) {
		if (veiculo == null) {
			return;
		}
		try {
			if (veiculo instanceof Passeio) {
				veiculo.setVelMaxima(100F);
			} else {
				veiculo.setVelMaxima(90F);
			}
		} catch (VelocException ve) {
		}
	}

}
