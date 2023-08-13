package controller;

public class VeicExistException extends Exception {
	
	public VeicExistException() {
	}
	
	public VeicExistException(String mensagem) {
		super(mensagem);
	}
}