package br.com.gabriel.user_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.user_api.model.User;
import br.com.gabriel.user_api.repositories.UserRepository;
import br.com.gabriel.user_api.services.UserService;
import br.com.gabriel.user_api.services.exceptions.ObjectNotFoundExceptions;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ObjectNotFoundExceptions("user not found"));
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

}
