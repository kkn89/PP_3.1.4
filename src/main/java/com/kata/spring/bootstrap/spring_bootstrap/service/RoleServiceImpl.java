package com.kata.spring.bootstrap.spring_bootstrap.service;


import com.kata.spring.bootstrap.spring_bootstrap.dao.RoleRepository;
import com.kata.spring.bootstrap.spring_bootstrap.model.Role;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleRepository.save(role);

    }

    @Override
    @Transactional
    public void update(Role role) {
        roleRepository.save(role);

    }

    @Override
    @Transactional
    public Role getById(long id) {
        Role role = null;
        Optional<Role> optional = roleRepository.findById(id);
        if(optional.isPresent()){
            role = optional.get();
        }
        return role;
    }

    @Override
    @Transactional
    public Role getByName(String roleName) throws NotFoundException {
        Role role = roleRepository.findByRole(roleName);
        if(role == null){
            throw new NotFoundException(roleName);
        }
        return role;
    }

    @Override
    public HashSet<Role> getRoleSet(String[] roleName) throws NotFoundException {
        HashSet<Role> roleSet = new HashSet<>();
        for (String roles : roleName) {
            roleSet.add(getByName(roles));
        }
        return roleSet;
    }
}
