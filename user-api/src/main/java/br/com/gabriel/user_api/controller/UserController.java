package br.com.gabriel.user_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.gabriel.user_api.model.User;

public interface UserController {

	@GetMapping(value = "/{id}")
	ResponseEntity<User> findById(@PathVariable Long id);

	@GetMapping
	ResponseEntity<List<User>> findAll();
}
