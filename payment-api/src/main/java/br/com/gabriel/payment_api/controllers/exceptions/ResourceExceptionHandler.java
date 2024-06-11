package br.com.gabriel.payment_api.controllers.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.gabriel.payment_api.services.exceptions.ObjectNotFoundExceptions;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundExceptions.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExceptions ex, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandardError(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.NOT_FOUND.value(), request.getRequestURI()));

	}
}
