package br.com.gabriel.user_api.services.exceptions;


public class ObjectNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExceptions (String message) {
		super(message);
	}
	
}
