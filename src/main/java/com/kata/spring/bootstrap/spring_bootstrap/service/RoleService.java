package com.kata.spring.bootstrap.spring_bootstrap.service;


import com.kata.spring.bootstrap.spring_bootstrap.model.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public interface RoleService {
    List<Role> allRoles();
    void add(Role role);

    void update(Role role);

    Role getById(long id);

    Role getByName(String roleName);

    HashSet<Role> getRoleSet(String[] roleName);


}
