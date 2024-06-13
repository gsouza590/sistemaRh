package br.com.gabriel.user_api.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.gabriel.user_api.model.User;
import br.com.gabriel.user_api.repositories.UserRepository;
import br.com.gabriel.user_api.services.UserService;
import br.com.gabriel.user_api.services.exceptions.ObjectNotFoundExceptions;

@Service
public class UserImpl implements UserService {

	
	private UserRepository repository;
	private static final Logger log = LoggerFactory.getLogger(UserImpl.class);
	private final Environment env;

	public UserImpl(Environment env, UserRepository repository) {
		this.env = env;
		this.repository = repository;
	}
	@Override
	public User findById(Long id) {
		log.info("User Service :: Get Request on " + env.getProperty("local.server.port") + "port");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundExceptions("user not found"));
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

}
