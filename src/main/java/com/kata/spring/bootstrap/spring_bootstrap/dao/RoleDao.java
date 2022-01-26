package com.kata.spring.bootstrap.spring_bootstrap.dao;



import com.kata.spring.bootstrap.spring_bootstrap.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleDao {
    List<Role> allRoles();

    void add(Role role);

    void update(Role role);

    Role getById(long id);

    Role getByName(String roleName);

    HashSet<Role> getRoleSet(String[] roleName);
}
