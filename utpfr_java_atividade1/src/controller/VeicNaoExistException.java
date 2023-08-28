package controller;

public class VeicNaoExistException extends Exception{
	
	public VeicNaoExistException() {
	}
	
	public VeicNaoExistException(String mensagem) {
		super(mensagem);
	}

}
