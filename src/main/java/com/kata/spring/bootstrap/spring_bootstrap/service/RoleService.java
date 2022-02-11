package com.kata.spring.bootstrap.spring_bootstrap.service;


import com.kata.spring.bootstrap.spring_bootstrap.model.Role;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public interface RoleService {

    void addRole(Set<Role> role);

    void updateRole(Role role);

    void deleteRoleById(long id);

    Set<Role> getAllRoles();

    Role getRole(long id);

    Role getRoleByRole(String role);




}
