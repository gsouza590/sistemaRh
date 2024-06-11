package br.com.gabriel.payment_api.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.gabriel.payment_api.model.User;

@FeignClient(name = "user-api", url = "http://localhost:8000")

public interface UserFeign {
	@GetMapping(value = "/api/users/{id}")
	ResponseEntity<User> findById(@PathVariable Long id);

	@GetMapping
	ResponseEntity<List<User>> findAll();
}
