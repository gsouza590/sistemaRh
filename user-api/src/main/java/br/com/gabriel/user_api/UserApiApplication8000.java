package br.com.gabriel.user_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gabriel.user_api.model.User;
import br.com.gabriel.user_api.repositories.UserRepository;

@SpringBootApplication
public class UserApiApplication8000 implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication8000.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.saveAll(List.of(new User(null,"Gabriel Souza","gabriel@email.com", "123", 20.00)));
	}

}
