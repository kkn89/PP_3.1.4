package com.kata.spring.bootstrap.spring_bootstrap.Repository;

import com.kata.spring.bootstrap.spring_bootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);
}
