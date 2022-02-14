package com.kata.spring.bootstrap.spring_bootstrap.Repository;

import com.kata.spring.bootstrap.spring_bootstrap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRole(String role);
}
