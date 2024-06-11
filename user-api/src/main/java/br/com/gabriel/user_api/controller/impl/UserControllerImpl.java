package br.com.gabriel.user_api.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.user_api.controller.UserController;
import br.com.gabriel.user_api.model.User;
import br.com.gabriel.user_api.services.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserControllerImpl implements UserController{
	
	private final UserService service ;
	
	public UserControllerImpl(UserService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<User> findById(Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@Override
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
