package br.com.gabriel.user_api.services;

import java.util.List;

import br.com.gabriel.user_api.model.User;

public interface UserService {

	User findById(Long id);
	List<User> findAll();
}
