package br.com.gabriel.user_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.user_api.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}
