package br.com.gabriel.payment_api.services.exceptions;


public class ObjectNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExceptions (String message) {
		super(message);
	}
	
}
