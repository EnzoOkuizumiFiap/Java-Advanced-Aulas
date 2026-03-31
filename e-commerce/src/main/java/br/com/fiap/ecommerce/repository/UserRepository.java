package br.com.fiap.ecommerce.repository;

import br.com.fiap.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
